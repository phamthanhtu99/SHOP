package org.example.service;

import org.example.core.dto.chitiethoadonDTO;
import org.example.core.dto.hoadonDTO;

import java.util.List;

public interface chitiethoadonService {
    void save(chitiethoadonDTO chitiethoadonDTO);
    List<chitiethoadonDTO>chitiethoadontheohoadon(hoadonDTO hoadonDTO);
    List<chitiethoadonDTO> ViewsAll ();
}
