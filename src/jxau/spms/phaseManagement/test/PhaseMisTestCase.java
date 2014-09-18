package jxau.spms.phaseManagement.test;

import java.util.Date;
import java.util.HashMap;
import jxau.spms.phaseManagement.service.PhaseMissionService;
import jxau.spms.student.po.StuMissionInfo;
import jxau.spms.tutor.po.PhaseMissionInfo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PhaseMisTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private PhaseMissionService phaseService = (PhaseMissionService) 
			actionContext.getBean("phaseMissionService");
	//@Test
	public void testAddPhase(){

		PhaseMissionInfo phaseMissionInfo = new PhaseMissionInfo();
		
		phaseMissionInfo.setTutorNo("1231");
		phaseMissionInfo.setStartTime(new Date());
		phaseMissionInfo.setMisBrief("无");
		phaseMissionInfo.setMisName("任务一");
		phaseMissionInfo.setPhaseTerm("2014-2015");
		phaseMissionInfo.setEndTime(new Date());
		
		String sendObj = "赖辉强";
		
		phaseService.addPhaseMission(phaseMissionInfo, sendObj);
	
	}
	//@Test
	public void testSendObject(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("tutorNo", "1231");
		params.put("term", "2014-2015");
		
		System.out.println(phaseService.querySendObject(params));
	}
	
	//@Test
	public void testQueryPhase(){
		HashMap<String, Object> params = new HashMap<>();
		//params.put("tutorNo", "1231");
		params.put("term", "2014-2015");
		params.put("account", "20111827");
		params.put("role", 1);
		
		System.out.println(phaseService.queryPhaseMission(params));
	}
	
	@Test
	public void testUploadPhase(){
		
		StuMissionInfo stuMissionInfo = new StuMissionInfo();
		stuMissionInfo.setMissionName("测试");
		stuMissionInfo.setMissionNo(1);
		stuMissionInfo.setUploadTime(new Date());
		
		phaseService.uploadPhaMission(stuMissionInfo);
	}
}
