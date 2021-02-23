package org.example.persistence.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaisanpham")
public class loaisanphamEntity {
    @Id
   @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Tensp")
    private String tenSanPham;
    @Column(name = "danhmuccon")
    private int danhmuccon;
    @OneToMany(mappedBy = "loaisanpham",fetch = FetchType.LAZY)
    private  List<sanphamEntity> sanphamEnities;

    public List<sanphamEntity> getSanphamEnities() {
        return sanphamEnities;
    }

    public int getDanhmuccon() {
        return danhmuccon;
    }

    public void setDanhmuccon(int danhmuccon) {
        this.danhmuccon = danhmuccon;
    }

    public void setSanphamEnities(List<sanphamEntity> sanphamEnities) {
        this.sanphamEnities = sanphamEnities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
}
