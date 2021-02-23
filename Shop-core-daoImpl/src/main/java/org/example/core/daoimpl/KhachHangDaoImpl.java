package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.KhachHangDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.KhachHangEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class KhachHangDaoImpl extends AbstracDao<Integer , KhachHangEntity>  implements KhachHangDao {

    public KhachHangEntity CheckLoginKhachHang(String Email, String PassWord) {
        KhachHangEntity khachHangEntity = new KhachHangEntity();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql= new StringBuilder("FROM KhachHangEntity ue WHERE ue.Email= :name AND PassWord= :password");
            Query query =session.createQuery(sql.toString());
            query.setParameter("name",Email);
            query.setParameter("password",PassWord);
            khachHangEntity= (KhachHangEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;

        }finally {
            session.close();
        }
        return khachHangEntity;
    }

    public Boolean CheckEmial(String email) {
        KhachHangEntity khachHangEntity = new KhachHangEntity();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("From KhachHangEntity ue WHERE ue.Email= :name ");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",email);
            khachHangEntity = (KhachHangEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        if (khachHangEntity!=null){
            return true;
        }else
        return false;
    }

    public List<KhachHangEntity> viewskhach(String name,String sdt) {
        List<KhachHangEntity> list= new ArrayList<KhachHangEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql= new StringBuilder("FROM KhachHangEntity ue ");
            if (name!=null ||sdt!=null){
                sql.append(" Where ");
            }if (name!=null && sdt==null){
                sql.append(" ue.TenKhachhang LIKE '%"+name+"%' ");
            }
            if (sdt!=null && name==null){
                sql.append(" ue.SDT = '"+sdt+"' ");
            }if (sdt!=null && name!=null){
                sql.append(" ue.TenKhachhang LIKE '%"+name+"%' and ue.SDT = '"+sdt+"' ");
            }
            Query query =session.createQuery(sql.toString());
          /*  query.setString("SP",name);*/
            list=query.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;

        }finally {
            session.close();
        }
        return list;
    }


}
