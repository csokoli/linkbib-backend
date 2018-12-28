package com.csokoli.linkbib.exception;

public class SiteNotFoundException extends RuntimeException {

    public SiteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SiteNotFoundException() {
        super();
    }

    public SiteNotFoundException(String message) {
        super(message);
    }

    public SiteNotFoundException(Throwable cause) {
        super(cause);
    }
}
