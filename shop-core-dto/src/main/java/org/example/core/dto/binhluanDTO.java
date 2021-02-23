package org.example.core.dto;

import org.example.persistence.data.KhachHangEntity;
import org.example.persistence.data.sanphamEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class binhluanDTO  implements Serializable {
    private Integer Id;
    private String chitietbinhluan;
    private sanphamDTO sanphamEntity;
    private KhachHangDTO khachHangEntity;
    private int sao;
    private Date ngay;

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getChitietbinhluan() {
        return chitietbinhluan;
    }

    public void setChitietbinhluan(String chitietbinhluan) {
        this.chitietbinhluan = chitietbinhluan;
    }

    public sanphamDTO getSanphamEntity() {
        return sanphamEntity;
    }

    public void setSanphamEntity(sanphamDTO sanphamEntity) {
        this.sanphamEntity = sanphamEntity;
    }

    public KhachHangDTO getKhachHangEntity() {
        return khachHangEntity;
    }

    public void setKhachHangEntity(KhachHangDTO khachHangEntity) {
        this.khachHangEntity = khachHangEntity;
    }

    public int getSao() {
        return sao;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }
}
