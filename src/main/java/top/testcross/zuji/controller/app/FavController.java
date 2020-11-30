package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.testcross.zuji.bean.PamFavorite;
import top.testcross.zuji.bean.PamLike;
import top.testcross.zuji.bean.Result;
import top.testcross.zuji.exception.ExceptionLog;
import top.testcross.zuji.exception.ZuJiException;
import top.testcross.zuji.service.IPamFavoriteService;
import top.testcross.zuji.service.IPamLikeService;

@Controller
@RequestMapping("/fav")
@Api(tags = "收藏")
public class FavController {
    @Autowired
    IPamFavoriteService favoriteService;

    @PostMapping("/add")
    public ResponseEntity saveLike(@RequestBody PamFavorite favorite){
        try{
            return new ResponseEntity(new Result("",favoriteService.save(favorite),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteLikeById(@PathVariable("id") String favId){
        try{
            return new ResponseEntity(new Result("",favoriteService.deleteByID(favId),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity deleteLikeByUserAndPost(PamFavorite favorite){
        try{
            return new ResponseEntity(new Result("",favoriteService.deleteByUserIdAndPostId(favorite.getUserId(),favorite.getPostId()),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
