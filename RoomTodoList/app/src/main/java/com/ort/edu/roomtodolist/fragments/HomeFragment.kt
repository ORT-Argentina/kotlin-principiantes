package com.ort.edu.roomtodolist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ort.edu.roomtodolist.MainActivity
import com.ort.edu.roomtodolist.R
import com.ort.edu.roomtodolist.adapter.TaskListAdapter
import com.ort.edu.roomtodolist.listener.OnTaskSelectedListener
import com.ort.edu.roomtodolist.model.Task
import com.ort.edu.roomtodolist.repository.TaskRepository
import kotlinx.coroutines.launch


class HomeFragment : Fragment(), OnTaskSelectedListener {

    private lateinit var taskRecyclerView: RecyclerView
    private lateinit var addTaskButton: FloatingActionButton
    private lateinit var adapter: TaskListAdapter
    private lateinit var taskRepository: TaskRepository


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskRecyclerView = view.findViewById(R.id.task_list)
        addTaskButton = view.findViewById(R.id.add_button)
        context?.let { taskRepository = TaskRepository.getInstance(it) }

        addTaskButton.setOnClickListener {
            findNavController().navigate(R.id.newTaskFragment)
        }

    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launch {
            adapter = TaskListAdapter(taskRepository.getAllTask(), this@HomeFragment)
            val layoutManager = LinearLayoutManager(context)
            taskRecyclerView.layoutManager = layoutManager
            taskRecyclerView.adapter = adapter

            // Solo agrego un separador entre items del recyclerview
            val dividerItemDecoration = DividerItemDecoration(taskRecyclerView.context, layoutManager.orientation)
            taskRecyclerView.addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onTaskSelected(task: Task, taskPosition: Int) {
        lifecycleScope.launch {
            taskRepository.removeTask(task)
            adapter.removeTask(taskPosition)
        }
    }

}