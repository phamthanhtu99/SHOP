package org.example.service;

import org.example.core.dto.KhachHangDTO;
import org.example.core.dto.hoadonDTO;
import org.example.core.dto.nhanvienDTO;
import org.example.core.dto.nhanvienquanlyhoadonDTO;
import org.example.persistence.data.NhanVienEntity;
import org.example.persistence.data.nhanvienquanlyhoadonEntity;

import java.util.List;

public interface nhanvienquanlyhoadonService {
    void savenhanvienquanlyhoadon (hoadonDTO hoadonDTO , nhanvienDTO dto);
    List<nhanvienquanlyhoadonDTO>  views(String hoadon, String ngaydau, String ngaycuoi, String id);
    List<nhanvienquanlyhoadonDTO>danhthu(String ngaymua, String ngaycuoi, String hoadon, String sanpham, String idnhanvien);
    List<nhanvienquanlyhoadonDTO>quanlysanpham(String ngaymua, String ngaycuoi, String hoadon, String sanpham, String idnhanvien,String tinhtrang);
    List<nhanvienquanlyhoadonDTO> danhthusanpham(String thang , String nam);
    void update(nhanvienquanlyhoadonDTO nhanvienquanlyhoadonDTO);
}
