package DAO;

import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UtentiDAO extends GenericDAO<Utente> {

    public UtentiDAO() {
        super(Utente.class);
    }

    public List<Utente> getUtentiByNome(String nome) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u WHERE u.nome LIKE :nome", Utente.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
