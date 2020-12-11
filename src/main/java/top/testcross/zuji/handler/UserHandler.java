package top.testcross.zuji.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.testcross.zuji.bean.UimUser;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.service.IUimUserService;

@Component
public class UserHandler {
    @Autowired
    IUimUserService userService;

    @Autowired
    IBmImgService imgService;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int saveUser(UimUser user){
        userService.save(user);
        user.getDpImg().setImgSrcId(user.getUserId());
        imgService.save(user.getDpImg());

        return 1;
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int deleteUser(String id){
        //删除用户
        userService.deleteByID(id);

        //删除图片
        imgService.deleteImgsBySrcId(id);

        return 1;
    }

}
