package jxau.spms.login.service.imple;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import jxau.spms.abstraction.dao.Dao;
import jxau.spms.admin.po.AdminBasicInfo;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.login.service.LoginService;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.tutor.po.TutorBasicInfo;

import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImple implements LoginService {

	
	private Dao dao;
	private final String mapper = "jxau.spms.dao.";
	
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	@Override
	public Map<String, String> identifyUser(int role,Map<String, Object> params) throws UnusualParamsException{
		// TODO Auto-generated method stub
		Map<String, String> message = new HashMap<String, String>();
		int state = 0;
		if (params == null) {
			throw new UnusualParamsException("参数不能为空！");
		}
		
		if (role == 1) {
			StuBasicInfo stuBasicInfo = dao.selectOne(mapper+"selectStuInfo", params);
			if (stuBasicInfo == null) {
				message.put("info", "学生账号或密码错误！");
				return message;
			}
			state = stuBasicInfo.getStuState();
			message.put("name", stuBasicInfo.getStudentName());
		}else if (role == 2) {
			TutorBasicInfo tutorBasicInfo = dao.selectOne(mapper+"selectTutorInfo", params);
			if (tutorBasicInfo == null) {
				message.put("info", "导师账号或密码错误！");
				return message;
			}
			state = tutorBasicInfo.getTutorState();
			message.put("name", tutorBasicInfo.getTutorName());
		}else {
			AdminBasicInfo adminBasicInfo = dao.selectOne(mapper+"selectAdminInfo", params);
			if (adminBasicInfo == null) {
				message.put("info", "管理员账号或密码错误！");
				return message;
			}
			state = 1;
			message.put("name", adminBasicInfo.getAdminName());
		}
		
		if (state == 0) {
			message.put("info", "对不起,该用户已被禁用，请与管理员联系!");
		}else {
			message.put("info", "登录成功!");
		}
		
		return message;
	}

}
