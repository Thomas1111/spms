package jxau.spms.admin.service;

import java.util.HashMap;

import jxau.spms.admin.po.AdminBasicInfo;

/**
 * @author Lai Huiqaing 
 * 2014-8-31
 * TODO 处理管理员业务信息接口
 */
public interface AdminService {

	/**
	 * TODO	获取管理员基本信息
	 * @param adminNo 管理员账号
	 * @return 管理员基本信息
	 * @throws RuntimeException 
	 */
	public AdminBasicInfo queryAdminByNo(HashMap<String, Object> params) throws RuntimeException;
}
