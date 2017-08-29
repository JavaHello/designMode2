package org.lk.springboot.demo.domain.base;

import java.util.List;
import java.util.Map;

public interface Base<T> {
    void addObj(T t);
    void delObj(Long id);
    void updateObj(T t);
    T findById(Long id);
    List<T> findAll(Map<String, Object> queryMap);
}
