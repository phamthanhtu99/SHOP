package org.example.core.dao;


import org.apache.commons.fileupload.util.LimitedInputStream;
import org.example.core.data.Dao.GenericDao;
import org.example.persistence.data.hinhanhEntity;

import java.util.List;

public interface hinhanhDao extends GenericDao<Integer, hinhanhEntity> {
    List<hinhanhEntity> hinhanhtheosanpham (String sanpham);
}
