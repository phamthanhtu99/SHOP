package org.example.core.dto;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

public class KhachHangDTO implements Serializable {
    private  Integer Id;

    private String tenKhachhang;

    private String diaChi;

    private String sdt;

    private String email;

    private String passWord;
    private List<hoadonDTO>hoadonDTOS;

    public List<hoadonDTO> getHoadonDTOS() {
        return hoadonDTOS;
    }

    public void setHoadonDTOS(List<hoadonDTO> hoadonDTOS) {
        this.hoadonDTOS = hoadonDTOS;
    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenKhachhang() {
        return tenKhachhang;
    }

    public void setTenKhachhang(String tenKhachhang) {
        this.tenKhachhang = tenKhachhang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
}
