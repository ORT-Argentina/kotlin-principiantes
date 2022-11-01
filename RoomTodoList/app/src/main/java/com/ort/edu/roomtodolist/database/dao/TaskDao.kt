package com.ort.edu.roomtodolist.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ort.edu.roomtodolist.model.Task

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task")
    suspend fun getAll(): MutableList<Task>
}