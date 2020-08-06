package com.oocl.todolist.integrationTest;

import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by CHENCO9 on 8/6/2020 10:06 PM
 */

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {
    @Autowired
    TodoRepository todoRepository;

    @Autowired
    MockMvc mockMvc;



    @Test
    void should_return_all_todo_list_when_get_all_todo_given_void() throws Exception {
        Todo todo = new Todo();
        todo.setContent("hello world");
        todo.setStatus(false);

        todoRepository.save(todo);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1));
    }
}
