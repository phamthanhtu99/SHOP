package org.example.serviecimpl;

import org.example.core.dao.loaisanphamDao;
import org.example.core.daoimpl.loaisanphamDaoImpl;
import org.example.core.dto.loaisanphamDTO;
import org.example.persistence.data.loaisanphamEntity;
import org.example.service.loaisanphamService;
import org.example.utisl.loaisanphamBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class loaisanphamServiceImpl implements loaisanphamService {
    loaisanphamDao dao = new loaisanphamDaoImpl();
    public List<loaisanphamDTO> Findall() {
        List<loaisanphamDTO> dtos= new ArrayList<loaisanphamDTO>();
        List<loaisanphamEntity> entities =dao.theodanhmuccha(1);
        for (loaisanphamEntity entity:entities){
            loaisanphamDTO dto = loaisanphamBeanUtils.EntitysangDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    public List<loaisanphamDTO> theoid(String danhmuccha) {
        List<loaisanphamDTO> dtos= new ArrayList<loaisanphamDTO>();
        List<loaisanphamEntity> entities =dao.theodanhmuccha(12);
        for (loaisanphamEntity entity:entities){
            loaisanphamDTO dto = loaisanphamBeanUtils.EntitysangDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    public List<loaisanphamDTO> all() {
        List<loaisanphamDTO> dtos= new ArrayList<loaisanphamDTO>();
        List<loaisanphamEntity> entities =dao.Finall();
        for (loaisanphamEntity entity:entities){
            loaisanphamDTO dto = loaisanphamBeanUtils.EntitysangDTO(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
