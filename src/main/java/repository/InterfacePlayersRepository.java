package repository;

import java.util.List;

public interface InterfacePlayersRepository<T> {
    public void create(String val1, String val2);
    public List<T> findAll(String val1, String val2);
    public List<T> find(String val1);
    public void update();
}
