package org.example.utisl;

import org.example.core.dto.nhacungcapDTO;
import org.example.persistence.data.nhacungcapEntity;

public class nhacungcapBeanUtisl {
    public static nhacungcapDTO entitysangdto(nhacungcapEntity entity){
        nhacungcapDTO dto = new nhacungcapDTO();
        dto.setId(entity.getId());
        dto.setNhacungcap(entity.getNhacungcap());
        dto.setSdt(entity.getSdt());
        dto.setEmail(entity.getEmail());
        return dto;
    }
    public static nhacungcapEntity DTOsangEntity(nhacungcapDTO dto){
        nhacungcapEntity entity = new nhacungcapEntity();
        if (dto.getId()!=null){
            entity.setId(dto.getId());
        }
        entity.setNhacungcap(dto.getNhacungcap());
        entity.setSdt(dto.getSdt());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
