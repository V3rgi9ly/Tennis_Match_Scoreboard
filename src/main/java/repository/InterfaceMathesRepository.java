package repository;

import java.util.List;

public interface InterfaceMathesRepository<T> {
    public void create(T... values);
    public List<T> findAll(T val1, T val2);
    public List<T> find(String val1);
    public void update();
}
