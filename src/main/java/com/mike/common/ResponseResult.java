package com.mike.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mike on 2017/11/7.
 */
public class ResponseResult<T> implements Serializable {
    private boolean code = false;
    private String msg;
    private T content;
    private List<?> result;

    public ResponseResult() {
    }

    public boolean getCode() {
        return this.code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public List<?> getResult() {
        return this.result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
