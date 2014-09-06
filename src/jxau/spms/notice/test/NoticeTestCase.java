package jxau.spms.notice.test;

import java.io.File;
import java.util.HashMap;

import jxau.spms.notice.service.NoticeService;
import jxau.spms.tutor.service.TutorService;
import jxau.spms.util.FileUpload;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoticeTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private NoticeService noticeService = (NoticeService) 
			actionContext.getBean("noticeService");
	@Test
	public void testQueryNotice(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("role", 3);
		params.put("account", "0791");
		System.out.print(noticeService.queryNotice(params));
	}
}
