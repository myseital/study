package com.stylefeng.guns;

import com.mao.maoyan.order.MaoyanOrderApplication;
import com.mao.maoyan.order.common.util.FTPUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MaoyanOrderApplication.class)
public class GunsRestApplicationTests {

	@Autowired
	private FTPUtil ftpUtil;

	@Test
	public void contextLoads() {

		String fileStrByAddress = ftpUtil.getFileStrByAddress("seats/cgs.json");

		System.out.println(fileStrByAddress);

	}

}
