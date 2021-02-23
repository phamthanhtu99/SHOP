package org.example.persistence.data;

import javax.persistence.*;

@Entity
@Table(name = "chititethoadon")
public class chitiethoadonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "hoadon")
    private hoadonEntity hoadonEntity;
    @ManyToOne
    @JoinColumn(name = "sanpham")
    private sanphamEntity sanphamEntity;
    @Column(name = "giatien")
    private double giatien;
    @Column(name = "soluong")
    private int soluong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public org.example.persistence.data.hoadonEntity getHoadonEntity() {
        return hoadonEntity;
    }

    public void setHoadonEntity(org.example.persistence.data.hoadonEntity hoadonEntity) {
        this.hoadonEntity = hoadonEntity;
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
}
