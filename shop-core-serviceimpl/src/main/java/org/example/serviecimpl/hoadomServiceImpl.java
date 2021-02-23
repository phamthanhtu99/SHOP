package org.example.serviecimpl;

import org.example.core.dao.hoadonDao;
import org.example.core.daoimpl.hoadonDaoImpl;
import org.example.core.dto.KhachHangDTO;
import org.example.core.dto.chitiethoadonDTO;
import org.example.core.dto.hoadonDTO;
import org.example.core.dto.sanphamDTO;
import org.example.persistence.data.chitiethoadonEntity;
import org.example.persistence.data.hoadonEntity;
import org.example.service.hoadonService;
import org.example.utisl.chitiethoadonBeanUtisl;
import org.example.utisl.hoadonBeanUtlis;
import org.example.utisl.khachHangBeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class hoadomServiceImpl implements hoadonService {
    hoadonDao hoadonDao = new hoadonDaoImpl();
    hoadonEntity hoadonEntity = new hoadonEntity();
    public hoadonDTO save(hoadonDTO hoadonDTO) {
        hoadonEntity = hoadonDao.save(hoadonBeanUtlis.dtosangEnityt(hoadonDTO));
        hoadonDTO= hoadonBeanUtlis.EntitysangDTO(hoadonEntity);
        return hoadonDTO;
    }

    public List<hoadonDTO> HOADON_DTOS(KhachHangDTO dto) {
        List<hoadonEntity> hoadonEntities =hoadonDao.HOADON_khachang(khachHangBeanUtils.dtosangentity(dto));
        List<hoadonDTO> hoadonDTOS = new ArrayList<hoadonDTO>();
        for (hoadonEntity entity :hoadonEntities){
            hoadonDTO hoadonDTO= new hoadonDTO();
            hoadonDTO =hoadonBeanUtlis.EntitysangDTO(entity);
            hoadonDTOS.add(hoadonDTO);
        }
        return hoadonDTOS;
    }

    public hoadonDTO update(hoadonDTO hoadonDTO) {
        hoadonEntity = hoadonDao.updata(hoadonBeanUtlis.dtosangEnityt(hoadonDTO));
        hoadonDTO=hoadonBeanUtlis.EntitysangDTO(hoadonEntity);
        return hoadonDTO;
    }

    public hoadonDTO viewsID(hoadonDTO hoadonDTO) {
        hoadonEntity =hoadonDao.findByID(hoadonDTO.getId());
        hoadonDTO = hoadonBeanUtlis.EntitysangDTO(hoadonEntity);
        List<chitiethoadonDTO> dtos = new ArrayList<chitiethoadonDTO>();
        for (chitiethoadonEntity entity : hoadonEntity.getChitiethoadonEntities()){
            chitiethoadonDTO dto = new chitiethoadonDTO();
            dto=chitiethoadonBeanUtisl.entitysangDTo(entity);
            dtos.add(dto);
        }
        hoadonDTO.setChitiethoadonDTOS(dtos);
        return hoadonDTO;
    }

    public List<hoadonDTO> viewstatall() {
        List<hoadonEntity> hoadonEntities =hoadonDao.hoadon();
        List<hoadonDTO> hoadonDTOS = new ArrayList<hoadonDTO>();
        for (hoadonEntity entity :hoadonEntities){
            hoadonDTO hoadonDTO= new hoadonDTO();
            hoadonDTO =hoadonBeanUtlis.EntitysangDTO(entity);
            hoadonDTOS.add(hoadonDTO);
        }
        return hoadonDTOS;
    }

    public List<hoadonDTO> viewsgiaohang() {
        List<hoadonEntity> hoadonEntities =hoadonDao.giaohang();
        List<hoadonDTO> hoadonDTOS = new ArrayList<hoadonDTO>();
        for (hoadonEntity entity :hoadonEntities){
            hoadonDTO hoadonDTO= new hoadonDTO();
            hoadonDTO =hoadonBeanUtlis.EntitysangDTO(entity);
            hoadonDTOS.add(hoadonDTO);
        }
        return hoadonDTOS;
    }



    public List<hoadonDTO> viewsall() {
        List<hoadonEntity> hoadonEntities =hoadonDao.Finall();
        List<hoadonDTO> hoadonDTOS = new ArrayList<hoadonDTO>();
        for (hoadonEntity entity :hoadonEntities){
            hoadonDTO hoadonDTO= new hoadonDTO();
            hoadonDTO =hoadonBeanUtlis.EntitysangDTO(entity);
            hoadonDTOS.add(hoadonDTO);
        }
        return hoadonDTOS;
    }

    public  TreeMap<sanphamDTO, Double> thongke() {
        List<hoadonEntity> hoadonEntities =hoadonDao.thongke();
        List<hoadonDTO> hoadonDTOS = new ArrayList<hoadonDTO>();

        TreeMap<sanphamDTO, Double> map = new TreeMap<sanphamDTO, Double>();
        for (hoadonEntity entity :hoadonEntities){
            hoadonDTO hoadonDTO= new hoadonDTO();
            hoadonDTO =hoadonBeanUtlis.EntitysangDTO(entity);
            for (chitiethoadonEntity entity1 :entity.getChitiethoadonEntities()){
                chitiethoadonDTO chitiethoadonDTO = new chitiethoadonDTO();
                chitiethoadonDTO = chitiethoadonBeanUtisl.entitysangDTo(entity1);
                if (map.containsKey(chitiethoadonDTO.getSanphamDTO())){
                    double tien=0;
                   for (Map.Entry<sanphamDTO,Double> entry: map.entrySet()){
                       if (entry.getKey().getId() ==chitiethoadonDTO.getSanphamDTO().getId()){
                           tien= entry.getValue()+chitiethoadonDTO.getGiatien();
                           map.remove(entry.getKey());
                           map.put(chitiethoadonDTO.getSanphamDTO(),tien);break;
                       }

                   }
                }else {
                    map.put(chitiethoadonDTO.getSanphamDTO(),chitiethoadonDTO.getGiatien());
                }
            }
            hoadonDTOS.add(hoadonDTO);
        }
        return map;
    }

    public List<hoadonDTO> hdchuaxacnhan(KhachHangDTO dto) {
        List<hoadonEntity> hoadonEntities =hoadonDao.dhchuaxacnhan(khachHangBeanUtils.dtosangentity(dto));
        List<hoadonDTO> hoadonDTOS = new ArrayList<hoadonDTO>();

        for (hoadonEntity entity :hoadonEntities){
            hoadonDTO hoadonDTO= new hoadonDTO();
            hoadonDTO =hoadonBeanUtlis.EntitysangDTO(entity);

            List<chitiethoadonDTO> chitiethoadonDTOS = new ArrayList<chitiethoadonDTO>();
            for (chitiethoadonEntity chitiethoadonEntity : entity.getChitiethoadonEntities()){
                chitiethoadonDTO dto1 = new chitiethoadonDTO();
                dto1 =  chitiethoadonBeanUtisl.entitysangDTo(chitiethoadonEntity);
                chitiethoadonDTOS.add(dto1);
            }
            hoadonDTO.setChitiethoadonDTOS(chitiethoadonDTOS);
            hoadonDTOS.add(hoadonDTO);
        }
        return hoadonDTOS;
    }

    public List<hoadonDTO> lichsuhdvadahuy(KhachHangDTO dto, String tinhtrang) {
        List<hoadonEntity> hoadonEntities = hoadonDao.lichsuda1(khachHangBeanUtils.dtosangentity(dto),tinhtrang);
        List<hoadonDTO> hoadonDTOS = new ArrayList<hoadonDTO>();
        for (hoadonEntity entity : hoadonEntities){
            hoadonDTO hoadonDTO= new hoadonDTO();
            hoadonDTO= hoadonBeanUtlis.EntitysangDTO(entity);
            hoadonDTOS.add(hoadonDTO);
        }
        return hoadonDTOS;
    }
}
