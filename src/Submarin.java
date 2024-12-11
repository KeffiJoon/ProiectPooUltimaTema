import java.util.ArrayList;

public class Submarin extends Vehicul implements StareVehicul {
private String model,tipCombustibil,tipArmament;
private int tonaj,adancimeMax;
public Submarin(String model, int tonaj, int id, int anFabricatie, String culoare, int adancimeMax, String tipCombustibil, String tipArmament ) {
    super(id,"Submarin", anFabricatie, culoare );
    this.model = model;
    this.tonaj = tonaj;
    this.adancimeMax = adancimeMax;
    this.tipCombustibil = tipCombustibil;
    this.tipArmament = tipArmament;
}
public Submarin(Submarin s) {
    super(s);
    this.model = s.model;
    this.tonaj = s.tonaj;
    this.adancimeMax = s.adancimeMax;
    this.tipCombustibil = s.tipCombustibil;
    this.tipArmament = s.tipArmament;
}
public Submarin() {
    super();
    this.tonaj = 0;
    this.model = "Not Defined";
}
        public static ArrayList<Submarin> getListaSubmarine() {
            ArrayList<Submarin> submarine = new ArrayList<>();

            Submarin Nautilus = new Submarin("Nautilus", 5000, 1, 1870, "Gri", 2500, "Diesel", "Torpile");
            Submarin Ohio = new Submarin("Ohio", 16000, 2, 1981, "Verde", 800, "Nuclear", "Rachete balistice");
            Submarin Scorpion = new Submarin("Scorpion", 4000, 3, 1970, "Negru", 1500, "Diesel", "Torpile");
            Submarin Virginia = new Submarin("Virginia", 8800, 4, 2004, "Albastru", 2400, "Nuclear", "Rachete de croaziera");
            Submarin Seawolf = new Submarin("Seawolf", 12000, 5, 1997, "Gri", 2500, "Nuclear", "Torpile si rachete");
            Submarin Kilo = new Submarin("Kilo", 3300, 6, 1982, "Verde inchis", 500, "Diesel", "Torpile");
            Submarin Barracuda = new Submarin("Barracuda", 6500, 7, 2018, "Albastru inchis", 1500, "Nuclear", "Rachete si torpile");
            Submarin Typhoon = new Submarin("Typhoon", 24000, 8, 1989, "Gri inchis", 600, "Nuclear", "Rachete balistice intercontinentale");
            Submarin Dolphin = new Submarin("Dolphin", 1500, 9, 1999, "Albastru deschis", 2000, "Diesel", "Torpile");
            Submarin RedOctober = new Submarin("Red October", 18000, 10, 1985, "Negru", 800, "Nuclear", "Torpile si rachete balistice");

            submarine.add(Nautilus);
            submarine.add(Ohio);
            submarine.add(Scorpion);
            submarine.add(Virginia);
            submarine.add(Seawolf);
            submarine.add(Kilo);
            submarine.add(Barracuda);
            submarine.add(Typhoon);
            submarine.add(Dolphin);
            submarine.add(RedOctober);

            return submarine;
        }
public boolean isNuclear(){
    if(this.tipCombustibil.contains("Nuclear")){
        return true;
    }
    return false;
}
public String getTipArmament(){
    return this.tipArmament;
}
public int getAdancimeMax(){return this.adancimeMax;}
public String getMarca(){
    return "Submarinul nu are marca comerciala.";
}
    @Override
    public String toString() {
        if(model=="Not Defined"){
            return "Nu a fost definit.";
        }
        else{
            return this.getId()+". Submarin model "+model+" de tonaj:"+tonaj+" de tone, adancime maxima de: "+adancimeMax+"  cu combustibil "+tipCombustibil+" cu culoare: "+getCuloare()+" si cu armamentul: "+tipArmament+" ,fabricat in "+getAnFabricatie()+"\n";
        }
    }
    @Override
    public void functional(){
    System.out.println("Submarinul functioneaza");
    }
    @Override
    public void nefunctional(){
    System.out.println("Submarinul nu mai functioneaza");
    }
}
