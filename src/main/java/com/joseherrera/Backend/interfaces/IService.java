package com.joseherrera.Backend.interfaces;

import java.util.List;
import java.util.Map;

public interface IService<T> {
    
    public T getOneById(int id);

    public T getOne();
    
    public T add();
    
    public T addWithId(int id);

    public void update(int id, Map<String, Object> field);

    public void delete(int id);

    public List<T> getAll();

}
