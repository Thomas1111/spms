package jxau.spms.document.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jxau.spms.admin.po.NoticeInfo;
import jxau.spms.document.service.DocumentService;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.notice.service.NoticeService;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.student.po.StuDownInfo;
import jxau.spms.student.service.StudentService;
import jxau.spms.tutor.po.DocumentInfo;
import jxau.spms.util.FileUpload;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller("queryDocumentAction")
@Scope("prototype")
public class DocUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private DocumentService docService;
	private StudentService studentService;
	private HttpSession session;
	private HttpServletRequest request;	
	// 封装上传文件域的属性  
    private File upload;  
    
	/**
	 * Lai Huiqiang
	 * TODO 上传公告(持久化)
	 * 下午3:48:07
	 * @return 跳转标记位
	 */
	public String uploadDoc(){
		String message = null;
		HashMap<String, Object> params = new HashMap<String, Object>();
		request = ServletActionContext.getRequest();
		session = request.getSession();
		String stuName = request.getParameter("sendObject");	//获取发送对象
		DocumentInfo tutorDoc = setTutorDoc();		//获取导师信息
		List<StuDownInfo> studentDoc = setStuDoc(stuName);		//设置学生下载信息
		String suffix = ".doc";
        try {
        	FileUpload.upload(tutorDoc.getTutorNo(),upload,
        			tutorDoc.getIdentifier()+suffix,"document");		//调用工具类上传方法
        	//设置参数
        	params.put("tutorDoc", tutorDoc);
        	params.put("studentDoc", studentDoc);
        	//调用service执行操作
        	docService.addDocument(params);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message = "文件读写异常，上传失败!";
		}
	
		return "success";
	}
	/**
	 * TODO 设置导师基本信息
	 * 下午3:19:13
	 * @return 导师基本信息
	 */
	public DocumentInfo setTutorDoc(){
		DocumentInfo tutorDoc = new DocumentInfo();
		//获取管理员账号
		String tutorNo = (String) session.getAttribute("account");
		String docType = request.getParameter("fileType");		//获取文件类型
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String identifier = tutorNo + format.format(new Date());		//获取上传文件编号
		String fileName = request.getParameter("fileName");		//获取文件名称
		//设置上传条件
		tutorDoc.setDocName(fileName);
		tutorDoc.setDocType(docType);
		tutorDoc.setTutorNo(tutorNo);
		tutorDoc.setUploadTime(new Date());
		tutorDoc.setIdentifier(identifier);
		
		return tutorDoc;
	}
	
	/**
	 * TODO 设置学生下载信息
	 * 下午3:18:26
	 * @param stuName 学生姓名
	 * @return 学生下载信息
	 */
	public List<StuDownInfo> setStuDoc(String stuName){
		List<StuDownInfo> studentDoc = new ArrayList<>();	
		HashMap<String, Object> params = new HashMap<>();
		//设置查询参数
		params.put("tutorNo", session.getAttribute("account"));
		//获取学生基本信息
		List<StuBasicInfo> stuInfo = studentService.queryTutorStu(params);
		if ("----发给所有----".equals(stuName)) {		//判断是否是发给全部学生
			for (int i = 0; i < stuInfo.size(); i++) {
				StuDownInfo stuDownInfo = new StuDownInfo();
				//获取学号并赋值
				stuDownInfo.setStudentNo(stuInfo.get(i).getStudentNo());
				studentDoc.add(stuDownInfo);
			}
		}else {
			for (int i = 0; i < stuInfo.size(); i++) {		//匹配姓名，赋值学号
				if (stuName.endsWith(stuInfo.get(i).getStudentName())) {
					StuDownInfo stuDownInfo = new StuDownInfo();
					stuDownInfo.setStudentNo(stuInfo.get(i).getStudentNo());
					studentDoc.add(stuDownInfo);
				}				
			}
		}
		return studentDoc;
	}
	
	@Resource(name="documentService")
	public void setDocumentService(DocumentService docService){
		this.docService = docService;
	}
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
    public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
}
