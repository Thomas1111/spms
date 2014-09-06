package jxau.spms.document.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jxau.spms.document.service.DocumentService;
import jxau.spms.notice.service.NoticeService;
import jxau.spms.student.po.StuDownInfo;
import jxau.spms.tutor.po.DocumentInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DocumentTestCase {

	private ClassPathXmlApplicationContext actionContext = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private DocumentService docService = (DocumentService) 
			actionContext.getBean("documentService");
	//@Test
	public void testQueryNotice(){
		HashMap<String, Object> params = new HashMap<>();
		params.put("role", 1);
		params.put("account", "20111826");
		System.out.print(docService.queryDocument(params));
	}
	@Test
	public void testUploadDoc(){
		DocumentInfo tutorDoc = new DocumentInfo();
		List<StuDownInfo> studentDoc = new ArrayList<>();
		HashMap<String, Object> params = new HashMap<String, Object>();
		StuDownInfo stu1 = new StuDownInfo();
		stu1.setDocNo(1);
		stu1.setStudentNo("20111826");
		StuDownInfo stu2 = new StuDownInfo();
		stu2.setDocNo(1);
		stu2.setStudentNo("20111830");
	
		studentDoc.add(stu1);
		studentDoc.add(stu2);
		
		//设置上传条件
				tutorDoc.setDocName("service测试中哦");
				tutorDoc.setDocType("开题报告类");
				tutorDoc.setTutorNo("1231");
				tutorDoc.setUploadTime(new Date());
				tutorDoc.setIdentifier("12311408031232");
				
		params.put("tutorDoc", tutorDoc);
		params.put("studentDoc", studentDoc);
		
		docService.addDocument(params);
	}
}
