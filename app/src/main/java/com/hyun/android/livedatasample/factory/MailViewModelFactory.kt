package com.hyun.android.livedatasample.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyun.android.livedatasample.repository.InputMsgRepository
import com.hyun.android.livedatasample.viewmodel.MainViewModel

class MailViewModelFactory(
    private val inputMsgRepository: InputMsgRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(inputMsgRepository) as T
    }
}