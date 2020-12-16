package com.archforce.ath.rds.exception;

public class RDSException extends Exception {

    private String errorCode;

    public RDSException(String errorCode) {
        this.errorCode = errorCode;
    }

    public RDSException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public RDSException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public RDSException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}