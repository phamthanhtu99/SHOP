package org.example.utisl;

import org.example.core.dto.phieunhapDTO;
import org.example.persistence.data.nhasanxuatEntity;
import org.example.persistence.data.phieunhapEntity;
import org.modelmapper.ModelMapper;

public class phieunhapBeanUtils {
    private static ModelMapper modelMapper = new ModelMapper();
    public static phieunhapEntity dtosangEntity(phieunhapDTO dto){
        phieunhapEntity entity=modelMapper.map(dto,phieunhapEntity.class);
        return entity;
    }
    public static phieunhapDTO Entitysangdto(phieunhapEntity entity){
        phieunhapDTO  phieunhapDTO = modelMapper.map(entity,phieunhapDTO.class);
        return phieunhapDTO;
    }
}
