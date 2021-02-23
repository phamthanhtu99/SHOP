package org.example.persistence.data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "nhasanxuat")
public class nhasanxuatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "tennhasanxuat")
    private String tennhasanxuat;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "diachi")
    private String diachi;
    @OneToMany(mappedBy = "nhasanxuatEntity",fetch = FetchType.LAZY)
    private List<phieunhapEntity> phieunhapEntities;

    public List<phieunhapEntity> getPhieunhapEntities() {
        return phieunhapEntities;
    }

    public void setPhieunhapEntities(List<phieunhapEntity> phieunhapEntities) {
        this.phieunhapEntities = phieunhapEntities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTennhasanxuat() {
        return tennhasanxuat;
    }

    public void setTennhasanxuat(String tennhasanxuat) {
        this.tennhasanxuat = tennhasanxuat;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
