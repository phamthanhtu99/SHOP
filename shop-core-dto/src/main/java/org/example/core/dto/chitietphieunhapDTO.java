package org.example.core.dto;

public class chitietphieunhapDTO {
    private  phieunhapDTO phieunhapDTO;
    private sanphamDTO sanphamDTO;
    private int soluong;
    private double thanhtien;
    private double giatien;

    public double getGiatien() {
        return giatien;
    }

    public void setGiatien(double giatien) {
        this.giatien = giatien;
    }

    public org.example.core.dto.phieunhapDTO getPhieunhapDTO() {
        return phieunhapDTO;
    }

    public void setPhieunhapDTO(org.example.core.dto.phieunhapDTO phieunhapDTO) {
        this.phieunhapDTO = phieunhapDTO;
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

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
}
