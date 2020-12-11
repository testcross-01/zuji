package top.testcross.zuji.controller.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import top.testcross.zuji.util.Constants;

@Controller
@RequestMapping(Constants.PREFIX+"/fav")
@Api(tags = "收藏")
public class FavController {
    @Autowired
    IPamFavoriteService favoriteService;

    @ApiOperation("收藏动态")
    @PostMapping("/{id}")
    public ResponseEntity saveFav(@PathVariable("id") String id,@RequestBody PamFavorite favorite){
        try{
            return new ResponseEntity(new Result("",favoriteService.save(favorite),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("根据favId取消收藏")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteFavById(@PathVariable("id") String favId){
        try{
            return new ResponseEntity(new Result("",favoriteService.deleteByID(favId),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("根据userId和postId取消收藏")
    @DeleteMapping("/uap")
    public ResponseEntity deleteFavByUserAndPost(PamFavorite favorite){
        try{
            return new ResponseEntity(new Result("",favoriteService.deleteByUserIdAndPostId(favorite.getUserId(),favorite.getPostId()),233), HttpStatus.OK);
        }catch (ZuJiException ex){
            return new ResponseEntity(new Result(ex.getMsg(),null,ex.getStatus()),HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity(new Result(ExceptionLog.UNKNOW_EXCEPTION,"",-1),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
