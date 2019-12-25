package com.sinosoft.cses.master.response;


import com.sinosoft.cses.master.enums.ErrorType;

/**
 * @program: workspace
 * @description: 系统基本返回类型
 * @author: xujian
 * @create: 2019-08-27 10:34
 **/
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(T data, ErrorType errorType){
        this.code=errorType.getCode();
        this.message=errorType.getMessage();
        this.data=data;
    }

    public BaseResponse(ErrorType errorType){
        this.code=errorType.getCode();
        this.message=errorType.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
}
