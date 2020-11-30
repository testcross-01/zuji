package top.testcross.zuji.exception;

import lombok.Data;


public class ZuJiException extends RuntimeException{
    protected String msg;

    protected Integer status;

    public ZuJiException(){
        super();
    }

    public ZuJiException(String message){
        super(message);
        this.msg=message;
    }

    public ZuJiException(String message,Integer status){
        super(message);
        this.status=status;
        this.msg=message;
    }

    public ZuJiException(String message,Integer status,Exception e){
        super(message,e);
        this.status=status;
        this.msg=message;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getStatus() {
        return status;
    }
}
