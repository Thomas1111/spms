package jxau.spms.notice.service.imple;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.admin.po.NoticeInfo;
import jxau.spms.exception.NoticeNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.notice.service.NoticeService;


/**
 * @author Lai Huiqiang
 * 2014-8-28
 * TODO 公告业务逻辑的实现类
 */
@Service("noticeService")
public class NoticeServiceImple implements NoticeService {
	
	private Dao dao;
	private  final String mapper = "jxau.spms.dao.";
	/**
	 * TODO 注入Dao
	 * @param dao
	 */
	@Resource(name = "dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see jxau.spms.notice.service.NoticeService#addNotice(jxau.spms.admin.po.NoticeInfo)
	 * TODO 实现发布公告 
	 * @param noticeInfo 公告实体类
	 * @return 处理增加公告的信息
	 */
	@Override
	public String addNotice(NoticeInfo noticeInfo) throws UnusualParamsException {
		// TODO Auto-generated method stub
		String message = "发布成功";
		if (noticeInfo == null) {
			throw new UnusualParamsException("参数不能为空！");
		}
		if (noticeInfo.getAdminNo()==null) {	
			message = "未识别的管理员！";
		}
		dao.add(mapper+"addNotice", noticeInfo);	//调用dao增加公告
		return message;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.notice.service.NoticeService#queryNotice(java.util.Map)
	 * TODO 根据条件查询公告
	 * @param params 查询条件
	 * @return 符合条件的公告信息
	 */
	@SuppressWarnings("unused")
	@Override
	public List<NoticeInfo> queryNotice(Map<String, Object> params)
			throws UnusualParamsException,NoticeNotExistException{
		// TODO Auto-generated method stub
		String id = null;	
		int role = (int) params.get("role"); 	//获取角色编号
		//判断角色,选择持久化操作
		if (role == 1) {
			id = "selectStudentNotice";
			
		}else if (role==2) {
			id = "selectTutorNotice";
		}else {
			id = "selectAdminNotice";
		}
		//判断参数的合理性
		if (params == null) {
			throw new UnusualParamsException("查询条件为空!");
		}
		//判断角色的合理性
		if (id == null) {
			throw new UnusualParamsException("用户角色参数错误!");
		}
		
		List<NoticeInfo> noticeInfos = dao.select(mapper+id, params);
		
		if (noticeInfos.size()==0 || noticeInfos == null) {
			throw new NoticeNotExistException("公告列表为空！");
		}
		
		return noticeInfos;
	}

}
