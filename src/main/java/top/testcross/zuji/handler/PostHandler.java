package top.testcross.zuji.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.BmGeoPlaceinfo;
import top.testcross.zuji.bean.BmImg;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.service.IBmGeoPlaceInfoService;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.service.IPmPostService;

import java.util.List;

@Component
public class PostHandler {
    @Autowired
    IPmPostService postService;

    @Autowired
    IBmImgService imgService;

    @Autowired
    IBmGeoPlaceInfoService placeInfoService;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int savePost(PmPost post){
        //保存地址
        BmGeoPlaceinfo placeinfo= post.getPlaceinfo();
        placeInfoService.save(placeinfo);

        //将地址信息赋给post
        post.setPiId(placeinfo.getPiId());
        //保存post
        postService.save(post);

        //将post信息给img
        List<BmImg> imgs= post.getImgs();
        for(BmImg img:imgs){
            img.setImgSrcId(post.getPostId());
        }

        imgService.saveImgs(imgs);

        return 1;
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int deletePost(PmPost post){
        imgService.deleteImgsBySrcId(post.getPostId());
        postService.deleteByID(post.getPostId());

        return 1;
    }


}
