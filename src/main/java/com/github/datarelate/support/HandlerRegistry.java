package com.github.datarelate.support;

import com.github.datarelate.handler.DataCollectHandler;

public interface HandlerRegistry {

    void registerHandler(String handlerName, DataCollectHandler<?> handler);

    void removeHandler(String handlerName);

    @SuppressWarnings("rawtypes")
    DataCollectHandler getHandler(String handlerName);

    boolean containsHandler(String handlerName);

    String[] getHandlerNames();

    int getHandlerCount();

}
