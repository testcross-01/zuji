package top.testcross.zuji.bean.interfaces;

public interface DataBean {
    /**
     * 设置uuid
     * 保证记录全局唯一性
     */
    void setUUID(String uuid);

    /**
     * 获得uuid
     */
    String getUUID();
}
