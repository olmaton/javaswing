package com.olmaton.javaswing.services;

public enum MessageLevel {
    EXITO(0, "Mensaje"),
    MENSAJE(1, "Mensaje"),
    ADVERTENCIA(2, "Advertencia"),
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
