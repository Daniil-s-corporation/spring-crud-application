package app.dao;


import app.model.User;

import java.util.List;

public interface UserDao<T, E> {

    void save(T type);

    void update(T type);

    void delete(E id);

    T findById(E id);

    List<T> findAll();

}
