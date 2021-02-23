package org.example.utisl;

import org.example.core.dto.loaisanphamDTO;
import org.example.persistence.data.loaisanphamEntity;

public class loaisanphamBeanUtils {
    public static loaisanphamDTO EntitysangDTO (loaisanphamEntity entity){
        loaisanphamDTO dto = new loaisanphamDTO();
        dto.setId(entity.getId());
        dto.setTenSp(entity.getTenSanPham());
        return dto;
    }
    public static loaisanphamEntity DTOsangEntity(loaisanphamDTO dto){
        loaisanphamEntity entity = new loaisanphamEntity();
        entity.setId(dto.getId());
        entity.setTenSanPham(dto.getTenSp());
        return entity;
    }
}
