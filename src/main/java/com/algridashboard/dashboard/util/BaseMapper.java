package com.algridashboard.dashboard.util;

import java.util.List;

public interface BaseMapper<T> {
 
    void insert(T obj);
    
    void delete(T obj);
    
    void deleteByPrimaryKey(String id);
    
    void update(T obj);
    
    T selectByPrimaryKey(String id);
    
    List<T> select(T obj); 
    
    List<T> selectAll();

    List<T> selectByPage(T obj, int startPage);
    
    List<T> selectByPage(T obj, int startPage, int pageSize);   
}
