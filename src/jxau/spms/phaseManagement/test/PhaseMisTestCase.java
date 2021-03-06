package jxau.spms.phaseManagement.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import jxau.spms.common.vo.MissionPageVo;
import jxau.spms.phaseManagement.service.PhaseMissionService;
import jxau.spms.student.po.StuMissionInfo;
import jxau.spms.tutor.po.PhaseMissionInfo;
import jxau.spms.util.FileUpload;

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
		public void testQueryVerMiss(){
			HashMap<String, Object> params = new HashMap<>();
			MissionPageVo missionPageVo = new MissionPageVo();
			//params.put("first", "yes");
			params.put("term", "2014-2015");
			params.put("tutorNo", "1231");
			params.put("missionNo", 2);
			
			System.out.println(phaseService.queryVerMission(params,missionPageVo));
			System.out.println(missionPageVo);
		}
	//@Test
	public void testUploadPhase(){
		
		StuMissionInfo stuMissionInfo = new StuMissionInfo();
		stuMissionInfo.setMissionName("测试");
		stuMissionInfo.setMissionNo(1);
		stuMissionInfo.setUploadTime(new Date());
		
		phaseService.uploadPhaMission(stuMissionInfo);
	}
	
	//@Test
	public void testVerStuPahMis(){
		
		HashMap<String, Object> params = new HashMap<>();
		
		params.put("studentNo", "20111826");
		params.put("exameState", 1);
		params.put("missionNo", 1);
		
		phaseService.verifyStuPhaMis(params);
		
	}
	
}
