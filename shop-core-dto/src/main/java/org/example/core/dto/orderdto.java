package org.example.core.dto;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class orderdto {
    public TreeMap<sanphamDTO, Integer> list;
    public double giaotien;
    public List<orderdto> orderdtos;

    public orderdto() {
        list = new TreeMap<sanphamDTO, Integer>();
    }

    public TreeMap<sanphamDTO, Integer> getList() {
        return list;
    }

    public double getGiaotien() {
        return giaotien;
    }

    public void setGiaotien(double giaotien) {
        this.giaotien = giaotien;
    }

    public void setList(TreeMap<sanphamDTO, Integer> list) {
        this.list = list;
    }

    public void insert(sanphamDTO dto, int slo) {
        boolean bl = list.containsKey(dto);
        if (bl) {
            if (slo > 1) {
                int sl = list.get(dto);
                if (dto.getSoluong() >= slo) {
                    list.put(dto, slo);
                } else {
                    sl = sl + 1;
                    if (sl >= dto.getSoluong()) { /*kiểm tra số lượng có vượt quá trong databse không*/
                        list.put(dto, dto.getSoluong());
                    } else {
                        list.put(dto, sl);
                    }
                }
            } else {
                int sl = list.get(dto);
                slo += sl+1;
                if (dto.getSoluong() >= slo) {
                    list.put(dto, slo);
                }
            }
        } else {
            if (dto.getSoluong() >= slo) {
                list.put(dto, slo);
            } else {
                list.put(dto, 1);
            }
        }
    }

    public void phieunhap(sanphamDTO dto, int slo) {
        boolean bl = list.containsKey(dto);
        if (bl) {
            list.put(dto, slo);
        }else {
            list.put(dto, slo);
        }
    }

    public void thongke(sanphamDTO dto, Integer slo) {
        boolean bl = list.containsKey(dto);
        if (bl) {
            if (slo > 1) {
                list.remove(dto);
                list.put(dto, slo);
            } else {
                int sl = list.get(dto);
                slo += sl;
                list.put(dto, slo);
            }
        } else {
            list.put(dto, slo);
        }
    }

    public void detele(sanphamDTO dto, int slo) {
        boolean bl = list.containsKey(dto);
        int sluong = list.get(dto);
        sluong = sluong - 1;
        if (bl) {
            if (sluong > 0) {
                list.remove(dto);
                list.put(dto, sluong);
            } else {
                list.remove(dto);
            }
        }
    }

    public void deteleSP(sanphamDTO dto) {

        list.remove(dto);

    }
}
