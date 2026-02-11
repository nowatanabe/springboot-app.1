package com.fujitsu.primesoft;

public class PsoftIllegalArgumentException extends PsoftRuntimeException {
    private Throwable cause;

    public PsoftIllegalArgumentException() {
        this.cause = new NullPointerException();
    }

    public PsoftIllegalArgumentException(java.lang.Throwable cause) {
        this.cause = cause;
    }
}
