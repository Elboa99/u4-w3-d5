import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.Set;

@Entity
public class Utente {

    @Id
    private int numeroTessera;
    private String nome;
    private String cognome;
    private Date dataDiNascita;

    @OneToMany(mappedBy = "utente")
    private Set<Prestito> prestiti;

    // Getters e Setters
    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(Set<Prestito> prestiti) {
        this.prestiti = prestiti;
    }
}

