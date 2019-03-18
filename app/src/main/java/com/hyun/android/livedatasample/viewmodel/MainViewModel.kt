package com.hyun.android.livedatasample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hyun.android.livedatasample.model.InputMsg
import com.hyun.android.livedatasample.repository.InputMsgRepository

class MainViewModel(
    private val inputMsgRepository: InputMsgRepository
) : ViewModel() {
    var TAG = javaClass.simpleName

    var inputMsgs: LiveData<List<InputMsg>> = inputMsgRepository.getAllMsgs()

    fun insertMsg(inputMsg: InputMsg) {
        inputMsgRepository.insert(inputMsg)
    }

}