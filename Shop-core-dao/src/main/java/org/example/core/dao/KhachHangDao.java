package org.example.core.dao;

import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.KhachHangEntity;

import java.util.ArrayList;
import java.util.List;

public interface KhachHangDao  extends GenericDao<Integer, KhachHangEntity> {
    KhachHangEntity CheckLoginKhachHang(String Email,String PassWord);
    Boolean CheckEmial (String email);
    List<KhachHangEntity> viewskhach(String name,String sdt);
    KhachHangEntity checklogin1(String Email, String password);
}
