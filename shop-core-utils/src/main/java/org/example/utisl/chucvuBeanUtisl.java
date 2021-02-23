package org.example.utisl;

import org.example.core.dto.chucvuDTO;
import org.example.core.dto.nhanvienDTO;
import org.example.persistence.data.ChucVuEntity;
import org.example.persistence.data.NhanVienEntity;

public class chucvuBeanUtisl {
    public  static chucvuDTO EntitysangDTO (ChucVuEntity Entity){
        chucvuDTO dto = new chucvuDTO();
        dto.setId(Entity.getId());
        dto.setTenChucVu(Entity.getTenChucVu());
        return dto;
    }
    public static ChucVuEntity DTOsangEntity(chucvuDTO dto){
      ChucVuEntity entity = new ChucVuEntity();
        entity.setId(dto.getId());
        entity.setTenChucVu(dto.getTenChucVu());
        return entity;
    }
}
