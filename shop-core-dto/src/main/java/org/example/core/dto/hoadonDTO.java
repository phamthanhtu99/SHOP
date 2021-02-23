package org.example.core.dto;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class hoadonDTO {
    private String id;
    private String sdt;
    private Timestamp ngaymua;
    private double tongtien;
    private KhachHangDTO khachHangDTO;
    private phuongthucthanhtoanDTO phuongthucthanhtoanDTO;
    private tinhtrangDTO tinhtrangDTO;
    private String diachigiaohang;
    private List<chitiethoadonDTO> chitiethoadonDTOS;

    public List<chitiethoadonDTO> getChitiethoadonDTOS() {
        return chitiethoadonDTOS;
    }

    public void setChitiethoadonDTOS(List<chitiethoadonDTO> chitiethoadonDTOS) {
        this.chitiethoadonDTOS = chitiethoadonDTOS;
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Timestamp getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Timestamp ngaymua) {
        this.ngaymua = ngaymua;
    }

    public KhachHangDTO getKhachHangDTO() {
        return khachHangDTO;
    }

    public void setKhachHangDTO(KhachHangDTO khachHangDTO) {
        this.khachHangDTO = khachHangDTO;
    }

    public org.example.core.dto.phuongthucthanhtoanDTO getPhuongthucthanhtoanDTO() {
        return phuongthucthanhtoanDTO;
    }

    public void setPhuongthucthanhtoanDTO(org.example.core.dto.phuongthucthanhtoanDTO phuongthucthanhtoanDTO) {
        this.phuongthucthanhtoanDTO = phuongthucthanhtoanDTO;
    }

    public org.example.core.dto.tinhtrangDTO getTinhtrangDTO() {
        return tinhtrangDTO;
    }

    public void setTinhtrangDTO(org.example.core.dto.tinhtrangDTO tinhtrangDTO) {
        this.tinhtrangDTO = tinhtrangDTO;
    }
}
