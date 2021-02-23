package org.example.utisl;

import org.example.core.dto.chitietphieunhapDTO;
import org.example.core.dto.phieunhapDTO;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.persistence.data.phieunhapEntity;
import org.modelmapper.ModelMapper;

public class chitietphieunhapBeaUtils {
    private static ModelMapper modelMapper = new ModelMapper();
    public static chitietphieunhapEntity dtosangEntity(chitietphieunhapDTO dto){
        chitietphieunhapEntity entity = new chitietphieunhapEntity();
        entity.setPhieunhapEntity(phieunhapBeanUtils.dtosangEntity(dto.getPhieunhapDTO()));
        entity.setSanphamEntity(sanphamBeanUtils.DtosangEuntity(dto.getSanphamDTO()));
        entity.setSoluong(dto.getSoluong());
        entity.setThanhtien(dto.getThanhtien());
        entity.setGiatien(dto.getGiatien());
        return entity;
    }
    public static chitietphieunhapDTO Entitysangdto(chitietphieunhapEntity entity){
       chitietphieunhapDTO chitietphieunhapDTO = new chitietphieunhapDTO();
       chitietphieunhapDTO.setSanphamDTO(sanphamBeanUtils.entitysangdto(entity.getSanphamEntity()));
       chitietphieunhapDTO.setPhieunhapDTO(phieunhapBeanUtils.Entitysangdto(entity.getPhieunhapEntity()));
       chitietphieunhapDTO.setSoluong(entity.getSoluong());
       chitietphieunhapDTO.setThanhtien(entity.getThanhtien());
       chitietphieunhapDTO.setGiatien(entity.getGiatien());
        return chitietphieunhapDTO;
    }


}
