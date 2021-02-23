package org.example.persistence.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chucvu")
public class ChucVuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "TenChucVu")
    private String TenChucVu;
    @OneToMany(mappedBy = "chucVuEntity",fetch = FetchType.LAZY)
    private List<NhanVienEntity>nhanVienEntityList;

    public List<NhanVienEntity> getNhanVienEntityList() {
        return nhanVienEntityList;
    }

    public void setNhanVienEntityList(List<NhanVienEntity> nhanVienEntityList) {
        this.nhanVienEntityList = nhanVienEntityList;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        TenChucVu = tenChucVu;
    }


}
