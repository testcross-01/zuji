package top.testcross.zuji;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.testcross.zuji.bean.PamComment;
import top.testcross.zuji.bean.PamCommentExample;
import top.testcross.zuji.mapper.PamCommentMapper;
import top.testcross.zuji.service.IPmPostService;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("top.testcross.zuji.mapper")
public class JavaToJSON {

    @Autowired
    PamCommentMapper commentMapper;

    @Autowired
    IPmPostService pmPostService;

    @Test
    public void createJSONDoc(){
        List<PamComment> comments=commentMapper.selectByExample(null);
        String str= JSON.toJSONString(comments);

        List<String> postIds=new LinkedList<>();
        postIds.add("5bd70addaa824a7ca85def358e02e898");
        String str2=JSON.toJSONString(pmPostService.findPostInIds(postIds,null));
        String str3=JSON.toJSONString(pmPostService.findPartPostInIds(postIds));
        System.out.println();
    }

}
