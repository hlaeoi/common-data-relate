package com.github.datarelate.handler;

import com.github.datarelate.context.DataAssistContext;

/**
 * 
 * <Description> <br> 
 * @author haolei<br>
 * @version 1.0<br>
 * @taskId <br>
 * @param <T>
 * @CreateDate 2018年1月20日 <br>
 */
public interface DataCollectHandler<T> {
    
    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @param data data
     * @param assistance assistance
     * @return <br>
     */
    T handle(T data, DataAssistContext assistance);

}
