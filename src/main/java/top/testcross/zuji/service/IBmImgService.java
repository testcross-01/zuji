package top.testcross.zuji.service;

import top.testcross.zuji.bean.interfaces.DataBean;

import java.util.List;

public interface IBmImgService extends IBaseService {
    int saveImgs(List<? extends DataBean> dataBeans) throws Exception;
}
