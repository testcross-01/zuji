package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
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

@RestController
@Api(tags = "评论")
@RequestMapping("/comt")
public class CommentController {
    @Autowired
    IPamCommentService commentService;

    @GetMapping("/comts/{id}")
    public ResponseEntity getComtsByPostId(@PathVariable("id") String id){
        try{
            return new ResponseEntity(new Result("",commentService.findCommentsByPostID(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody PamComment comment){
        try{
            return new ResponseEntity(new Result("",commentService.save(comment),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity delComment(@PathVariable("id") String id){
        try{
            return new ResponseEntity(new Result("",commentService.deleteByID(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateComment(@RequestBody PamComment pamComment){
        try{
            return new ResponseEntity(new Result("",commentService.modifyByID(pamComment),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
