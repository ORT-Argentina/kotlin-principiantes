package com.ort.edu.roomtodolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val name: String,
    @ColumnInfo(name = "creation_date") val creationDate: Date
)