package com.cagmeini.serviciosya.dao.orm;

import com.cagmeini.serviciosya.beans.entity.ContractEntity;
import com.cagmeini.serviciosya.dao.DaoException;
import com.cagmeini.serviciosya.dao.IContractDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ContractDaoHibernate implements IContractDao {

    private static final Logger logger = Logger.getLogger (ContractDaoHibernate.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create (ContractEntity target) {

        // Validate argument
        if (target == null) {

            logger.warn ("Object contract is null.");
            return;
        }

        Session session = null;
        Transaction tx = null;

        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug(String.format ("Creating new contract %s", target));
            session.save(target);
            tx.commit();
            logger.debug(String.format ("New contract %s created", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new contract %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update (ContractEntity target) {

        // Validate argument.
        if (target == null) {

            logger.warn("Object contract is null");
            return;
        }

        Session session = null;
        Transaction tx = null;

        try {

            logger.debug("Getting Hibernate session...");
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();

            logger.debug(String.format("Updating a contract %s", target));
            session.update(target);
            tx.commit();
            logger.debug(String.format("Contract %s updated", target));

        } catch (Exception e) {

            logger.error ("Error updating a contract.");
            tx.rollback ();
            throw new DaoException (e.getMessage(), e);
        } finally {

            session.close();
        }

    }

    @Override
    public void delete(Integer id) {

        // Validate
        if (id == null) {

            logger.warn("Id contract is null.");
            return;
        }

        ContractEntity contract = null;
        Session session = null;
        Transaction tx = null;

        try {

            logger.debug ("Getting Hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting a contract %s", id.toString()));
            contract = (ContractEntity) session.get (ContractEntity.class, id);

            if (contract != null) {

                session.delete (contract);
                tx.commit ();
                logger.debug (String.format ("Contract %s deleted", id.toString ()));
            } else {

                logger.warn( String.format ("Contract by id %s not found", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format( "Error deleting a contract %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();

        }
    }

    @Override
    public List<ContractEntity> findAll() {
        return null;
    }

    @Override
    public ContractEntity findById(Integer id) {
        return null;
    }
}
