package com.github.datarelate.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.datarelate.context.DataAssistContext;
import com.google.common.base.CaseFormat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;

/**
 * 
 * <Description> <br> 
 * @author haolei<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年1月22日 <br>
 */
public abstract class AbstractDataCollectHandler implements DataCollectHandler<List<Map<String, Object>>> {
    
    
    /**
     * colName
     */
    private final String colName;
    
    /**
     * 构造方法
     */
    public AbstractDataCollectHandler() {
        this("");
    }
    
    /**
     * 构造方法
     * @param colName colName
     */
    public AbstractDataCollectHandler(String colName) {
        this.colName = colName;
    }

    @Override
    public List<Map<String, Object>> handle(List<Map<String, Object>> datas, DataAssistContext assistance) {
        if (datas == null || datas.isEmpty()) {
            return datas;
        }
        if (!datas.parallelStream().anyMatch(
                data -> !Strings.isNullOrEmpty(MoreObjects.firstNonNull(data.get(getColName()), "").toString()) && dataFilter(data))) {
            return datas;
        }
        return forwardHandle(datas, assistance);
    }
    
    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @param data data
     * @return <br>
     */
    public abstract boolean dataFilter(Map<String, Object> data);
    
    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @param datas datas
     * @param assistance assistance
     * @return <br>
     */
    public abstract List<Map<String, Object>> forwardHandle(List<Map<String, Object>> datas, DataAssistContext assistance);
    
    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @param data data
     * @param colName colName
     * @return <br>
     */
    protected Set<String> getColValues(List<Map<String, Object>> data, String colName) {
        return data.parallelStream()
                .filter(map -> map.containsKey(colName))
                .map(map -> map.get(colName).toString())
                .collect(Collectors.toSet()); 
    }

    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @return <br>
     */
    protected String getColName() {
        return colName;
    }

    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @return <br>
     */
    protected String getCamelColName() {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, colName);
    }

    /**
     * 
     * Description: <br> 
     * @author haolei<br>
     * @taskId <br>
     * @return <br>
     */
    protected String getUnderscoreColName() {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, colName);
    }

}
