package com.example.demo.soap;

class ServiceFaultException extends RuntimeException {
    ServiceFaultException(String message) {
        super(message);
    }
}
