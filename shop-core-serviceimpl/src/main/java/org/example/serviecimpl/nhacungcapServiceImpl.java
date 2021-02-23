package org.example.serviecimpl;

import org.example.core.dao.nhacungcapDao;
import org.example.core.daoimpl.nhacungcapDaoImpl;
import org.example.core.dto.nhacungcapDTO;
import org.example.persistence.data.nhacungcapEntity;
import org.example.service.nhacungcapService;
import org.example.utisl.nhacungcapBeanUtisl;

import java.util.ArrayList;
import java.util.List;

public class nhacungcapServiceImpl implements nhacungcapService {
nhacungcapDao dao = new nhacungcapDaoImpl();
    public List<nhacungcapDTO> findall() {
        List<nhacungcapEntity> lits = dao.Finall();
        List<nhacungcapDTO >dtos = new ArrayList<nhacungcapDTO>();
        for (nhacungcapEntity entity:lits){
            nhacungcapDTO dto = nhacungcapBeanUtisl.entitysangdto(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    public void save(nhacungcapDTO dto) {
        dao.save(nhacungcapBeanUtisl.DTOsangEntity(dto));
    }
}
