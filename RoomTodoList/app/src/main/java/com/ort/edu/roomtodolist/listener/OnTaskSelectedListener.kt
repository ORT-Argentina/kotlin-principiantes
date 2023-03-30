package com.ort.edu.roomtodolist.listener

import com.ort.edu.roomtodolist.model.Task

interface OnTaskSelectedListener {
    fun onTaskSelected(task: Task,taskPosition: Int)
}