package org.example.persistence.data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "binhluan")
public class binhluanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "chitietninhluan")
    private String chitietbinhluan;
    @ManyToOne
    @JoinColumn(name = "SP")
    private sanphamEntity sanphamEntity;
    @ManyToOne
    @JoinColumn(name = "khachang")
    private KhachHangEntity  khachHangEntity;
    @Column(name = "sao")
    private int sao;
    @Column(name = "ngay")
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

    public org.example.persistence.data.sanphamEntity getSanphamEntity() {
        return sanphamEntity;
    }

    public void setSanphamEntity(sanphamEntity sanphamEntity) {
        this.sanphamEntity = sanphamEntity;
    }

    public KhachHangEntity getKhachHangEntity() {
        return khachHangEntity;
    }

    public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
        this.khachHangEntity = khachHangEntity;
    }

    public int getSao() {
        return sao;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }
}
