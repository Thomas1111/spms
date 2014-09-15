package jxau.spms.tutor.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jxau.spms.admin.po.AdminInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.tutor.po.TutorBasicInfo;
import jxau.spms.tutor.service.TutorService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("queryTutorAction")
@Scope("prototype")
public class QueryTutorAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private Map<String, Object> session;	
	private TutorService tutorService;
	
	/**
	 * 查询导师信息(导师、管理员)
	 * @return 重定向位置标识
	 * 
	*/
	public String queryTutor(){
		String message = "";
		String flag = "tutor";		//定义重定向的标识
		HashMap<String, Object> params = new HashMap<>();		//查询输入条件
		String account = (String) session.get("account");		//获取账号
		int role = (int) session.get("role");		//获取角色编号
		if ("".equals(account)||account == null) {
			System.out.println("编号为空!");
		}
		if (role == 2) {			//判断查询导师信息的角色
			querySingle(message,params,account);
		}else {		//当前角色是管理员
			String tutorNo = (String) request.getParameter("tutorNo");
			if (tutorNo == null) {		//判断管理员是否查询单个导师信息
				params.put("adminNo", account);		//存储管理员账号
				try {
					PageVo pageVo = setPageVo(params);		//设置分页对象，设定参数
					params.put("start", pageVo.getFirstIndex());	//设置起始序数
					params.put("number", pageVo.getSize());		//设置选取数量
					//调用service选择导师方法
					List<TutorBasicInfo> tutors = tutorService.queryTutors(params);		//调用service查询导师信息
					if (tutors == null||tutors.size() == 0) {	//判断符合条件的导师数量
						message = "当前还未分配导师!";
					}
					request.setAttribute("tutorsInfo", tutors);		//request存储查询导师信息
					flag = "admin";
					//判断管理员的操作类型,确定跳转路径
					String path = request.getParameter("opeType"); 	//获取跳转参数
					if ("adminManifest".equals(path)
							|| "verifySub".equals(path)) {
						flag = path;		
					}
				} catch (UnusualParamsException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}else {
				querySingle(message,params,tutorNo); 	//调用查询单个导师信息方法
			}
		}
		request.setAttribute("message", message);
		return flag;
	}
	//查询单个导师信息
	public void querySingle(String message,HashMap<String, Object> params,String account){
		params.put("tutorNo", account);		//存储当前登录教师账号
		try {
			TutorBasicInfo tutor = tutorService.queryTutorByNo(params);		//调用service查询导师信息
			if (tutor == null) {
				message = "数据异常了！";
			}
			request.setAttribute("tutorInfo", tutor);		//request存储查询导师信息
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * TODO 设置分页对象
	 * @param params 查询导师参数
	 */
	public PageVo setPageVo(HashMap<String, Object> params){
		PageVo pageVo = new PageVo();
		//设置符合条件导师的数量
		pageVo.setCount(tutorService.queryTutorNumber(params));
		//设置当前页面数
		pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		request.setAttribute("pageVo", pageVo);		//存储当前pageVo
		return pageVo;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	@Resource(name="tutorService")
	public void setTutorService(TutorService tutorService){
		this.tutorService = tutorService;
	}
	
}
