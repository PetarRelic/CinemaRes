package rs.ac.singidunum.cinemares.data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;
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
@Table(name = "projekcija")
public class Projekcija implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProjekcija")
    private Integer idProjekcija;
    
    @NotNull
    @Column(name = "termin_projekcije")
    private Date termin_projekcije;
    
    @JoinColumn(name = "fk_Film", referencedColumnName = "idFilm")
    @ManyToOne(fetch = FetchType.EAGER)
    private Film fk_Film;
    
    @JoinColumn(name = "fk_Sala", referencedColumnName = "idSala")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sala fk_Sala;

    public Projekcija() {
    }

    public Projekcija(Integer idProjekcija) {
        this.idProjekcija = idProjekcija;
    }

    public Projekcija(Integer idProjekcija, Date termin_projekcije, Film fk_Film, Sala fk_Sala) {
        this.idProjekcija = idProjekcija;
        this.termin_projekcije = termin_projekcije;
        this.fk_Film = fk_Film;
        this.fk_Sala = fk_Sala;
    }

    public Projekcija(Date termin_projekcije) {
        this.termin_projekcije = termin_projekcije;
    }

    public Projekcija(Date termin_projekcije, Film fk_Film, Sala fk_Sala) {
        this.termin_projekcije = termin_projekcije;
        this.fk_Film = fk_Film;
        this.fk_Sala = fk_Sala;
    }

    public Projekcija(Integer idProjekcija, Film fk_Film, Sala fk_Sala) {
        this.idProjekcija = idProjekcija;
        this.fk_Film = fk_Film;
        this.fk_Sala = fk_Sala;
    }

    public Projekcija(Sala sala, String termin_projekcije, Film film) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Projekcija(String termin_projekcije, Film film, Sala sala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public Date getTermin_projekcije() {
        return termin_projekcije;
    }

    public void setTermin_projekcije(Date termin_projekcije) {
        this.termin_projekcije = termin_projekcije;
    }

    public Film getFk_Film() {
        return fk_Film;
    }

    public void setFk_Film(Film fk_Film) {
        this.fk_Film = fk_Film;
    }

    public Sala getFk_Sala() {
        return fk_Sala;
    }

    public void setFk_Sala(Sala fk_Sala) {
        this.fk_Sala = fk_Sala;
    }

    public Integer getIdProjekcija() {
        return idProjekcija;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idProjekcija);
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
        final Projekcija other = (Projekcija) obj;
        
        return Objects.equals(this.idProjekcija, other.idProjekcija);
    }

    @Override
    public String toString() {
        return "Projekcija{" + "idProjekcija=" + idProjekcija + ", termin_projekcije=" + termin_projekcije + ", fk_Film=" + fk_Film + ", fk_Sala=" + fk_Sala + '}';
    }
    
    
    
}
