package jxau.spms.subjectManagement.service.imple;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.subjectManagement.service.SubjectService;

/**
 * @author Lai Huiqiang
 * 2014-9-5
 * TODO 处理选题信息的业务实现类
 */
public class SubjectServiceImple implements SubjectService {

	private final String mapper = "jxau.spms.dao.";
	private Dao dao;
	
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.subjectManagement.service.SubjectService#querySubject(java.util.Map, jxau.spms.common.vo.PageVo)
	 * TODO 查询符合条件的选题信息
	 */
	@Override
	public List<SubjectInfo> querySubject(Map<String, Object> params,PageVo pageVo)
		throws UnusualParamsException,CommonErrorException{
		// TODO Auto-generated method stub
		if (params == null) {	//检查查询参数
			throw new UnusualParamsException("参数不能为空");
		}
		if (pageVo == null || pageVo.getCurrentPage() == 0) {	//检查pageVo参数
			throw new UnusualParamsException("请设置pageVo必要参数");
		}
		//设置查询参数(起始位置、查询数量)
		params.put("start", pageVo.getFirstIndex());
		params.put("number", pageVo.getSize());
		//调用dao方法
		List<SubjectInfo> subjectInfos = dao.select(mapper + "selectSubject", params);
		if (subjectInfos.size() == 0) {		//判读选题信息是否为空
			throw new CommonErrorException("选题信息不存在");
		}else {
			pageVo.setCount(subjectInfos.size());	//设置查询数量
		}
		
		return subjectInfos;
	}

}
