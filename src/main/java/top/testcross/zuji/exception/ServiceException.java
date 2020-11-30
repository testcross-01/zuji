package top.testcross.zuji.exception;

public class ServiceException extends ZuJiException{
    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message,ExceptionLog.SERVICE_EXCEPTION_STATUS);
    }


    public ServiceException(String message,Exception e){
        super(message,ExceptionLog.SERVICE_EXCEPTION_STATUS,e);
    }
}
