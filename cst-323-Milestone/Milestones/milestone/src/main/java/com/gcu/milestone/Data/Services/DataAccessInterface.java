package com.gcu.milestone.Data.Services;

import java.util.List;

public interface DataAccessInterface <T> {

    public List<T> findAll();
    public T findById(Long id);
    public T findByName(String name);
    //public boolean create(T t);
    public void delete(Long t);

    
}

