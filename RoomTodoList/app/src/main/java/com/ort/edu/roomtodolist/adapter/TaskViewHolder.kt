package com.ort.edu.roomtodolist.adapter

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.roomtodolist.R
import com.ort.edu.roomtodolist.listener.OnTaskSelectedListener
import com.ort.edu.roomtodolist.model.Task
import java.text.DateFormat

class TaskViewHolder(itemView: View, private val onTaskSelectedListener: OnTaskSelectedListener) :
    RecyclerView.ViewHolder(itemView) {

    private val taskNameText: TextView
    private val taskDateText: TextView
    private val completeTaskCheck: CheckBox

    init {
        taskNameText = itemView.findViewById(R.id.task_name)
        taskDateText = itemView.findViewById(R.id.task_creation_date)
        completeTaskCheck = itemView.findViewById(R.id.complete_task_check)
    }

    fun bind(task: Task,position: Int) {
        taskNameText.text = task.name
        taskDateText.text = DateFormat.getDateInstance(DateFormat.SHORT).format(task.creationDate)

        completeTaskCheck.setOnClickListener {
            onTaskSelectedListener.onTaskSelected(task,position)
        }
    }
}