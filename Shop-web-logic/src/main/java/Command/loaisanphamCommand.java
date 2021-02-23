package Command;

import command.AbstractCommand;
import org.example.core.dto.loaisanphamDTO;

import java.util.List;

public class    loaisanphamCommand extends AbstractCommand<loaisanphamDTO> {
private List<loaisanphamDTO> loaisanphamDTOList;

    public List<loaisanphamDTO> getLoaisanphamDTOList() {
        return loaisanphamDTOList;
    }

    public void setLoaisanphamDTOList(List<loaisanphamDTO> loaisanphamDTOList) {
        this.loaisanphamDTOList = loaisanphamDTOList;
    }
}
