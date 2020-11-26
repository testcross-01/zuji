package top.testcross.zuji.util;


import org.springframework.jdbc.BadSqlGrammarException;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.bean.interfaces.Example;
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
     * 错误日志
     */
    private static final String NO_SUCH_METHOD="mapper中不包含此类方法";
    private static final String ILLEGAL_ACCESS="方法使用了错误的参数";
    private static final String INVOKE_EXCEPTION="方法执行错误";
    private static final String BAD_SQL_EXCEPTION="sql语法有误";
    private static final String WTF="耗子尾汁";//乱调用方法导致错误


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
            e.printStackTrace();
            System.out.println(NO_SUCH_METHOD);
            return 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(ILLEGAL_ACCESS);
            return 0;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(INVOKE_EXCEPTION);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(WTF);
            return 0;
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
            e.printStackTrace();
            System.out.println(NO_SUCH_METHOD);
            return 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(ILLEGAL_ACCESS);
            return 0;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(INVOKE_EXCEPTION);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(WTF);
            return 0;
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
            e.printStackTrace();
            System.out.println(NO_SUCH_METHOD);
            return 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(ILLEGAL_ACCESS);
            return 0;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(INVOKE_EXCEPTION);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(WTF);
            return 0;
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
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println(NO_SUCH_METHOD);
            return new DataBean() {
                @Override
                public void setUUID(String uuid) {

                }

                @Override
                public String getUUID() {
                    return null;
                }

                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            };
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(ILLEGAL_ACCESS);
            return new DataBean() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }

                @Override
                public void setUUID(String uuid) {

                }

                @Override
                public String getUUID() {
                    return null;
                }
            };
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(INVOKE_EXCEPTION);
            return new DataBean() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }

                @Override
                public String getUUID() {
                    return null;
                }

                @Override
                public void setUUID(String uuid) {

                }
            };
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(WTF);
            return new DataBean() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
                @Override
                public void setUUID(String uuid) {

                }

                @Override
                public String getUUID() {
                    return null;
                }
            };
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
            e.printStackTrace();
            System.out.println(NO_SUCH_METHOD);
            return new LinkedList<>();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(ILLEGAL_ACCESS);
            return new LinkedList<>();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(INVOKE_EXCEPTION);
            return new LinkedList<>();
        }

    }

}
