package org.example.utisl;

import org.example.core.dto.tinhtrangDTO;
import org.example.persistence.data.tinhtrangEntity;
import org.modelmapper.ModelMapper;

public class tinhtrangBeanUtisl {
    private static ModelMapper modelMapper = new ModelMapper();
    public static tinhtrangDTO entitysangdto(tinhtrangEntity entity){
        tinhtrangDTO tinhtrangDTO = new tinhtrangDTO();
        tinhtrangDTO.setId(entity.getId());
        tinhtrangDTO.setTinhtrang(entity.getTinhtrang());
        return tinhtrangDTO;
    }
    public static tinhtrangEntity dtosangEnity(tinhtrangDTO dto){
        tinhtrangEntity tinhtrangEntity =new tinhtrangEntity();
        tinhtrangEntity.setId(dto.getId());
        tinhtrangEntity.setTinhtrang(dto.getTinhtrang());
        return tinhtrangEntity;
    }

}
