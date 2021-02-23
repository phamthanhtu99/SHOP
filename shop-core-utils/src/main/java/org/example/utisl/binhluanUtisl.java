package org.example.utisl;

import org.example.core.dto.binhluanDTO;
import org.example.persistence.data.binhluanEntity;

public class binhluanUtisl {
    public  static binhluanDTO entitysangdto(binhluanEntity entity){
        binhluanDTO dto = new binhluanDTO();
        dto.setId(entity.getId());
        dto.setChitietbinhluan(entity.getChitietbinhluan());
        dto.setKhachHangEntity(khachHangBeanUtils.entitysangdto(entity.getKhachHangEntity()));
        dto.setSanphamEntity(sanphamBeanUtils.entitysangdto(entity.getSanphamEntity()));
        dto.setNgay(entity.getNgay());
        return  dto;
    }
    public static binhluanEntity dtosangentyti(binhluanDTO dto){
        binhluanEntity entity = new binhluanEntity();
        entity.setId(dto.getId());
        entity.setChitietbinhluan(dto.getChitietbinhluan());
        entity.setKhachHangEntity(khachHangBeanUtils.dtosangentity(dto.getKhachHangEntity()));
        entity.setSanphamEntity(sanphamBeanUtils.DtosangEuntity(dto.getSanphamEntity()));
        entity.setNgay(dto.getNgay());
        return entity;
    }
}

