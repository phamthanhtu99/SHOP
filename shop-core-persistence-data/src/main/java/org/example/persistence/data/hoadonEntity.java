package org.example.persistence.data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "hoadon")
public class hoadonEntity {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "phuongthucthanhtoan")
    private phuongthucthanhtoanEntity phuongthucthanhtoanEntity;
    @ManyToOne
    @JoinColumn(name = "khachhang")
    private KhachHangEntity khachHangEntity;
    @ManyToOne
    @JoinColumn(name = "tinhtrang")
    private tinhtrangEntity tinhtrangEntity;
    @Column(name = "ngaymua")
    private Timestamp ngaymua;
    @Column(name = "sdt")
    private String Sdt;
    @Column(name = "diachigiaohang")
    private String diachigiaohang;
    @Column(name = "tongtien")
    private double tongtien;
    @OneToMany(mappedBy = "hoadonEntity",fetch = FetchType.EAGER)
    List<nhanvienquanlyhoadonEntity> nhanvienquanlyhoadonEntities;

    @OneToMany(mappedBy = "hoadonEntity",fetch = FetchType.EAGER)
    List<chitiethoadonEntity> chitiethoadonEntities;


    public List<nhanvienquanlyhoadonEntity> getNhanvienquanlyhoadonEntities() {
        return nhanvienquanlyhoadonEntities;
    }

    public void setNhanvienquanlyhoadonEntities(List<nhanvienquanlyhoadonEntity> nhanvienquanlyhoadonEntities) {
        this.nhanvienquanlyhoadonEntities = nhanvienquanlyhoadonEntities;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public List<chitiethoadonEntity> getChitiethoadonEntities() {
        return chitiethoadonEntities;
    }

    public void setChitiethoadonEntities(List<chitiethoadonEntity> chitiethoadonEntities) {
        this.chitiethoadonEntities = chitiethoadonEntities;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public org.example.persistence.data.phuongthucthanhtoanEntity getPhuongthucthanhtoanEntity() {
        return phuongthucthanhtoanEntity;
    }

    public void setPhuongthucthanhtoanEntity(org.example.persistence.data.phuongthucthanhtoanEntity phuongthucthanhtoanEntity) {
        this.phuongthucthanhtoanEntity = phuongthucthanhtoanEntity;
    }

    public KhachHangEntity getKhachHangEntity() {
        return khachHangEntity;
    }

    public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
        this.khachHangEntity = khachHangEntity;
    }

    public org.example.persistence.data.tinhtrangEntity getTinhtrangEntity() {
        return tinhtrangEntity;
    }

    public void setTinhtrangEntity(org.example.persistence.data.tinhtrangEntity tinhtrangEntity) {
        this.tinhtrangEntity = tinhtrangEntity;
    }

    public Timestamp getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Timestamp ngaymua) {
        this.ngaymua = ngaymua;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }
}
