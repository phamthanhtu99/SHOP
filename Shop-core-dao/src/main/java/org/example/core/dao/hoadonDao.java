package org.example.core.dao;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.data.Dao.GenericDao;
import org.example.core.dto.KhachHangDTO;
import org.example.persistence.data.KhachHangEntity;
import org.example.persistence.data.hoadonEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface hoadonDao extends GenericDao<String, hoadonEntity> {
    List<hoadonEntity> HOADON_khachang(KhachHangEntity khachHangEntity);
    List<hoadonEntity> hoadon();
    List<hoadonEntity> quanlyhoadon(String ngaymua,String mahoadon);
    List<hoadonEntity> giaohang();
    List<hoadonEntity> thongke ();
    List<hoadonEntity> lichsuda1(KhachHangEntity dto,String tinhtrang);
    List<hoadonEntity> dhchuaxacnhan(KhachHangEntity entity);


    }
