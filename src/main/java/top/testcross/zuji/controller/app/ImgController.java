package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.BmImg;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.bean.UimUser;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.util.Constants;

@RestController
@Api(tags = "图片")
@RequestMapping(Constants.PREFIX+"/img")
public class ImgController {
    @Autowired
    IBmImgService imgService;

    @ApiOperation("获取图片")
    @GetMapping("/{id}")
    public ResponseEntity getImage(@PathVariable("id")String id){
        try{
            return new ResponseEntity(new Result("",imgService.findByID(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ApiOperation(value = "保存图片",notes = "动态和用户图片不需要主动调用此方法")
    @PostMapping("/{id}")
    public ResponseEntity saveImage(@PathVariable("id")String id,@RequestBody BmImg img){
        try{
            return new ResponseEntity(new Result("",imgService.save(img),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @ApiOperation("更新/替换图片")
    @PutMapping("/{id}")
    public  ResponseEntity updateImage(@PathVariable("id")String id,@RequestBody BmImg img){
        try{
            return new ResponseEntity(new Result("",imgService.modifyByID(img),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("删除图片")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteImage(@PathVariable("id")String id){
        try{
            return new ResponseEntity(new Result("",imgService.deleteByID(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
