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
	public List<SubjectInfo> querySubject(Map<String, Object> params,PageVo pageVo)
		throws RuntimeException;
}
