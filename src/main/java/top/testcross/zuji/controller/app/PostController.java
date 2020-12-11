package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import top.testcross.zuji.exception.NotImplException;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.handler.PostHandler;
import top.testcross.zuji.service.IBmGeoPlaceInfoService;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.service.IBmPostMarkService;
import top.testcross.zuji.service.IPmPostService;
import top.testcross.zuji.util.Constants;

import java.util.LinkedList;
import java.util.List;

@RestController()
@RequestMapping(Constants.PREFIX+"/post")
@Api(tags = "动态")
public class PostController {
    @Autowired
    IPmPostService postService;

    @Autowired
    PostHandler postHandler;

    @Autowired
    IBmPostMarkService postMarkService;

    @ApiOperation("根据用户id获取动态")
    @GetMapping("/posts/user/{id}")
    public ResponseEntity getPostByUserId(@PathVariable("id") String id) {
        try{
            Result result=new Result("",postService.findPostByUserIdOrderByCreateTime(id),0);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("默认推荐缺省的动态")
    @GetMapping("/posts")
    public ResponseEntity getPartPost() {
        try{
            throw new NotImplException();
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @ApiOperation("根据tagid获取动态")
    @GetMapping("/posts/tag/{id}")
    public ResponseEntity getPostByTagId(@PathVariable("id") String id) {
        try{
            List<PmPost> posts=(List<PmPost>) postMarkService.findPostByTag(id);
            List<String> postIds=new LinkedList<>();
            for(PmPost post:posts){
                postIds.add(post.getPostId());
            }
            Result result=new Result("",postService.findPostInIds(postIds,null),0);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("根据动态id获取动态")
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

    @ApiOperation(value = "保存动态",notes = "需要提供动态信息，placeInfo信息和图片信息")
    @PostMapping("/{id}")
    public ResponseEntity savePost(@PathVariable("id")String id,@RequestBody PmPost post){
        try{
            return new ResponseEntity(new Result("",postHandler.savePost(post),233),HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("根据id删除动态")
    @DeleteMapping("/{id}")
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

    @ApiOperation(value = "更新动态",notes = "主要更新动态内容，无法直接添加tag、img等附加信息")
    @PutMapping("/{id}")
    public ResponseEntity updatePost(@PathVariable("id")String id,@RequestBody PmPost post){
        try{
            return new ResponseEntity(new Result("",postService.modifyByID(post),233),HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
