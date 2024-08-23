package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {
    @Id
    @GeneratedValue
    private UUID codice_ISBN;

    private String titolo;
    private Date annoPubblicazione;
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

    public Date getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Date annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }
}
