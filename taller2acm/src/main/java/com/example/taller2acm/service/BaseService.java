package com.example.taller2acm.service;


import java.util.List;

public interface BaseService <T> {
    T save(T Entity);
    T update(T Entity);
    void delete(String id);
    T findById(String id);
    List<T> findAll();


}
