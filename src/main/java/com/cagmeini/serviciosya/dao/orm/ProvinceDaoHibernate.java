package com.cagmeini.serviciosya.dao.orm;

import java.util.List;

import com.cagmeini.serviciosya.beans.entity.ProvinceEntity;
import com.cagmeini.serviciosya.dao.IProvinceDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.apache.log4j.Logger;

import com.cagmeini.serviciosya.dao.DaoException;
import org.hibernate.Transaction;

public class ProvinceDaoHibernate implements IProvinceDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();

    private static final Logger logger= Logger.getLogger (ProvinceDaoHibernate.class);

    @Override
    public void create(ProvinceEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("Province object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Creating new province %s", target));
            session.save (target);
            tx.commit ();
            logger.debug (String.format ("New province %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new province %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update(ProvinceEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("Province object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Updating province %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("Province %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating province %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void delete(Integer id) {

        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id province is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting province by id %s", id.toString ()));
            ProvinceEntity p = (ProvinceEntity) session.get (ProvinceEntity.class, id);
            if (p != null) {

                session.delete (p);
                tx.commit ();
                logger.debug (String.format ("Province id %s deleted!", id.toString ()));
            } else {
                logger.warn (String.format ("Province by id %s not found!", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting province id %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public List<ProvinceEntity> findAll() {

        List<ProvinceEntity> list = null;

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug ("Finding all provinces");
            list = (List<ProvinceEntity>) session.createCriteria (ProvinceEntity.class).list ();

        } catch (Exception e) {

            logger.error ("Error finding all provinces id");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return list;
    }

    @Override
    public ProvinceEntity findById(Integer id) {

        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id province is null!");
            return null;
        }

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding province by id %s", id.toString ()));
            ProvinceEntity p = (ProvinceEntity) session.get (ProvinceEntity.class, id);
            if (p != null) {

                return p;
            } else {

                logger.warn (String.format ("Province by id %s not found!", id.toString ()));
                return null;
            }

        } catch (Exception e) {

            logger.error (String.format ("Error finding province id %s", id.toString ()));
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }
}
