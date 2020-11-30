package top.testcross.zuji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.testcross.zuji.mapper")
public class ZujiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZujiApplication.class, args);
	}

}
