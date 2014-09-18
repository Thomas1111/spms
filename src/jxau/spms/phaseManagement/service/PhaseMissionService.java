package jxau.spms.phaseManagement.service;

import java.util.List;
import java.util.Map;

import javax.management.Query;

import jxau.spms.common.vo.PhaseMissionVo;
import jxau.spms.student.po.StuMissionInfo;
import jxau.spms.tutor.po.PhaseMissionInfo;

/**
 * @author Lai Huiqiang
 * 2014-9-17
 * TODO 管理阶段任务的业务逻辑接口
 */ 
public interface PhaseMissionService {

	/**
	 * TODO 导师发布阶段任务
	 * 上午8:25:28
	 * @param phaseMissionInfo 阶段任务信息类
	 * @param sendObj 发送对象
	 * @throws RuntimeException
	 */
	public void addPhaseMission(PhaseMissionInfo phaseMissionInfo,String sendObj) 
			throws RuntimeException;
	/**
	 * TODO 学生上传阶段任务
	 * 上午9:59:43
	 * @param stuMissionInfo 阶段任务信息
	 * @throws RuntimeException
	 */
	public void uploadPhaMission(StuMissionInfo stuMissionInfo) 
			throws RuntimeException;
	/**
	 * TODO 获取导师发送对象信息
	 * 上午10:31:41
	 * @param params 查询参数
	 * @return	符合条件的发送对象信息
	 * @throws RuntimeException
	 */
	public List<PhaseMissionVo> querySendObject(Map<String, Object> params) 
			throws RuntimeException;
	
	/**
	 * TODO 导师、学生获取阶段任务
	 * 下午8:21:07
	 * @param params 查询参数
	 * @return	符合条件的阶段任务信息
	 * @throws RuntimeException
	 */
	public <E> List<E> queryPhaseMission(Map<String, Object> params) 
			throws RuntimeException;
	/**
	 * TODO 获取符合条件的阶段任务数
	 * 下午9:12:18
	 * @param params 查询阶段任务参数
	 * @return 任务数量
	 * @throws RuntimeException
	 */
	public int queryMissionNum(Map<String, Object> params) throws RuntimeException;
}
