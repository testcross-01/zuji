package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

import java.util.List;

public interface IBmImgService extends IBaseService {
    /**
     * 保存所有照片
     * @param dataBeans
     * @return
     * @throws Exception
     */
    int saveImgs(List<? extends DataBean> dataBeans) throws Exception;


    /**
     * 计算图片数量
     * @param userId
     * @return
     */
    int countImgsByUser(String userId) throws Exception;
}
