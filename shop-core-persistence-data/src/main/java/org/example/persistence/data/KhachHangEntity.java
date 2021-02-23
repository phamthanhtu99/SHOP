package org.example.persistence.data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "khachhang")
public class KhachHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer Id;
    @Column(name = "TenKhachHang")
    private String TenKhachhang;
    @Column(name = "DiaChi")
    private String DiaChi;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "Email")
    private String Email;
    @Column(name = "PassWord")
    private String PassWord;

    @OneToMany(mappedBy = "khachHangEntity",fetch = FetchType.EAGER)
    private List<hoadonEntity> hoadonEntities;

    public List<hoadonEntity> getHoadonEntities() {
        return hoadonEntities;
    }

    public void setHoadonEntities(List<hoadonEntity> hoadonEntities) {
        this.hoadonEntities = hoadonEntities;
    }

    @OneToMany(mappedBy = "khachHangEntity",fetch = FetchType.LAZY)
    private List<binhluanEntity> nhanVienEntityList;

    public List<binhluanEntity> getNhanVienEntityList() {
        return nhanVienEntityList;
    }

    public void setNhanVienEntityList(List<binhluanEntity> nhanVienEntityList) {
        this.nhanVienEntityList = nhanVienEntityList;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenKhachhang() {
        return TenKhachhang;
    }

    public void setTenKhachhang(String tenKhachhang) {
        TenKhachhang = tenKhachhang;
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
