package com.oocl.todolist.Service;

import com.oocl.todolist.Dto.TodoRequest;
import com.oocl.todolist.Dto.TodoResponse;
import com.oocl.todolist.Dto.TodoUpdateRequest;
import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CHENCO9 on 8/6/2020 8:04 PM
 */
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;
    //test git
    public Boolean deleteTodo(Integer id) {
        try {
            todoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //add annotation
    public TodoResponse addTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);
        Todo saveTodo = todoRepository.save(todo);

        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(saveTodo, todoResponse);

        return todoResponse;
    }


    public List<TodoResponse> queryAll() {
        List<Todo> todoList = todoRepository.findAll();
        List<TodoResponse> todoResponseList = todoList.stream().map((todo) -> {
            TodoResponse todoResponse = new TodoResponse();
            BeanUtils.copyProperties(todo, todoResponse);
            return todoResponse;
        }).collect(Collectors.toList());
        return todoResponseList;
    }

    public List<TodoResponse> queryFinishList() {
        List<Todo> todoByStatus = todoRepository.getTodoByStatus(true);

        List<TodoResponse> todoResponseList = todoByStatus.stream().map((todo) -> {
            TodoResponse todoResponse = new TodoResponse();
            BeanUtils.copyProperties(todo, todoResponse);
            return todoResponse;
        }).collect(Collectors.toList());
        return todoResponseList;
    }

    public TodoResponse updateTodoStatus(Integer id, TodoUpdateRequest todoUpdateRequest) {

        Todo todo = todoRepository.findById(id).get();
        todo.setStatus(todoUpdateRequest.isStatus());

        Todo saveUpdate = todoRepository.save(todo);

        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(saveUpdate, todoResponse);

        return todoResponse;
    }
}
