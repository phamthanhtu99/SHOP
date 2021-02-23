package org.example.core.dto;

import javax.persistence.Column;
import java.io.Serializable;

public class phuongthucthanhtoanDTO  {
    private Integer id;
    private String tenphuongthuc;

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
