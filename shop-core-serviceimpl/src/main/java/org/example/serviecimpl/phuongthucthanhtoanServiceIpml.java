package org.example.serviecimpl;

import org.example.core.dao.phuongthucthanhtoanDao;
import org.example.core.daoimpl.phuongthucthanhtoanDaoImpl;
import org.example.core.dto.phuongthucthanhtoanDTO;
import org.example.persistence.data.phuongthucthanhtoanEntity;
import org.example.service.phuongthucthanhtoanService;
import org.example.utisl.phuongthucthanhtoanBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class phuongthucthanhtoanServiceIpml implements phuongthucthanhtoanService {
    private phuongthucthanhtoanDao phuongthucthanhtoanDao = new phuongthucthanhtoanDaoImpl();
    public List<phuongthucthanhtoanDTO> PHUONGTHUCTHANHTOAN_DTOS() {
        List<phuongthucthanhtoanDTO> phuongthucthanhtoanDTOS=new ArrayList<phuongthucthanhtoanDTO>();
        List<phuongthucthanhtoanEntity> phuongthucthanhtoanEntities = phuongthucthanhtoanDao.Finall();
        for (phuongthucthanhtoanEntity entity:phuongthucthanhtoanEntities){
            phuongthucthanhtoanDTO dto = new phuongthucthanhtoanDTO();
            dto= phuongthucthanhtoanBeanUtils.entitysangdto(entity);
            phuongthucthanhtoanDTOS.add(dto);
        }
        return phuongthucthanhtoanDTOS;
    }
}
