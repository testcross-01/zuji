package top.testcross.zuji.exception;

public class DaoUtilException extends ZuJiException {
    public DaoUtilException(){
        super();
    }

    public DaoUtilException(String message){
        super(message,ExceptionLog.DAOUTIL_EXCEPTION_STATUS);
    }


    public DaoUtilException(String message,Exception e){
        super(message,ExceptionLog.DAOUTIL_EXCEPTION_STATUS,e);
    }

}
