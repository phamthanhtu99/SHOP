package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.chitetphieunhapDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.persistence.data.phieunhapEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class chitietphieunhapImpl extends AbstracDao<String, chitietphieunhapEntity> implements chitetphieunhapDao {

    public List<chitietphieunhapEntity> CHITIETPHIEUNHAP_phieunhap(phieunhapEntity entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<chitietphieunhapEntity> chitietphieunhapEntities = new ArrayList<chitietphieunhapEntity>();
        try {
           StringBuilder sql= new StringBuilder("from chitietphieunhapEntity ue ");
           sql.append(" where ue.phieunhapEntity = :id");
            Query query=session.createQuery(sql.toString());
            query.setString("id",entity.getId());
            chitietphieunhapEntities =query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return chitietphieunhapEntities;
    }
}
