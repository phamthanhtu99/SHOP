package org.example.utisl;

import org.example.core.dto.nhacungcapDTO;
import org.example.core.dto.nhanvienquanlyhoadonDTO;
import org.example.persistence.data.nhacungcapEntity;
import org.example.persistence.data.nhanvienquanlyhoadonEntity;

public class nhanvienquanlyhoadonBeanUtils {

    public static nhanvienquanlyhoadonEntity dtosangentity(nhanvienquanlyhoadonDTO dto){
        nhanvienquanlyhoadonEntity nhanvienquanlyhoadonEntity = new nhanvienquanlyhoadonEntity();
        nhanvienquanlyhoadonEntity.setId(dto.getId());
        nhanvienquanlyhoadonEntity.setNhanVienEntity(nhanvienBeanUtils.dtosangEnityt(dto.getNhanvienDTO()));
        nhanvienquanlyhoadonEntity.setNgaythuchien(dto.getNgaythuchien());
        nhanvienquanlyhoadonEntity.setHoadonEntity(hoadonBeanUtlis.dtosangEnityt(dto.getHoadonDTO()));
        nhanvienquanlyhoadonEntity.setNgaythuchien(dto.getNgaygiao());
        return nhanvienquanlyhoadonEntity;
    }
    public static nhanvienquanlyhoadonDTO  entitysandto (nhanvienquanlyhoadonEntity entity){
        nhanvienquanlyhoadonDTO dto = new nhanvienquanlyhoadonDTO();
        dto.setHoadonDTO(hoadonBeanUtlis.EntitysangDTO(entity.getHoadonEntity()));
        dto.setNhanvienDTO(nhanvienBeanUtils.EntitysangDTO(entity.getNhanVienEntity()));
        dto.setId(entity.getId());
        dto.setNgaythuchien(entity.getNgaythuchien());
        dto.setNgaygiao(entity.getNgaygiao());
        return dto;
    }
}
