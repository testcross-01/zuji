package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.PamComment;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.service.IPamCommentService;
import top.testcross.zuji.util.Constants;

@RestController
@Api(tags = "评论")
@RequestMapping(Constants.PREFIX +"/comt")
public class CommentController {
    @Autowired
    IPamCommentService commentService;

    @ApiOperation( "根据动态id获取对应动态的所有评论")
    @GetMapping("/comts/post/{id}")
    public ResponseEntity getComtsByPostId(@PathVariable("id") String id){
        try{
            return new ResponseEntity(new Result("",commentService.findCommentsByPostID(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("添加新动态")
    @PostMapping("/{id}")
    public ResponseEntity addComment(@PathVariable("id") String id,@RequestBody PamComment comment){
        try{
            return new ResponseEntity(new Result("",commentService.save(comment),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/{id}")
    public ResponseEntity delComment(@PathVariable("id") String id){
        try{
            return new ResponseEntity(new Result("",commentService.deleteByID(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("修改评论")
    @PutMapping("/{id}")
    public ResponseEntity updateComment(@PathVariable("id") String id,@RequestBody PamComment pamComment){
        try{
            return new ResponseEntity(new Result("",commentService.modifyByID(pamComment),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
