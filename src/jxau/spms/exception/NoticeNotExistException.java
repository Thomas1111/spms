package jxau.spms.exception;


/**
 * @author Lai Huiqiang
 * 2014-8-28
 * TODO 公告列表为空
 */
public class NoticeNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoticeNotExistException(String message){
		super(message);
	}
}
