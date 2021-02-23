package Command;

import command.AbstractCommand;
import org.example.core.dto.phieunhapDTO;

import java.util.List;

public class phieunhapCommand extends AbstractCommand<phieunhapDTO> {
    public phieunhapCommand (){
        this.pojo= new phieunhapDTO();
    }
    private List<phieunhapDTO>phieunhapDTOList;
    private int nhasanxuat;
    private String ngay;
    private String id;
    private double tongtien;
    private String idsp;
    private String idhoadon;
    private String ngaydau;
    private String ngaycuoi;

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
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

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public String getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(String idhoadon) {
        this.idhoadon = idhoadon;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public List<phieunhapDTO> getPhieunhapDTOList() {
        return phieunhapDTOList;
    }

    public void setPhieunhapDTOList(List<phieunhapDTO> phieunhapDTOList) {
        this.phieunhapDTOList = phieunhapDTOList;
    }

    public int getNhasanxuat() {
        return nhasanxuat;
    }

    public void setNhasanxuat(int nhasanxuat) {
        this.nhasanxuat = nhasanxuat;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
