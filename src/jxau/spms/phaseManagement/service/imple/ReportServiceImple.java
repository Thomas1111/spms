package jxau.spms.phaseManagement.service.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.common.po.PaperInfo;
import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.ReportInfoVo;
import jxau.spms.common.vo.TaskInfoVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.ReportNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.ReportService;
import jxau.spms.tutor.po.TaskInfo;

/**
 * @author Lai Huiqiang
 * 2014-8-31
 * TODO 开题报告业务逻辑实现类
 */
@Service("reportService")
public class ReportServiceImple implements ReportService {

	private Dao dao;
	private final String mapper = "jxau.spms.dao.";
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	/* (non-Javadoc)
	 * @see jxau.spms.reportinfo.service.ReportService#queryReport(java.util.HashMap)
	 * TODO 查询开题报告实现类
	 */
	@Override
	public List<ReportInfoVo> queryReport(HashMap<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {		//判断参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("tutorNo")) {	//判断参数合理性
			throw new UnusualParamsException("参数不包含重要参数!");
		}
		//调用dao查询方法获取学生信息
		List<ReportInfoVo> reportInfo = dao.select(mapper+"selectStuReport", params);
		//判断查询学生信息是够为空
		if (reportInfo == null || reportInfo.size() == 0) {
			throw new ReportNotExistException("暂时无人上传开题报告，列表为空!");
		}
		
		return reportInfo;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.reportinfo.service.ReportService#addReport(jxau.spms.common.po.ReportInfo)
	 * TODO	增加开题报告信息实现类
	 */
	@Override
	public void addReport(ReportInfo reportInfo,Map<String, Object> params) throws RuntimeException {
		// TODO Auto-generated method stub
		if (reportInfo == null	|| params == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		if (params.get("studentNo") == null ||
				params.get("reportTerm") == null) {
			throw new UnusualParamsException("参数内容不能为空!");
		}
		//获取导师工号
		String tutorNo = dao.selectOne(mapper + "selectTutorNo",params);
		reportInfo.setTutorNo(tutorNo);		//设置导师工号
		int count =  dao.selectOne(mapper + "repExistOrNot",params);	//获取开题报告数量
		if (count >= 1) {	//判断开题报告信息是否已存在
			dao.delete(mapper + "deleteReportInfo", params);	//删除已存在信息
		}
		//调用dao添加方法
		dao.add(mapper+"addReportInfo", reportInfo);
	}
	
	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.ReportService#queryRepNumber(java.util.HashMap)
	 * TODO 获取开题报告数量实现类
	 */
	@Override
	public int queryRepNumber(HashMap<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {		//判断参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("tutorNo")) {	//判断参数合理性
			throw new UnusualParamsException("参数不包含重要参数!");
		}
		//调用dao查询方法获取学生信息
		int repNumber = dao.selectOne(mapper+"selectReportNum", params);
		//判断查询学生信息是够为空
		if ( repNumber == 0) {
			throw new ReportNotExistException("暂时无人上传开题报告，列表为空!");
		}
	
		return repNumber;
	}
	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.ReportService#addTaskInfo(jxau.spms.tutor.po.TaskInfo, java.util.Map)
	 * TODO 导师添加任务信息
	 */
	@Override
	public void addTaskInfo(TaskInfo taskInfo,Map<String, Object> params) throws RuntimeException {
		// TODO Auto-generated method stub
		if (taskInfo == null
				|| params == null) {		//判读参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		//判断参数内容是否为空
		if (params.get("term") == null
				||params.get("tutorNo") == null
					||params.get("subName") == null) {
			throw new UnusualParamsException("请设置参数数值!");
		}
		//判断用户输入内容是否为空
		if (" ".equals(taskInfo.getContent())
				|| " ".equals(taskInfo.getDiagram())
					|| " ".equals(taskInfo.getIndicator())
						|| " ".equals(taskInfo.getReference())
							|| " ".equals(taskInfo.getSchedule())) {
			throw new UnusualParamsException("信息不能为空");
		}
		//调用dao获取选题subjectNo
		SubjectInfo subjectInfo = dao.selectOne(mapper + "selectSubject", params);
		taskInfo.setSubjectNo(subjectInfo.getSubjectNo());		//设置选题编号信息
		//调用dao添加方法
		dao.add(mapper+"addTaskInfo", taskInfo);
	}
	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.ReportService#queryTaskInfo(java.util.HashMap)
	 * TODO 学生查询任务书信息
	 */
	@Override
	public TaskInfoVo queryTaskInfo(HashMap<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {		//判读参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		//判断参数内容是否为空
		if (params.get("studentNo") == null
				||params.get("term") == null) {
			throw new UnusualParamsException("请设置参数数值!");
		}
		TaskInfoVo taskInfo = dao.selectOne(mapper + "selectTaskInfo", params);	//调用dao查询方法
		//判断信息是否存在
		if (taskInfo == null) {
			throw new CommonErrorException("导师尚未发布任务书");
		}
		
		return taskInfo;
	}
	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.ReportService#verifyReport(java.util.Map)
	 * TODO 导师审核开题报告
	 */
	@Override
	public void verifyReport(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {		//判读参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		if (params.get("type") == null
				||params.get("reportNo") == null) {
			throw new UnusualParamsException("请设置参数数值!");
		}
		String type = (String) params.get("type");	//获取审核类型
		//判断审核类型，设置状态
		if ("pass".equals(type)) {
			params.put("exameState", 1);
		}else {
			params.put("exameState", 3);
		}
		
		//调用dao方法更新开题报告
		dao.update(mapper + "verifyReportInfo", params);
	}
	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.ReportService#addPaper(jxau.spms.common.po.PaperInfo, java.util.Map)
	 * TODO 学生上传开题报告
	 */
	@Override
	public void addPaper(PaperInfo paperInfo, Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (paperInfo == null	|| params == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		if (params.get("studentNo") == null ||
				params.get("paperTerm") == null) {
			throw new UnusualParamsException("参数内容不能为空!");
		}
		int count =  dao.selectOne(mapper + "paperExistOrNot",params);	//获取论文信息数量
		if (count >= 1) {	//判断论文信息是否已存在
			dao.delete(mapper + "deletePaperInfo", params);	//删除已存在信息
		}
		//调用dao添加方法
		dao.add(mapper+"addPaperInfo", paperInfo);
	}
}
