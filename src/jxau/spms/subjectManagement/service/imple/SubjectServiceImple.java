package jxau.spms.subjectManagement.service.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.springframework.stereotype.Service;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.common.vo.SpecificSubjectVo;
import jxau.spms.common.vo.StuSubjectVo;
import jxau.spms.common.vo.VerTutorSubVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.SubNumberOutOfRange;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.subjectManagement.service.SubjectService;
import jxau.spms.tutor.po.TutorBasicInfo;

/**
 * @author Lai Huiqiang
 * 2014-9-5
 * TODO 处理选题信息的业务实现类
 */
@Service("subjectService")
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
	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> querySubject(Map<String, Object> params,PageVo pageVo,String type)
		throws UnusualParamsException,CommonErrorException{
		// TODO Auto-generated method stub
		int count = 0;
		if (params == null) {	//检查查询参数
			throw new UnusualParamsException("参数不能为空");
		}
		//设置查询参数(起始位置、查询数量)
		if (pageVo != null&&pageVo.getCurrentPage() != 0) {
			params.put("start", pageVo.getFirstIndex());		//设置起始位置
			params.put("number", pageVo.getSize());		//设置数量
		}
		List<E> subjectInfos = null;
		//调用dao方法
		if ("subInfo".equals(type)||type == null) {	//判断是否是导师查询选题信息
			subjectInfos = dao.select(mapper + "selectSubject", params);
			count = dao.selectOne(mapper + "getSubjectNum", params);
		}else if("stuSubInfo".equals(type)) {		//查询学生选题基本信息
			subjectInfos = dao.select(mapper + "selectStuSub", params);
			if (subjectInfos.size() == 0) {		//判读选题信息是否为空
				throw new CommonErrorException("还未有人申请选题");
			}
			count = dao.selectOne(mapper + "getStuSubNum", params);
		}else if ("stuCancelInfo".equals(type)) {
			subjectInfos = dao.select(mapper + "selectCancelInfo", params);
			if (subjectInfos.size() == 0) {		//判读选题信息是否为空
				throw new CommonErrorException("你还未申请选题");
			}
			count = subjectInfos.size();
		}else {
			subjectInfos = dao.select(mapper + "selectSubInfo", params);
			count = dao.selectOne(mapper + "getSubInfoNum", params);
		}
		
		if (subjectInfos.size() == 0) {		//判读选题信息是否为空
			throw new CommonErrorException("选题信息不存在");
		}else {
			if (pageVo != null) {		//判断pageVo 是否为空
				pageVo.setCount(count);	//设置查询数量
			}
		}
		
		return (List<E>) subjectInfos;
	}

	@Override
	public void addSubject(SubjectInfo subjectInfo) throws RuntimeException {
		// TODO Auto-generated method stub
		
		if (subjectInfo == null) {		//判断参数
			throw new UnusualParamsException("参数不能为空");
		}
		//设置状态系数
		subjectInfo.setExameState(2);	//设置选题审核状态为'审核中状态'
		subjectInfo.setStuExaState(0);	//设置学生选题审核状态为'未提交状态'
		subjectInfo.setApplyNum(1);		//设置上限人数
		subjectInfo.setLeftNum(1);		//设置剩余人数
		//调用dao插入方法
		dao.add(mapper+"addSubject", subjectInfo);
	}

	/* (non-Javadoc)
	 * @see jxau.spms.subjectManagement.service.SubjectService#verifySubject(java.util.Map)
	 * TODO
	 */
	@Override
	public String verifySubject(Map<String, Object> params)
			throws UnusualParamsException {
		// TODO Auto-generated method stub
		String message = "审核成功";
		if (params == null) {	//检查查询参数
			throw new UnusualParamsException("参数不能为空");
		}
		if (params.get("term") == null) {
			throw new UnusualParamsException("缺少必要参数");
		}
		if ((params.get("studentNo") == null &&params.get("stuExaState") == null)
				&&(params.get("tutorNo") == null &&params.get("exameState") == null)) {
			message = "参数信息有误";
			return message;
		}
		//调用dao更新方法
		dao.update(mapper+"verStuSubject", params);
		
		return message;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.subjectManagement.service.SubjectService#operateSubject(java.util.Map)
	 * TODO 学生申请、退选选题
	 */
	@Override
	public String operateSubject(Map<String, Object> params)
			throws UnusualParamsException,SubNumberOutOfRange {
		// TODO Auto-generated method stub
		String message = "";
		if (params == null) {	//检查查询参数
			throw new UnusualParamsException("参数不能为空");
		}
		//获取当前学生选题信息
		StuSubjectVo exist = dao.selectOne(mapper + "applyOrNot", params);
		String opeType = (String) params.get("opeType");	//获取操作类型
		int leftNum = (int) params.get("leftNum");	//获取选题剩余数量
		if ("apply".equals(opeType)) {
			if (leftNum == 0) {		//判断数量为零
				throw new SubNumberOutOfRange("对不起，选题已达到上限");
			}
			if (exist != null) {	//判断是否已选选题
				message = "你已申请选题，请先退选";
				return message;
			}
			leftNum--;		//选题剩余数量减一
			message = "申请成功";
		}else {
			if (exist.getStuExaState() == 1) {	//判断是否通过
				message = "审核已通过,不能再退选";
				return message;
			}
			leftNum++;		//选题剩余数量减一
			message = "退选成功";
		}
		params.put("leftNum", leftNum);		//设置操作后的选题数量
		//调用dao更新方法
		dao.update(mapper + "opeSubject", params);
		
		return message;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.subjectManagement.service.SubjectService#querySubResult(java.util.Map, jxau.spms.common.vo.PageVo)
	 * TODO 导师查询学生选题结果
	 */
	@Override
	public Map<String, Object> querySubResult(Map<String, Object> params,
			PageVo pageVo) throws RuntimeException {
		// TODO Auto-generated method stub
		int count = 0;
		Map<String, Object> resultInfo = new HashMap<String, Object>();
		if (params == null) {	//检查查询参数
			throw new UnusualParamsException("参数不能为空");
		}
		//设置查询参数(起始位置、查询数量)
		if (pageVo == null||pageVo.getCurrentPage() == 0) {
			throw new UnusualParamsException("缺少重要参数");
		}
		params.put("start", pageVo.getFirstIndex());		//设置起始位置
		params.put("number", pageVo.getSize());		//设置数量
		List<StuSubjectVo> subjectInfos = dao.select(mapper + "selectStuSub", params);
		if (subjectInfos.size() == 0) {		//判读选题信息是否为空
			throw new CommonErrorException("学生选题结果为空");
		}
		count = dao.selectOne(mapper + "getStuSubNum", params);		//获取查询数量
		pageVo.setCount(count);		//设置查询数量
		//获取已发布任务书的选题
		List<Integer> subjectNos = dao.select(mapper + "selectSubResult", params);
		//设置结果信息
		resultInfo.put("subResult", subjectInfos);
		resultInfo.put("distribution", subjectNos);
		
		return resultInfo;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.subjectManagement.service.SubjectService#queryTutSub(java.util.Map, jxau.spms.common.vo.PageVo)
	 * TODO 管理员获取导师选题信息
	 */
	@Override
	public <E> List<E> queryTutSub(Map<String, Object> params,
			PageVo pageVo) throws RuntimeException {
		// TODO Auto-generated method stub
		int count = 0;
		if (params == null) {	//检查查询参数
			throw new UnusualParamsException("参数不能为空");
		}
		//设置查询参数(起始位置、查询数量)
		if (pageVo == null||pageVo.getCurrentPage() == 0) {
			throw new UnusualParamsException("缺少重要参数");
		}
		params.put("start", pageVo.getFirstIndex());		//设置起始位置
		params.put("number", pageVo.getSize());		//设置数量
		//调用dao获取导师选题数量(使用触发器)
		//List<SubjectInfo> subNum = dao.select(mapper + "selectSubject", params);
		List<E> subjectInfos = dao.select(mapper + "selectTutors", params);
		count = dao.selectOne(mapper + "getTutorNum", params);		//获取总数量
		pageVo.setCount(count);	//设置查询数量
		if (count == 0) {		//判读选题信息是否为空
			throw new CommonErrorException("暂时没有导师尚提交选题信息");
		}
		return subjectInfos;
	}

	@Override
	public SpecificSubjectVo querySpeSub(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {	//检查查询参数
			throw new UnusualParamsException("参数不能为空");
		}
		if (params.get("subjectNo") == null) {
			throw new UnusualParamsException("缺少重要参数");
		}
		SpecificSubjectVo speSubVo = dao.selectOne(mapper + "selectSpeSub", params);
		if (speSubVo == null) {
			throw new CommonErrorException("对不起，信息错误");
		}
		return speSubVo;
	}

}
