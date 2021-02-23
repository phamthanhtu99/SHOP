package org.example.persistence.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhacungcap")
public class nhacungcapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "TenNhaCungCap")
    private String nhacungcap;
    @Column(name="Email")
    private String email;
    @Column(name = "Sdt")
    private String sdt;
    @OneToMany(mappedBy = "nhacungcapEntity",fetch = FetchType.LAZY)
    private List<sanphamEntity>  list;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public List<sanphamEntity> getList() {
        return list;
    }

    public void setList(List<sanphamEntity> list) {
        this.list = list;
    }
}
