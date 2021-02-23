package org.example.service;

import org.example.core.dto.KhachHangDTO;
import org.example.core.dto.hoadonDTO;
import org.example.core.dto.sanphamDTO;

import java.util.List;
import java.util.TreeMap;

public interface hoadonService {
    hoadonDTO save (hoadonDTO hoadonDTO);
    List<hoadonDTO>HOADON_DTOS(KhachHangDTO dto);
    hoadonDTO update(hoadonDTO hoadonDTO);
    hoadonDTO viewsID(hoadonDTO hoadonDTO);
    List<hoadonDTO> viewstatall();
    List<hoadonDTO> viewsgiaohang();
    List<hoadonDTO> viewsall();
    TreeMap<sanphamDTO, Double> thongke();
    List<hoadonDTO>hdchuaxacnhan(KhachHangDTO dto);
    List<hoadonDTO> lichsuhdvadahuy(KhachHangDTO dto ,String tinhtrang);
}
