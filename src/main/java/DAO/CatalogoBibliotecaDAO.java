package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.UUID;

public abstract class CatalogoBibliotecaDAO<T> {
    private static EntityManagerFactory emFactory;

    protected EntityManager getEntityManager() {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory("BibliotecaPU");
        }
        return emFactory.createEntityManager();
    }

    public void saveOrUpdate(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            UUID entityId = (UUID) getEntityId(entity); // Assicurati che questo metodo ritorni l'UUID corretto
            if (entityId == null || em.find(getEntityClass(), entityId) == null) {
                em.persist(entity);
            } else {
                em.merge(entity);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }


    public void removeEntityById(Object entityId) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(getEntityClass(), entityId);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public T findEntityById(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(getEntityClass(), id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    protected abstract Class<T> getEntityClass();

    protected abstract Object getEntityId(T entity);
}
