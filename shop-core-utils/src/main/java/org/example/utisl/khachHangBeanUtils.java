package org.example.utisl;

import org.example.core.dto.KhachHangDTO;
import org.example.persistence.data.KhachHangEntity;
public class khachHangBeanUtils {
        public static KhachHangDTO entitysangdto(KhachHangEntity entity){
            KhachHangDTO dto = new KhachHangDTO();
            dto.setId(entity.getId());
            dto.setEmail(entity.getEmail());
            dto.setPassWord(entity.getPassWord());
            dto.setSdt(entity.getSDT());
            dto.setTenKhachhang(entity.getTenKhachhang());

            dto.setDiaChi(entity.getDiaChi());

            return dto;
        }
        public static KhachHangEntity dtosangentity(KhachHangDTO dto){
            KhachHangEntity entity = new KhachHangEntity();
            entity.setId(dto.getId());
            entity.setTenKhachhang(dto.getTenKhachhang());
            entity.setEmail(dto.getEmail());
            entity.setDiaChi(dto.getDiaChi());
            entity.setSDT(dto.getSdt());
            entity.setPassWord(dto.getPassWord());
            return entity;
        }

}
