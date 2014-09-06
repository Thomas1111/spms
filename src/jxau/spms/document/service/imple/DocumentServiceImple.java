package jxau.spms.document.service.imple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.management.relation.RoleNotFoundException;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.document.service.DocumentService;
import jxau.spms.exception.DocNotExistException;
import jxau.spms.exception.RoleNotPermittedException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.student.po.StuDownInfo;
import jxau.spms.tutor.po.DocumentInfo;


/**
 * @author Lai Huiqiang
 * 2014-8-29
 * TODO 处理文档业务的实现类
 */
@Service("documentService")
public class DocumentServiceImple implements DocumentService {

	private Dao dao;
	private final String mapper = "jxau.spms.dao.";
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	/**
	 * TODO 添加文档信息(导师、学生)
	 * 上午8:27:38
	 * @param params 添加文档的参数信息
	 * @throws RuntimeException 参数异常
	 */
	@Override
	//@Transactional("propagation = Propagation.REQUIRED")		//添加事务
	public void addDocument(HashMap<String, Object> params)
			throws UnusualParamsException {
		// TODO Auto-generated method stub
		if (params == null) {		//判断参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		DocumentInfo tutorDoc = (DocumentInfo) params.get("tutorDoc");
		ArrayList<StuDownInfo> studentDoc = (ArrayList<StuDownInfo>) params.get("studentDoc");
		if (tutorDoc == null
				||studentDoc == null
					||studentDoc.size() == 0) {  		//判断参数的合理性
			throw new UnusualParamsException("参数错误(导师、学生)");
		}
		//调用dao添加导师文档信息
		dao.add(mapper+"addTutorDocument",tutorDoc);
		int docNo = tutorDoc.getDocNo();	//获取插入的自增长的主键值
		Iterator<StuDownInfo> stuItr = studentDoc.iterator();
		//学生信息中设置docNo
		while(stuItr.hasNext()) {
			stuItr.next().setDocNo(docNo);
		}
		//调用dao批量添加学生文档信息
		dao.batchAdd(mapper+"batchAddStuDoc", params);
	}

	/**
	 * TODO 查询文档信息
	 * 上午8:19:16
	 * @param params 查询文档的参数
	 * @return 符合查询条件文档信息
	 * @throws RuntimeException 参数异常
	 */
	@Override
	@Transactional(readOnly=true)
	public <T> List<T> queryDocument(HashMap<String, Object> params)
			throws UnusualParamsException,RoleNotPermittedException,DocNotExistException{
		// TODO Auto-generated method stub
		if (params == null) {		//判断参数
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("account")
				||!params.containsKey("role")) {
			throw new UnusualParamsException("参数不合理!");
		}
		int role = (int) params.get("role");	//获取角色参数 
		List<T> docInfo = null;
		//List<StuDownInfo> studentDoc = null;
		//判断角色参数，执行查询操作
		if (role == 1) {
			docInfo = dao.select(mapper+"selectStuDocument", params);
		}else if (role == 2) {
			docInfo = dao.select(mapper+"selectTutorDocument", params);
		}else{
			throw new RoleNotPermittedException("该角色不允许执行该操作!");
		}
		//判断文档信息是否为空
		if (docInfo == null || docInfo.size() == 0) {
			throw new DocNotExistException("文件列表为空!");
		}
		
		return docInfo;		//返回查询结果
	}

}
