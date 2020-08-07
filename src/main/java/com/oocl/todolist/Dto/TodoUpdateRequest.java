package com.oocl.todolist.Dto;

import java.util.Objects;

/**
 * Created by CHENCO9 on 8/7/2020 1:18 AM
 */
public class TodoUpdateRequest {

    private boolean status;

    public TodoUpdateRequest() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
