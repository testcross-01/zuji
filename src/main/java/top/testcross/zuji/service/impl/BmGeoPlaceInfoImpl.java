package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmGeoPlaceinfoMapper;
import top.testcross.zuji.service.IBmGeoPlaceInfoService;
import top.testcross.zuji.util.DaoUtil;

@Service
public class BmGeoPlaceInfoImpl implements IBmGeoPlaceInfoService {
    @Autowired
    BmGeoPlaceinfoMapper geoPlaceinfoMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(geoPlaceinfoMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(geoPlaceinfoMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(geoPlaceinfoMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(geoPlaceinfoMapper,id);
    }
}
