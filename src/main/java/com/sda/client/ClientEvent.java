package com.sda.client;

import javafx.event.EventType;

public class ClientEvent extends CustomEvent {
    public static final EventType<CustomEvent> CLIENT_EVENT = new EventType(CUSTOM_EVENT_TYPE, "ClientEvent");

    private final String param;

    public ClientEvent(String param) {
        super(CLIENT_EVENT);
        this.param = param;
    }

    @Override
    public void invokeHandler(MyCustomEventHandler handler) {
        handler.onEvent(param);
    }
}
