package jxau.spms.phaseManagement.action;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.po.TermInfo;
import jxau.spms.common.vo.MissionPageVo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.common.vo.ReportInfoVo;
import jxau.spms.common.vo.StuPhaseMission;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.ReportNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.PhaseMissionService;
import jxau.spms.phaseManagement.service.ReportService;
import jxau.spms.student.po.StuMissionInfo;
import jxau.spms.student.service.StudentService;
import jxau.spms.tutor.po.PhaseMissionInfo;
import jxau.spms.util.FileUpload;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-9-17
 * TODO 管理以及操作阶段任务
 */
@Controller("phaseMissionAction")
@Scope("prototype")
public class PhaseMissionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private PhaseMissionService phaseMissionService ;
	private StudentService studentService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	// 封装上传文件域的属性  
    private File upload;
    private String message;
    private PageVo pageVo;
    
    @Resource(name="phaseMissionService")
    public void setPhaseMissionService(PhaseMissionService phaseMissionService){
    	this.phaseMissionService = phaseMissionService;
    }
    @Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
    /**
     * TODO 导师发布阶段任务
     * 下午4:24:14
     * @return 
     */
    public String addPhaseMission(){
    	message = "添加成功";
    	String sendObj = request.getParameter("missionObject");	//获取发送对象
    	String tutrNo = (String) session.getAttribute("tutorNo");	//获取导师账号
    	String startTime = request.getParameter("startTime");	//获取起始时间
    	String deadline = request.getParameter("deadline");		//获取终止时间
    	
    	//实例化并设置阶段任务信息
    	PhaseMissionInfo phaseMissionInfo = new PhaseMissionInfo();
		phaseMissionInfo.setTutorNo(tutrNo);
		try {
			//设置起始、终止时间格式
			phaseMissionInfo.setStartTime(DateUtils.parseDate
					(startTime, "yyyy-MM-dd"));
			phaseMissionInfo.setEndTime(DateUtils.parseDate
					(deadline, "yyyy-MM-dd"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			message = "时间格式不正确";
		}
		phaseMissionInfo.setMisBrief(request.getParameter("description"));
		phaseMissionInfo.setMisName(request.getParameter("missionName"));
		phaseMissionInfo.setPhaseTerm(request.getParameter("term"));
		//调用service添加方法
		try {
			phaseMissionService.addPhaseMission(phaseMissionInfo, sendObj);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		System.out.println("************" + message);
		
		request.setAttribute("message", message);	
		
    	return "add";
    }
    
    /**
     * TODO 查询阶段任务信息
     * 下午8:58:20
     * @return 
     */
    public String queryPhaseInfo(){
    	message = "查询成功";
    	String dispatch = "tutPhaMisson";
    	HashMap<String, Object> params = new HashMap<>();
		pageVo = new PageVo();		//实例化分页对象
		//获取默认学期信息
    	List<TermInfo> terms = studentService.queryTerms(null);
		//判断加载信息标志位
		String flag = request.getParameter("flag");
		//获取开题报告学期
		String term;
		if ("reload".equals(flag)) {
			term = request.getParameter("term");	//获取加载学期信息
		}else {
			term = terms.get(terms.size() - 1).getTerm();		//默认加载最新学期内容
		}
		int role = (int) session.getAttribute("role");	//获取角色编号哦
		String account = null;	
		//获取当前页面数
		String page = request.getParameter("currentPage");
		if (page == null || "".equals(page)) {
			message = "参数错误";
			return dispatch;
		}
		int currentPage = Integer.parseInt(page.trim());
		//设置分页对象属性
		pageVo.setCurrentPage(currentPage);
		//设置查询参数
		params.put("role", role);
		//判断角色,获取用户账号
		if (role == 1) {
			account = (String) session.getAttribute("studentNo");		
		}else if (role==2) {
			account = (String) session.getAttribute("tutorNo");	
		}else {
			account = (String) session.getAttribute("adminNo");	
		}
		params.put("account", account);
		params.put("term", term);
		//设置分页内容
		params.put("start",pageVo.getFirstIndex());		
		params.put("number",pageVo.getSize());
		//设置term属性
		request.setAttribute("terms", terms);
		request.setAttribute("term", term);
		try {
			//查询信息
			List<StuPhaseMission> phaseMissions = 
					phaseMissionService.queryPhaseMission(params);
			int number = phaseMissionService.queryMissionNum(params);	//获取审核的数量
			pageVo.setCount(number);	//设置数量
			//设置request属性(报告对象、分页对象)
			request.setAttribute("phaseMissions", phaseMissions);
			request.setAttribute("pageVo", pageVo);	
			} catch (UnusualParamsException e) {
				// TODO: handle exception
				message = e.getMessage();
			}catch (CommonErrorException e) {
				// TODO: handle exception
				message = e.getMessage();
			}finally{
				request.setAttribute("message", message);
			}
		if (role == 1) {
			dispatch = "stuPhaMisson";
		}

    	return dispatch;
    }
    /**
     * TODO 导师获取学生阶段任务审核信息
     * 下午4:15:57
     * @return
     */
    public String queryVerMission(){
    	message = "查询成功";
    	HashMap<String, Object> params = new HashMap<>();
    	MissionPageVo missionPageVo = new MissionPageVo();
		//获取默认学期信息
    	List<TermInfo> terms = studentService.queryTerms(null);
		//判断加载信息标志位
		String flag = request.getParameter("flag");
		//获取开题报告学期
		String term;
		if ("reload".equals(flag)) {
			term = request.getParameter("term");	//获取加载学期信息
		}else {
			term = terms.get(terms.size() - 1).getTerm();		//默认加载最新学期内容
		}
		String tutorNo = (String) session.getAttribute("tutorNo");	//获取用户账号
		String init = request.getParameter("init");
		String missionNo = null;
		//设置查询参数
		params.put("tutorNo", tutorNo);
		params.put("term", term);
		if ("yes".equals(init)) {		//判断是否默认加载
			params.put("first", "yes");		
		}else {
			missionNo = request.getParameter("missionNo");
			if (missionNo == null || " ".equals(missionNo)) {
				message = "参数错误";
				return "veriMisInfo";
			}
			params.put("missionNo",Integer.parseInt(missionNo.trim()));  //设置missionNo参数
		}
		//设置term属性
		request.setAttribute("terms", terms);
		request.setAttribute("term", term);
		
		try {
			//查询信息
			List<StuPhaseMission> verMissions = 
					phaseMissionService.queryVerMission(params,missionPageVo);
			//设置request属性
			request.setAttribute("verMissions", verMissions);
			request.setAttribute("missionPageVo",missionPageVo);	//设置当前阶段任务编号	//设置当前阶段任务编号
			} catch (UnusualParamsException e) {
				// TODO: handle exception
				message = e.getMessage();
			}catch (CommonErrorException e) {
				// TODO: handle exception
				message = e.getMessage();
			}finally{
				request.setAttribute("message", message);
			}
	
    	return "veriMisInfo";
    }
    /**
	 * TODO 学生上传阶段任务
	 * @return 跳转标记位
	 */
	public String uploadPhaMission(){
		String message = "添加成功";
		StuMissionInfo stuMissionInfo = new StuMissionInfo();
		String missionNo = request.getParameter("missionNo");		//获取任务编号
		String term = request.getParameter("term");	//获取当前学期
		if (missionNo == null || term == null) {
			message = "参数异常";
			return "stuPhaMisson";
		}
		//获取学生学号
		String studentNo = (String) session.getAttribute("studentNo");
		stuMissionInfo.setStudentNo(studentNo);			//设置学生学号
		stuMissionInfo.setMissionNo(Integer.parseInt(missionNo.trim()));	//设置任务编号
		stuMissionInfo.setUploadTime(new Date());	//设置上传时间	
		stuMissionInfo.setMissionName(request.getParameter("fileName"));//设置文件名称
		try {
			FileUpload.upload(term+File.separator+studentNo,upload,
					stuMissionInfo.getMissionName(),"phaseMission");	//调用上传工具类方法	
			phaseMissionService.uploadPhaMission(stuMissionInfo);	//调用service更新方法
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		
		System.out.println("*************" + message);
		return "stuPhaMisson";
	}
	
	
	 public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
}
