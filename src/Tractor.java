import java.util.ArrayList;

public class Tractor extends Vehicul{
    private int cai_putere;
    private String tip_roti;
    private double consum_combustibil;
    private int ore_functionare;
    private boolean incarcator;

    //Constructor fara argumente
    public Tractor(){
        super();
        this.cai_putere = 0;
        this.tip_roti = "nespecificat";
        this.consum_combustibil = 0;
        this.ore_functionare = 0;
        this.incarcator = false;
    }
    //Constructor cu toate argumentele
    public Tractor(int id, String marca, int anFabricatie , String culoare , int cai_putere, String starea_curenta , double consum_combustibil , int ore_functionare , boolean incarcator){
        super(id,marca,anFabricatie,culoare);
        this.cai_putere = cai_putere;
        this.tip_roti = starea_curenta;
        this.consum_combustibil = consum_combustibil;
        this.ore_functionare = ore_functionare;
        this.incarcator = incarcator;
    }
    //Constrictor de copiere
    public Tractor(Tractor tr){
        super(tr);
        this.cai_putere = tr.cai_putere;
        this.tip_roti = tr.tip_roti;
        this.consum_combustibil = tr.consum_combustibil;
        this.ore_functionare = tr.ore_functionare;
        this.incarcator = tr.incarcator;
    }
    public static ArrayList<Tractor> getListaTractor() {
    Tractor JohnDeere = new Tractor(24, "John Deere", 2015, "VERDE", 150, "cauciucuri", 30.0, 7000, false);
    Tractor MasseyFerguson = new Tractor(20, "Massey Ferguson", 2012, "ROSU", 120, "cauciucuri", 28.0, 6000, false);
    Tractor NewHolland = new Tractor(18, "New Holland", 2018, "ALBASTRU", 140, "cauciucuri", 32.5, 4800, true);
    Tractor Fendt = new Tractor(26, "Fendt", 2020, "VERDE", 300, "senile", 35.0, 5500, true);
    Tractor Case = new Tractor(25, "Case", 2017, "GALBEN", 280, "senile", 29.5, 6400, false);
    Tractor Valtra = new Tractor(20, "Valtra", 2014, "NEGRU", 130, "cauciucuri", 27.0, 5900, true);
    Tractor DeutzFahr = new Tractor(30, "Deutz-Fahr", 2019, "VERDE", 175, "cauciucuri", 33.5, 5100, false);
    Tractor Kubota = new Tractor(16, "Kubota", 2016, "PORTOCALIU", 100, "cauciucuri", 26.0, 4500, false);
    Tractor Zetor = new Tractor(18, "Zetor", 2013, "ROSU", 125, "cauciucuri", 28.5, 5300, false);
    Tractor Belarus = new Tractor(23, "Belarus", 2021, "ALB", 190, "cauciucuri", 34.0, 5700, true);

    ArrayList<Tractor> tractoare = new ArrayList<>();
            tractoare.add(JohnDeere);
            tractoare.add(MasseyFerguson);
            tractoare.add(NewHolland);
            tractoare.add(Fendt);
            tractoare.add(Case);
            tractoare.add(Valtra);
            tractoare.add(DeutzFahr);
            tractoare.add(Kubota);
            tractoare.add(Zetor);
            tractoare.add(Belarus);
            return tractoare;}
    //Metoda toString
    @Override
    public String toString(){
        return "Tractorul " + super.getMarca() +" din anul "+super.getAnFabricatie() +" cu puterea de " + cai_putere + " cp si are un consum de " + consum_combustibil + " si este " + tip_roti + " si acum are " + ore_functionare + " ore de functionare si " + (incarcator?"are incarcator ":"nu are incarcator ")+ ".";
    }

    public void setCai_putere(int cai_putere) {
        this.cai_putere = cai_putere;
    }
    public int getCai_putere() {
        return cai_putere;
    }
    public void setTip_roti(String tip_roti) {
        this.tip_roti = tip_roti;
    }
    public String getTip_roti() {
        return tip_roti;
    }
    public void setConsum_combustibil(double consum_combustibil) {
        this.consum_combustibil = consum_combustibil;
    }
    public double getConsum_combustibil() {
        return consum_combustibil;
    }
    public void setOre_functionare(int ore_functionare) {
        this.ore_functionare = ore_functionare;
    }
    public int getOre_functionare() {
        return ore_functionare;
    }
    public void setIncarcator(boolean incarcator) {
        this.incarcator = incarcator;
    }
    public boolean getIncarcator() {
        return incarcator;
    }
}


