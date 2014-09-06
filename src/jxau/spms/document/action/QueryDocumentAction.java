package jxau.spms.document.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.student.po.StuDownInfo;
import jxau.spms.tutor.po.DocumentInfo;
import jxau.spms.document.service.DocumentService;
import jxau.spms.exception.DocNotExistException;
import jxau.spms.exception.NoticeNotExistException;
import jxau.spms.exception.RoleNotPermittedException;
import jxau.spms.exception.UnusualParamsException;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller("docUploadAction")
@Scope("prototype")
public class QueryDocumentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private DocumentService docService;
	private HttpSession session;
	private HttpServletRequest request;
	
	@Resource(name="documentService")
	public void setDocumentService(DocumentService docService){
		this.docService = docService;
	}
	
	/**
	 * TODO 获取用户文档信息
	 * 上午9:38:07
	 * @return 跳转标志位
	 */
	public String queryDocument(){
		String flag = "student";
		request = ServletActionContext.getRequest();
		session = request.getSession();
		List<DocumentInfo> docInfo = null;
		//List<StuDownInfo> studentDoc = null;
		//获取参数信息
		int role = (int) session.getAttribute("role");
		String account = (String) session.getAttribute("account");
		HashMap< String, Object> params = new HashMap<>();
		//设置查询条件
		params.put("role", role);
		params.put("account", account);
		//调用service查询方法
		try {
			docInfo = docService.queryDocument(params);
			if (role == 1) {
			}else {
				flag = "tutor";
			}
			request.setAttribute("docInfo", docInfo);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return flag;
		}catch (RoleNotPermittedException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return flag;
		}catch (DocNotExistException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return flag;
		}
		
		return flag;
	}
	
	
}
