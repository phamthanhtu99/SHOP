package org.example.serviecimpl;

import org.example.core.dao.chitiethoadonDao;
import org.example.core.daoimpl.chitiethoadonDaoImpl;
import org.example.core.dto.chitiethoadonDTO;
import org.example.core.dto.hoadonDTO;
import org.example.persistence.data.chitiethoadonEntity;
import org.example.service.chitiethoadonService;
import org.example.utisl.chitiethoadonBeanUtisl;
import org.example.utisl.hoadonBeanUtlis;

import java.util.ArrayList;
import java.util.List;

public class chitiethoadonServiceImpl implements chitiethoadonService {
    chitiethoadonDTO chitiethoadonDTO= new chitiethoadonDTO();
    chitiethoadonEntity chitiethoadonEntity = new chitiethoadonEntity();
    chitiethoadonDao chitiethoadonDao = new chitiethoadonDaoImpl();
    public void save(chitiethoadonDTO chitiethoadonDTO) {
        chitiethoadonEntity = chitiethoadonBeanUtisl.dtosangentity(chitiethoadonDTO);
        chitiethoadonDao.save(chitiethoadonEntity);
    }

    public List<chitiethoadonDTO> chitiethoadontheohoadon(hoadonDTO  dto) {
        List<chitiethoadonEntity> chitiethoadonEntities = chitiethoadonDao.CHITIETHOADON_ENTITIES(hoadonBeanUtlis.dtosangEnityt(dto));
        List<chitiethoadonDTO> chitiethoadonDTOS = new ArrayList<org.example.core.dto.chitiethoadonDTO>();
        for (chitiethoadonEntity entity:chitiethoadonEntities){
            chitiethoadonDTO chitiethoadonDTO = new chitiethoadonDTO();
            chitiethoadonDTO=chitiethoadonBeanUtisl.entitysangDTo(entity);
            chitiethoadonDTOS.add(chitiethoadonDTO);
        }
        return chitiethoadonDTOS;
    }

    public List<chitiethoadonDTO> ViewsAll() {
        List<chitiethoadonEntity> chitiethoadonEntities = chitiethoadonDao.Finall();
        List<chitiethoadonDTO> chitiethoadonDTOS = new ArrayList<chitiethoadonDTO>();
        for (chitiethoadonEntity entity:chitiethoadonEntities){
            chitiethoadonDTO chitiethoadonDTO = new chitiethoadonDTO();
            chitiethoadonDTO=chitiethoadonBeanUtisl.entitysangDTo(entity);
            chitiethoadonDTOS.add(chitiethoadonDTO);
        }
        return chitiethoadonDTOS;
    }
}
