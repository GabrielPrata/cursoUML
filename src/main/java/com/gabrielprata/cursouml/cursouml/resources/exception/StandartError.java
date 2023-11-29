package com.gabrielprata.cursouml.cursouml.resources.exception;

import java.io.Serializable;

public class StandartError implements Serializable{
    private static final long serialVersionUID = 1L;

    private int Status;
    private String Message;
    private long TimeStamp;
    
    public StandartError(int status, String message, long timeStamp) {
        Status = status;
        Message = message;
        TimeStamp = timeStamp;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public long getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        TimeStamp = timeStamp;
    }


    
}
