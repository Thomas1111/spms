package jxau.spms.subjectManagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.student.service.StudentService;
import jxau.spms.subjectManagement.service.SubjectService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 * 2014-9-5
 * TODO
 */
@Controller("querySubjectAsyc")
@Scope("prototype")
public class QuerySubjectAsyc extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SubjectService subjectService;
	private HttpServletRequest request;
	private HttpSession session;
	private List<SubjectInfo> subjectInfos;
	private PageVo pageVo;
	
	
}
