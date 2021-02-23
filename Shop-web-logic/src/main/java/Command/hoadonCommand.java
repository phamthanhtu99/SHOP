package Command;

import command.AbstractCommand;
import jdk.internal.dynalink.linker.LinkerServices;
import org.example.core.dto.hoadonDTO;

import java.util.List;

public class hoadonCommand extends AbstractCommand<hoadonDTO> {
    public hoadonCommand() {
        this.pojo = new hoadonDTO();
    }

    private List<hoadonDTO> hoadonDTOS;
    private List<hoadonDTO> hoadonchuaxacnhan;
    private List<hoadonDTO> all;
    private Integer phuongthucgiaohang;
    private Integer tenkhachhang;
    private String idhoadon;
    private String sanpham;
    private hoadonDTO hoadonDTO;
    private Integer Idnhanvien;
    private String ngaydau;
    private String ngaycuoi;
    private String thang;
    private String nam;


    private String idnv;

    public List<org.example.core.dto.hoadonDTO> getAll() {
        return all;
    }

    public void setAll(List<org.example.core.dto.hoadonDTO> all) {
        this.all = all;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getNgaydau() {
        return ngaydau;
    }

    public void setNgaydau(String ngaydau) {
        this.ngaydau = ngaydau;
    }

    public String getNgaycuoi() {
        return ngaycuoi;
    }

    public void setNgaycuoi(String ngaycuoi) {
        this.ngaycuoi = ngaycuoi;
    }

    public Integer getIdnhanvien() {
        return Idnhanvien;
    }

    public void setIdnhanvien(Integer idnhanvien) {
        Idnhanvien = idnhanvien;
    }

    public org.example.core.dto.hoadonDTO getHoadonDTO() {
        return hoadonDTO;
    }

    public void setHoadonDTO(org.example.core.dto.hoadonDTO hoadonDTO) {
        this.hoadonDTO = hoadonDTO;
    }

    public List<hoadonDTO> getHoadonchuaxacnhan() {
        return hoadonchuaxacnhan;
    }

    public void setHoadonchuaxacnhan(List<hoadonDTO> hoadonchuaxacnhan) {
        this.hoadonchuaxacnhan = hoadonchuaxacnhan;
    }

    public List<hoadonDTO> getHoadonDTOS() {
        return hoadonDTOS;
    }

    public void setHoadonDTOS(List<hoadonDTO> hoadonDTOS) {
        this.hoadonDTOS = hoadonDTOS;
    }

    public String getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(String idhoadon) {
        this.idhoadon = idhoadon;
    }

    public Integer getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(Integer tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public Integer getPhuongthucgiaohang() {
        return phuongthucgiaohang;
    }

    public void setPhuongthucgiaohang(Integer phuongthucgiaohang) {
        this.phuongthucgiaohang = phuongthucgiaohang;
    }
}
