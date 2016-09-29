package rs.ac.singidunum.cinemares.controller;

public enum TipAkcije {

    LIST("list"), //izlistavanje sadrzaja
    ADD("add"), //dodavanje novog elementa (clana, knjige itd.)
    EDIT("edit"), //izmena 
    DELETE("delete"); //brisanje

    private final String action;

    private TipAkcije(String action) {
        this.action = action;
    }

    /**
     * Vraca odgovarajuci enum na osnovu stringa koji se dobija preko skrivenog polja formea (hidden input, name="action" u formi).
     * Ako se prosledi nepostojeci action ili ako je action null, vratice se enum LIST.
     */
    public static TipAkcije getForAction(String action) {
        for (TipAkcije tipAkcije : values()) {
            if (tipAkcije.action.equals(action)) {
                return tipAkcije;
            }
        }
        return LIST;
    }
    
}
