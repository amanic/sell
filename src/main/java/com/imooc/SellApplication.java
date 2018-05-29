package com.imooc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 本项目仅代表个人所有，与任何集团或者企业无关
 */
@SpringBootApplication
public class SellApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}



	@Override
	public void run(String... strings) throws Exception {

	}
}
