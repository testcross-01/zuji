package top.testcross.zuji.exception;

public class NotImplException extends ZuJiException {
    public NotImplException(){
        super(ExceptionLog.NOT_IMPL_EXCEPTION,ExceptionLog.NOT_IMPL_EXCEPTION_STATUS);
    }


    public NotImplException(String message,Exception e){
        super(ExceptionLog.NOT_IMPL_EXCEPTION,ExceptionLog.NOT_IMPL_EXCEPTION_STATUS,e);
    }
}
