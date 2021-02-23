package org.example.serviecimpl;

import org.example.core.dao.chucvuDao;
import org.example.core.daoimpl.chucvuDaoImpl;
import org.example.core.dto.chucvuDTO;
import org.example.persistence.data.ChucVuEntity;
import org.example.service.chucvuService;
import org.example.utisl.chucvuBeanUtisl;

import java.util.ArrayList;
import java.util.List;

public class chucvuServiceImpl implements chucvuService {
        chucvuDao chucvuDao = new chucvuDaoImpl();
    public List<chucvuDTO> CHUCVU_DTOS() {
        List<ChucVuEntity> chucVuEntities = chucvuDao.Finall();
        List<chucvuDTO> chucvuDTOS = new ArrayList<chucvuDTO>();
        for (ChucVuEntity entity: chucVuEntities){
            chucvuDTO dto = chucvuBeanUtisl.EntitysangDTO(entity);
            chucvuDTOS.add(dto);
        }
        return chucvuDTOS;
    }
}
