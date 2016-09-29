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
@Table(name = "film")
public class Film implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFilm")
    private Integer idFilm;
    
    @NotNull
    @Column(name = "naziv")
    private String naziv;
    
    @NotNull
    @Column(name = "zanr")
    private String zanr;

    public Film() {
    }

    public Film(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public Film(String naziv, String zanr) {
        this.naziv = naziv;
        this.zanr = zanr;
    }

    public Film(Integer idFilm, String naziv, String zanr) {
        this.idFilm = idFilm;
        this.naziv = naziv;
        this.zanr = zanr;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public Integer getIdFilm() {
        return idFilm;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idFilm);
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
        final Film other = (Film) obj;
        
        return Objects.equals(this.idFilm, other.idFilm);
    }

    @Override
    public String toString() {
        return "Film{" + "naziv=" + naziv + ", zanr=" + zanr + '}';
    }
    
    
    
    
    
}
