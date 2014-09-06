package jxau.spms.document.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Lai Huiqiang
 * 2014-8-29
 * TODO 处理文档的业务逻辑类
 */
public interface DocumentService {
	
	/**
	 * TODO 添加文档
	 * 上午8:17:55
	 * @param params 添加文档的参数信息(导师、学生)
	 * @throws RuntimeException 参数异常
	 */
	public void addDocument(HashMap<String, Object> params) throws RuntimeException;
	/**
	 * TODO 查询文档信息
	 * 上午8:19:16
	 * @param params 查询文档的参数
	 * @return 符合查询条件文档信息
	 * @throws RuntimeException 参数异常
	 */
	public <T> List<T> queryDocument(HashMap<String, Object> params)
			throws RuntimeException;
	 
}
