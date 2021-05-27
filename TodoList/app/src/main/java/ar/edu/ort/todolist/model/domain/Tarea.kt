package ar.edu.ort.todolist.model.domain

import java.io.FileDescriptor

class Task (id: Int, description: String) {

    var id: Int
    var description: String
    var done: Boolean

    init{
        this.id = id;
        this.description = description;
        this.done = false;
    }

    fun toogle(){
        this.done = !this.done;
    }

}