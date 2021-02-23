package Command;

import command.AbstractCommand;

import org.example.core.dto.binhluanDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class binhluanCommand  extends AbstractCommand<binhluanDTO> {
    private String Idsanpham;
    private Integer idkhachhang;
    private List<binhluanDTO> binhluanDTOS;

    public List<binhluanDTO> getBinhluanDTOS() {
        return binhluanDTOS;
    }

    public void setBinhluanDTOS(List<binhluanDTO> binhluanDTOS) {
        this.binhluanDTOS = binhluanDTOS;
    }

    public binhluanCommand(){
        this.pojo= new binhluanDTO();
    }

    public String getIdsanpham() {
        return Idsanpham;
    }

    public void setIdsanpham(String idsanpham) {
        Idsanpham = idsanpham;
    }

    public Integer getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(Integer idkhachhang) {
        this.idkhachhang = idkhachhang;
    }
}
