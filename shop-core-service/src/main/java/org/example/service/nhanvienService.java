package org.example.service;

import org.example.core.dto.nhanvienDTO;
import org.example.persistence.data.NhanVienEntity;

import java.util.List;

public interface nhanvienService {
       nhanvienDTO Kiemtranguoidung (nhanvienDTO dto);
       List<nhanvienDTO> viewsnhanvien();
       nhanvienDTO nhanvientheoID(nhanvienDTO id);
       void save(nhanvienDTO dto);
       void updatenhanvien(nhanvienDTO dto);
       boolean detele (Integer entity);
}
