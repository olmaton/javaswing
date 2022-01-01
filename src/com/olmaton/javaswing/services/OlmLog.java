package com.olmaton.javaswing.services;

public class OlmLog extends OlmCustomLog {

    private static OlmLog instancia;

    public OlmLog(String fileError, String fileInfo) {
        super(fileError, fileInfo);
    }

    public static OlmLog getInstance() {
        if (instancia == null) {
            instancia = new OlmLog("olm_error.log", "olm_info.log");
        }
        return instancia;
    }
}
