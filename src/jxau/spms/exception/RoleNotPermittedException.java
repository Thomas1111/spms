package jxau.spms.exception;

public class RoleNotPermittedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public RoleNotPermittedException(String message) {
		super(message);
	}
	
}
