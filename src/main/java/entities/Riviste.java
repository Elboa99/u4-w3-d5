package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Riviste extends Catalogo {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public enum Periodicita {
        SETTIMANALE, MENSILE, ANNUALE
    }
}
