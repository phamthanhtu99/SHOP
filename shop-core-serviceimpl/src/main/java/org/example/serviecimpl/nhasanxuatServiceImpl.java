package org.example.serviecimpl;

import org.example.core.dao.nhasanxuatDao;
import org.example.core.daoimpl.nhasanxuatDaoImpl;
import org.example.core.dto.nhanvienDTO;
import org.example.core.dto.nhasanxuatDTO;
import org.example.persistence.data.nhasanxuatEntity;
import org.example.service.nhasanxuatService;
import org.example.utisl.nhasanxuatBeanUtisl;

import java.util.ArrayList;
import java.util.List;

public class nhasanxuatServiceImpl implements nhasanxuatService {
    nhasanxuatDao nhasanxuatDao = new nhasanxuatDaoImpl();
    public List<nhasanxuatDTO> viewsnhanvien() {
        List<nhasanxuatEntity> nhasanxuatEntities = nhasanxuatDao.Finall();
        List<nhasanxuatDTO> nhasanxuatDTOList = new ArrayList<nhasanxuatDTO>();
        for (nhasanxuatEntity entity : nhasanxuatEntities){
            nhasanxuatDTO  dto = new nhasanxuatDTO();
            dto= nhasanxuatBeanUtisl.EnitysangDto(entity);
            nhasanxuatDTOList.add(dto);
        }
        return nhasanxuatDTOList;
    }
}
