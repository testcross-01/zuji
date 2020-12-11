package top.testcross.zuji.exception;

public class ExceptionLog {
    /**
     * 错误日志
     */

    /**
     * DaoUtil
     */
    public static final String NO_SUCH_METHOD="mapper中不包含此类方法";
    public static final String ILLEGAL_ACCESS="方法使用了错误的参数";
    public static final String INVOKE_EXCEPTION="方法执行错误";
    public static final String INTEGRITY_EXCEPTION="数据违反完整性约束(数据完整性、主键、外键等)";
    public static final String ACCESS_RESOURCE_EXCEPTION="数据访问资源失败（数据库连接失败）";
    public static final String ACCESS_RESOURCE_USAGE_EXCEPTION="错误使用数据访问资源(sql语句错误)";
    public static final String UNCATEGORIZED_EXCEPTION="无法分类异常";
    public static final String UNKNOW_EXCEPTION="未知异常";

    public static final int DAOUTIL_EXCEPTION_STATUS=0;

    /**
     * service
     */
    public static final String NOUSER_EXCEPTION="用户不存在更新";

    public static final int SERVICE_EXCEPTION_STATUS=1;

    /**
     * 未实现异常
     */
    public static final String NOT_IMPL_EXCEPTION="方法未实现";

    public static final int NOT_IMPL_EXCEPTION_STATUS=2;
}
