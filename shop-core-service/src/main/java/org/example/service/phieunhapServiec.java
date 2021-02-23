package org.example.service;

import org.example.core.dto.phieunhapDTO;

import java.util.List;

public interface phieunhapServiec {
    void savephieunhap(phieunhapDTO dto);
    List<phieunhapDTO> PHIEUNHAP_DTOS();
    List<phieunhapDTO> viewphieunhapDTO(String mapn,String ngaydau,String ngaycuoi);
    phieunhapDTO timtheoid (String id);
    List<phieunhapDTO> stnhap(String nam,String thang);
}
