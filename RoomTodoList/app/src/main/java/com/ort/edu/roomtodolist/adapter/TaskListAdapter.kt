package com.ort.edu.roomtodolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.roomtodolist.R
import com.ort.edu.roomtodolist.listener.OnTaskSelectedListener
import com.ort.edu.roomtodolist.model.Task

class TaskListAdapter(
    private val taskList: MutableList<Task>,
    private val onTaskSelectedListener: OnTaskSelectedListener
) :
    RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)

        return TaskViewHolder(view, onTaskSelectedListener)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.bind(task, position)
    }

    override fun getItemCount() = taskList.size


    fun removeTask(taskPosition: Int) {
        taskList.removeAt(taskPosition)
        notifyItemRemoved(taskPosition)
    }
}