package org.example.serviecimpl;

import org.example.core.dao.hinhanhDao;
import org.example.core.dao.sanphamDao;
import org.example.core.daoimpl.hinhanhDaoImpl;
import org.example.core.daoimpl.sanphamDaoImpl;
import org.example.core.dto.hinhanhDTO;
import org.example.core.dto.sanphamDTO;
import org.example.persistence.data.hinhanhEntity;
import org.example.persistence.data.sanphamEntity;
import org.example.service.sanphamService;
import org.example.utisl.hinhanhBeanUtils;
import org.example.utisl.sanphamBeanUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class sanphamServiceImpl implements sanphamService {
    sanphamDao dao = new sanphamDaoImpl();
    hinhanhDao hinhanhDao = new hinhanhDaoImpl();
    public List<sanphamDTO> viewsSp() {
        List<sanphamEntity>sanphamEntities = dao.Finall();
        List<sanphamDTO> sanphamDTOList = new ArrayList<sanphamDTO>();
        for (sanphamEntity item : sanphamEntities){
            sanphamDTO dto = sanphamBeanUtils.entitysangdto(item);
            sanphamDTOList.add(dto);
        }
        return sanphamDTOList;
    }

    public Object[] timkiemsanpham(Integer offset, Integer limit,String id,String ten) {
        List<sanphamDTO>  list = new ArrayList<sanphamDTO>() ;
        Object [] objects = dao.timkiemsanpham(offset,limit,id,ten);
        for (sanphamEntity entity :(List<sanphamEntity>) objects[1]){
                sanphamDTO dto = sanphamBeanUtils.entitysangdto(entity);
                list.add(dto);
        }
        objects[1]=list;
        return objects;
    }

    public Object[] FindByproprety1(Integer offset, Integer limit, String seach, String loaisanpham) {
        List<sanphamDTO>  list = new ArrayList<sanphamDTO>() ;

        Object [] objects = dao.FindByproprety1(offset,limit,seach,loaisanpham);
        for (sanphamEntity entity :(List<sanphamEntity>) objects[1]){
            List<hinhanhDTO> dtos = new ArrayList<hinhanhDTO>();
            for (hinhanhEntity hinhanhEntity :entity.getHinhanhEntities()){
                hinhanhDTO hinhanhDTO=hinhanhBeanUtils.dtosangEnityt(hinhanhEntity);
                dtos.add(hinhanhDTO);
            }
            sanphamDTO dto = sanphamBeanUtils.entitysangdto(entity);
            dto.setHinhanhDTOS(dtos);
            list.add(dto);
        }
        objects[1]=list;

        return objects;
    }

    public sanphamDTO timtheosanpham(String Id) {
        hinhanhDao hinhanhDao = new hinhanhDaoImpl();
        sanphamEntity entity = dao.findByID(Id);
        List<hinhanhEntity> hinhanhEntities = hinhanhDao.hinhanhtheosanpham(entity.getId());
        List<hinhanhDTO> list = new ArrayList<hinhanhDTO>();
        for (hinhanhEntity entity1 : hinhanhEntities){
            hinhanhDTO hinhanhDTO = new hinhanhDTO();
            hinhanhDTO = hinhanhBeanUtils.dtosangEnityt(entity1);
            list.add(hinhanhDTO);
        }
        sanphamDTO dto = sanphamBeanUtils.entitysangdto(entity);
        dto.setHinhanhDTOS(list);
        return dto;
    }

    public void save(sanphamDTO dto) {
        sanphamEntity entity = sanphamBeanUtils.DtosangEuntity(dto);
        dao.save(entity);
    }

    public void update(sanphamDTO dto) {
        sanphamEntity entity = sanphamBeanUtils.DtosangEuntity(dto);
        dao.updata(entity);
    }

    public boolean detele(String id) {
        boolean bl=false;
        if(bl==dao.detele(id)){
            return false;
        }
        return true;
    }

    public List<sanphamDTO> xe(int offset, int limit,String seach,String loaixe) {

        List<sanphamEntity>sanphamEntities = dao.Xe(offset,limit,seach,loaixe);
        List<sanphamDTO> sanphamDTOList = new ArrayList<sanphamDTO>();
        List<hinhanhDTO> dtos = new ArrayList<hinhanhDTO>();
        for (sanphamEntity item : sanphamEntities){
            List<hinhanhEntity> hinhanhEntities = hinhanhDao.hinhanhtheosanpham(item.getId());
            sanphamDTO dto = sanphamBeanUtils.entitysangdto(item);
            dto.setHinhanhDTOS(timtheosanpham(item.getId()).getHinhanhDTOS());
            sanphamDTOList.add(dto);
        }
        return sanphamDTOList;
    }
}
