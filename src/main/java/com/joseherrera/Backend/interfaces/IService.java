package com.joseherrera.Backend.interfaces;

import java.util.List;


public interface IService<T> {

    public T getByPrincipalKey(int id);
    public void update(T model);
    public T getOneByForeignKeyId(int fkId);
    public List<T> getAllByForeignKeyId(int fkId);
    public void add(int foreignKeyId);
    public void delete(int id);
}
