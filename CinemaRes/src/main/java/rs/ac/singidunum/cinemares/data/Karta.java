package rs.ac.singidunum.cinemares.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "karta")
public class Karta implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKarta")
    private Integer idKarta;
    
    @NotNull
    @Column(name = "cena")
    private String cena;
    
    @JoinColumn(name = "fk_Korisnik", referencedColumnName = "idKorisnik")
    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik fk_Korisnik;
    
    @JoinColumn(name = "fk_Projekcija", referencedColumnName = "idProjekcija")
    @ManyToOne
    private Projekcija fk_Projekcija;

    public Karta() {
    }

    public Karta(Integer idKarta) {
        this.idKarta = idKarta;
    }

    public Karta(Integer idKarta, String cena, Korisnik fk_Korisnik, Projekcija fk_Projekcija) {
        this.idKarta = idKarta;
        this.cena = cena;
        this.fk_Korisnik = fk_Korisnik;
        this.fk_Projekcija = fk_Projekcija;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Korisnik getFk_Korisnik() {
        return fk_Korisnik;
    }

    public void setFk_Korisnik(Korisnik fk_Korisnik) {
        this.fk_Korisnik = fk_Korisnik;
    }

    public Projekcija getFk_Projekcija() {
        return fk_Projekcija;
    }

    public void setFk_Projekcija(Projekcija fk_Projekcija) {
        this.fk_Projekcija = fk_Projekcija;
    }

    public Integer getIdKarta() {
        return idKarta;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idKarta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Karta other = (Karta) obj;
        
        return Objects.equals(this.idKarta, other.idKarta);
    }

    @Override
    public String toString() {
        return "Karta{" + "idKarta=" + idKarta + ", cena=" + cena + ", fk_Korisnik=" + fk_Korisnik + ", fk_Projekcija=" + fk_Projekcija + '}';
    }
    
    
    
}
