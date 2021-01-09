package com.example.jpademo.service;

import javax.persistence.criteria.*;
import java.util.LinkedHashMap;
import java.util.List;

public class PageCount<T> {
    private int page; //当前页
    private int size; //页大小
    private long total; //总记录数
    private List<T> data; //数据

    public PageCount(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageCount() {
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    //获取当前页首条记录下标
    public int first() {
        return (page - 1) * size;
    }

    //获取当前页末条记录下标
    public int max() {
        return page * size;
    }

    //构建select count语句
    public CriteriaQuery<Long> count(CriteriaBuilder criteriaBuilder, Predicate predicate, Class<?> clazz, LinkedHashMap<String,JoinType> joinMap){
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<?> root = criteriaQuery.from(clazz);
        joinMap.forEach(root::join);
        return criteriaQuery.select(criteriaBuilder.count(root)).where(predicate);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }
}
