import java.util.ArrayList;
import java.util.Objects;

public class Autobuz extends Vehicul {
    public int getLinie;
    private int capacitatePasageri;
    private int linie;
    private boolean aerConditionat;
    private String normaEmisii;
    private boolean esteElectric;

    // Constructor fără argumente
    public Autobuz() {
        super();
        this.capacitatePasageri = 0;
        this.linie = 0;
        this.aerConditionat = false;
        this.normaEmisii = "Necunoscut";
        this.esteElectric = false;
    }

    // Constructor cu toate argumentele
    public Autobuz(int id,boolean esteElectric, String normaEmisii, String marca, boolean aerConditionat, int anFabricatie, String culoare, int capacitatePasageri, int linie) {
        super(id, marca, anFabricatie, culoare);
        this.capacitatePasageri = capacitatePasageri;
        this.linie = linie;
        this.aerConditionat = aerConditionat;
        this.normaEmisii = normaEmisii;
        this.esteElectric = esteElectric;
    }

    // Constructor de copiere
    public Autobuz(Autobuz other) {
        super(other);
        this.capacitatePasageri = other.capacitatePasageri;
        this.linie = other.linie;
        this.aerConditionat = other.aerConditionat;
        this.normaEmisii = other.normaEmisii;
        this.esteElectric = other.esteElectric;
    }

    public void setAerConditionat(boolean aerConditionat) {
        this.aerConditionat = aerConditionat;
    }

    public void setEsteElectric(boolean esteElectric) {
        this.esteElectric = esteElectric;
    }

    public void setNormaEmisii(String normaEmisii) {
        this.normaEmisii = normaEmisii;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    public void setCapacitatePasageri(int capacitatePasageri) {
        this.capacitatePasageri = capacitatePasageri;
    }

    public boolean isAerConditionat() {
        return aerConditionat;
    }

    public boolean getAerConditionat(){return aerConditionat;}

    public boolean isEsteElectric() {
        return esteElectric;
    }

    public String getNormaEmisii() {
        return normaEmisii;
    }

    public int getLinie() {
        return getLinie;
    }

    public int getCapacitatePasageri() {
        return capacitatePasageri;
    }

    //metoda for-each cu scrierea listei in clasa test
    public static ArrayList<Autobuz> getListaAutobuze() {
        ArrayList<Autobuz> listaAutobuze = new ArrayList<>();

        Autobuz mercedes = new Autobuz(1, true, "euro6", "Mercedes", true, 2019, "alb", 60, 52);
        Autobuz volvo = new Autobuz(2, false, "euro4", "Volvo", true, 2017, "alb", 60, 40);
        Autobuz iveco = new Autobuz(3, false, "euro2", "Iveco", true, 2013, "negru", 50, 33);
        Autobuz Iveco = new Autobuz(4, true, "euro6", "Iveco", true, 2020, "gri", 35, 20);
        Autobuz scania = new Autobuz(5, true, "euro6", "Scania", true, 2019, "alb", 60, 51);
        Autobuz volvo2 = new Autobuz(6, false, "euro3", "Volvo", true, 2017, "alb", 65, 43);
        Autobuz scania2 = new Autobuz(7, false, "euro2", "Scania", true, 2013, "negru", 50, 35);
        Autobuz scania3 = new Autobuz(8, true, "euro6", "Scania", true, 2020, "gri", 35, 25);
        Autobuz man = new Autobuz(9, true, "euro4", "MAN", true, 2019, "alb", 60, 40);
        Autobuz man2 = new Autobuz(10, false, "euro3", "MAN", true, 2009, "alb", 48, 76);

        ArrayList<Autobuz> autobuze = new ArrayList<>();
        autobuze.add(mercedes);
        autobuze.add(volvo);
        autobuze.add(iveco);
        autobuze.add(Iveco);
        autobuze.add(scania);
        autobuze.add(scania2);
        autobuze.add(scania3);
        autobuze.add(man);
        autobuze.add(man2);
        autobuze.add(volvo2);
        return autobuze;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(linie);
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Autobuzul " + super.getMarca() + " cu " + capacitatePasageri +
                " locuri si care circula pe" + " linia "+ linie+
                (aerConditionat ? " are aer conditionat." : " nu are aer conditionat.");
    }

}
