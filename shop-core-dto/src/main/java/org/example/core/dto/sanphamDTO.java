package org.example.core.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

public class sanphamDTO implements Comparable<sanphamDTO> , Serializable {
    private String Id;
    private String tensp;
    private int soluong;
    private double giatien;
    private String mota;
    private String hinhanh;
    private loaisanphamDTO loaisanpham;
    private nhacungcapDTO  nhacungcapdto;
    private List<hinhanhDTO> hinhanhDTOS;

    public List<hinhanhDTO> getHinhanhDTOS() {
        return hinhanhDTOS;
    }

    public void setHinhanhDTOS(List<hinhanhDTO> hinhanhDTOS) {
        this.hinhanhDTOS = hinhanhDTOS;
    }

    public  sanphamDTO(){
        this.Id=Id;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public loaisanphamDTO getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(loaisanphamDTO loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    public nhacungcapDTO getNhacungcapdto() {
        return nhacungcapdto;
    }

    public void setNhacungcapdto(nhacungcapDTO nhacungcapdto) {
        this.nhacungcapdto = nhacungcapdto;
    }

    public int compareTo(sanphamDTO o) {
       /* if(this.Id.equals(o.Id)){
            return 0;
        }
        return 1;*/
        return Id.compareTo(o.Id);
    }
}
