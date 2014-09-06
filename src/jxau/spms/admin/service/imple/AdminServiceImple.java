package jxau.spms.admin.service.imple;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.admin.po.AdminBasicInfo;
import jxau.spms.admin.service.AdminService;
import jxau.spms.exception.UnusualParamsException;

/**
 * @author Lai Huiqaing 
 * 2014-8-31
 * TODO 
 */
@Service("adminService")
public class AdminServiceImple implements AdminService {

	private Dao dao;
	private final String mapper = "jxau.spms.dao.";
	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao =dao;
	}
	/* (non-Javadoc)
	 * @see jxau.spms.admin.service.AdminService#queryAdminByNo(java.lang.String)
	 * TODO 获取管理员基本信息实现类
	 */
	@Override
	public AdminBasicInfo queryAdminByNo(HashMap<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("adminNo")) {
			throw new UnusualParamsException("缺少重要参数");
		}
		//调用dao方法查询管理员基本信息
		AdminBasicInfo adminBasicInfo = dao.selectOne(mapper+"selectAdminBasic", params);
		
		return adminBasicInfo;
	}

}
