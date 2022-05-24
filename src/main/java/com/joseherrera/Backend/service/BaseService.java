package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IModel;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.repository.BaseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T extends IModel, K extends BaseRepository<T>> implements IService<T> {

    @Autowired
    K repo;

    @Override
    public T getByPrincipalKey(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void update(T model) {
        repo.save(model);
    }

    @Override
    public T getOneByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<T> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int foreignKeyId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

}
