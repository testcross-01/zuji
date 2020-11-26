package top.testcross.zuji.bean;

import lombok.Data;
import top.testcross.zuji.bean.interfaces.DataBean;

@Data
public class Result {
    /**
     * 错误信息
     */
    private String errInfo;

    /**
     * 返回的数据结果
     */
    private DataBean resultData;

    /**
     * 返回状态
     */
    private int status;

    public Result(){

    }

    public Result(String errInfo, DataBean resultData, int status) {
        this.errInfo = errInfo;
        this.resultData = resultData;
        this.status = status;
    }
}
