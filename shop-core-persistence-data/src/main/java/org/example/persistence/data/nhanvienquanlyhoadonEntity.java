package org.example.persistence.data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "nhanvienquanlyhoadon")
public class nhanvienquanlyhoadonEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "hoadon")
    private hoadonEntity hoadonEntity;
    @ManyToOne
    @JoinColumn(name = "nhanvien")
    private NhanVienEntity nhanVienEntity;
    @Column(name = "ngaythuchien")
    private Date ngaythuchien;
    @Column(name = "ngaygiao")
    private Date ngaygiao;

    public Date getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(Date ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public nhanvienquanlyhoadonEntity() {

    }

    public nhanvienquanlyhoadonEntity(Integer id, org.example.persistence.data.hoadonEntity hoadonEntity, NhanVienEntity nhanVienEntity, Date ngaythuchien) {
        this.id = id;
        this.hoadonEntity = hoadonEntity;
        this.nhanVienEntity = nhanVienEntity;
        this.ngaythuchien = ngaythuchien;
    }

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

    public NhanVienEntity getNhanVienEntity() {
        return nhanVienEntity;
    }

    public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
        this.nhanVienEntity = nhanVienEntity;
    }

    public Date getNgaythuchien() {
        return ngaythuchien;
    }

    public void setNgaythuchien(Date ngaythuchien) {
        this.ngaythuchien = ngaythuchien;
    }
}
