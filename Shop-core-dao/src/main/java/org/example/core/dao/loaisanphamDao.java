package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.loaisanphamEntity;

import java.util.List;

public interface loaisanphamDao extends GenericDao<Integer, loaisanphamEntity> {
    List<loaisanphamEntity> theodanhmuccha(int id);
}
