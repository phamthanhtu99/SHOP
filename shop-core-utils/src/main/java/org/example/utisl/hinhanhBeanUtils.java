package org.example.utisl;

import org.example.core.dto.hinhanhDTO;
import org.example.core.dto.hoadonDTO;
import org.example.persistence.data.hinhanhEntity;


public class hinhanhBeanUtils {
    public  static hinhanhEntity dtosangEnityt(hinhanhDTO dto){
        hinhanhEntity hinhanhEntity = new hinhanhEntity();
        hinhanhEntity.setId(dto.getId());
        hinhanhEntity.setSanpham(sanphamBeanUtils.DtosangEuntity(dto.getSanphamDTO()));
        hinhanhEntity.setTenhinh(dto.getTenhinh());
        return  hinhanhEntity;
    }
    public  static hinhanhDTO dtosangEnityt(hinhanhEntity entity){
        hinhanhDTO dto = new hinhanhDTO();
        dto.setId(entity.getId());
        dto.setSanphamDTO(sanphamBeanUtils.entitysangdto(entity.getSanpham()));
        dto.setTenhinh(entity.getTenhinh());
        return dto;
    }
}
