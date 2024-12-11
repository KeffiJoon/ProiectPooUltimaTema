import java.util.ArrayList;

public class Masina extends Vehicul{
    private int capacitate_cilindrica;
    private String tip_caroserie;
    private int nrKilometri;
    private int nrLocuri;
    private String tip_faruri;


    //Constructor fara argumente
    public Masina(){
        super();
        this.capacitate_cilindrica = 0;
        this.tip_caroserie = "Nedefinit";
        this.nrKilometri = 0;
        this.nrLocuri = 0;
        this.tip_faruri = "Nedefinit";

    }
    //Constructor cu toate argumentele
    public Masina(int id, String marca, int anFabricatie , String culoare , int capacitate_cilindrica, String tip_caroserie , int nrKilometri, int nrLocuri, String tip_faruri){
        super(id,marca,anFabricatie,culoare);
        this.capacitate_cilindrica = capacitate_cilindrica;
        this.tip_caroserie = tip_caroserie;
        this.nrKilometri = nrKilometri;
        this.nrLocuri = nrLocuri;
        this.tip_faruri = tip_faruri;
    }
    //Constrictor de copiere
    public Masina(Masina m){
        super(m);
        this.capacitate_cilindrica = m.capacitate_cilindrica;
        this.tip_caroserie = m.tip_caroserie;
        this.nrKilometri = m.nrKilometri;
        this.nrLocuri = m.nrLocuri;
        this.tip_faruri = m.tip_faruri;
    }
    //Metoda toString
    @Override
    public String toString(){
        return "Autoturismul " + super.getMarca() + " cu capacitatea cilindrica de " + capacitate_cilindrica + " cm³ si tipul caroseriei " + tip_caroserie + ", numarul de kilometri este "+ nrKilometri + " km, are un numar de " + nrLocuri + " locuri si are faruri de tipul "+ tip_faruri;
    }


    public void setCapacitate_cilindrica(int capacitate){
        this.capacitate_cilindrica = capacitate;
    }
    public int getCapacitate_cilindrica(){
        return capacitate_cilindrica;
    }
    public void setTip_caroserie(String tip){
        this.tip_caroserie = tip;
    }
    public String getTip_caroserie(){
        return tip_caroserie;
    }
    public void setNrKilometri(int nr){
        this.nrKilometri = nr;
    }
    public int getNrKilometri(){
        return nrKilometri;
    }
    public void setNrLocuri(int nr){
        this.nrLocuri = nr;
    }
    public int getNrLocuri(){
        return nrLocuri;
    }
    public void setTip_faruri(String tip_faruri){
        this.tip_faruri = tip_faruri;
    }
    public String getTip_faruri(){
        return tip_faruri;
    }

    public static ArrayList<Masina> getListaMasini() {
        ArrayList<Masina> listaMasini = new ArrayList<>();
        Masina Renault = new Masina(1, "Renault", 2015, "Albastru", 1600, "hatchback", 95620, 5, "LED");
        Masina Ford = new Masina(2, "Ford", 2020, "Negru", 2000, "coupe", 45000, 2, "xenon");
        Masina Toyota = new Masina(3, "Toyota", 2018, "Alb", 1800, "SUV", 120000, 5, "halogen");
        Masina Mercedes  = new Masina(4, "Mercedes", 2021, "Gri", 3000, "van", 30000, 6, "LED");
        Masina Volkswagen = new Masina(5, "Volkswagen", 2017, "Verde", 1500, "combi", 105000, 5, "halogen");
        Masina BMW = new Masina(6, "BMW", 2023, "Albastru inchis", 1998, "sedan", 87000, 5, "LED");
        Masina Audi = new Masina(7, "Audi", 2016, "Argintiu", 2200, "SUV", 135000, 5, "xenon");
        Masina Mini_Cooper = new Masina(8, "Mini Cooper", 2014, "Galben", 1200, "hatchback", 76000, 4, "halogen");
        Masina Hyundai = new Masina(9, "Hyundai", 2022, "Rosu inchis", 1600, "sedan", 15000, 5, "LED");
        Masina Chevrolet = new Masina(10, "Chevrolet", 2013, "Portocaliu", 2500, "coupe", 98500, 2, "halogen");
        listaMasini.add(Renault);
        listaMasini.add(Ford);
        listaMasini.add(Toyota);
        listaMasini.add(Mercedes);
        listaMasini.add(Volkswagen);
        listaMasini.add(BMW);
        listaMasini.add(Audi);
        listaMasini.add(Mini_Cooper);
        listaMasini.add(Hyundai);
        listaMasini.add(Chevrolet);
        return listaMasini;
    }
}
