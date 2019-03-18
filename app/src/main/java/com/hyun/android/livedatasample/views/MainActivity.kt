package com.hyun.android.livedatasample.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hyun.android.livedatasample.R
import com.hyun.android.livedatasample.dao.AppDatabase
import com.hyun.android.livedatasample.factory.MailViewModelFactory
import com.hyun.android.livedatasample.model.InputMsg
import com.hyun.android.livedatasample.repository.InputMsgRepository
import com.hyun.android.livedatasample.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeUi()
    }

    private fun subscribeUi() {
        /**
         * 이 과정은 DI(dependency injection)으로 대체가 가능합니다.
         */
        val dao = AppDatabase.getInstance(this).inputMsgDao()
        val repository = InputMsgRepository.getInstance(dao)
        val factory = MailViewModelFactory(repository)
        var viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.inputMsgs.observe(this, Observer {
            if (it == null || it.isEmpty())
                return@Observer

            var sb = StringBuffer()
            for (data in it) {
                sb.append(data.msg).append("\n")
            }

            tv_result.text = sb.toString()
        })

        btn_input.setOnClickListener {
            var input = et_input.text.toString()
            if (input == null || input.isEmpty())
                return@setOnClickListener

            et_input.setText("")
            viewModel.insertMsg(InputMsg(msg = input))
        }
    }
}
