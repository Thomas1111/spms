package jxau.spms.exception;

public class StudentNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentNotExistException(String message){
		super(message);
	}
}
