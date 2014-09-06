package jxau.spms.exception;

/**
 * @author Lai Huiqaing
 * 2014-8-31
 * TODO 学生报告信息不存在异常
 */
public class ReportNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public ReportNotExistException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
