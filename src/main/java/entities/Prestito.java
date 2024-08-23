package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Prestito {
    @Id
    @GeneratedValue
    private UUID idPrestito;

    @ManyToOne
    @JoinColumn(name = "utente_id", referencedColumnName = "numeroTessera")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_prestato", referencedColumnName = "codice_ISBN")
    private Catalogo catalogo;

    private Date dataInizioPrestito;
    private Date dataRestituzionePrevista;
    private Date dataRestituzioneEffettiva;

    // Getters and setters
    public UUID getIdPrestito() {
        return idPrestito;
    }

    public void setIdPrestito(UUID idPrestito) {
        this.idPrestito = idPrestito;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}
