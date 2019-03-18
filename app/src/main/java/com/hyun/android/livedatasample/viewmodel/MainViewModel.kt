package com.hyun.android.livedatasample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hyun.android.livedatasample.model.InputMsg
import com.hyun.android.livedatasample.repository.InputMsgRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(
    private val inputMsgRepository: InputMsgRepository
) : ViewModel() {
    var TAG = javaClass.simpleName

    var inputMsgs: LiveData<List<InputMsg>> = inputMsgRepository.getAllMsgs()

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Main + viewModelJob)

    fun insertMsg(inputMsg: InputMsg) {
        viewModelScope.launch { inputMsgRepository.insert(inputMsg) }

    }
}