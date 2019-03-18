package com.hyun.android.livedatasample.repository

import com.hyun.android.livedatasample.dao.InputMsgDao
import com.hyun.android.livedatasample.model.InputMsg

class InputMsgRepository private constructor(private val inputMsgDao: InputMsgDao) {
    fun getAllMsgs() = inputMsgDao.getAll()
    fun insert(inputMsg: InputMsg) = inputMsgDao.insertMsg(inputMsg)

    companion object {
        @Volatile
        private var instance: InputMsgRepository? = null

        fun getInstance(catDao: InputMsgDao) =
            instance ?: synchronized(this) {
                instance ?: InputMsgRepository(catDao).also { instance = it }
            }

    }
}