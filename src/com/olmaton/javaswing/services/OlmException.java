package com.olmaton.javaswing.services;

public class OlmException extends Exception {

    private MessageLevel level = MessageLevel.ERROR;
    private String origin = "";

    public OlmException(String message, String origen) {
        super(message);
        this.origin = origen;
        OlmLog.getInstance().error(message, origen);
    }

    public OlmException(String message, MessageLevel level, String origen) {
        super(message);
        this.level = level;
        this.origin = origen;
        OlmLog.getInstance().error(message, origen);
    }

    public String getOrigin() {
        return origin;
    }

    public MessageLevel getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return getMessage();
    }

}
