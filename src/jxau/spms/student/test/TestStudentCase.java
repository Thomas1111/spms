package jxau.spms.student.test;

import java.util.HashMap;

import jxau.spms.notice.service.NoticeService;
import jxau.spms.student.service.StudentService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private StudentService stuService = (StudentService) 
			actionContext.getBean("studentService");
	@Test
	public void testQueryStudent() {
		HashMap< String, Object> params = new HashMap<>();
		params.put("tutorNo", "1231");
		stuService.queryTutorStu(params);
	}
}
