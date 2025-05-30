package repository;

import model.Match;

import java.util.List;

public interface InterfaceMathesRepository<T> {
    public void save(Match values);
    public List<T> findAll(T val1, T val2);
    public List<T> find(String val1);
    public void update();
}
