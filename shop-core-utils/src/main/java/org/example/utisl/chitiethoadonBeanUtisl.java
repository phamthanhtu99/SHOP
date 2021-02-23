package org.example.utisl;

import org.example.core.dto.chitiethoadonDTO;
import org.example.persistence.data.chitiethoadonEntity;
import org.modelmapper.ModelMapper;

public class chitiethoadonBeanUtisl {
    private static ModelMapper modelMapper = new ModelMapper();
    public static chitiethoadonDTO entitysangDTo (chitiethoadonEntity chitiethoadonEntity){
        chitiethoadonDTO chitiethoadonDTO = new chitiethoadonDTO();
        chitiethoadonDTO.setId(chitiethoadonEntity.getId());
        chitiethoadonDTO.setSanphamDTO(sanphamBeanUtils.entitysangdto(chitiethoadonEntity.getSanphamEntity()));
        chitiethoadonDTO.setHoadonDTO(hoadonBeanUtlis.EntitysangDTO(chitiethoadonEntity.getHoadonEntity()));
        chitiethoadonDTO.setSoluong(chitiethoadonEntity.getSoluong());
        chitiethoadonDTO.setGiatien(chitiethoadonEntity.getGiatien());
        return chitiethoadonDTO;
    }
    public  static chitiethoadonEntity dtosangentity(chitiethoadonDTO chitiethoadonDTO){
        chitiethoadonEntity chitiethoadonEntity = new chitiethoadonEntity();
        chitiethoadonEntity.setId(chitiethoadonDTO.getId());
        chitiethoadonEntity.setHoadonEntity(hoadonBeanUtlis.dtosangEnityt(chitiethoadonDTO.getHoadonDTO()));
        chitiethoadonEntity.setGiatien(chitiethoadonDTO.getGiatien());
        chitiethoadonEntity.setSanphamEntity(sanphamBeanUtils.DtosangEuntity(chitiethoadonDTO.getSanphamDTO()));
        chitiethoadonEntity.setSoluong(chitiethoadonDTO.getSoluong());
        return chitiethoadonEntity;
    }
}
