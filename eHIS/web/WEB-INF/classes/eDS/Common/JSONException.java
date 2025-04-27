/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS.Common;


public class JSONException extends RuntimeException {
    private static final long serialVersionUID = 1L;	
    private Throwable cause;

    /**
     * Constructs a JSONException with an explanatory message.
     *
     * @param message
     *            Detail about the reason for the exception.
     */
    public JSONException(String message) {
        super(message);
    }

    /**
     * Constructs a new JSONException with the specified cause.
     */
    public JSONException(Throwable cause) {
        super(cause.getMessage());
        this.cause = cause;
    }

    /**
     * Returns the cause of this exception or null if the cause is nonexistent
     * or unknown.
     *
     * @returns the cause of this exception or null if the cause is nonexistent
     *          or unknown.
     */
    public Throwable getCause() {
        return this.cause;
    }
}
