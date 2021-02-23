package Command;

import command.AbstractCommand;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.core.dto.sanphamDTO;

import java.util.ArrayList;

public class giohangCommand extends AbstractCommand<sanphamDTO> {
    public giohangCommand(){
        this.pojo=new sanphamDTO();
    }
    private ArrayList<Long> longArrayList;
    private String command;
    private int quantity;/*số lượng*/
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<Long> getLongArrayList() {
        return longArrayList;
    }

    public void setLongArrayList(ArrayList<Long> longArrayList) {
        this.longArrayList = longArrayList;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
