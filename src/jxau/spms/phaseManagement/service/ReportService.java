package jxau.spms.phaseManagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.vo.ReportInfoVo;
import jxau.spms.common.vo.TaskInfoVo;
import jxau.spms.tutor.po.TaskInfo;

/**
 * @author Lai Huiqiang
 * 2014-8-31
 * TODO 开题报告业务逻辑接口
 */
public interface ReportService {

	/**
	 * TODO 查询学生开题报告信息
	 * @param params 开题报告查询参数
	 * @return	符合条件的学生开题报告信息
	 * @throws RuntimeException	
	 */
	public List<ReportInfoVo> queryReport(HashMap<String, Object> params)
				throws RuntimeException;
	/**
	 * TODO 查询学生开题报告数量
	 * @param params 开题报告参数
	 * @return 开题报告数量
	 * @throws RuntimeException
	 */
	public int queryRepNumber(HashMap<String, Object> params) 
			throws RuntimeException;
	/**
	 * TODO 学生查询任务书信息
	 * @param params 参数信息
	 * @return 选题信息Vo
	 * @throws RuntimeException
	 */
	public TaskInfoVo queryTaskInfo(HashMap<String, Object> params) 
			throws RuntimeException;
	/**
	 * TODO 增加开题报告信息
	 * 下午7:03:50
	 * @param reportInfo 开题报告实体信息
	 * @throws RuntimeException
	 */
	public void addReport(ReportInfo reportInfo ) throws RuntimeException;
	
	/**
	 * TODO 导师发布任务书
	 * @param taskInfo 阶段任务实体类
	 * @throws RuntimeException
	 */
	public void addTaskInfo(TaskInfo taskInfo,Map<String, Object> params) throws RuntimeException;
}
