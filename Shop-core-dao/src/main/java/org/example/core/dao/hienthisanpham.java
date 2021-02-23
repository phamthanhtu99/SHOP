package org.example.core.dao;


import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.chitietphieunhapEntity;

import java.util.List;


public interface hienthisanpham extends GenericDao<String, chitietphieunhapEntity> {
    List<chitietphieunhapEntity> Xe(int offset, int limit, String seach, String loaixe) ;

}
