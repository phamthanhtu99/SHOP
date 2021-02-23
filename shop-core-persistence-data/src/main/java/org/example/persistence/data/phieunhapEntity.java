package org.example.persistence.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name ="phieunhap")
public class phieunhapEntity {
    @Id
    private String id;
    @Column(name = "ngaynhap")
    private Date date;
    @Column(name = "nguoinhap")
    private String nguoinhap;
    @Column(name = "ghichu")
    private String ghichu;
    @Column(name = "tongtiem")
    private double tongtien;
    @ManyToOne
    @JoinColumn(name ="nhasanxuat")
    private nhasanxuatEntity nhasanxuatEntity;

    @OneToMany(mappedBy = "phieunhapEntity")
    List<chitietphieunhapEntity>chitietphieunhapEntities;

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
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

    public List<chitietphieunhapEntity> getChitietphieunhapEntities() {
        return chitietphieunhapEntities;
    }

    public void setChitietphieunhapEntities(List<chitietphieunhapEntity> chitietphieunhapEntities) {
        this.chitietphieunhapEntities = chitietphieunhapEntities;
    }

    public String getId() {
        return id;
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

    public org.example.persistence.data.nhasanxuatEntity getNhasanxuatEntity() {
        return nhasanxuatEntity;
    }

    public void setNhasanxuatEntity(org.example.persistence.data.nhasanxuatEntity nhasanxuatEntity) {
        this.nhasanxuatEntity = nhasanxuatEntity;
    }
}
