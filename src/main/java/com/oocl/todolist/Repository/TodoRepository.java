package com.oocl.todolist.Repository;

import com.oocl.todolist.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CHENCO9 on 8/6/2020 8:04 PM
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> getTodoByStatus(Boolean status);
}
