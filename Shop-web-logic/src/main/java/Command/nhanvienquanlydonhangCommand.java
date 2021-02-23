package Command;

import command.AbstractCommand;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.core.dto.nhanvienquanlyhoadonDTO;

import java.util.Date;

public class nhanvienquanlydonhangCommand  extends AbstractCommand<nhanvienquanlyhoadonDTO> {
    private String hoadon;
    private String thang;
    private String nam;
    private String ngaybatday;
    private String ngaycuoi;
    private String idnhanvien;
    private String sanpham;
    private String tinhtrang;

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public String getNgaybatday() {
        return ngaybatday;
    }

    public void setNgaybatday(String ngaybatday) {
        this.ngaybatday = ngaybatday;
    }

    public String getNgaycuoi() {
        return ngaycuoi;
    }

    public void setNgaycuoi(String ngaycuoi) {
        this.ngaycuoi = ngaycuoi;
    }

    public String getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public String getHoadon() {
        return hoadon;
    }

    public void setHoadon(String hoadon) {
        this.hoadon = hoadon;
    }
}
