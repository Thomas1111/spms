package jxau.spms.tutor.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import jxau.spms.common.vo.PassModification;
import jxau.spms.tutor.po.TutorBasicInfo;
import jxau.spms.tutor.service.TutorService;

import org.apache.poi.ss.usermodel.DataFormat;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class TutorTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private TutorService tutorService = (TutorService) 
			actionContext.getBean("tutorService");
	@Test
	public void testQueryTutor(){
		HashMap<String, Object> params = new HashMap<>();
		//params.put("tutorNo", "1231");
		params.put("adminNo", "0791");
		//params.put("password", "123456");
		System.out.print(tutorService.queryTutors(params));
	}
	//@Test
	public void testModofyPass(){
		PassModification modify = new PassModification();
		modify.setAccount("1231");
		modify.setPassword("123");
		modify.setModifyPass("123456");
		modify.setConfirmPass("123456");
		//params.put("tutorNo", "1231");
		//params.put("password", "123456");
		System.out.print(tutorService.updatePass(modify));
	}
	//@Test
	public void testUpdateTutor(){
		/*SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String identifier = "0791" + format.format(new Date());
		System.out.println(identifier);*/
		TutorBasicInfo tutorBasicInfo = new TutorBasicInfo();
		tutorBasicInfo.setTutorState(0);
		tutorBasicInfo.setTutorNo("1231");
		tutorService.updateTutor(tutorBasicInfo);
	}	
	
}
