package org.example.service;


import org.example.core.dto.sanphamDTO;
import java.util.List;

public interface sanphamService {
    List<sanphamDTO> viewsSp();
    Object[] timkiemsanpham(Integer offset, Integer limit,String id,String tensanpham);
    Object[] FindByproprety1(Integer offset, Integer limit,String seach,String loaisanpham);
    sanphamDTO timtheosanpham(String Id);
    void save(sanphamDTO dto);
    void update(sanphamDTO dto);
    boolean detele(String id);
    List<sanphamDTO> xe(int offset,int limit,String seach,String loaixe);
}
