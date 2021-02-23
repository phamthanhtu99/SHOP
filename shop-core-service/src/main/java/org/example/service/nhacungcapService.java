package org.example.service;

import org.example.core.dto.nhacungcapDTO;

import java.util.List;

public interface nhacungcapService {
    List<nhacungcapDTO> findall();
    void save(nhacungcapDTO dto);
}
