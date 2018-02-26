package com.github.datarelate.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <Description> <br> 
 * @author haolei<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年1月20日 <br>
 */
public class DataAssistContext {
    
    /**
     * collectionName
     */
    private String collectionName;
    
    /**
     * additionalData
     */
    private Map<String, Object> additionalData = new HashMap<>();

    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @return <br>
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @param collectionName <br>
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
    
    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @param key key
     * @param value value<br>
     */
    public void putAddtionalData(String key, Object value) {
        additionalData.put(key, value);
    }
    
    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @param datas <br>
     */
    public void putAllAddtionalData(Map<String, Object> datas) {
        additionalData.putAll(datas);
    }

}
