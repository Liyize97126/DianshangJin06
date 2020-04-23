package com.bawei.dianshangjin06.bean;

/**
 * 数据总根类
 */
public class DataBean<T> {
    private T result;
    private String message;
    private String status;
    public T getResult() {
        return result;
    }
    public void setResult(T result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
