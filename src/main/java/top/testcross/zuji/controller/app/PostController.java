package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.handler.PostHandler;
import top.testcross.zuji.service.IBmGeoPlaceInfoService;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.service.IPmPostService;

@RestController()
@RequestMapping("/post")
@Api(tags = "动态")
public class PostController {
    @Autowired
    IPmPostService postService;

    @Autowired
    PostHandler postHandler;

    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable("id") String id) {
        try{
            DataBean dataBean=postService.findByID(id);
            Result result=new Result("",dataBean,0);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity savePost(@RequestBody PmPost post){
        try{
            return new ResponseEntity(new Result("",postHandler.savePost(post),233),HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deletePostById(@PathVariable("id") String postId){
        try{
            DataBean dataBean=postService.findByID(postId);
            return new ResponseEntity(new Result("",postHandler.deletePost((PmPost)dataBean),233),HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
