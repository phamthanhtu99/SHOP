package org.example.service;

import org.example.core.dto.KhachHangDTO;
import org.example.persistence.data.KhachHangEntity;

import java.util.List;

public interface KhachHangService {
    KhachHangDTO Kiemtranguoidung (KhachHangDTO dto);
    boolean Checkemail(KhachHangDTO dto);
    void save(KhachHangDTO dto);
    void update(KhachHangDTO dto);
    KhachHangDTO timtheoid(KhachHangDTO dto);
    List<KhachHangDTO> khachhang(String name,String sdt);
}
