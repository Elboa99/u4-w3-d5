package DAO;

import entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitiDAO extends GenericDAO<Prestito> {

    public PrestitiDAO() {
        super(Prestito.class);
    }

    public List<Prestito> getPrestitiByUtenteId(int utenteId) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.id = :utenteId", Prestito.class);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
