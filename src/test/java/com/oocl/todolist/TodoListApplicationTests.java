package com.oocl.todolist;

import com.oocl.todolist.Dto.TodoRequest;
import com.oocl.todolist.Dto.TodoResponse;
import com.oocl.todolist.Entity.Todo;
import com.oocl.todolist.Repository.TodoRepository;
import com.oocl.todolist.Service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TodoListApplicationTests {

	@InjectMocks
	TodoService todoService;

	@Mock
	TodoRepository todoRepository;

	@Test
	void should_return_TodoResponse_when_addTodo_given_todoRequest() {
		TodoRequest todoRequest = new TodoRequest();
		todoRequest.setContent("hello world");
		todoRequest.setStatus(false);

		Todo todo = new Todo();
		todo.setContent("hello world");
		todo.setStatus(false);
		Mockito.when(todoRepository.save(any())).thenReturn(todo);

		TodoResponse todoResponse = todoService.addTodo(todoRequest);

		assertEquals(todoRequest.getContent(),todoResponse.getContent());
	}


	@Test
	void should_return_true_when_deletetodo_given_id() {
		Integer id = 1;

		Boolean result = todoService.deleteTodo(id);

		assertEquals(true, result);

	}

	@Test
	void should_return_todolist_when_query_all() {
		List<Todo> todoList = new ArrayList<>();
		Todo todo = new Todo();
		todo.setId(1);
		todo.setContent("hello world");
		todoList.add(todo);

//		TodoResponse todoResponse = new TodoResponse();
//		BeanUtils.copyProperties(todo, todoResponse);

		Mockito.when(todoRepository.findAll()).thenReturn(todoList);

		List<TodoResponse> todoListResult = todoService.queryAll();

		assertEquals(1, todoListResult.size());
	}

	@Test
	void should_return_finish_todo_list_when_query_finish_list_given_void() {

		List<Todo> todoList = new ArrayList<>();
		Todo todoFinish = new Todo();
		todoFinish.setId(1);
		todoFinish.setContent("hello world");
		todoFinish.setStatus(true);

		Todo todoNotFinish = new Todo();
		todoNotFinish.setId(2);
		todoNotFinish.setContent("hello world");
		todoNotFinish.setStatus(false);
		todoList.add(todoNotFinish);

		Mockito.when(todoRepository.getTodoByStatus(true)).thenReturn(todoList);

		List<TodoResponse> todoListResult = todoService.queryFinishList();

		assertEquals(1, todoListResult.size());


	}
}
