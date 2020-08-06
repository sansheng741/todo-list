package com.oocl.todolist.Controller;

import com.oocl.todolist.Dto.TodoResponse;
import com.oocl.todolist.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by CHENCO9 on 8/6/2020 8:03 PM
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<TodoResponse> queryAll(){
        return todoService.queryAll();
    }





}
