package Command;

import command.AbstractCommand;
import org.example.core.dto.loaisanphamDTO;
import org.example.core.dto.sanphamDTO;

import java.util.List;

public class sanphamCommand extends AbstractCommand<sanphamDTO> {
    private List<sanphamDTO> sanphamDTOList;
    private String loaisanpham;
    private String nhacungcap;
    private double tongtien=0;
    List<sanphamDTO> sanphamnoibac;

    public String getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public List<sanphamDTO> getSanphamnoibac() {
        return sanphamnoibac;
    }

    public void setSanphamnoibac(List<sanphamDTO> sanphamnoibac) {
        this.sanphamnoibac = sanphamnoibac;
    }

    public sanphamCommand (){this.pojo=new sanphamDTO();}
    public List<sanphamDTO> getSanphamDTOList() {
        return sanphamDTOList;
    }
    public void setSanphamDTOList(List<sanphamDTO> sanphamDTOList) {
        this.sanphamDTOList = sanphamDTOList;
    }

    public String getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(String loaisanpham) {
        this.loaisanpham = loaisanpham;
    }
    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

}
