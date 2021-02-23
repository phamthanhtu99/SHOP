package common;

import Command.chitiethoadonCommand;
import Command.chitietphieunhaoCommand;
import org.example.service.hienthiSerice;
import org.example.serviecimpl.hienthisanphamSeriveImpl;

public class hienthisanphamCommon {
    private static hienthiSerice hienthiSerice = new hienthisanphamSeriveImpl();
    private static chitietphieunhaoCommand chitiethoadonCommand = new chitietphieunhaoCommand();

    public static chitietphieunhaoCommand xe(chitietphieunhaoCommand command) {/* hiển thị thông tin xe */
        chitiethoadonCommand.setListResult(hienthiSerice.xe(0, command.getLimit(), command.getSeach(), command.getCrudaction()));
        return chitiethoadonCommand;
    }

}
