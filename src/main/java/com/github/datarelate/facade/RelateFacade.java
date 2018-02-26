package com.github.datarelate.facade;

import java.util.List;
import java.util.Map;

public interface RelateFacade<T> {

    List<String> getIds(Map<String, Object> params);
    
    List<T> getListByIds(List<String> ids);

}
