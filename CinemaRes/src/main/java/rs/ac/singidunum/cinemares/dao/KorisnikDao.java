package rs.ac.singidunum.cinemares.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.xml.bind.DatatypeConverter;
import rs.ac.singidunum.cinemares.data.Korisnik;
import rs.ac.singidunum.cinemares.exceptions.CinemaResException;

public class KorisnikDao {


    private static KorisnikDao instance = new KorisnikDao();

    public KorisnikDao() {
    }
    
    public static KorisnikDao getInstance(){
        
        return instance;
    }
    
    public boolean checkLogin(EntityManager em, Korisnik korisnik) throws CinemaResException {
        try {
            TypedQuery<Korisnik> query = em.createQuery("SELECT b FROM Korisnik b WHERE b.korisnicko_ime=:korisnicko_ime AND b.lozinka=:lozinka", Korisnik.class);
            query.setParameter("korisnicko_ime", korisnik.getKorisnicko_ime());
            
            query.setParameter("lozinka", calculateHash(korisnik));
            query.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        } catch (Exception ex) {
            throw new CinemaResException("Neuspešna provera korisničkog naloga.", ex);
        }
    }
    
    private String calculateHash(Korisnik korisnik) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String korisnickoImeILozinka = korisnik.getKorisnicko_ime()+ korisnik.getKorisnicko_ime();

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte hashBytes[] = messageDigest.digest(korisnickoImeILozinka.getBytes("UTF-8"));

        return DatatypeConverter.printBase64Binary(hashBytes);
    }
    
    
    public List<Korisnik> findAll(EntityManager em){
        TypedQuery<Korisnik> query = em.createQuery("SELECT c FROM Korisnik c", Korisnik.class);
        return query.getResultList();
    }
    
    public void add(EntityManager em, Korisnik korisnik) {
        em.persist(korisnik);
    }

    public void edit(EntityManager em, Korisnik korisnik) {
        em.merge(korisnik);
    }

    public void delete(EntityManager em, Korisnik korisnik) {
        
        Korisnik managedKorisnik = em.merge(korisnik);
        em.remove(managedKorisnik);
    }
    
}
