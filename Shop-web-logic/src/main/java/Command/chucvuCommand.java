package Command;

import command.AbstractCommand;
import org.example.core.dto.chucvuDTO;

import java.util.List;

public class chucvuCommand extends AbstractCommand<chucvuDTO> {
    public chucvuCommand(){
       this.pojo= new  chucvuDTO() ;
    }
    private List<chucvuDTO>chucvuDTOS;

    public List<chucvuDTO> getChucvuDTOS() {
        return chucvuDTOS;
    }

    public void setChucvuDTOS(List<chucvuDTO> chucvuDTOS) {
        this.chucvuDTOS = chucvuDTOS;
    }
}
