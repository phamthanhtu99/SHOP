package Command;

import org.example.core.dto.nhanvienquanlyhoadonDTO;
import org.example.core.dto.sanphamDTO;
import org.example.service.nhanvienquanlyhoadonService;
import org.example.serviecimpl.nhanvienquanlyhoadonServiceImpl;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class thongkeCommon {
    private static nhanvienquanlyhoadonService nhanvienquanlyhoadonService = new nhanvienquanlyhoadonServiceImpl();

    public static List<Map<Object, Object>> danhthutheothang() {
        Map<Object, Object> map = null;
        List<Map<Object, Object>> maps = new ArrayList<Map<Object, Object>>();
        List<nhanvienquanlyhoadonDTO> nhanvienquanlyhoadonEntity = nhanvienquanlyhoadonService.danhthu(null, null, null, null, null);
        TreeMap<Integer, Double> list = new TreeMap<Integer, Double>();
        double tg = 0;
        for (int i = 1; i <= 12; i++) {
            for (nhanvienquanlyhoadonDTO dto : nhanvienquanlyhoadonEntity) {
                if (dto.getNgaygiao().getMonth() + 1 == i) { /*nhom theo thang*/
                    double ttien = 0;
                    if (list.containsKey(i)) {   /*ton tại */ /*kiêm tra đã tồn tại chưa*/
                        for (Map.Entry<Integer, Double> entry : list.entrySet()) {
                            if (entry.getKey() == i) {
                                ttien = dto.getHoadonDTO().getTongtien() + entry.getValue();
                                list.put(entry.getKey(), ttien); /*cập nhập giá trị của phần tử trong treemap*/
                            }
                        }
                    } else { /*không tồn tại*/
                        list.put(i, dto.getHoadonDTO().getTongtien()); /*thêm vào treemap*/
                    }
                } else {
                    if (dto.getNgaygiao().getMonth() +1 != i) {
                        continue; /*tiếp tục duyệt tiếp qua list*/
                    } else {
                        list.put(i, tg);
                    }

                }
            }
        }
        for (Map.Entry<Integer, Double> entry : list.entrySet()) { /*chuyển qua list để */
            map = new HashMap<Object, Object>();
            map.put("label", "tháng "+entry.getKey());
            map.put("y", entry.getValue());
            maps.add(map);
        }
        return maps;
    }

   /* public static List<Map<Object, Object>> danhthutheothang() {
        Map<Object, Object> map = null;
        List<Map<Object, Object>> maps = new ArrayList<Map<Object, Object>>();
        List<nhanvienquanlyhoadonDTO> nhanvienquanlyhoadonEntity = nhanvienquanlyhoadonService.danhthu(null, null, null, null, null);
        TreeMap<Integer, Double> list = new TreeMap<Integer, Double>();
        double tg = 0;
        for (int i = 1; i <= 12; i++) {
            for (nhanvienquanlyhoadonDTO dto : nhanvienquanlyhoadonEntity) {
                if (i != dto.getNgaygiao().getMonth() + 1) {
                    list.put(i, tg);
                } else {
                    if (list.containsKey(i)) {
                        double toen = 0;
                        for (Map.Entry<Integer, Double> entry : list.entrySet()) {
                            if (entry.getKey() == i) {
                                list.remove(i);
                                toen = dto.getHoadonDTO().getTongtien() + entry.getValue();
                                list.put(i, toen);
                                i++;
                            }

                        }
                    } else {
                        list.put(i, dto.getHoadonDTO().getTongtien());
                        continue;
                    }

                }
            }
        }
        for (Map.Entry<Integer, Double> entry : list.entrySet()) {
            map = new HashMap<Object, Object>();
            map.put("x", entry.getKey());
            map.put("y", entry.getValue());
            maps.add(map);
        }
        return maps;
    }*/
}
