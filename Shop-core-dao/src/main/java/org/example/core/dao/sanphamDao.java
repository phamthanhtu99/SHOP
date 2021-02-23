package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.sanphamEntity;

import java.util.List;

public interface sanphamDao extends GenericDao<String, sanphamEntity>  {
    sanphamEntity theoID(String id);
    boolean detele(String id);
    List<sanphamEntity> Xe(int offset,int limit,String seach,String loaixe );
    Object[] FindByproprety1(Integer offset, Integer limit,String seach,String loaisanpham);
    Object[] timkiemsanpham(Integer offset, Integer limit,String id,String ten);
}
