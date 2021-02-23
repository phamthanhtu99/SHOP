package Command;

import command.AbstractCommand;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.core.dto.chitietphieunhapDTO;
import org.example.core.dto.orderdto;
import org.example.core.dto.phieunhapDTO;

import java.util.List;

public class chitietphieunhaoCommand extends AbstractCommand<chitietphieunhapDTO> {
    public chitietphieunhaoCommand() {
        this.pojo = new chitietphieunhapDTO();
    }

    private List<chitietphieunhapDTO> chitietphieunhapDTOS;
    private List<orderdto> orderdtos;

    public List<orderdto> getOrderdtos() {
        return orderdtos;
    }

    public void setOrderdtos(List<orderdto> orderdtos) {
        this.orderdtos = orderdtos;
    }

    private double tongtien1;
    private phieunhapDTO phieunhapDTO;

    public org.example.core.dto.phieunhapDTO getPhieunhapDTO() {
        return phieunhapDTO;
    }

    public void setPhieunhapDTO(org.example.core.dto.phieunhapDTO phieunhapDTO) {
        this.phieunhapDTO = phieunhapDTO;
    }

    public List<chitietphieunhapDTO> getChitietphieunhapDTOS() {
        return chitietphieunhapDTOS;
    }

    public void setChitietphieunhapDTOS(List<chitietphieunhapDTO> chitietphieunhapDTOS) {
        this.chitietphieunhapDTOS = chitietphieunhapDTOS;
    }

    public double getTongtien1() {
        return tongtien1;
    }

    public void setTongtien1(double tongtien) {
        this.tongtien1 = tongtien;
    }
}
