/**
 * 
 */
package jxau.spms.notice.service;

import java.util.List;
import java.util.Map;

import jxau.spms.admin.po.NoticeInfo;

/**
 * @author Lai Huiqiang
 * 2014-8-28
 * TODO 处理公告的业务逻辑解接口
 */
public interface NoticeService {

	public String addNotice(NoticeInfo noticeInfo) throws RuntimeException;
	public List<NoticeInfo> queryNotice(Map<String,Object> params) throws RuntimeException;
	
}
