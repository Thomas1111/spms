package jxau.spms.phaseManagement.service.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.login.AccountException;

import org.springframework.stereotype.Service;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.common.vo.PhaseMissionVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.PhaseMissionService;
import jxau.spms.student.po.StuMissionInfo;
import jxau.spms.tutor.po.PhaseMissionInfo;

/**
 * @author Lai Huiqiang 
 * 2014-9-17
 * TODO 管理以及操作阶段任务业务实现类
 */
@Service("phaseMissionService")
public class PhaseMissionServiceImple implements PhaseMissionService {

	private final String mapper = "jxau.spms.dao.";
	
	private Dao dao;
	
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.PhaseMissionService#addPhaseMission(jxau.spms.tutor.po.PhaseMissionInfo, java.lang.String)
	 * TODO 导师发布阶段任务
	 */
	@Override
	public void addPhaseMission(PhaseMissionInfo phaseMissionInfo,
			String sendObj) throws RuntimeException {
		// TODO Auto-generated method stub
		//实例化查询学生学号的参数条件
		Map<String, Object> params = new HashMap<String, Object>();
		//判断参数信息是否为空
		if (phaseMissionInfo == null || sendObj == null 		
				|| " ".equals(sendObj)) {
			throw new UnusualParamsException("参数信息不能为空");
		}
		//判断参数内容的合理性
		if (phaseMissionInfo.getStartTime() == null 
				||phaseMissionInfo.getEndTime()== null 
					|| "".equals(phaseMissionInfo.getMisBrief())
						|| "".equals(phaseMissionInfo.getMisName())
							|| equals(phaseMissionInfo.getPhaseTerm() == null)) {
			throw new UnusualParamsException("参数内容不能为空");
		}
		//判断起始、终止时间的合理性
		
		params.put("tutorNo", phaseMissionInfo.getTutorNo());	//设置导师工号参数
		if (!"----全部----".equals(sendObj)) {		//获取并判断发送对象
			params.put("studentName",sendObj);
			sendObj="全部学生";
		}
		params.put("stuExaState", 1);		//设置审核为"已通过"状态
		params.put("term",phaseMissionInfo.getPhaseTerm());		//设置学期信息
		phaseMissionInfo.setSendObject(sendObj);	//设置发送对象信息
		//调用dao添加方法
		dao.add(mapper + "addPhaseMission", phaseMissionInfo);	
		int missionNo = phaseMissionInfo.getMissionNo();	//获取自动增长的编号
		//获取发送对象学号
		List<PhaseMissionVo> phaseMissions = dao.select(mapper + "selectSendObject", params);
		//设置任务编号
		for (PhaseMissionVo element:phaseMissions) {
			element.setMissionNo(missionNo);
			System.out.println(element);
		}
		params.clear();		//清空参数信息
		params.put("phaseMissions", phaseMissions);		//设置批量添加参数信息
		//批量添加学生阶段任务
		dao.batchAdd(mapper + "batchAddStuPhase", params);
	}

	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.PhaseMissionService#querySendObject(java.util.Map)
	 * TODO
	 */
	@Override
	public List<PhaseMissionVo> querySendObject(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {	
			throw new UnusualParamsException("参数信息不能为空");
		}
		if (params.get("tutorNo") == null 	//判断参数信息是否为空
				|| params.get("term") == null) {
			throw new UnusualParamsException("请设置必要参数信息");
		}
		params.put("stuExaState", 1);		//设置状态参数为"已通过"状态
		List<PhaseMissionVo> phaseMissions = dao.select(mapper + "selectSendObject", params);
		//判断发送对象信息是否为空
		if (phaseMissions == null || 
				phaseMissions.size() == 0) {
			throw new CommonErrorException("尚未有人申请选题，无法发布任务书");
		}
		return phaseMissions;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.PhaseMissionService#queryPhaseMission(java.util.Map)
	 * TODO 导师、学生获取阶段任务信息
	 */
	@Override
	public <E> List<E> queryPhaseMission(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		List<E> phaseMission = null;
		//判断参数是够为空
		if (params == null) {	
			throw new UnusualParamsException("参数信息不能为空");
		}
		//获取账号和角色
		int role = (int) params.get("role");
		String account = (String) params.get("account");
		//判断参数内容是否为空
		if (params.get("term") == null || 
				(role != 1&&role != 2) || account == null) {
			throw new UnusualParamsException("请设置必要参数信息");
		}
		//判断角色
		if (role == 1) {
			params.put("studentNo", account);	//设置学生学号
		}else {
			params.put("tutorNo", account);	//设置导师工号
		}
	
		//调用dao查询方法
		phaseMission = dao.select(mapper + "selectPhaMission", params);
		//判断查询结果是否为空
		if (phaseMission.size() == 0) {
			throw new CommonErrorException("尚未发布阶段任务");
		}
		
		return phaseMission;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.PhaseMissionService#queryMissionNum(java.util.Map)
	 * TODO 获取符合条件的阶段任务数
	 */
	@Override
	public int queryMissionNum(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {	
			throw new UnusualParamsException("参数信息不能为空");
		}
		//获取账号和角色
		int role = (int) params.get("role");
		String account = (String) params.get("account");
		//判断参数内容是否为空
		if (params.get("term") == null || 
				(role != 1&&role != 2) || account == null) {
			throw new UnusualParamsException("请设置必要参数信息");
		}
		//判断角色
		if (role == 1) {
			params.put("studentNo", account);	//设置学生学号
		}else {
			params.put("tutorNo", account);	//设置导师工号
		}
		//获取选题数量
		int number = dao.selectOne(mapper + "selectMissionNum", params);
		//判断符合条件数量的合理性
		if (number == 0) {
			throw new CommonErrorException("尚未发布阶段任务");
		}
		return number;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.PhaseMissionService#uploadPhaMission(jxau.spms.student.po.StuMissionInfo)
	 * TODO 学生上传阶段任务信息
	 */
	@Override
	public void uploadPhaMission(StuMissionInfo stuMissionInfo)
			throws RuntimeException {
		// TODO Auto-generated method stub
		//判断阶段任务信息的合理性
		if (stuMissionInfo == null) {
			throw new UnusualParamsException("参数信息不能为空");
		}
		if (stuMissionInfo.getMissionName() == null
				|| stuMissionInfo.getMissionNo() == 0) {
			throw new UnusualParamsException("参数内容不能为空");
		}
		stuMissionInfo.setExameState(2);	//设置阶段任务审核状态为"审核中"
		//调用dao更新方法
		dao.update(mapper + "uploadPhaseMis", stuMissionInfo);
	}

}
