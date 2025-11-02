package com.example.kursinis.hibernateControl;

import com.example.kursinis.model.User;
import com.example.kursinis.fxControllers.FxUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class GenericHibernate {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public GenericHibernate(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public <T> void create(T entity) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            FxUtils.generateDialogAlert(Alert.AlertType.ERROR, "During CREATE", e);
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }

    public <T> void update(T entity) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            FxUtils.generateDialogAlert(Alert.AlertType.ERROR, "During UPDATE", e);
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }

    public <T> void delete(Class<T> entityClass, int id) {
        try
        {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            T entity = entityManager.find(entityClass, id);
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e)
        {
            FxUtils.generateDialogAlert(Alert.AlertType.ERROR, "During DELETE", e);
        } finally
        {
            if (entityManager != null)
                entityManager.close();
        }
    }

    public <T> T getEntityById(Class<T> entityClass, int id) {
        T entity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entity = entityManager.find(entityClass, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            FxUtils.generateDialogAlert(Alert.AlertType.ERROR, "During READ", e);
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return entity;
    }

    public <T> List<T> getAllRecords(Class<T> entityClass) {
        List<T> list = new ArrayList<>();
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(entityClass));
            Query q = entityManager.createQuery(query);
            list = q.getResultList();
        } catch (Exception e) {
            FxUtils.generateDialogAlert(Alert.AlertType.ERROR, "During READ", e);
        }
        return list;
    }
}
