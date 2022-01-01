package com.olmaton.javaswing.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OlmCustomLog {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY-MM-dd HH:mm:ss");
    protected final OlmFile error;
    protected final OlmFile info;

    public OlmCustomLog(String fileError, String fileInfo) {
        this.error = new OlmFile(fileError);
        this.info = new OlmFile(fileInfo);
    }

    public void error(String string, String origen) {
        System.out.println("error|" + LocalDateTime.now().format(dtf) + "|" + origen + "|" + string);
        error.setLinea("error|" + LocalDateTime.now().format(dtf) + "|" + origen + "|" + string);
    }

    public void info(String string, String origen) {
        System.out.println("info|" + LocalDateTime.now().format(dtf) + "|" + origen + "|" + string);
        info.setLinea("info|" + LocalDateTime.now().format(dtf) + "|" + origen + "|" + string);
    }
}
