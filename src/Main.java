//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
Avion av = new Avion();
Submarin sub=new Submarin();
System.out.println(av);
System.out.println(sub);

//Tren IR1802 = new Tren(1802,"CFR",2004,"ALBASTRU",3,"NORMAL");
//System.out.println(IR1802);
//Vapor Combi_Freighter_4500=new Vapor(4500,"DAMEN",2024,"ALB",2950,"MARFAR");
//System.out.println(Combi_Freighter_4500);
Motocicleta moto = new Motocicleta(1,"euro5",2,true,"bmw",2010,"rosie",2000,false);
System.out.println(moto);


    }
}