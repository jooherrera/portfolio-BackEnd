package com.joseherrera.Backend.interfaces;


public interface IService<T> {
    public T get(int id);
    public void update(T model);
}
