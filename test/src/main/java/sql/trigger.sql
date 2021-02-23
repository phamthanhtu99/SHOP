use  shopbanhang;
DELIMITER $$
CREATE TRIGGER insert_nhapsp
    AFTER INSERT
    ON chitietphieunhap FOR EACH ROW

BEGIN

    declare slton int  DEFAULT 0;
    declare slNHAP int  DEFAULT 0;
    SELECT NEW.soluong INTO slNHAP FROM  sanpham WHERE sanpham.Id=NEW.sanpham;
    select sanpham.soluong into slton from sanpham where sanpham.Id=new.sanpham;
    if(slton > 0)Then
        update sanpham set soluong =(slton+slNHAP) where sanpham.Id=new.sanpham;
    else
        update sanpham set soluong=slNHAP where sanpham.Id=new.sanpham;
    end if;

END;
DELIMITER ;
DELIMITER ;
/*update nhâp*/
DELIMITER $$
CREATE TRIGGER update_nhapsp
    AFTER update
    ON chitietphieunhap FOR EACH ROW

BEGIN

    declare slton int  DEFAULT 0;
    declare sldau int  DEFAULT 0;

    select sanpham.soluong into slton from sanpham where sanpham.Id=new.sanpham;

    SELECT  OLD.soluong INTO sldau FROM chitietphieunhap  WHERE  chitietphieunhap.chitietphieunhapcol=new.chitietphieunhapcol;
    if(sldau!=new.soluong)Then
        update sanpham set soluong=(slton+new.soluong-sldau) where sanpham.Id=new.sanpham;

    end if ;

END;
DELIMITER ;
DELIMITER $$
CREATE TRIGGER insert_nhapsp
    AFTER INSERT
    ON chi FOR EACH ROW

BEGIN

    declare slton int  DEFAULT 0;
    declare slNHAP int  DEFAULT 0;
    SELECT NEW.soluong INTO slNHAP FROM  sanpham WHERE sanpham.Id=NEW.sanpham;
    select sanpham.soluong into slton from sanpham where sanpham.Id=new.sanpham;
    if(slton > 0)Then
        update sanpham set soluong =(slton+slNHAP) where sanpham.Id=new.sanpham;
    else
        update sanpham set soluong=slNHAP where sanpham.Id=new.sanpham;
    end if;

END;
DELIMITER ;