package jxau.spms.subjectManagement.test;

import java.util.HashMap;

import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.subjectManagement.service.SubjectService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubjectTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private SubjectService subjectService = (SubjectService) 
			actionContext.getBean("subjectService");
	//@Test
	public void testQuerySubject(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("tutorNo", "1231");
		params.put("term", "2014-2015");
		//PageVo pageVo = null;
		PageVo pageVo = new PageVo();
		subjectService.querySubject(params, pageVo);
		System.out.println("页面数量==="+pageVo.getCount());
	}
	
	@Test
	public void testAddSubject(){
		
		SubjectInfo subjectInfo = new SubjectInfo();
		
		subjectInfo.setSubBrief("无");
		subjectInfo.setPapLocation("五教102");
		subjectInfo.setSubName("大数据时代的下web数据挖掘");
		subjectInfo.setSubPosition("校外");
		subjectInfo.setSubSource("横向且有经费");
		subjectInfo.setSubTerm("2014-2015");
		subjectInfo.setSubType("运用于理论结合研究");
		subjectInfo.setTutorNo("1231");
		
		subjectService.addSubject(subjectInfo);
		
	}
}
