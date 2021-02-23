package org.example.persistence.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tinhtrangthanhtoan")
public class tinhtrangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tinhtrang")
    private String tinhtrang;
    @OneToMany(mappedBy = "tinhtrangEntity",fetch = FetchType.LAZY)
    private List<hoadonEntity> hoadonEntities;

    public List<hoadonEntity> getHoadonEntities() {
        return hoadonEntities;
    }

    public void setHoadonEntities(List<hoadonEntity> hoadonEntities) {
        this.hoadonEntities = hoadonEntities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
