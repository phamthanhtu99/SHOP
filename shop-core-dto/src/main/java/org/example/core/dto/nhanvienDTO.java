package org.example.core.dto;

import java.io.Serializable;

public class nhanvienDTO implements Serializable {
    private  Integer Id;
    private String tennhanvien;
    private String diachi;
    private String sdt;
    private String email;
    private String passWord;
    private chucvuDTO chucvuEntity;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public chucvuDTO getChucvuEntity() {
        return chucvuEntity;
    }

    public void setChucvuEntity(chucvuDTO chucvuEntity) {
        this.chucvuEntity = chucvuEntity;
    }
}

