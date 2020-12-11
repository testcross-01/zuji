package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.mapper.BmImgMapper;
import top.testcross.zuji.mapper.BmTagMapper;
import top.testcross.zuji.mapper.BmUserMarkMapper;
import top.testcross.zuji.mapper.UimUserMapper;
import top.testcross.zuji.service.IUimUserService;
import top.testcross.zuji.util.DaoUtil;

import java.util.LinkedList;
import java.util.List;

@Service
public class UimUserServiceImpl implements IUimUserService {
    @Autowired
    UimUserMapper uimUserMapper;

    @Autowired
    BmImgMapper imgMapper;

    @Autowired
    BmTagMapper tagMapper;

    @Autowired
    BmUserMarkMapper markMapper;

    @Override
    public int save(DataBean dataBean) {
        return DaoUtil.insert(uimUserMapper,dataBean);
    }

    @Override
    public int deleteByID(String id) {
        return DaoUtil.deleteByID(uimUserMapper,id);
    }

    @Override
    public int modifyByID(DataBean dataBean) {
        return DaoUtil.updateByID(uimUserMapper,dataBean);
    }

    @Override
    public DataBean findByID(String id) {
        return DaoUtil.selectByID(uimUserMapper,id);
    }


    /**
     * 向用户中添加用户头像
     * @param user
     */
    private void addImgToUser(UimUser user) {
        if(user==null)return;
        BmImgExample imgExample=new BmImgExample();
        imgExample.createCriteria().andImgSrcIdEqualTo(user.getUserId());
        List<BmImg> imgs= (List<BmImg>)DaoUtil.selectByExample(imgMapper,imgExample);

        user.setDpImg(imgs.get(0));
    }

    /**
     * 向用户中添加tag
     * @param user
     */
    private void addTagsToUser(UimUser user) {
        if(user==null)return;
        //搜索所有标识记录值
        BmUserMarkExample markExample=new BmUserMarkExample();
        markExample.createCriteria().andUserIdEqualTo(user.getUserId());
        List<BmUserMark> marks=(List<BmUserMark>) DaoUtil.selectByExample(markMapper,markExample);

        //构建tag id list
        List<String> tagIds=new LinkedList<>();
        for(BmUserMark mark:marks){
            tagIds.add(mark.getTagId());
        }

        //搜索所有的标签
        BmTagExample tagExample=new BmTagExample();
        tagExample.createCriteria().andTagIdIn(tagIds);
        List<BmTag> tags=(List<BmTag>) DaoUtil.selectByExample(tagMapper,tagExample);

        user.setTags(tags);
    }

    @Override
    public DataBean findCompleteUser(String userId) {
        UimUser user= (UimUser) findByID(userId);
        addImgToUser(user);
        addTagsToUser(user);

        return user;
    }
}
