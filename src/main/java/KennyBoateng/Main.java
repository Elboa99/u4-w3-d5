package KennyBoateng;

import DAO.LibriDAO;
import entities.Libri;

import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        LibriDAO libriDAO = new LibriDAO();

        // Creazione di 15 libri
        for (int i = 1; i <= 15; i++) {
            Libri libro = new Libri();
            libro.setCodice_ISBN(UUID.randomUUID());
            libro.setTitolo("Libro " + i);
            libro.setAutore("Autore " + ((i % 5) + 1));
            libro.setGenere("Genere " + ((i % 3) + 1));
            libro.setAnnoPubblicazione(LocalDate.now().minusYears(i));
            libro.setNumPagine(100 + i * 10);
            libriDAO.save(libro);
        }
    }
}
