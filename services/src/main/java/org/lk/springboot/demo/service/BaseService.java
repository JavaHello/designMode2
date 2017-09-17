package org.lk.springboot.demo.service;

import java.util.Map;

import org.lk.springboot.demo.domain.base.Base;

import com.github.pagehelper.PageInfo;

/**
 * Created by luokai on 17-7-15.
 */
public interface BaseService<T> extends Base<T> {
    PageInfo<T> findByPage(Map<String, Object> queryMap, int pageNum, int pageSize);
}