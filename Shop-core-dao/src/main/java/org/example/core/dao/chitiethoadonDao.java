package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface chitiethoadonDao extends GenericDao<Integer, chitiethoadonEntity> {
    List<chitiethoadonEntity> CHITIETHOADON_ENTITIES(hoadonEntity hoadonEntity);
}
