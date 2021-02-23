package org.example.core.dto;


import java.io.Serializable;

public class chucvuDTO  implements Serializable {
    private Integer Id;
    private String TenChucVu;

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
