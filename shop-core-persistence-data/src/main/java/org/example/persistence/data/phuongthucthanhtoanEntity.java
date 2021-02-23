package org.example.persistence.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phuongthucthanhtoan")
public class phuongthucthanhtoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="tenphuongthuc")
    private String tenphuongthuc;
    @OneToMany(mappedBy = "phuongthucthanhtoanEntity",fetch = FetchType.LAZY)
    private List<hoadonEntity>hoadonEntities;

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

    public String getTenphuongthuc() {
        return tenphuongthuc;
    }

    public void setTenphuongthuc(String tenphuongthuc) {
        this.tenphuongthuc = tenphuongthuc;
    }
}
