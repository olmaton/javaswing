package com.olmaton.javaswing.views.messages;

import com.olmaton.javaswing.services.MessageLevel;

public interface ViewMessageInterface {

    void showMessage(MessageLevel level, String message, String origin);
}
