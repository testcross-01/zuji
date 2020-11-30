package top.testcross.zuji.util;


import org.omg.CORBA.UNKNOWN;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.bean.interfaces.Example;
import top.testcross.zuji.exception.DaoUtilException;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.mapper.Mapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * dao用到的工具类
 */
public class DaoUtil {



    /**
     * 获取uuid
     * 用于各个主键
     * @return UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 插入记录
     * @param mapper
     * @param dataBean
     * @return 插入是否成功 0失败 1成功 其他情况具体分析
     */
    public static int insert(Mapper mapper, DataBean dataBean){
        try {
            dataBean.setUUID(getUUID());
            Method insert=mapper.getClass().getMethod("insert",dataBean.getClass());
            return (int)insert.invoke(mapper,dataBean);
        } catch (NoSuchMethodException e) {
            throw new DaoUtilException(ExceptionLog.NO_SUCH_METHOD,e);
        } catch (IllegalAccessException e) {
            throw new DaoUtilException(ExceptionLog.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw createDaoUtilException((Exception) e.getCause());
        }
    }


    /**
     * 通过id删除记录
     * @param mapper
     * @param id
     * @return 删除是否成功 0失败 1成功 其他情况具体分析
     */
    public static int deleteByID(Mapper mapper,String id){
        Method delete= null;
        try {
            delete = mapper.getClass().getMethod("deleteByPrimaryKey",String.class);
            return (int)delete.invoke(mapper,id);
        } catch (NoSuchMethodException e) {
            throw new DaoUtilException(ExceptionLog.NO_SUCH_METHOD,e);
        } catch (IllegalAccessException e) {
            throw new DaoUtilException(ExceptionLog.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw createDaoUtilException((Exception) e.getCause());
        }
    }

    /**
     *根据id更新记录
     * @param mapper
     * @param dataBean
     * @return 更新是否成功 0失败 1成功 其他情况具体分析
     */
    public static int updateByID(Mapper mapper,DataBean dataBean){
        Method update= null;
        try {
            update = mapper.getClass().getMethod("updateByPrimaryKeySelective",dataBean.getClass());
            return (int)update.invoke(mapper,dataBean);
        } catch (NoSuchMethodException e) {
            throw new DaoUtilException(ExceptionLog.NO_SUCH_METHOD,e);
        } catch (IllegalAccessException e) {
            throw new DaoUtilException(ExceptionLog.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw createDaoUtilException((Exception) e.getCause());
        }
    }

    /**
     * 根据id查询记录
     * @param mapper
     * @param id
     * @return 返回记录
     */
    public static DataBean selectByID(Mapper mapper,String id){
        Method select=null;
        try {
            select = mapper.getClass().getMethod("selectByPrimaryKey",String.class);
            return (DataBean) select.invoke(mapper,id);
        }catch (NoSuchMethodException e) {
            throw new DaoUtilException(ExceptionLog.NO_SUCH_METHOD,e);
        } catch (IllegalAccessException e) {
            throw new DaoUtilException(ExceptionLog.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw createDaoUtilException((Exception) e.getCause());
        }

    }

    /**
     * selectByExample统一入口
     * @param mapper
     * @param example
     * @return 查询到的集合
     */
    public  static List<? extends DataBean> selectByExample(Mapper mapper, Example example) {
        try{
            Method selectByExample=mapper.getClass().getMethod("selectByExample",example.getClass());
            return (List<? extends DataBean>)selectByExample.invoke(mapper,example);
        }catch (NoSuchMethodException e) {
            throw new DaoUtilException(ExceptionLog.NO_SUCH_METHOD,e);
        } catch (IllegalAccessException e) {
            throw new DaoUtilException(ExceptionLog.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw createDaoUtilException((Exception) e.getCause());
        }
    }

    /**
     * 根据example删除记录
     * @param mapper
     * @param example
     * @return 是否成功
     */
    public static int deleteByExample(Mapper mapper, Example example){
        try{
            Method deleteByByExample=mapper.getClass().getMethod("deleteByExample",example.getClass());
            return (int)deleteByByExample.invoke(mapper,example);
        }catch (NoSuchMethodException e) {
            throw new DaoUtilException(ExceptionLog.NO_SUCH_METHOD,e);
        } catch (IllegalAccessException e) {
            throw new DaoUtilException(ExceptionLog.ILLEGAL_ACCESS,e);
        } catch (InvocationTargetException e) {
            throw createDaoUtilException((Exception) e.getCause());
        }
    }

    /**
     * 根据不同的cause异常来建立对应的异常处理
     * @param ex
     * @return
     */
    private static DaoUtilException createDaoUtilException(Exception ex){
        DaoUtilException daoUtilException=null;
        if(ex instanceof DataIntegrityViolationException){
            daoUtilException=new DaoUtilException(ExceptionLog.INTEGRITY_EXCEPTION,ex);
        }else if(ex instanceof InvalidDataAccessResourceUsageException){
            daoUtilException=new DaoUtilException(ExceptionLog.ACCESS_RESOURCE_USAGE_EXCEPTION, ex);
        }else if(ex instanceof UncategorizedDataAccessException){
            daoUtilException=new DaoUtilException(ExceptionLog.UNCATEGORIZED_EXCEPTION,ex);
        }else if(ex instanceof DataAccessResourceFailureException){
            daoUtilException=new DaoUtilException(ExceptionLog.ACCESS_RESOURCE_EXCEPTION, ex);
        }else{
            daoUtilException=new DaoUtilException(ExceptionLog.UNKNOW_EXCEPTION,ex);
        }

        return daoUtilException;
    }

}
