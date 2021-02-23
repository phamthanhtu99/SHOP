package Command;

import command.AbstractCommand;
import org.example.core.dto.nhanvienDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class nhanvienCommand extends AbstractCommand<nhanvienDTO> {
    public nhanvienCommand(){
        this.pojo=new nhanvienDTO();
    }
    private List<nhanvienDTO> nhanvienDTOS;
    private Integer chucvu;

    public Integer getChucvu() {
        return chucvu;
    }

    public void setChucvu(Integer chucvu) {
        this.chucvu = chucvu;
    }

    public List<nhanvienDTO> getNhanvienDTOS() {
        return nhanvienDTOS;
    }

    public void setNhanvienDTOS(List<nhanvienDTO> nhanvienDTOS) {
        this.nhanvienDTOS = nhanvienDTOS;
    }
}
