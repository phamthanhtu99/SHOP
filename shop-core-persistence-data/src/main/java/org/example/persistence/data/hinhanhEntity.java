package org.example.persistence.data;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "hinhanh")
public class hinhanhEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "sanpham")
    private sanphamEntity sanpham;
    @Column(name = "tenhinh")
    private String tenhinh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public sanphamEntity getSanpham() {
        return sanpham;
    }

    public void setSanpham(sanphamEntity sanpham) {
        this.sanpham = sanpham;
    }

    public String getTenhinh() {
        return tenhinh;
    }

    public void setTenhinh(String tenhinh) {
        this.tenhinh = tenhinh;
    }
}
