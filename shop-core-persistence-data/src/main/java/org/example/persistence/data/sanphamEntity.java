package org.example.persistence.data;


import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "sanpham")
public class sanphamEntity {
    @Id
    private String Id;
    @Column(name = "TenSP")
    private String tensp;
    @Column(name = "Soluong")
    private int soluong;
    @Column(name = "GiaTien")
    private double giatien;
    @Column(name = "mota")
    private String mota;
    @Column(name = "HinhAnh")
    private String hinhanh;

    @ManyToOne
    @JoinColumn(name = "LoaiSanPham")
    private loaisanphamEntity loaisanpham;
    @ManyToOne
    @JoinColumn(name = "nhacungcap")
    private nhacungcapEntity  nhacungcapEntity;
    @OneToMany(mappedBy ="sanphamEntity",fetch = FetchType.EAGER)
    private List<binhluanEntity> binhluanEntities;

    @OneToMany(mappedBy =  "sanphamEntity",fetch = FetchType.LAZY)
    private List<chitietphieunhapEntity> chitietphieunhapEntities;

    @OneToMany(mappedBy = "sanphamEntity",fetch = FetchType.EAGER)
    private List<chitiethoadonEntity> chitiethoadonEntities;

    @OneToMany(mappedBy = "sanpham",fetch = FetchType.EAGER)
    private List<hinhanhEntity> hinhanhEntities;

    public List<hinhanhEntity> getHinhanhEntities() {
        return hinhanhEntities;
    }

    public void setHinhanhEntities(List<hinhanhEntity> hinhanhEntities) {
        this.hinhanhEntities = hinhanhEntities;
    }

    public List<chitiethoadonEntity> getChitiethoadonEntities() {
        return chitiethoadonEntities;
    }

    public void setChitiethoadonEntities(List<chitiethoadonEntity> chitiethoadonEntities) {
        this.chitiethoadonEntities = chitiethoadonEntities;
    }



    public List<chitietphieunhapEntity> getChitietphieunhapEntities() {
        return chitietphieunhapEntities;
    }

    public void setChitietphieunhapEntities(List<chitietphieunhapEntity> chitietphieunhapEntities) {
        this.chitietphieunhapEntities = chitietphieunhapEntities;
    }

    public List<binhluanEntity> getBinhluanEntities() {
        return binhluanEntities;
    }

    public void setBinhluanEntities(List<binhluanEntity> binhluanEntities) {
        this.binhluanEntities = binhluanEntities;
    }

    public nhacungcapEntity getNhacungcapEntity() {
        return nhacungcapEntity;
    }

    public void setNhacungcapEntity(nhacungcapEntity nhacungcapEntity) {
        this.nhacungcapEntity = nhacungcapEntity;
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

    public loaisanphamEntity getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(loaisanphamEntity loaisanpham) {
        this.loaisanpham = loaisanpham;
    }
}
