package org.example.utisl;

import org.example.core.dto.phuongthucthanhtoanDTO;
import org.example.persistence.data.phuongthucthanhtoanEntity;
import org.modelmapper.ModelMapper;

public class phuongthucthanhtoanBeanUtils {
    private static ModelMapper modelMapper = new ModelMapper();

    public static phuongthucthanhtoanDTO entitysangdto(phuongthucthanhtoanEntity entity) {
        phuongthucthanhtoanDTO phuongthucthanhtoanDTO = new phuongthucthanhtoanDTO();
        phuongthucthanhtoanDTO.setId(entity.getId());
        phuongthucthanhtoanDTO.setTenphuongthuc(entity.getTenphuongthuc());
        return phuongthucthanhtoanDTO;
    }

    public static phuongthucthanhtoanEntity dtosangEnity(phuongthucthanhtoanDTO dto) {
        phuongthucthanhtoanEntity phuongthucthanhtoanEntity = new phuongthucthanhtoanEntity();
        phuongthucthanhtoanEntity.setId(dto.getId());
        phuongthucthanhtoanEntity.setTenphuongthuc(dto.getTenphuongthuc());
        return phuongthucthanhtoanEntity;
    }
}
