package com.example.socle.exceptions;

/**
 * Generique exception thrown in runtime
 *
 * @author S.BENDRIOUE
 */
public class GenericException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs the exception with the necessary infos
     *
     * @param msg
     *            error trace
     */
    public GenericException(String msg,Exception e) {
    	super(msg);
    	e.printStackTrace();
    }
}
