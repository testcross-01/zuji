package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.BmImgExample;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.PmPostExample;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmImgMapper;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.util.DaoUtil;

import java.util.List;

@Service
public class BmImgServiceImpl implements IBmImgService {
    @Autowired
    BmImgMapper imgMapper;

    @Autowired
    PmPostMapper postMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(imgMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(imgMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(imgMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(imgMapper,id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int saveImgs(List<? extends DataBean> dataBeans){
        //循环批量插入图片
        for (DataBean dataBean:dataBeans){
            DaoUtil.insert(imgMapper,dataBean);
        }
        return 1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int deleteImgsBySrcId(String srcId) {
        //根据srcId删除所有的照片
        BmImgExample example=new BmImgExample();
        example.createCriteria().andImgSrcIdEqualTo(srcId);

        return DaoUtil.deleteByExample(imgMapper,example);
    }

    @Override
    public int countImgsByUser(String userId) {
        int number=0;
        PmPostExample postExample=new PmPostExample();
        postExample.createCriteria().andUserIdEqualTo(userId);
        List<PmPost> posts=(List<PmPost>) DaoUtil.selectByExample(postMapper,postExample);

        for(PmPost post:posts){
            number+=post.getPostImgCount();
        }

        return number;
    }
}
