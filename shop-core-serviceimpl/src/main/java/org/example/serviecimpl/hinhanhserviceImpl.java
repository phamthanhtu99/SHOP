package org.example.serviecimpl;

import org.example.core.dao.hinhanhDao;
import org.example.core.daoimpl.hinhanhDaoImpl;
import org.example.core.dto.hinhanhDTO;
import org.example.persistence.data.hinhanhEntity;
import org.example.service.hinhanhService;
import org.example.utisl.hinhanhBeanUtils;

public class hinhanhserviceImpl implements hinhanhService {
    hinhanhDao dao =new hinhanhDaoImpl();
    public void savehinhanh(hinhanhDTO dto) {
        hinhanhEntity hinhanhEntity = hinhanhBeanUtils.dtosangEnityt(dto);
        dao.save(hinhanhEntity);
    }
}
