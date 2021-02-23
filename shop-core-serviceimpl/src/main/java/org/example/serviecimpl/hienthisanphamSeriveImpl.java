package org.example.serviecimpl;

import org.example.core.dao.hienthisanpham;
import org.example.core.daoimpl.hienthisanphamImpl;
import org.example.core.dto.chitietphieunhapDTO;
import org.example.core.dto.hinhanhDTO;
import org.example.core.dto.sanphamDTO;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.persistence.data.hinhanhEntity;
import org.example.service.hienthiSerice;
import org.example.service.sanphamService;
import org.example.utisl.chitietphieunhapBeaUtils;
import org.example.utisl.hinhanhBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class hienthisanphamSeriveImpl  implements hienthiSerice {
    private hienthisanpham hienthisanpham =new hienthisanphamImpl();
    private sanphamService sanphamService = new sanphamServiceImpl();
    public List<chitietphieunhapDTO> xe(int offset, int limit, String seach, String loaixe) {
        List<chitietphieunhapEntity> xe = hienthisanpham.Xe(offset,limit,seach,loaixe);
        List<chitietphieunhapDTO>  list = new ArrayList<chitietphieunhapDTO>();
        sanphamDTO sanphamDTO = new sanphamDTO();
        for (chitietphieunhapEntity item : xe){
            List<hinhanhDTO> hinhanh= new ArrayList<hinhanhDTO>();
            chitietphieunhapDTO  dto= new chitietphieunhapDTO();
            dto= chitietphieunhapBeaUtils.Entitysangdto(item);
            for (hinhanhEntity entity : item.getSanphamEntity().getHinhanhEntities()){
                hinhanhDTO hinhanhDTO = new hinhanhDTO();
                hinhanhDTO= hinhanhBeanUtils.dtosangEnityt(entity);
                hinhanh.add(hinhanhDTO);
            }
            dto.getSanphamDTO().setHinhanhDTOS(hinhanh);
            list.add(dto);

        }
        return list;
    }
}
