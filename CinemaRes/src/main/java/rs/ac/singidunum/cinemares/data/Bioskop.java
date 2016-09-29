package rs.ac.singidunum.cinemares.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "bioskop")
public class Bioskop implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBioskop")
    private Integer idBioskop;
    
    @NotNull
    @Column(name = "naziv")
    private String naziv;
    
    @NotNull
    @Column(name = "adresa")
    private String adresa;

    public Bioskop() {
    }

    public Bioskop(Integer idBioskop) {
        this.idBioskop = idBioskop;
    }

    public Bioskop(String naziv, String adresa) {
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public Bioskop(Integer idBioskop, String naziv, String adresa) {
        this.idBioskop = idBioskop;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public Integer getIdBioskop() {
        return idBioskop;
    }

    public void setIdBioskop(Integer idBioskop) {
        this.idBioskop = idBioskop;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idBioskop);
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
        final Bioskop other = (Bioskop) obj;
        
        return Objects.equals(this.idBioskop, other.idBioskop);
    }

    @Override
    public String toString() {
        return "Bioskop{" + "naziv=" + naziv + ", adresa=" + adresa + '}';
    }
    
    
    
    
}
