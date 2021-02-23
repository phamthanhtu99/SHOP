package org.example.core.dto;

import java.io.Serializable;
import java.util.List;

public class chitiethoadonDTO implements Serializable {

    private Integer id;

    private hoadonDTO hoadonDTO;

    private sanphamDTO sanphamDTO;

    private int soluong;

    private double giatien;


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

    public org.example.core.dto.sanphamDTO getSanphamDTO() {
        return sanphamDTO;
    }

    public void setSanphamDTO(org.example.core.dto.sanphamDTO sanphamDTO) {
        this.sanphamDTO = sanphamDTO;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGiatien() {
        return giatien;
    }

    public void setGiatien(double giatien) {
        this.giatien = giatien;
    }
}
