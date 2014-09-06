package jxau.spms.subjectManagement.test;

import java.util.HashMap;
import jxau.spms.common.vo.PageVo;
import jxau.spms.subjectManagement.service.SubjectService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubjectTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private SubjectService subjectService = (SubjectService) 
			actionContext.getBean("subjectService");
	@Test
	public void testQuerySubject(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("tutorNo", "1231");
		params.put("term", "2014-2015");
		//PageVo pageVo = null;
		PageVo pageVo = new PageVo();
		subjectService.querySubject(params, pageVo);
		System.out.println("页面数量==="+pageVo.getCount());
	}
}
