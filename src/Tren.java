public class Tren extends Vehicul implements StareVehicul{
    private int numarVagoane;
    private String tipTren;
    private boolean esteElectric;
    private String ruta;
    private int vitezaMaxima;


    // Constructor fără argumente
    public Tren() {
        super();
        this.numarVagoane = 0;
        this.esteElectric = false;
        this.ruta = "Necunoscut";
        this.vitezaMaxima = 0;
        this.tipTren = "Necunoscut";
    }

    // Constructor cu argumentele
    public Tren(int id, String tipTren, boolean esteElectric, String marca, int anFabricatie, String culoare,int numarVagoane, String ruta, int vitezaMaxima) {
        super(id, marca, anFabricatie, culoare);
        this.numarVagoane = numarVagoane;
        this.tipTren = tipTren;
        this.esteElectric = esteElectric;
        this.ruta = ruta;
        this.vitezaMaxima = vitezaMaxima;
    }

    // Constructor de copiere
    public Tren(Tren other) {
        super(other);
        this.numarVagoane = other.numarVagoane;
        this.tipTren = other.tipTren;
        this.esteElectric = other.esteElectric;
        this.ruta = other.ruta;
        this.vitezaMaxima = other.vitezaMaxima;
    }

    public void setEsteElectric(boolean esteElectric) {
        this.esteElectric = esteElectric;
    }
    public boolean getEsteElectric() {
        return esteElectric;
    }

    public void setNumarVagoane(int numarVagoane) {
        this.numarVagoane = numarVagoane;
    }
    public int getNumarVagoane() {
        return numarVagoane;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public String getRuta() {
        return ruta;
    }

    public void setVitezaMaxima(int vitezaMaxima) {
        this.vitezaMaxima = vitezaMaxima;
    }
    public int getVitezaMaxima() {
        return vitezaMaxima;
    }

    public void setTipTren(String tipTren) {
        this.tipTren = tipTren;
    }
    public String getTipTren() {
        return tipTren;
    }

    // Metoda toString
    @Override
    public String toString() {
        return super.toString() + " este Tren [Număr Vagoane: " + numarVagoane + ", Tip: " + tipTren + (esteElectric ? ", este electric" : ", nu este electric") + ", are ruta: " + ruta + " și Viteza Maxima: " + vitezaMaxima + " km/h ]";
    }

    @Override
    public void functional() {
        System.out.println("Tren Funcțional");
    }

    @Override
    public void nefunctional() {
        System.out.println("Tren Nefuncțional");
    }
}
