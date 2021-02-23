package org.example.core.data.Dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <ID extends Serializable,T> {
    List<T> Finall();
    T updata(T entity);
    T save (T entity);
    T checklogin1(String Email ,String password);
    Object[] FindByproprety(Integer offset, Integer limit,String seach,String loaisanpham);
    T findByID(ID id);
    T ID(ID id);
    boolean detele (ID entity);
}
