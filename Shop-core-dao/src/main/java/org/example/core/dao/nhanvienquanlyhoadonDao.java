package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.hoadonEntity;
import org.example.persistence.data.nhanvienquanlyhoadonEntity;

import java.util.List;

public interface nhanvienquanlyhoadonDao extends GenericDao<Integer, nhanvienquanlyhoadonEntity> {
    List<nhanvienquanlyhoadonEntity>quanlyhoadin(String hoadon, String ngaydau, String ngaycuoi, String tennhanvien);
    List<nhanvienquanlyhoadonEntity> danhthu(String ngaymua , String ngaycuoi, String hoadon, String sanpham, String idnhanvien);
    List<nhanvienquanlyhoadonEntity> danhthusanpham(String thang ,String nam);
    nhanvienquanlyhoadonEntity timtheohd(hoadonEntity entity);
    List<nhanvienquanlyhoadonEntity> quanlysanpham(String ngaymua , String ngaycuoi, String hoadon, String sanpham, String idnhanvien,String tinhtrang);
}
