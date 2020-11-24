package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    public int saveImgs(List<? extends DataBean> dataBeans) throws Exception {
        //循环批量插入图片
        for (DataBean dataBean:dataBeans){
            int result=DaoUtil.insert(imgMapper,dataBean);
            if(result==0){
                throw new Exception("图片数据插入异常");
            }
        }
        return 1;
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
