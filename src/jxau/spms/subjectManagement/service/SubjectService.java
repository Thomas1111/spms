package jxau.spms.subjectManagement.service;

import java.util.List;
import java.util.Map;

import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;

/**
 * @author Lai Huiqiang 
 * 2014-9-5
 * TODO 处理选题信息的业务接口
 */
public interface SubjectService {

	/**
	 * TODO 查询符合条件的选题信息
	 * @param params 查询条件
	 * @param params 查询条件
	 * @return 符合条件的选题信息
	 */
	public <E> List<E> querySubject(Map<String, Object> params,PageVo pageVo,String type)
		throws RuntimeException;
	/**
	 * TODO 增加选题信息
	 * @param subjectInfo 选题信息实体
	 * @throws RuntimeException 插入数据时异常
	 */
	public void addSubject(SubjectInfo subjectInfo) throws RuntimeException;
	
	/**
	 * TODO 审核学生
	 * 上午9:26:14
	 * @param params
	 * @return 审核信息
	 * @throws RuntimeException
	 */
	public String verifySubject(Map<String, Object> params) throws RuntimeException;
	/**
	 * TODO	学生申请、退选选题
	 * 下午10:10:27
	 * @param params 操作选题参数
	 * @throws RuntimeException
	 */
	public String operateSubject(Map<String, Object> params) throws RuntimeException;
}
