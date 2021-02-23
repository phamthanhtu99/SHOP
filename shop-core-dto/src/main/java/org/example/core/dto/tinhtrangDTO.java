package org.example.core.dto;


import java.io.Serializable;

public class tinhtrangDTO implements Serializable {
    private Integer id;
    private String tinhtrang;

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
