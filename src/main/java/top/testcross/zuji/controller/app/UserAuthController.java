package top.testcross.zuji.controller.app;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.util.Constants;

@RestController()
@RequestMapping()
@Api(tags = "用户认证")
public class UserAuthController {

    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="用户名",dataType="string", paramType = "query"),
            @ApiImplicitParam(name="password",value="密码",dataType="string", paramType = "query")})
    @PostMapping("/login")
    public ResponseEntity login() {
        try{
            return new ResponseEntity(new Result(),HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),"",ex.getStatus()), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
