package top.testcross.zuji;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.testcross.zuji.bean.*;
import top.testcross.zuji.mapper.PmPostMapper;
import top.testcross.zuji.mapper.UimFollowMapper;
import top.testcross.zuji.mapper.UimUserMapper;
import top.testcross.zuji.service.IBmImgService;
import top.testcross.zuji.service.IUimFollowService;
import top.testcross.zuji.util.DaoUtil;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("top.testcross.zuji.mapper")
class ZujiApplicationTests {
	@Autowired
	UimUserMapper mapper;

	@Autowired
	UimFollowMapper uimFollowMapper;

	@Autowired
	IUimFollowService uimFollowService;

	@Autowired
	IBmImgService imgService;

	@Autowired
	PmPostMapper pmPostMapper;
	@Test
	void contextLoads() throws Exception {
		UimFollowExample example=new UimFollowExample();
		List<String> uids=new LinkedList<>();

		example.createCriteria().andUserIdIn(uids);
		//uimFollowMapper.selectByExample(example);
		uids.add("123");
		example.createCriteria().andUserIdEqualTo(null);
		uimFollowMapper.selectByExample(example);

	}

	void count(Object mapper,Object example) throws Exception {
		Class clazz= mapper.getClass();
		Method method= clazz.getMethod("countByExample", example.getClass());
		System.out.println(method.invoke(mapper,example));
	}




}
