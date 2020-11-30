package top.testcross.zuji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.testcross.zuji.bean.PmPost;
import top.testcross.zuji.controller.app.PostController;


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("top.testcross.zuji.mapper")
public class ControllerTest {

    @Autowired
    PostController postController;


    @Test
    public void postController(){
        postController.savePost(new PmPost());
    }

}
