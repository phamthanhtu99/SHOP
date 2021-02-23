package org.example.persistence.data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "chitietphieunhap")
public class chitietphieunhapEntity  implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "phieunhap")
    private phieunhapEntity phieunhapEntity;


    @Id
    @ManyToOne
    @JoinColumn(name = "sanpham")
    private sanphamEntity sanphamEntity;

    @Column(name = "giatien")
    private double giatien;

    @Column(name = "soluong")
    private int soluong;
    @Column(name ="thanhtien")
    private double thanhtien;

    public org.example.persistence.data.phieunhapEntity getPhieunhapEntity() {
        return phieunhapEntity;
    }

    public void setPhieunhapEntity(org.example.persistence.data.phieunhapEntity phieunhapEntity) {
        this.phieunhapEntity = phieunhapEntity;
    }

    public org.example.persistence.data.sanphamEntity getSanphamEntity() {
        return sanphamEntity;
    }

    public void setSanphamEntity(org.example.persistence.data.sanphamEntity sanphamEntity) {
        this.sanphamEntity = sanphamEntity;
    }

    public double getGiatien() {
        return giatien;
    }

    public void setGiatien(double giatien) {
        this.giatien = giatien;
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

    @Override
    public int hashCode() {
        return Objects.hash(sanphamEntity.getId(),phieunhapEntity.getId(),soluong,giatien);
    }

    @Override
    public boolean equals(Object obj) {
        if (this ==obj) return  true;
        if(!(obj instanceof  chitiethoadonEntity )) return false;
        chitiethoadonEntity that = (chitiethoadonEntity) obj;

        return super.equals(obj);
    }
}


