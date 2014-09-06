package jxau.spms.phaseManagement.service.imple;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jxau.spms.abstraction.dao.Dao;
import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.vo.ReportInfoVo;
import jxau.spms.exception.ReportNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.ReportService;

/**
 * @author Lai Huiqiang
 * 2014-8-31
 * TODO 开题报告业务逻辑实现类
 */
@Service("reportService")
public class ReportServiceImple implements ReportService {

	private Dao dao;
	private final String mapper = "jxau.spms.dao.";
	@Resource(name="dao")
	public void setDao(Dao dao){
		this.dao = dao;
	}
	/* (non-Javadoc)
	 * @see jxau.spms.reportinfo.service.ReportService#queryReport(java.util.HashMap)
	 * TODO 查询开题报告实现类
	 */
	@Override
	public List<ReportInfoVo> queryReport(HashMap<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {		//判断参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("tutorNo")) {	//判断参数合理性
			throw new UnusualParamsException("参数不包含重要参数!");
		}
		//调用dao查询方法获取学生信息
		List<ReportInfoVo> reportInfo = dao.select(mapper+"selectStuReport", params);
		//判断查询学生信息是够为空
		if (reportInfo == null || reportInfo.size() == 0) {
			throw new ReportNotExistException("暂时无人上传开题报告，列表为空!");
		}
		
		return reportInfo;
	}

	/* (non-Javadoc)
	 * @see jxau.spms.reportinfo.service.ReportService#addReport(jxau.spms.common.po.ReportInfo)
	 * TODO	增加开题报告信息实现类
	 */
	@Override
	public void addReport(ReportInfo reportInfo) throws RuntimeException {
		// TODO Auto-generated method stub
		if (reportInfo == null) {
			throw new UnusualParamsException("参数不能为空!");
		}
		dao.add(mapper+"addReportInfo", reportInfo);
	}
	/* (non-Javadoc)
	 * @see jxau.spms.phaseManagement.service.ReportService#queryRepNumber(java.util.HashMap)
	 * TODO 获取开题报告数量实现类
	 */
	@Override
	public int queryRepNumber(HashMap<String, Object> params)
			throws RuntimeException {
		// TODO Auto-generated method stub
		if (params == null) {		//判断参数是否为空
			throw new UnusualParamsException("参数不能为空!");
		}
		if (!params.containsKey("tutorNo")) {	//判断参数合理性
			throw new UnusualParamsException("参数不包含重要参数!");
		}
		//调用dao查询方法获取学生信息
		int repNumber = dao.selectOne(mapper+"selectReportNum", params);
		//判断查询学生信息是够为空
		if ( repNumber == 0) {
			throw new ReportNotExistException("暂时无人上传开题报告，列表为空!");
		}
	
		return repNumber;
	}

}
