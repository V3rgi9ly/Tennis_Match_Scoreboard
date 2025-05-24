package repository;

import util.ConfigurationData;
import util.HibernateUtil;

import java.util.List;

public class MathesRepository implements  InterfaceMathesRepository {
    HibernateUtil configHibernate = HibernateUtil.getInstance();
    ConfigurationData configurationData=ConfigurationData.getInstance();

    @Override
    public void save(Object values) {

    }

    @Override
    public List findAll(Object val1, Object val2) {
        return List.of();
    }

    @Override
    public List find(String val1) {
        return List.of();
    }

    @Override
    public void update() {

    }
}
