package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.NhanVienEntity;

public interface nhanvienDao extends GenericDao<Integer, NhanVienEntity> {
     NhanVienEntity checklogin(String Email, String password);
     NhanVienEntity savenhanvien (NhanVienEntity entity);
}
