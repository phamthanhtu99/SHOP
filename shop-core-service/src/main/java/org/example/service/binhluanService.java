package org.example.service;

import org.example.core.dto.binhluanDTO;
import org.example.core.dto.sanphamDTO;

import java.util.List;

public interface binhluanService {
    void BINHLUAN_DTO(binhluanDTO dto);
    List<binhluanDTO> BINHLUAN_DTO_LIST(sanphamDTO dto);
    void xoab(Integer id);

}
