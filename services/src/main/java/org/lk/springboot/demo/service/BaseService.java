package org.lk.springboot.demo.service;

import com.github.pagehelper.PageInfo;
import org.lk.springboot.demo.domain.base.Base;

import java.util.List;
import java.util.Map;

/**
 * Created by luokai on 17-7-15.
 */
public interface BaseService<T> extends Base<T> {
    PageInfo<T> findByPage(Map<String, Object> queryMap, int pageNum, int pageSize);
}