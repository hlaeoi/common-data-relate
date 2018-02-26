package com.github.datarelate.exception;

public class NoSuchHandlerException extends RuntimeException {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 3058793909650500860L;

    public NoSuchHandlerException() {
        super();
    }

    public NoSuchHandlerException(String message) {
        super(message);
    }

    public NoSuchHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchHandlerException(Throwable cause) {
        super(cause);
    }

}
