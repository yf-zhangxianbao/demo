package com.example.test.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.domain.User;
import com.example.test.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService ts;
	
	/**
	 * 访问数据库测试
	 * @return
	 */
	@GetMapping("/test")
	public User test() {
		Map<String,Object> count = ts.selectCount();
		String name =(String)count.get("XM");
		String xb = (String)count.get("XB");
		User u = new User();
		u.setName(name);
		u.setXb(xb);
		return u;
	}
	
	 @GetMapping("/export")
	 public void downloadLocal(@RequestParam("fileId") String fileId,HttpServletResponse response) throws FileNotFoundException {
		  // 下载本地文件
	      String fileName = "text.docx".toString(); // 文件的默认保存名
	      // 读到流中
	      InputStream inStream = new FileInputStream("c:/text.docx");// 文件的存放路径
	      // 设置输出的格式
	      response.reset();
	      response.setContentType("bin");
		  response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	      // 循环取出流中的数据
	      byte[] b = new byte[100];
	      int len;
	      try {
	        while ((len = inStream.read(b)) > 0)
	         response.getOutputStream().write(b, 0, len);
	         inStream.close();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	  }
}
