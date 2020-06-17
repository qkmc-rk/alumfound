package org.whystudio.alumfound.vo;


import java.time.LocalDateTime;

/**
 * Controller的返回值
 * @author mrruan
 */
public class Response<T>  {

    private Integer status;

    private String message;

    private T data;

    private LocalDateTime timestamp = LocalDateTime.now();

    public Response(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
