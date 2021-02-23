package org.example.core.daoimpl;

import org.apache.commons.lang.StringUtils;
import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.sanphamDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.phieunhapEntity;
import org.example.persistence.data.sanphamEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class sanphamDaoImpl extends AbstracDao<String, sanphamEntity> implements sanphamDao {

    public Object[] FindByproprety1(Integer offset, Integer limit,String seach,String loaisanpham) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<sanphamEntity> list =new ArrayList<sanphamEntity>();
        Object totalItems =0;
        try {
            StringBuilder sql1= new StringBuilder("From ").append(getPresistenceClass());
            Query query1 = session.createQuery(sql1.toString());
            totalItems= query1.list().size();
            if (offset!=null && limit!=null && offset>=0 && limit >=0){
                StringBuilder sql =new StringBuilder("Select ue From sanphamEntity ue ,loaisanphamEntity lp ");
                sql.append(" where ue.loaisanpham = lp.id and lp.danhmuccon <> 12 ");
                if (StringUtils.isNotBlank(seach)) {
                    sql.append(" and ue.tensp LIKE '%"+seach+"%' ");
                }else if (StringUtils.isNotBlank(loaisanpham)){
                    sql.append(" and ue.loaisanpham LIKE '%"+loaisanpham+"%' ");
                }else {
                    sql.append(" order by rand() ");
                }

                Query query = session.createQuery(sql.toString());

                query.setFirstResult(offset);
                query.setMaxResults(limit);

                list= query.list();
            }

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }
        return new Object[]{totalItems,list};
    }

    public Object[] timkiemsanpham(Integer offset, Integer limit, String id, String ten) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<sanphamEntity> list =new ArrayList<sanphamEntity>();
        Object totalItems =0;
        try {
            StringBuilder sql1= new StringBuilder("From ").append(getPresistenceClass());
            Query query1 = session.createQuery(sql1.toString());
            totalItems= query1.list().size();
            if (offset!=null && limit!=null && offset>=0 && limit >=0){
                StringBuilder sql =new StringBuilder("Select ue From sanphamEntity ue ");
                if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(ten)) {
                    sql.append("where ue.id ='%"+id+"%' and ue.tensp LIKE '%"+ten+"%' ");
                }else {
                    if (StringUtils.isNotBlank(id)) {
                        sql.append("where ue.id ='"+id +"'");
                    } else if (StringUtils.isNotBlank(ten)) {
                        sql.append("where ue.tensp LIKE '%"+ten +"%' ");
                    }
                }
                Query query = session.createQuery(sql.toString());

                query.setFirstResult(offset);
                query.setMaxResults(limit);

                list= query.list();
            }

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }
        return new Object[]{totalItems,list};
    }

    public sanphamEntity theoID(String id) {
        sanphamEntity entity = new sanphamEntity();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
        StringBuilder sql = new StringBuilder(" from  sanphamEntity ue where eu.Id = '"+id+"'");
        entity = (sanphamEntity) session.get(sanphamEntity.class,id);

        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        return entity;
    }

    public boolean detele(String id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            sanphamEntity t = (sanphamEntity) session.get(sanphamEntity.class,id);
            session.delete(t);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        return true;
    }

    public List<sanphamEntity> Xe(int offset,int limit,String seach,String loaixe) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<sanphamEntity> list = new ArrayList<sanphamEntity>();
        try {
            StringBuilder sql = new StringBuilder("SElECT ue  FROM sanphamEntity ue,loaisanphamEntity lsp where ue.loaisanpham=lsp.id  ");
            sql.append(" and lsp.danhmuccon = '12'");
            if(seach!=null){
                sql.append(" and ue.tensp like '%"+seach+"%'");
            }
            if (loaixe!=null){
                sql.append(" and lsp = '"+loaixe+"'");
            }
            Query query = session.createQuery(sql.toString());
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            Object i =null;
            list=query.list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        return list;

    }


}
