package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.persistence.data.phieunhapEntity;

import java.util.List;

public interface chitetphieunhapDao extends GenericDao<String, chitietphieunhapEntity> {
        List<chitietphieunhapEntity> CHITIETPHIEUNHAP_phieunhap(phieunhapEntity  entity);
}
