package com.oocl.todolist.Dto;

import javax.validation.constraints.NotNull;

/**
 * Created by CHENCO9 on 8/6/2020 7:59 PM
 */
public class TodoRequest {

    private String content;
    private boolean status;

    public TodoRequest() {
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
}
