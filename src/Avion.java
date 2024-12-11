import java.util.ArrayList;

public class Avion extends Vehicul implements StareVehicul{
private String  Model,tipMotor;
private boolean mil;
private int maxrange,pssnr,cargolim;
public Avion(){
    super();
    Model = "";
}
public int kmRange(){
    return maxrange;
}
public boolean isMil()  {
    return mil;
}
public Avion(String Marca, String Model, int id, int anFabricatie, String culoare, int maxrange, int pssnr, int cargolim, String tipMotor, boolean mil) {
    super(id, Marca, anFabricatie, culoare );
    this.Model = Model;
    this.maxrange = maxrange;
    this.pssnr = pssnr;
    this.cargolim = cargolim;
    this.tipMotor = tipMotor;
    this.mil = mil;
}
public Avion(Avion a){
    super(a);
    this.Model = a.Model;
    this.maxrange = a.maxrange;
    this.pssnr = a.pssnr;
    this.cargolim = a.cargolim;
    this.tipMotor = a.tipMotor;
    this.mil = a.mil;
}
public boolean isPropType(){
    if(this.tipMotor.indexOf("Turboprop")!=-1 || this.tipMotor.indexOf("Prop")!=-1){
        return true;
    }
    return false;

}
public int getMaxrange(){
    return maxrange;
}
public boolean isJetType(){
    if(this.tipMotor.indexOf("Jet")!=-1 || this.tipMotor.indexOf("Turbojet")!=-1){
        return true;
    }
    return false;
}
    //vector 10 elemente tip ArrayList
    public static ArrayList<Avion> getListaAvioane() {
        ArrayList<Avion> avioane = new ArrayList<>();
        Avion Mcdonnel = new Avion("Mcdonnel", "DC117", 1, 1967, "Argintiu", 3000, 78, 25, "Turboprop x 4", false);
        Avion Boeing = new Avion("Boeing", "777", 2, 2008, "Alb", 23000, 99, 150, "Turbofan x 4", false );
        Avion Airbus = new Avion("Airbus", "A220", 3, 2012, "Alb", 22500, 120, 225, "Turbofan x 4", false );
        Avion Dassault = new Avion("Dassault", "Mirage", 4, 1978, "Industrial Grey", 3000, 1, 12, "Jet x 1", true);
        Avion Fairchild = new Avion("Fairchild", "A-10", 5, 1977, "Gri", 3000, 2, 8, "Jet x 2", true);
        Avion Northrop = new Avion("Northrop", "B-2", 6, 1987, "Negru", 11000, 6, 20, "Jet x 2", true);
        Avion Cessna = new Avion("Cessna", "172", 7, 1955, "Alb cu Verde", 200, 5, 1, "Prop x 1", false);
        Avion Dakota = new Avion("Mcdonnel", "C-47", 8, 1941, "Kaki", 5000, 40, 50, "Prop x 2", true);
        Avion Concorde = new Avion("Concorde", "Concorde", 9, 1976, "Alb cu Albastru", 38000, 128, 100, "Turbojet x 4", false);
        Avion Lockheed = new Avion("Lockheed", "SR-71 Blackbird", 10, 1966, "Negru", 34000, 80, 120, "Turbojet x 2", true);
avioane.add(Concorde);
avioane.add(Lockheed);
        avioane.add(Dakota);
        avioane.add(Cessna);
        avioane.add(Mcdonnel);
        avioane.add(Boeing);
        avioane.add(Airbus);
        avioane.add(Dassault);
        avioane.add(Fairchild);
        avioane.add(Northrop);


        return avioane;
    }

    @Override
    public String toString() {
    if(super.getMarca()=="Necunoscut"){
        return "Nu a fost definit.";
    }
    else{
        if(mil) {
            return this.getId()+". Avion de marca " + super.getMarca() + ", de model " + Model + ", care poate transporta " + this.pssnr + " de oameni, " + this.cargolim + " de tone de marfa cu motor tip " + this.tipMotor+" cu culoare: "+getCuloare()+ " cu raza: "+maxrange+"km fabricat in anul: "+getAnFabricatie()+" cu scop militar\n";
        }
        else{ return this.getId()+". Avion de marca " + super.getMarca() + ", de model " + Model + ", care poate transporta " + this.pssnr + " de oameni, " + this.cargolim + " de tone de marfa cu motor tip " + this.tipMotor+" cu culoare: "+getCuloare()+" cu raza: "+maxrange+"km fabricat in anul: "+getAnFabricatie()+" cu scop civil\n";
        }
        }

    }

    @Override
    public void functional(){
        System.out.println("Avionul functioneaza");
    }
    @Override
    public void nefunctional(){
        System.out.println("Avionul nu mai functioneaza");
    }
}
