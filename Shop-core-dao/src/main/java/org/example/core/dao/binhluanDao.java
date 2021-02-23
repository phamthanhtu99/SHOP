package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.core.dto.binhluanDTO;
import org.example.persistence.data.binhluanEntity;
import org.example.persistence.data.sanphamEntity;

import java.util.List;

public interface binhluanDao extends GenericDao<Integer, binhluanEntity> {
    List<binhluanEntity> BINHLUAN_DAOS (sanphamEntity SP);
    List<binhluanEntity> BINHLUAN_DAOS1 (binhluanEntity SP);
}
