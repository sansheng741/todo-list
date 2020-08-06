package com.oocl.todolist.Service;

import com.oocl.todolist.Dto.TodoRequest;
import com.oocl.todolist.Dto.TodoResponse;
import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CHENCO9 on 8/6/2020 8:04 PM
 */
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;


    public TodoResponse addTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest,todo);
        Todo saveTodo = todoRepository.save(todo);

        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(saveTodo,todoResponse);

        return todoResponse;
    }
}
