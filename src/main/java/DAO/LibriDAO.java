package DAO;

import entities.Libri;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class LibriDAO extends GenericDAO<Libri> {

    public LibriDAO() {
        super(Libri.class);
    }

    public List<Libri> getLibriByAutore(String autore) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.autore = :autore", Libri.class);
            query.setParameter("autore", autore);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Libri> getLibriByAnnoPubblicazione(LocalDate annoPubblicazione) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.annoPubblicazione = :annoPubblicazione", Libri.class);
            query.setParameter("annoPubblicazione", annoPubblicazione);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Libri> getLibriByTitolo(String titolo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.titolo LIKE :titolo", Libri.class);
            query.setParameter("titolo", "%" + titolo + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Libri findByISBN(UUID isbn) {
        return find(isbn);
    }

    public void removeByISBN(UUID isbn) {
        delete(isbn);
    }

    public void save(Libri libro) {
    }
}

