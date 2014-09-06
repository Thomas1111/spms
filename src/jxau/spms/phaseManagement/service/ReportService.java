package jxau.spms.phaseManagement.service;

import java.util.HashMap;
import java.util.List;

import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.vo.ReportInfoVo;

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
	 * TODO 增加开题报告信息
	 * 下午7:03:50
	 * @param reportInfo 开题报告实体信息
	 * @throws RuntimeException
	 */
	public void addReport(ReportInfo reportInfo ) throws RuntimeException;
}
