package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.ChucVuEntity;
import org.example.persistence.data.phieunhapEntity;

import java.util.List;

public interface phieunhapDao extends GenericDao<String, phieunhapEntity> {
    List<phieunhapEntity> viewphieunhap(String mapn,String ngaydau,String ngaynhapcuoi);
    List<phieunhapEntity> stnhap (String nam ,String thang);
}
