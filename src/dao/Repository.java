package dao;

import java.util.ArrayList;

public interface Repository<T>{
    int add(T entity);
    int update(T entity);
    int delete(T entity);
    ArrayList<T> list();
    T get(int id);
}
