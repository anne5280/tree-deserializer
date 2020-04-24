/**
 * 
 */
package com.flatirons.collections;

/**
 * @author Flatirons Solutions
 *
 */
public class TreeException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 5144602476439230643L;

    /**
     * Default constructor
     */
    public TreeException() {
    }

    /**
     * @param message the detail message
     */
    public TreeException(String message) {
        super(message);
    }

    /**
     * @param cause the cause
     */
    public TreeException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message the detail message
     * @param cause the cause
     */
    public TreeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message the detail message
     * @param cause the cause
     * @param enableSuppression whether or not suppression is enabled or disabled
     * @param writableStackTrace whether or not the stack trace should be writable
     */
    public TreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
