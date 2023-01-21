package com.olmaton.javaswing.views.tables;

/**
 *
 * @author Olmaton
 */
public class OlmObject {

    private final String code;
    private final String description;

    public OlmObject(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
