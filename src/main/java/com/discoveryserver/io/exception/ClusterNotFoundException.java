package com.discoveryserver.io.exception;

public class ClusterNotFoundException extends RuntimeException{

    public ClusterNotFoundException(String message) {
        super(message);
    }
}
