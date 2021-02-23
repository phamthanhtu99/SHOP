package org.example.core.dto;

import javax.persistence.Column;
import java.io.Serializable;

public class nhasanxuatDTO implements Serializable {
    private Integer id;
    private String tennhasanxuat;
    private String sdt;
    private String email;
    private String diachi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTennhasanxuat() {
        return tennhasanxuat;
    }

    public void setTennhasanxuat(String tennhasanxuat) {
        this.tennhasanxuat = tennhasanxuat;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
