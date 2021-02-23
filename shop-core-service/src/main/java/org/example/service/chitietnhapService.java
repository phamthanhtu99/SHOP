package org.example.service;

import org.example.core.dto.chitietphieunhapDTO;
import org.example.core.dto.phieunhapDTO;

import java.util.List;

public interface chitietnhapService {
    void saveCtphieunhap(chitietphieunhapDTO dto);
    List<chitietphieunhapDTO> CHITIETPHIEUNHAPall ();
   List<chitietphieunhapDTO> CHITIETPHIEUNHAP_DTO (phieunhapDTO dto);
}
