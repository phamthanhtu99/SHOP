package org.example.utisl;

import org.example.core.dto.nhanvienDTO;
import org.example.persistence.data.NhanVienEntity;
import org.modelmapper.ModelMapper;

public class nhanvienBeanUtils {
    private static ModelMapper modelMapper = new ModelMapper();
    public  static nhanvienDTO EntitysangDTO (NhanVienEntity entity){
        nhanvienDTO dto = modelMapper.map(entity,nhanvienDTO.class);
        return dto;
    }
    public static NhanVienEntity dtosangEnityt(nhanvienDTO dto){
        NhanVienEntity entity =modelMapper.map(dto,NhanVienEntity.class);
        return entity;
    }
}
