package jxau.spms.phaseManagement.test;

import java.util.Date;
import java.util.HashMap;

import jxau.spms.common.po.ReportInfo;
import jxau.spms.phaseManagement.service.ReportService;
import jxau.spms.student.service.StudentService;
import jxau.spms.tutor.po.TaskInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PhaseManTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private ReportService reportService = (ReportService) 
			actionContext.getBean("reportService");
	private StudentService studentService = (StudentService) 
			actionContext.getBean("studentService");
	
	//@Test
	public void testQueryReport(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("tutorNo", "1231");
		params.put("reportTerm", "2014-2015");
		System.out.println(reportService.queryReport(params));
	}
	
	//@Test
	public void testAddReport(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("subName", "基于B/S架构的飞机航班订票系统的设计与开发");
		params.put("tutorNo", "1231");
		params.put("term", "2014-2015");
		
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setContent("测试");
		taskInfo.setDiagram("测试");
		taskInfo.setIndicator("测试");
		taskInfo.setReference("测试");
		taskInfo.setSchedule("测试");

		reportService.addTaskInfo(taskInfo, params);
	}
	
	//@Test
	public void testQueryTask(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("studentNo", "20111826");
		params.put("term", "2014-2015");
		System.out.println(reportService.queryTaskInfo(params));
	}
	
	@Test
	public void testVeriReport() {
		HashMap<String, Object> params = new HashMap<>();
		params.put("type", "pass");
		params.put("reportNo",1);
		reportService.verifyReport(params);
	}
	
	//@Test
	public void addReport() {
		HashMap<String, Object> params = new HashMap<>();
		ReportInfo reportInfo = new ReportInfo();
		reportInfo.setExameState(2);
		reportInfo.setReportName("测试");
		reportInfo.setMemo("无");
		reportInfo.setReportTerm("2014-2015");
		reportInfo.setStudentNo("20111826");
		reportInfo.setTutorNo("1231");
		reportInfo.setUploadTime(new Date());
		
		params.put("studentNo", "20111826");
		params.put("reportTerm", reportInfo.getReportTerm());
		
		reportService.addReport(reportInfo, params);
	}

}
