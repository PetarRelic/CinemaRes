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
@Table(name = "korisnik")
public class Korisnik implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKorisnik")
    private Integer idKorisnik;
    
    @NotNull
    @Column(name = "korisnicko_ime")
    private String korisnicko_ime;
    
    @NotNull
    @Column(name = "lozinka")
    private String lozinka;
    
    @NotNull
    @Column(name = "email")
    private String email;

    public Korisnik() {
    }

    public Korisnik(Integer idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public Korisnik(String korisnicko_ime, String lozinka, String email) {
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.email = email;
    }

    public Korisnik(String korisnicko_ime, String lozinka) {
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
    }
    

    public Korisnik(Integer idKorisnik, String korisnicko_ime, String lozinka, String email) {
        this.idKorisnik = idKorisnik;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.email = email;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdKorisnik() {
        return idKorisnik;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idKorisnik);
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
        final Korisnik other = (Korisnik) obj;
        
        return Objects.equals(this.idKorisnik, other.idKorisnik);
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + ", email=" + email + '}';
    }
    
    
    
}
