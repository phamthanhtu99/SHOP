package org.example.utisl;

import org.example.core.dto.KhachHangDTO;
import org.example.core.dto.sanphamDTO;
import org.example.persistence.data.KhachHangEntity;
import org.example.persistence.data.sanphamEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DecimalFormat;

public class sanphamBeanUtils {
    public static sanphamDTO entitysangdto(sanphamEntity entity){
            sanphamDTO dto = new sanphamDTO();
            dto.setId(entity.getId());
            dto.setTensp(entity.getTensp());
            dto.setSoluong(entity.getSoluong());
            dto.setHinhanh(entity.getHinhanh());
            dto.setGiatien(entity.getGiatien());
            dto.setMota(entity.getMota());
            dto.setLoaisanpham(loaisanphamBeanUtils.EntitysangDTO(entity.getLoaisanpham()));
            dto.setNhacungcapdto(nhacungcapBeanUtisl.entitysangdto(entity.getNhacungcapEntity()));
        return dto;
    }
    public static sanphamEntity DtosangEuntity(sanphamDTO dto){
        sanphamEntity entity = new sanphamEntity();
        entity.setId(dto.getId());
        entity.setTensp(dto.getTensp());
        entity.setGiatien(dto.getGiatien());
        entity.setNhacungcapEntity(nhacungcapBeanUtisl.DTOsangEntity(dto.getNhacungcapdto()));
        entity.setMota(dto.getMota());
        entity.setLoaisanpham(loaisanphamBeanUtils.DTOsangEntity(dto.getLoaisanpham()));
        entity.setHinhanh(dto.getHinhanh());
        entity.setSoluong(dto.getSoluong());
        return entity;
    }
}
