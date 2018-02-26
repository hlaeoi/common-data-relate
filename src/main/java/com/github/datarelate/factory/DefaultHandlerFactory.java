package com.github.datarelate.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.github.datarelate.exception.NoSuchHandlerException;
import com.github.datarelate.handler.DataCollectHandler;
import com.github.datarelate.support.HandlerRegistry;

public class DefaultHandlerFactory implements HandlerRegistry {

    /** Logger available to subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private Map<String, DataCollectHandler<?>> handlers = new HashMap<>();

    @Override
    public void registerHandler(String handlerName, DataCollectHandler<?> handler) {

        Assert.hasText(handlerName, "Handler name must not be empty");
        Assert.notNull(handler, "handler must not be null");
        handlers.put(handlerName, handler);
    }

    @Override
    public void removeHandler(String handlerName) {
        Assert.hasText(handlerName, "'handlerName' must not be empty");

        DataCollectHandler<?> handler = this.handlers.remove(handlerName);
        if (handler == null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("No handler named '" + handlerName + "' found in " + this);
            }
            throw new NoSuchHandlerException("No handler named '" + handlerName + "' found in " + this);
        }
    }

    @Override
    public DataCollectHandler<?> getHandler(String handlerName) {
        Assert.hasText(handlerName, "'handlerName' must not be empty");
        
        DataCollectHandler<?> handler = this.handlers.get(handlerName);
        if (handler == null) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("No handler named '" + handlerName + "' found in " + this);
            }
            throw new NoSuchHandlerException("No handler named '" + handlerName + "' found in " + this);
        }
        return handler;
    }

    @Override
    public boolean containsHandler(String handlerName) {
        Assert.notNull(handlerName, "Handler name must not be null");
        return this.handlers.containsKey(handlerName);
    }

    @Override
    public String[] getHandlerNames() {
        return this.handlers.keySet().toArray(new String[0]);
    }

    @Override
    public int getHandlerCount() {
        return this.handlers.size();
    }
    
}
