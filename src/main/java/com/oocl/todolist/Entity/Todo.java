package com.oocl.todolist.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by CHENCO9 on 8/6/2020 7:51 PM
 * @author CHENCO9
 */
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String content;
    @NotNull
    private boolean status;


    public Todo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
