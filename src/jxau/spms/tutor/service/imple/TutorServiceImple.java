package jxau.spms.tutor.service.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.common.vo.PassModification;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.student.po.StuInfo;
import jxau.spms.tutor.po.TutorBasicInfo;
import jxau.spms.tutor.service.TutorService;


/**
 * @author Administrator
 * 2014-8-27
 * TODO 操作导师的业务逻辑处理类
 */
@Service("tutorService")
public class TutorServiceImple implements TutorService {
	
	private Dao dao;
	private  final String mapper = "jxau.spms.dao.";
	@Resource(name = "dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see jxau.spms.tutor.service.TutorService#queryTutorByNo(java.util.Map)
	 * TODO
	 * Administrator
	 */
	@Override
	public TutorBasicInfo queryTutorByNo(Map<String, Object> params) 
			throws UnusualParamsException {
		// TODO Auto-generated method stub
		TutorBasicInfo tutor = null;
		if (params == null
				||"".equals(params.get("tutorNo"))
					||params.get("tutorNo") == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		tutor = dao.selectOne(mapper + "selectTutorBasicInfo", params);
		
		return tutor;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.tutor.service.TutorService#queryTutors(java.util.Map)
	 * TODO
	 * Administrator
	 */
	@Override
	public List<TutorBasicInfo> queryTutors(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		List<TutorBasicInfo> tutors = null;
		String adminNo = (String) params.get("adminNo");
		if (params.size() == 0||params == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		if (adminNo == null||"".equals(adminNo)) {
			throw new UnusualParamsException("参数错误!");
		}
		
		tutors = dao.select(mapper + "selectTutors", params);
		
		return tutors;
	}
	
	
	/* (non-Javadoc)
	 * @see jxau.spms.tutor.service.TutorService#batchAddTutor(java.util.List)
	 * TODO
	 * Administrator
	 */
	@Override
	public void batchAddTutor(List<TutorBasicInfo> tutors)
			throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see jxau.spms.tutor.service.TutorService#updateTutor(jxau.spms.tutor.po.TutorBasicInfo)
	 * TODO
	 * Administrator
	 */
	@Override
	public void updateTutor(TutorBasicInfo tutor) throws UnusualParamsException {
		// TODO Auto-generated method stub
		if (tutor == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		String tutorNo = tutor.getTutorNo();
		int state = tutor.getTutorState();
		if ((state !=0&&state != 1)||"".equals(tutor)||tutorNo == null) {
			throw new UnusualParamsException("参数错误!!!!");
		}
		dao.update(mapper+"updateTutor", tutor);
	}
	
	/* (non-Javadoc)
	 * @see jxau.spms.tutor.service.TutorService#updateTutorPass(jxau.sms.common.vo.PassModification)
	 * TODO
	 * Administrator
	 */
	@Override
	public String updatePass(PassModification modification) throws UnusualParamsException {
		// TODO Auto-generated method stub
		String message = "修改成功";
		String originPass = null;
		int role = modification.getRole();
		Map<String, Object> params = new HashMap<String, Object>();		//查询密码参数
		if (modification.getAccount() == null) {
			throw new UnusualParamsException("账号不能为空!");
		}
		if (modification.getModifyPass()==null) {		
			message = "修改密码不能为空";
		}else if(!modification.getModifyPass().equals(modification.getConfirmPass())) {
			message = "密码前后不一致";
		}else {
			params.put("account", modification.getAccount());		//设置账号参数
			params.put("password", modification.getPassword());		////设置密码参数
			originPass = modification.getPassword();
			if (!modification.getPassword().equals(originPass)) {		//判断该密码用户是否存在
				message = "原密码输入不正确";
			}else {
				params.put("modifyPass", modification.getModifyPass());		//设置新密码
				//判断角色，选择相应操作
				if (role == 1) {
					dao.update(mapper+"updateStuPass",params);	//修改学生密码
				}else if (role == 2) {
					dao.update(mapper+"updateTutorPass",params);	//修改导师密码
				}else {
					dao.update(mapper+"updateAdminPass",params);	//修改管理员密码
				}
			}
		}
		
		return message;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.tutor.service.TutorService#queryTutorNumber(java.util.Map)
	 * TODO
	 * Administrator
	 */
	@Override
	public int queryTutorNumber(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("adminNo")) {
			throw new UnusualParamsException("缺少重要参数!");
		}
		int number = dao.selectOne(mapper+"getTutorNum", params);
		
		return number;
	}
	
}
