package com.sda.client;

import javafx.event.EventHandler;

public abstract class MyCustomEventHandler implements EventHandler<CustomEvent> {

    public abstract void onEvent(String param0);

    @Override
    public void handle(CustomEvent event) {
        event.invokeHandler(this);
    }
}