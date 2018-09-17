package com.cagmeini.serviciosya.dao.orm;

import com.cagmeini.serviciosya.beans.entity.ConsumerEntity;
import com.cagmeini.serviciosya.dao.DaoException;
import com.cagmeini.serviciosya.dao.IConsumerDao;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

public class ConsumerDaoHibernate implements IConsumerDao {

    private static final Logger logger = Logger.getLogger (ConsumerDaoHibernate.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(ConsumerEntity target) {

        // Validate the argument
        if (target == null) {
            logger.warn("Consumer object is null");
            return;
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<ConsumerEntity>> validationErrors = validator.validate(target);

        if (!validationErrors.isEmpty()) {

            for (ConstraintViolation<ConsumerEntity> error : validationErrors) {

                System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());
            }
        }

        Session session = null;
        Transaction tx = null;

        try {

            logger.debug("Getting Hibernate session");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug(String.format("Creating new consumer %s", target));
            session.save(target);
            tx.commit();
            logger.debug(String.format("New consumer %s created", target));

        } catch (Exception e) {

            logger.error(String.format("Error creating new consumer %s", target));
            tx.rollback();
            throw new DaoException(e.getMessage(), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update(ConsumerEntity target) {

        // Validate argument
        if (target == null) {

            logger.warn("Object consumer is null");
            return;
        }

        Session session = null;
        Transaction tx = null;

        try {

            logger.debug("Getting hibernate session...");
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();

            logger.debug(String.format("Updating consumer %s", target));
            session.update (target);
            tx.commit();
            logger.debug(String.format("Consumer %s updated", target));

        } catch (Exception e) {

            logger.error(String.format("Error updating consumer %s", target));
            tx.rollback();
            throw new DaoException(e.getMessage(), e);

        } finally {

            session.close();
        }
    }

    @Override
    public void delete(Integer id) {

        // Validate argument.
        if (id == null) {

            logger.warn("Id consumer is null");
            return;
        }

        Session session = null;
        Transaction tx = null;

        try {

            logger.debug ("Getting Hibernate session");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting consumer by id %s", id.toString ()));

            ConsumerEntity c = (ConsumerEntity) session.get(ConsumerEntity.class, id);

            if (c != null) {

                session.delete( c);
                tx.commit ();
                logger.debug (String.format ("Consumer by id %s deleted!", id.toString ()));
            } else {

                logger.warn (String.format("Consumer by id %s not found", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting consumer id %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public List<ConsumerEntity> findAll() {

        List<ConsumerEntity> list = null;

        Session session = null;

        try {

            logger.debug("Getting Hibernate session...");
            session = this.sessionFactory.openSession();

            logger.debug("Finding all consumers");
            list = (List<ConsumerEntity>) session.createCriteria (ConsumerEntity.class).list();


        } catch (Exception e) {

            logger.error("Error finding all consumers id");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close();
        }

        return list;
    }

    @Override
    public ConsumerEntity findById(Integer id) {

        // Validate argument.
        if (id == null) {

            logger.warn("Id consumer is null");
            return null;
        }

        Session session = null;

        try {

            logger.debug("Getting Hibernate session...");
            session = this.sessionFactory.openSession();

            logger.debug(String.format("Finding consumer by id %s", id.toString ()));
            ConsumerEntity c = (ConsumerEntity) session.get(ConsumerEntity.class, id);

            if (c != null) {

                return c;
            } else {

                logger.warn(String.format("Consumer by id %s not found", id.toString()));
                return null;
            }

        } catch (Exception e) {

            logger.error (String.format ("Consumer by id %s not found", id.toString ()));
            throw new DaoException (e.getMessage(), e);

        } finally {

            session.close();
        }
    }

    @Override
    public ConsumerEntity findByEmail(String email) {

        // Validate argument.
        if (isEmpty (email)) {

            logger.warn("Email argument is empty");
            return null;
        }

        ConsumerEntity consumer;
        Session session = null;

        try {

            logger.debug("Getting hibernate session...");
            session = this.sessionFactory.openSession();

            logger.debug(String.format("Finding consumer by email", email.toString()));
            Criteria criteria = session.createCriteria (ConsumerEntity.class);
            criteria.add(Restrictions.eq("email", email));

            consumer = (ConsumerEntity) criteria.uniqueResult();

        } catch (Exception e) {

            logger.error("Error finding a consumer by email ");
            throw new DaoException(e.getMessage(), e);
        } finally {

            session.close();
        }

        return consumer;
    }

    @Override
    public ConsumerEntity findByDNI(Integer dni) {
        // Validate argument.
        if (dni == null) {

            logger.warn("DNI consumer is null.");
            return null;
        }

        ConsumerEntity consumer;
        Session session = null;

        try {

            logger.debug("Getting hibernate session...");
            session = this.sessionFactory.openSession();

            logger.debug(String.format("Finding consumer by email", dni.toString()));
            Criteria criteria = session.createCriteria (ConsumerEntity.class);
            criteria.add(Restrictions.eq("dni", dni));

            consumer = (ConsumerEntity) criteria.uniqueResult();

        } catch (Exception e) {

            logger.error("Error finding a consumer by dni ");
            throw new DaoException(e.getMessage(), e);
        } finally {

            session.close();
        }

        return consumer;
    }

    @Override
    public ConsumerEntity findByPhone(String phone) {
        // Validate argument.
        if (isEmpty(phone)) {

            logger.warn("Phone argument is empty");
            return null;
        }

        ConsumerEntity consumer;
        Session session = null;

        try {

            logger.debug("Getting hibernate session...");
            session = this.sessionFactory.openSession();

            logger.debug(String.format("Finding consumer by phone", phone.toString()));
            Criteria criteria = session.createCriteria (ConsumerEntity.class);
            criteria.add(Restrictions.eq("phone", phone));

            consumer = (ConsumerEntity) criteria.uniqueResult();

        } catch (Exception e) {

            logger.error("Error finding a consumer by phone ");
            throw new DaoException(e.getMessage(), e);
        } finally {

            session.close();
        }

        return consumer;
    }
}
