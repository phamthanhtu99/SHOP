package org.example.core.dto;

import org.example.persistence.data.nhasanxuatEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class phieunhapDTO {
    private String id;
    private Date date;
    private nhasanxuatDTO nhasanxuatEntity;
    private String nguoinhap;
    private String ghichu;
    private double tongtien;

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getId() {
        return id;
    }

    public String getNguoinhap() {
        return nguoinhap;
    }

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public nhasanxuatDTO getNhasanxuatEntity() {
        return nhasanxuatEntity;
    }

    public void setNhasanxuatEntity(nhasanxuatDTO nhasanxuatEntity) {
        this.nhasanxuatEntity = nhasanxuatEntity;
    }
}
