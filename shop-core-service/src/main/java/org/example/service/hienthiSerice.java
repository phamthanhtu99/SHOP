package org.example.service;


import org.example.core.dto.chitiethoadonDTO;
import org.example.core.dto.chitietphieunhapDTO;
import org.example.core.dto.phieunhapDTO;

import java.util.List;

public interface hienthiSerice {
    List<chitietphieunhapDTO> xe(int offset, int limit, String seach, String loaixe);

}
