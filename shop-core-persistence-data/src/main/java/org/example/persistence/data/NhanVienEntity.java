package org.example.persistence.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhanvien")
public class NhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer Id;
    @Column(name = "TenNhanVien")
    private String TenNhanVien;
    @Column(name = "DiaChi")
    private String DiaChi;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "Email")
    private String email;
    @Column(name = "PassWord")
    private String password;
    @ManyToOne
    @JoinColumn(name = "ChucVu")
    private ChucVuEntity chucVuEntity;
    @OneToMany(mappedBy = "nhanVienEntity",fetch = FetchType.LAZY)
    List<nhanvienquanlyhoadonEntity> nhanvienquanlyhoadonEntities;

    public List<nhanvienquanlyhoadonEntity> getNhanvienquanlyhoadonEntities() {
        return nhanvienquanlyhoadonEntities;
    }

    public void setNhanvienquanlyhoadonEntities(List<nhanvienquanlyhoadonEntity> nhanvienquanlyhoadonEntities) {
        this.nhanvienquanlyhoadonEntities = nhanvienquanlyhoadonEntities;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        TenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ChucVuEntity getChucVuEntity() {
        return chucVuEntity;
    }

    public void setChucVuEntity(ChucVuEntity chucVuEntity) {
        this.chucVuEntity = chucVuEntity;
    }
}
