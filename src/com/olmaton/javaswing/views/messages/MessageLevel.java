package com.olmaton.javaswing.views.messages;

public enum MessageLevel {
    MESSAGE(0, "Message"),
    INFO(1, "Information"),
    WARNING(2, "Warning"),
    ERROR(2, "Error");

    private final int level;
    private final String description;

    private MessageLevel(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }
        
    @Override
    public String toString() {
        return description;
    }
}
