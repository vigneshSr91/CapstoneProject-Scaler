package com.scaler.productservicejan31capstone.dtos;

public class ErrorDto {
    private String status;
    private String message;

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
