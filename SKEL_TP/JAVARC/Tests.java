	
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    public static float nota=0;

    @Test
    public void test01ComprueboLosgettersDeLaClaseAsiento() {
    	System.out.println("Test 1 - Valor: 1 pto");
    	Asiento a = new Asiento(0,0,10);
    	boolean condition = a.get_fila()==0 && a.get_columna()==0 && a.get_precio()==10;
    	print_test("Compruebo los getters de la clase Avion, funcionan correctamente",condition);
    	if(condition){nota+=1;}


    }

    @Test
    public void test02ComprueboQueElAsientoSeOcupeCorrectamente() {
    	System.out.println("Test 2 - Valor: 1 pto");
    	Asiento a = new Asiento(0,0,10);
    	print_test("El asiento arranca libre",a.esta_vacio());
    	a.ocupar();
    	print_test("Ocupo ese asiento",!a.esta_vacio());
    	if(!a.esta_vacio()){nota+=1;}

    }

    @Test
    public void test03CreoUnAvionDeUnaSolaFilaBuscoElMasBarato(){
    	System.out.println("Test 3 - Valor: 1 pto");
    	Avion a = new Avion(1,150);
    	Asiento mb = a.buscar_mas_barato();
    	boolean condition = mb.get_precio() == 150*0.6 && mb.get_fila()==0 && mb.get_columna()==3;
    	print_test("El precio del mas barato en un avion vacio es el 40% del precio mas caro",condition);
    	if(condition){nota+=1;}

        
    }
    
    
    @Test
    public void test04CreoUnAvionDeUnaSolaFilaBuscoElMasBaratoYLoOcupo(){
    	System.out.println("Test 4 - Valor: 1 pto");
    	Avion a = new Avion(1,150);
    	Asiento mb = a.buscar_mas_barato();
    	boolean condition = mb.get_precio() == 150*0.6 && mb.get_fila()==0 && mb.get_columna()==3;
    	print_test("El precio del mas barato en un avion vacio es el 40% del precio mas caro",condition);
    	mb.ocupar();
    	mb = a.buscar_mas_barato();
    	condition = mb.get_precio() == 150*0.7 && mb.get_fila()==0 && ( mb.get_columna()==2 || mb.get_columna()== 4);
    	print_test("Ocupo el anterior y el precio del mas barato ahora es el 30% del precio mas caro",condition);
    	if(condition){nota+=1;}
      }
    
    @Test
    public void test05CreoUnAvionDeUnaSolaFilaBuscoElMasBaratoYLoOcupoLuegoOcupoLosSiguientesDos(){
    	System.out.println("Test 5 - Valor: 1 pto");
    	Avion a = new Avion(1,150);
    	Asiento mb = a.buscar_mas_barato(); // es el D
    	boolean condition = mb.get_precio() == 150*0.6 && mb.get_fila()==0 && mb.get_columna()==3;
    	print_test("El precio del mas barato en un avion vacio es el 40% del precio mas caro",condition);
    	mb.ocupar();
    	mb = a.buscar_mas_barato(); // es el E o C
    	condition = mb.get_precio() == 150*0.7 && mb.get_fila()==0 && ( mb.get_columna()==2 || mb.get_columna()== 4);
    	print_test("Ocupo el anterior y el precio del mas barato ahora es el 30% del precio mas caro",condition);
    	mb.ocupar();
    	mb = a.buscar_mas_barato(); // es el E o C
    	mb.ocupar();
    	mb = a.buscar_mas_barato(); // es el B o F
    	condition = mb.get_precio() == 150*0.8 && mb.get_fila()==0 && ( mb.get_columna()==1 || mb.get_columna()== 5);
    	print_test("Ocupo el anterior y el precio del mas barato ahora es el 20% del precio mas caro",condition);
    	if(condition){nota+=1;}

    }
    
    @Test
    public void test06CreoUnAvionDeVariasFilasOcupoTodaLaColumnaD(){
    	System.out.println("Test 6 - Valor: 1 pto");
    	int filas = 10;
    	Avion a = new Avion(filas,150);
    	for (int i = 0; i < filas; i++) {
			Asiento asiento = a.buscar_mas_barato();
			asiento.ocupar();
		}
    	 
    	boolean condition = a.buscar_mas_barato().get_precio() == 150*0.7 && ( a.buscar_mas_barato().get_columna()==2 || a.buscar_mas_barato().get_columna()== 4);
    	print_test("Ocupo el anterior y el precio del mas barato ahora es el 30% del precio mas caro",condition);
    	if(condition){nota+=1;}
    }
    
    
    @Test
    public void test07CreoUnAvionDeVariasFilasOcupoTodasLasMasBaratas(){
    	System.out.println("Test 7 - Valor: 2 ptos");
    	int filas = 10;
    	
    	Avion a = new Avion(filas,150);
    	for (int i = 0; i < filas; i++) {
    		// Ocupo las D
			Asiento asiento = a.buscar_mas_barato();
			asiento.ocupar();
		}
    	 
    	boolean condition = a.buscar_mas_barato().get_precio() == 150*0.7 && ( a.buscar_mas_barato().get_columna()==2 || a.buscar_mas_barato().get_columna()== 4);
    	print_test("Ocupo el anterior y el precio del mas barato ahora es el 30% del precio mas caro",condition);
    	
    	for (int i = 0; i < 2*filas; i++) {
    			//Ocupo las C y E
    			Asiento asiento = a.buscar_mas_barato();
    			asiento.ocupar();
    		}
    	

    	condition = a.buscar_mas_barato().get_precio() == 150*0.8  && ( a.buscar_mas_barato().get_columna()==1 || a.buscar_mas_barato().get_columna()== 5);
    	print_test("Ocupo las filas anteriores, el precio del mas barato ahora es el 20% del precio mas caro",condition);
    	
    	for (int i = 0; i < 2*filas; i++) {
    		//Ocupo las B y F
			Asiento asiento = a.buscar_mas_barato();
			asiento.ocupar();
		}
    	
    	condition = a.buscar_mas_barato().get_precio() == 150  && ( a.buscar_mas_barato().get_columna()==0 || a.buscar_mas_barato().get_columna()== 6);
    	print_test("Ocupo las filas anteriores, el precio del mas barato ahora es el 30% del precio mas caro",condition);
    	
    	
    	if(condition){nota+=2;}
    	
  
    }
    
    @Test
    public void test08ComprueboQueNoSePuedanIngresarValoresInvalidosAlConstructor(){
    	System.out.println("Test 8 - Valor: 2 pto");
    	int f,p;
    	do {
    		f=getRandomNumberInRange(-100, 10);
    		p=getRandomNumberInRange(-100, 10);
    	} while ((f>=0) && (p>=0));
    	try {
    		Avion a = new Avion(f,p);
    		print_test("Creo un avion con un constructor con algun numero negativo, debe fallar",false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo un avion con un constructor con algun numero negativo, debe fallar",true);
			nota+=2;
		}
    
    }   
    
    @AfterClass
    public static void Mostrar(){
    	System.out.println("--------------");
    	System.out.println("FIN DEL EXAMEN");
    	System.out.println("--------------");
    	System.out.println("La nota obtenida es " + Math.round(nota) );
    }



    
    private  int getRandomNumberInRange(int min, int max) {
    		if (min >= max) {
    			throw new IllegalArgumentException("max debe ser mayor que min");
    		}
    		Random r = new Random();
    		return r.nextInt((max - min) + 1) + min;
    	}

    public void print_test(String msg, boolean ok){
        System.out.flush();
        String res;
        if(ok){
            res="OK";
        }
        else{
            res="ERROR";
        }
        System.out.printf("%s...%s \n", msg,res);
        assertTrue(ok);
    }

}
