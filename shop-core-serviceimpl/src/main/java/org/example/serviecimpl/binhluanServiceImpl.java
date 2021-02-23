package org.example.serviecimpl;

import org.example.core.dao.binhluanDao;
import org.example.core.daoimpl.binhluanDaoImpl;
import org.example.core.dto.binhluanDTO;
import org.example.core.dto.sanphamDTO;
import org.example.persistence.data.binhluanEntity;
import org.example.persistence.data.sanphamEntity;
import org.example.service.binhluanService;
import org.example.service.sanphamService;
import org.example.utisl.binhluanUtisl;
import org.example.utisl.sanphamBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class binhluanServiceImpl implements binhluanService {
    binhluanDao dao = new binhluanDaoImpl();
    public void BINHLUAN_DTO(binhluanDTO dto) {
        binhluanEntity entity =dao.save(binhluanUtisl.dtosangentyti(dto));
    }

    public List<binhluanDTO> BINHLUAN_DTO_LIST(sanphamDTO dto) {
        sanphamService service = new sanphamServiceImpl();
        dto  =service.timtheosanpham(dto.getId());
        sanphamEntity  sanphamEntity = new sanphamEntity();
        sanphamEntity=(sanphamBeanUtils.DtosangEuntity(dto));
        List<binhluanEntity> binhluanEntityList = dao.BINHLUAN_DAOS(sanphamEntity);
        List<binhluanDTO> binhluanDTOS=new ArrayList<binhluanDTO>();
        for (binhluanEntity entity: binhluanEntityList){
          binhluanDTO binhluanDTO = binhluanUtisl.entitysangdto(entity);
          binhluanDTOS.add(binhluanDTO);
        }
        return binhluanDTOS;
    }

    public void xoab(Integer id) {
        dao.detele(id);
    }
}
