package com.hyun.android.livedatasample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inputMsg")
data class InputMsg(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var msgId: Int = 0,
    @ColumnInfo(name = "msg") var msg: String = ""
)