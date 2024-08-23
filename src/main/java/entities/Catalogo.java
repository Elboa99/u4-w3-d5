package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {
    @Id
    @GeneratedValue
    private UUID codice_ISBN;

    private String titolo;
    private LocalDate annoPubblicazione;
    private int numPagine;

    // Getters and setters
    public UUID getCodice_ISBN() {
        return codice_ISBN;
    }

    public void setCodice_ISBN(UUID codice_ISBN) {
        this.codice_ISBN = codice_ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }
}
