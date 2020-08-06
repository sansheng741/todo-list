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
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

		Mockito.when(todoRepository.save(any())).thenReturn(new Todo());

		TodoResponse todoResponse = todoService.addTodo(todoRequest);

		List<Todo> todoList = todoRepository.findAll();

		assertEquals(1,todoList.size());
	}
}
