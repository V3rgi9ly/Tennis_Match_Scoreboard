package repository;

import java.util.List;

public interface InterfaceLocalRepository<T> {
    public T create(String val1, String val2);
    public List<T> findAll(T val1, T val2);
    public List<T> find(String val1);
    public void update();
}
