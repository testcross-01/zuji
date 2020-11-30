package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.PamLike;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.service.IPamLikeService;

@RestController
@RequestMapping("/like")
@Api(tags = "喜爱")
public class LikeController {
    @Autowired
    IPamLikeService likeService;

    @PostMapping("/add")
    public ResponseEntity saveLike(@RequestBody PamLike like){
        try{
            return new ResponseEntity(new Result("",likeService.save(like),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteLikeById(@PathVariable("id") String likeId){
        try{
            return new ResponseEntity(new Result("",likeService.deleteByID(likeId),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity deleteLikeByUserAndPost(PamLike like){
        try{
            return new ResponseEntity(new Result("",likeService.deleteByUserIdAndPostId(like.getUserId(),like.getPostId()),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
