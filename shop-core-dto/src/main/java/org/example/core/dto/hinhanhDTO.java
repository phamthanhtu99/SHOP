package org.example.core.dto;

import org.example.persistence.data.sanphamEntity;

import javax.persistence.*;

public class hinhanhDTO {
    private Integer id;
    private sanphamDTO sanphamDTO;
    private String tenhinh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.core.dto.sanphamDTO getSanphamDTO() {
        return sanphamDTO;
    }

    public void setSanphamDTO(org.example.core.dto.sanphamDTO sanphamDTO) {
        this.sanphamDTO = sanphamDTO;
    }

    public String getTenhinh() {
        return tenhinh;
    }

    public void setTenhinh(String tenhinh) {
        this.tenhinh = tenhinh;
    }
}
