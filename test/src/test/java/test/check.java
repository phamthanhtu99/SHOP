package test;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;
import common.nhanvienquanlydonhang;
import common.nhavienCommon;
import org.apache.commons.fileupload.FileItemHeaders;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.core.dao.*;
import org.example.core.daoimpl.*;
import org.example.core.dto.*;
import org.example.persistence.data.*;

import org.example.service.hoadonService;
import org.example.service.nhanvienquanlyhoadonService;
import org.example.service.sanphamService;
import org.example.serviecimpl.hoadomServiceImpl;
import org.example.serviecimpl.nhanvienquanlyhoadonServiceImpl;
import org.example.serviecimpl.sanphamServiceImpl;
import org.example.utisl.khachHangBeanUtils;
import org.example.utisl.nhacungcapBeanUtisl;
import org.example.utisl.nhasanxuatBeanUtisl;
import org.example.utisl.phieunhapBeanUtils;
import org.testng.annotations.Test;
import sun.util.calendar.BaseCalendar;


import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Table;
import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.DataFormatException;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;
import com.restfb.types.User;

public class check {

       @Test
       public  void fianlá1(){
            String acc ="EAAl8J7c5LJYBAK3CJsTndItbq0tpVOYgr864FyNnj1BbZCWBysBgyydCka6xulH92P6MPH4bZAuDMd4jOCzCobfE6ZCEWafnaJVOt0P1EIniAZAZCfrwOAVdQ5K81vjmErVqZBH0YyD7Fl6zZBhZBb6krdLfYuBfHDgz7m2cWwhukB4BlvZAlSuQa43bepTwQE6HKGBo2AAjto6ZA5umErIocm8taoZB0v9zVABW2pRz1nUfQZDZD";
            FacebookClient client = new DefaultFacebookClient(acc);
            User me = client.fetchObject("me",User.class);
           System.out.println(me.getName());
           System.out.println(me.getLanguages());
       }

    @Test
    public void checklogin() {
        KhachHangDao dao = new KhachHangDaoImpl();
        KhachHangEntity entity = new KhachHangEntity();
        KhachHangDTO hangDTO = new KhachHangDTO();
        hangDTO.setEmail("hjnknk@gmail.com");
        hangDTO.setTenKhachhang("thanhtu");
        hangDTO.setSdt("0333692447");
        hangDTO.setPassWord("1234");

        KhachHangEntity entity1 = dao.save(khachHangBeanUtils.dtosangentity(hangDTO));

    }

    @Test
    public void fianl() {
        sanphamDao dao = new sanphamDaoImpl();
        sanphamEntity entity = new sanphamEntity();
        entity.setId("9");
        entity.setTensp("sdsdsd");
        entity.setHinhanh("sdsds");
        entity.setGiatien(123);
        nhacungcapEntity entity1 = new nhacungcapEntity();
        entity1.setId(1);
        entity.setNhacungcapEntity(entity1);
        loaisanphamEntity loaisanphamEntity = new loaisanphamEntity();
        loaisanphamEntity.setId(1);
        entity.setLoaisanpham(loaisanphamEntity);
        sanphamEntity entities = dao.save(entity);

    }

    @Test
    public void fianl1() {
        phieunhapEntity phieunhapEntity = new phieunhapEntity();
        phieunhapEntity.setId("1593517295340");
        chitetphieunhapDao chitetphieunhapDao = new chitietphieunhapImpl();
        List<chitietphieunhapEntity> chitietphieunhapEntities = chitetphieunhapDao.CHITIETPHIEUNHAP_phieunhap(phieunhapEntity);
    }

    @Test
    public void fi1anl1() {
        binhluanDao binhluanDao = new binhluanDaoImpl();
        sanphamEntity entity = new sanphamEntity();
        entity.setId("BT01");
        List<binhluanEntity> list = binhluanDao.BINHLUAN_DAOS(entity);
        System.out.println(list.size());
    }

    @Test
    public void fi1anl2() {
        binhluanDao binhluanDao = new binhluanDaoImpl();
        binhluanEntity entity = new binhluanEntity();
        sanphamEntity sanphamEntity = new sanphamEntity();
        sanphamDao sanphamDao = new sanphamDaoImpl();
        sanphamEntity = sanphamDao.theoID("BT01");
        entity.setSanphamEntity(sanphamEntity);
        List<binhluanEntity> list = binhluanDao.BINHLUAN_DAOS1(entity);
        System.out.println(list.size());
    }

    @Test
    public void testmodelmaper() {
        chitetphieunhapDao chitetphieunhapDao = new chitietphieunhapImpl();
        sanphamEntity entity = new sanphamEntity();
        entity.setId("BT01");
        phieunhapEntity phieunhapEntity = new phieunhapEntity();
        phieunhapEntity.setId("BB01");
        chitietphieunhapEntity entity1 = new chitietphieunhapEntity();
        entity1.setPhieunhapEntity(phieunhapEntity);
        entity1.setSanphamEntity(entity);
        entity1.setSoluong(100);
        entity1.setThanhtien(1000);
        entity1 = chitetphieunhapDao.save(entity1);

    }

    @Test
    public void sdsd() {
        Date date = new Date();
        nhasanxuatDTO nhasanxuatDTO = new nhasanxuatDTO();
        nhasanxuatDTO.setId(1);
        phieunhapEntity phieunhapEntity = new phieunhapEntity();
        phieunhapDTO phieunhapDTO = new phieunhapDTO();
        phieunhapDTO.setId("1");
        phieunhapDTO.setNhasanxuatEntity(nhasanxuatDTO);
        phieunhapEntity = phieunhapBeanUtils.dtosangEntity(phieunhapDTO);
    }

    @Test
    public void sd() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date parse = sdf.parse("30/010/2012");
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        System.out.println(c.get(Calendar.MONTH) + 1 + "," + c.get(Calendar.DATE) + "," + c.get(Calendar.YEAR));

   /* hoadonService service = new hoadomServiceImpl();
    TreeMap<sanphamDTO,Double> map= service.thongke();
        for (Map.Entry<sanphamDTO,Double> entry : map.entrySet()){
            entry.getKey().
        }*/

    }

    @Test
    public void s1d() throws ParseException {

        nhanvienquanlyhoadonService dao = new nhanvienquanlyhoadonServiceImpl();
        List<nhanvienquanlyhoadonDTO> nhanvienquanlyhoadonEntity = dao.views(null, null, null, null);
        TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();
        double tg=0;
        for (int i = 1; i <= 12; i++) {
            for (nhanvienquanlyhoadonDTO dto : nhanvienquanlyhoadonEntity) {
                    if (i!= dto.getNgaygiao().getMonth()+1){
                        map.put(i,tg);break;
                    }else {
                        if (map.containsKey(i)){
                            double toen=0 ;
                            for(Map.Entry<Integer,Double> entry : map.entrySet() ){
                                if (entry.getKey()==i){
                                    map.remove(i);
                                    toen=dto.getHoadonDTO().getTongtien()+entry.getValue();
                                    map.put(i,toen);
                                    i++;
                                }

                            }
                        }else {
                            map.put(i,dto.getHoadonDTO().getTongtien());
                        }

                    }
            }
        }
        System.out.println("sdsd");
    }

    @Test
    public void report() throws ParseException, IOException {
        /*   *//* nhanvienDao dao = new NhanVienDaoImpl();
        List<NhanVienEntity> list= dao.Finall();*//*
        String url="danhthuController.xls";

        FileInputStream fis= new FileInputStream("C:\\Users\\ADMIN\\Desktop\\shop\\test\\src\\test\\java\\test\\danhthuController.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case NUMERIC:
                        System.out.println( cell.getNumericCellValue());
                        break;
                    case STRING:
                        System.out.println( cell.getStringCellValue());
                        break;
                }

        }}
    }
    */
        System.out.println("Create file excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Customer_Info");
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("List of Customer");
        nhanvienDao dao = new NhanVienDaoImpl();
        List<NhanVienEntity> list = dao.Finall();
        for (NhanVienEntity customer : list) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(customer.getId());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(customer.getTenNhanVien());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(customer.getEmail());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\shop\\test\\src\\test\\java\\test\\danhthuController.xlsx");
            workbook.write(outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
        @Test
    public void testrestfb(){
            FacebookClient facebookClient= new DefaultFacebookClient(Constants.MY_ACCESS_TOKEN);
            JsonObject jsonObject = facebookClient.fetchObject("me",JsonObject.class, Parameter.with("fields","name,id"));
            System.out.println(jsonObject.getString("name"));
        }
}

