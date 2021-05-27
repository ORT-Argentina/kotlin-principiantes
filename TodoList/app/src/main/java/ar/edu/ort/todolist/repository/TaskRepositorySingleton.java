package ar.edu.ort.todolist.repository;

import java.util.HashMap;

import ar.edu.ort.todolist.model.domain.Task;

public class TaskRepositorySingleton {

    private HashMap<Integer, Task> tasks;

    private static TaskRepositorySingleton instance;

    private TaskRepositorySingleton(){
        tasks = new HashMap<Integer, Task>();
        tasks.put(1, new Task(1, "Dar clase de PR3"));
        tasks.put(2, new Task(2, "Comer"));
        tasks.put(3, new Task(3, "Dormir"));
    }

    public static TaskRepositorySingleton getInstance(){
        if(instance == null ){
            instance = new TaskRepositorySingleton();
        }
        return instance;
    }

    public void addTask(String descrition){
        Task newTask = new Task(tasks.size(), descrition);
        tasks.put(newTask.getId(), newTask);
    }

}
