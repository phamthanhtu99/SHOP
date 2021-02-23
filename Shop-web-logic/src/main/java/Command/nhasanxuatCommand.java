package Command;

import command.AbstractCommand;
import org.example.core.dto.nhasanxuatDTO;

import java.util.List;

public class nhasanxuatCommand extends AbstractCommand<nhasanxuatDTO> {
    private List<nhasanxuatDTO> nhasanxuatDTOS ;

    public List<nhasanxuatDTO> getNhasanxuatDTOS() {
        return nhasanxuatDTOS;
    }

    public void setNhasanxuatDTOS(List<nhasanxuatDTO> nhasanxuatDTOS) {
        this.nhasanxuatDTOS = nhasanxuatDTOS;
    }
}
