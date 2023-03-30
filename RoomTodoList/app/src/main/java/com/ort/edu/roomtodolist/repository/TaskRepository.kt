package com.ort.edu.roomtodolist.repository

import android.content.Context
import androidx.room.Room
import com.ort.edu.roomtodolist.database.AppDatabase
import com.ort.edu.roomtodolist.database.dao.TaskDao
import com.ort.edu.roomtodolist.model.Task

class TaskRepository private constructor(appDatabase: AppDatabase) {

    private val taskDao: TaskDao = appDatabase.taskDao()

    suspend fun addTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun removeTask(task: Task) {
        taskDao.delete(task)
    }

    suspend fun getAllTask(): MutableList<Task> {
        return taskDao.getAll()
    }

    companion object {
        private var taskRepository: TaskRepository? = null

        fun getInstance(context: Context): TaskRepository {
            return taskRepository ?: kotlin.run {

                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "task-database"
                ).build()

                val createdTaskRepository = TaskRepository(db)
                taskRepository = TaskRepository(db)
                createdTaskRepository
            }
        }
    }
}