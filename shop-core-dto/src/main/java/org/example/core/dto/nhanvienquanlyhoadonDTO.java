package org.example.core.dto;

import java.sql.Date;
import java.util.List;

public class nhanvienquanlyhoadonDTO {
    private Integer id;
    private hoadonDTO hoadonDTO;
    private nhanvienDTO nhanvienDTO;
    private Date ngaythuchien;
    private Date ngaygiao;
    private List<chitiethoadonDTO> dtos;
    private List<hoadonDTO> hoadonDTOS;

    public Date getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(Date ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public List<org.example.core.dto.hoadonDTO> getHoadonDTOS() {
        return hoadonDTOS;
    }

    public void setHoadonDTOS(List<org.example.core.dto.hoadonDTO> hoadonDTOS) {
        this.hoadonDTOS = hoadonDTOS;
    }

    public List<chitiethoadonDTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<chitiethoadonDTO> dtos) {
        this.dtos = dtos;
    }

    public Date getNgaythuchien() {
        return ngaythuchien;
    }

    public void setNgaythuchien(Date ngaythuchien) {
        this.ngaythuchien = ngaythuchien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.core.dto.hoadonDTO getHoadonDTO() {
        return hoadonDTO;
    }

    public void setHoadonDTO(org.example.core.dto.hoadonDTO hoadonDTO) {
        this.hoadonDTO = hoadonDTO;
    }

    public org.example.core.dto.nhanvienDTO getNhanvienDTO() {
        return nhanvienDTO;
    }

    public void setNhanvienDTO(org.example.core.dto.nhanvienDTO nhanvienDTO) {
        this.nhanvienDTO = nhanvienDTO;
    }
}
