package com.ort.edu.roomtodolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ort.edu.roomtodolist.R
import com.ort.edu.roomtodolist.model.Task
import com.ort.edu.roomtodolist.repository.TaskRepository
import kotlinx.coroutines.launch
import java.util.*


class NewTaskFragment : Fragment() {

    private lateinit var taskNameInput: TextView
    private lateinit var saveButton: Button
    private lateinit var taskRepository: TaskRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskNameInput = view.findViewById(R.id.task_name_input)
        saveButton = view.findViewById(R.id.save_button)

        context?.let { taskRepository = TaskRepository.getInstance(it) }

        saveButton.setOnClickListener {

            lifecycleScope.launch {
                val newTask = Task(0, taskNameInput.text.toString(), Date())
                taskRepository.addTask(newTask)
                findNavController().navigate(R.id.homeFragment)
            }

        }
    }

}