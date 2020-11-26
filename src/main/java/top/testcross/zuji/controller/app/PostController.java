package top.testcross.zuji.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.service.IBmGeoPlaceInfoService;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.service.IPmPostService;

@RestController()
@RequestMapping("/post")
public class PostController {
    @Autowired
    IPmPostService postService;

    @Autowired
    IBmImgService imgService;

    @Autowired
    IBmGeoPlaceInfoService placeInfoService;

    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable("id") String id) {
        try{
            DataBean dataBean=postService.findByID(id);
            Result result=new Result("",dataBean,0);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new Result("",null,1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResponseEntity savePost(@RequestBody PmPost post){
        try {
            imgService.saveImgs(post.getImgs());
            placeInfoService.save(post.getPlaceinfo());
            postService.save(post);
            return new ResponseEntity(new Result(),HttpStatus.OK);
        }catch (Exception e){
            return null;
        }
    }



}
