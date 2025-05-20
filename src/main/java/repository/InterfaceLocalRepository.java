package repository;

import model.Match;
import model.Players;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface InterfaceLocalRepository<T> {
    public List<Players> create(String val1, String val2);
    public List<T> findAll(T val1, T val2);
    public List<T> find(String val1);
    public void update();
}
