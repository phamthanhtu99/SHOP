package org.example.core.dto;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

public class loaisanphamDTO implements Serializable {
    private int id;
    private String tenSp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }
}
