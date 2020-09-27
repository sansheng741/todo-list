package com.oocl.todolist.Dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoRequest that = (TodoRequest) o;
        return status == that.status &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, status);
    }
}
