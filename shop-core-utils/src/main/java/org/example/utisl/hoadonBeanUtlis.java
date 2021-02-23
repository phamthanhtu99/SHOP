package org.example.utisl;

import org.example.core.dto.hoadonDTO;
import org.example.persistence.data.hoadonEntity;
import org.modelmapper.ModelMapper;

public class hoadonBeanUtlis {
    private static ModelMapper modelMapper = new ModelMapper();
    public  static hoadonEntity dtosangEnityt(hoadonDTO hoadonDTO){
        hoadonEntity hoadonEntity = new hoadonEntity();
        hoadonEntity.setId(hoadonDTO.getId());
        hoadonEntity.setNgaymua(hoadonDTO.getNgaymua());
        hoadonEntity.setKhachHangEntity(khachHangBeanUtils.dtosangentity(hoadonDTO.getKhachHangDTO()));
        hoadonEntity.setTinhtrangEntity(tinhtrangBeanUtisl.dtosangEnity(hoadonDTO.getTinhtrangDTO()));
        hoadonEntity.setSdt(hoadonDTO.getSdt());
        hoadonEntity.setPhuongthucthanhtoanEntity(phuongthucthanhtoanBeanUtils.dtosangEnity(hoadonDTO.getPhuongthucthanhtoanDTO()));
        hoadonEntity.setTongtien(hoadonDTO.getTongtien());
        hoadonEntity.setDiachigiaohang(hoadonDTO.getDiachigiaohang());
        return hoadonEntity;
    }
    public  static hoadonDTO EntitysangDTO(hoadonEntity hoadonEntity){
        hoadonDTO hoadonDTO =new hoadonDTO();
        hoadonDTO.setId(hoadonEntity.getId());
        hoadonDTO.setNgaymua(hoadonEntity.getNgaymua());
        hoadonDTO.setDiachigiaohang(hoadonEntity.getDiachigiaohang());
        hoadonDTO.setKhachHangDTO(khachHangBeanUtils.entitysangdto(hoadonEntity.getKhachHangEntity()));
        hoadonDTO.setPhuongthucthanhtoanDTO(phuongthucthanhtoanBeanUtils.entitysangdto(hoadonEntity.getPhuongthucthanhtoanEntity()));
        hoadonDTO.setTinhtrangDTO(tinhtrangBeanUtisl.entitysangdto(hoadonEntity.getTinhtrangEntity()));
        hoadonDTO.setSdt(hoadonEntity.getSdt());
        hoadonDTO.setTongtien(hoadonEntity.getTongtien());
        hoadonDTO.setDiachigiaohang(hoadonDTO.getDiachigiaohang());
        return hoadonDTO;
    }
}
