package com.toysforshots.error;

public final class UserAlreadyExistException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3374909976682692234L;

	public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
