package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Riviste extends Catalogo {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    // Getters e Setters
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    // Enumerazione per la periodicità
    public enum Periodicita {
        SETTIMANALE, MENSILE, ANNUALE
    }
}
