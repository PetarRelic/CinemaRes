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
@Table(name = "sala")
public class Sala implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Integer idSala;
    
    @NotNull
    @Column(name = "br_sedista")
    private String br_sedista;
    
    @NotNull
    @Column(name = "br_sale")
    private String br_sale;
    
    @JoinColumn(name = "fk_Bioskop", referencedColumnName = "idBioskop")
    @ManyToOne(fetch = FetchType.EAGER)
    private Bioskop fk_Bioskop;

    public Sala() {
    }

    public Sala(Integer idSala) {
        this.idSala = idSala;
    }

    public Sala(String br_sedista, String br_sale, Bioskop fk_Bioskop) {
        this.br_sedista = br_sedista;
        this.br_sale = br_sale;
        this.fk_Bioskop = fk_Bioskop;
    }

    public Sala(Integer idSala, String br_sedista, String br_sale, Bioskop fk_Bioskop) {
        this.idSala = idSala;
        this.br_sedista = br_sedista;
        this.br_sale = br_sale;
        this.fk_Bioskop = fk_Bioskop;
    }

    public Sala(String br_sedista, String br_sale) {
        this.br_sedista = br_sedista;
        this.br_sale = br_sale;
    }

    public Sala(Integer idSala, String br_sedista, String br_sale) {
        this.idSala = idSala;
        this.br_sedista = br_sedista;
        this.br_sale = br_sale;
    }

    public Sala(Integer idSale, Bioskop bioskop) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getBr_sedista() {
        return br_sedista;
    }

    public void setBr_sedista(String br_sedista) {
        this.br_sedista = br_sedista;
    }

    public String getBr_sale() {
        return br_sale;
    }

    public void setBr_sale(String br_sale) {
        this.br_sale = br_sale;
    }

    public Bioskop getFk_Bioskop() {
        return fk_Bioskop;
    }

    public void setFk_Bioskop(Bioskop fk_Bioskop) {
        this.fk_Bioskop = fk_Bioskop;
    }

    public Integer getIdSala() {
        return idSala;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idSala);
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
        final Sala other = (Sala) obj;
        
        return Objects.equals(this.idSala, other.idSala);
    }

    @Override
    public String toString() {
        return "Sala{" + "idSala=" + idSala + ", br_sedista=" + br_sedista + ", br_sale=" + br_sale + ", fk_Bioskop=" + fk_Bioskop + '}';
    }
    
    

    
}
