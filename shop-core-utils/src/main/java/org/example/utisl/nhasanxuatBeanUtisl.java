package org.example.utisl;

import org.example.core.dto.nhasanxuatDTO;
import org.example.persistence.data.nhasanxuatEntity;
import org.modelmapper.ModelMapper;

public class nhasanxuatBeanUtisl {
    private static ModelMapper modelMapper = new ModelMapper();
    public static nhasanxuatEntity dtosangEntity(nhasanxuatDTO dto){
        nhasanxuatEntity nhasanxuatEntity = modelMapper.map(dto, nhasanxuatEntity.class);
        return nhasanxuatEntity;
    }
    public static nhasanxuatDTO EnitysangDto (nhasanxuatEntity entity){
        nhasanxuatDTO dto = modelMapper.map(entity,nhasanxuatDTO.class);
        return dto;
    }
}
