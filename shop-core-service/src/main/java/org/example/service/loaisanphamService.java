package org.example.service;

import org.example.core.dto.loaisanphamDTO;

import java.util.List;

public interface loaisanphamService {
    List<loaisanphamDTO> Findall();
    List<loaisanphamDTO> theoid(String danhmuccha);
    List<loaisanphamDTO> all();

}
