package jxau.spms.student.service;

import java.util.List;
import java.util.Map;

import jxau.spms.common.po.TermInfo;
import jxau.spms.student.po.StuBasicInfo;

public interface StudentService {

	/**
	 * TODO 查询导师所带学生的信息
	 * @param params 查询学生条件(导师工号)
	 * @return 符合条件学生信息
	 * @throws RuntimeException
	 */
	public List<StuBasicInfo> queryTutorStu(Map<String, Object> params) 
			throws RuntimeException; 
	
	/**
	 * TODO 查询符合条件学生的数量
	 * @param params params 查询学生条件(导师工号)
	 * @return  符合条件学生数量
	 * @throws RuntimeException
	 */
	public int queryStuNumber(Map<String, Object> params) 
			throws RuntimeException; 
	/**
	 * TODO 获取学期信息	
	 * @param params 获取参数
	 * @return 学期信息
	 * @throws RuntimeException
	 */
	public List<TermInfo> queryTerms(Map<String, Object> params) 
			throws RuntimeException; 
}
