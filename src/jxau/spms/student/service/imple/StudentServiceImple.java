package jxau.spms.student.service.imple;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.common.po.TermInfo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.StudentNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.student.service.StudentService;

@Service("studentService")
public class StudentServiceImple implements StudentService {

	private Dao dao;
	private final String mapper = "jxau.spms.dao.";
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see jxau.spms.student.service.StudentService#queryTutorStu(java.util.Map)
	 * TODO 查询导师所带学生信息业务实现类
	 */
	@Override
	public List<StuBasicInfo> queryTutorStu(Map<String, Object> params)
			throws UnusualParamsException,StudentNotExistException {
		// TODO Auto-generated method stub
	
		if (params == null) {		//判断参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("tutorNo")) {	//判断参数合理性
			throw new UnusualParamsException("参数不包含重要参数!");
		}
		//调用dao查询方法获取学生信息
		List<StuBasicInfo> stuBasicInfo = dao.select(mapper+"selectTutorStudent", params);
		//判断查询学生信息是够为空
		if (stuBasicInfo == null || stuBasicInfo.size() == 0) {
			throw new StudentNotExistException("还未分配学生，学生列表为空!");
		}
		
		return stuBasicInfo;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.student.service.StudentService#queryStuNumber(java.util.Map)
	 * TODO 获取符合学生数量实现类
	 */
	@Override
	public int queryStuNumber(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {		//判断参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("tutorNo")) {	//判断参数合理性
			throw new UnusualParamsException("参数不包含重要参数!");
		}
		int stuNum= dao.selectOne(mapper+"getStuNumber", params);
		//判断查询学生信息是够为空
		if (stuNum == 0) {
			throw new StudentNotExistException("学生数量为0!");
		}
		return stuNum;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.student.service.StudentService#queryTerms(java.util.Map)
	 * TODO
	 */
	@Override
	public List<TermInfo> queryTerms(Map<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		List<TermInfo> termInfo = dao.select(mapper+"selectTerms", params); 
		if (termInfo == null || 
				termInfo.size() == 0) {
			throw new CommonErrorException("学期信息加载出错!");
		}
		return termInfo;
	}
	
}
