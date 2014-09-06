package jxau.spms.phaseManagement.test;

import java.util.HashMap;

import jxau.spms.phaseManagement.service.ReportService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PhaseManTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private ReportService reportService = (ReportService) 
			actionContext.getBean("reportService");
	
	@Test
	public void testQueryReport(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("tutorNo", "1231");
		params.put("reportTerm", "2014-2015");
		System.out.println(reportService.queryReport(params).get(0).getUploadTime());
	}
}
