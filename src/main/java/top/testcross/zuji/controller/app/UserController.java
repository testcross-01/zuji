package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.BmImg;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.bean.UimUser;
import top.testcross.zuji.bean.interfaces.DataBean;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.handler.UserHandler;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.service.IUimUserService;
import top.testcross.zuji.util.Constants;

@RestController
@Api(tags = "用户")
@RequestMapping(Constants.PREFIX+"/user")
public class UserController {
    @Autowired
    IUimUserService userService;

    @Autowired
    UserHandler userHandler;

    @ApiOperation("获得完整的用户")
    @GetMapping("/{id}")
    public ResponseEntity getCompleteUser(@PathVariable("id")String id){
        try{
            return new ResponseEntity(new Result("",userService.findCompleteUser(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/{id}")
    @ApiOperation("保存用户")
    public ResponseEntity saveUser(@PathVariable("id")String id,@RequestBody UimUser user){
        try{
            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
            return new ResponseEntity(new Result("",userHandler.saveUser(user),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/{id}")
    @ApiOperation(value = "更新用户",notes = "更改用户的姓名，密码等，无法修改tag和img这种附加信息")
    public  ResponseEntity upDateUser(@PathVariable("id")String id,@RequestBody UimUser user){
        try{
            return new ResponseEntity(new Result("",userService.modifyByID(user),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户")
    public ResponseEntity deleteUser(@PathVariable("id")String id){
        try{
            return new ResponseEntity(new Result("",userHandler.deleteUser(id),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
