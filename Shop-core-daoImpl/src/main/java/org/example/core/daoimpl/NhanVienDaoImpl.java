package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.nhanvienDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.NhanVienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NhanVienDaoImpl extends AbstracDao<Integer, NhanVienEntity> implements nhanvienDao {
    public NhanVienEntity checklogin(String Email, String password) {
        NhanVienEntity  entity = new NhanVienEntity();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("FROM NhanVienEntity ue WHERE ue.email= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",Email);
            query.setParameter("password",password);
            entity = (NhanVienEntity) query.setMaxResults(1).uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return entity;

    }

    public NhanVienEntity savenhanvien(NhanVienEntity entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        }catch (HibernateException e ){
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        return entity;
    }
}
