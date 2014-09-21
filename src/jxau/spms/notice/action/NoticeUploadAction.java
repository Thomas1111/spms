package jxau.spms.notice.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jxau.spms.admin.po.NoticeInfo;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.notice.service.NoticeService;
import jxau.spms.util.FileUpload;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqaing 
 * 2014-8-28
 * TODO 预处理发布公告
 */
@Controller("noticeUploadAction")
@Scope("prototype")
public class NoticeUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private HttpServletRequest request;
	private HttpSession session;
	// 封装上传文件域的属性  
    private File upload;  
    
	/**
	 * Lai Huiqiang
	 * TODO 上传公告(持久化)
	 * 下午3:48:07
	 * @return 跳转标记位
	 */
	public String addNotice(){
		PrintWriter out = null;
		String message = null;
		request = ServletActionContext.getRequest();
		session = request.getSession();
		NoticeInfo noticeInfo = new NoticeInfo();
		//获取管理员账号
		String adminNo = (String) session.getAttribute("adminNo");
		String noticeTitle = request.getParameter("noticeTitle");	//获取notice标题
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String identifier = adminNo + format.format(new Date());
		String suffix = ".doc";		//获取文件名称
		//设置上传条件
		noticeInfo.setAdminNo(adminNo);
		noticeInfo.setNoticeName(noticeTitle);
		noticeInfo.setUploadTime(new Date());
		noticeInfo.setIdentifier(identifier);
        try {
        	ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        	out = ServletActionContext.getResponse().getWriter();
        	FileUpload.upload(adminNo,upload,identifier+suffix,"notice");		//调用上传方法
        	message = noticeService.addNotice(noticeInfo);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message = "文件读写异常，上传失败!";
		}
        
        out.print(message);
        
		return "success";
	}
	
	@Resource(name="noiceService")
	public void setNoticeService(NoticeService noticeService){
		this.noticeService = noticeService;
	}
    public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	
}
