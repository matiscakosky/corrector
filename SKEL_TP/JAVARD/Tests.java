	
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
    public void test01ComprueboQueEstenCreadosLosGettersDeLaClaseJugador() {
    	System.out.println("Test 1 - Valor: 1 pto");
    	Jugador messi = new Jugador(30,50,90,"DEL");
    	boolean condition=messi.getFuerza()==30 && messi.getVelocidad() ==50 && messi.getDefinicion()==90 && messi.getPosicion().equals("DEL");
    	print_test("Los getters de la clase jugador estan bien creados, todos funcionan: ",condition);
        assertTrue(condition);
        try {
        	int f,v,d;
        	do {
        		f=getRandomNumberInRange(-100, 200);
        		v=getRandomNumberInRange(-100, 200);
        		d=getRandomNumberInRange(-100, 200);
			} while ((f>=0&&f<=99) && (v>=0&&v<=99) && (d>=0&&d<=99) );
        	messi=new Jugador(f,v,d,"DEL");
        	print_test("Creo un jugador con argumentos invalidos, debe fallar: ",false);
        	assertTrue(false);
        	
		} catch (IllegalArgumentException e) {
			print_test("Creo un jugador con argumentos invalidos, debe fallar: ",true);
			nota+=1;
	        
		}

    }

    @Test
    public void test02ComprueboLaPosicionDelJugador() {
    	System.out.println("Test 2 - Valor: 1 pto");
    	try {
        	Jugador messi=new Jugador(10,10,10,"Hola don pepito");
        	print_test("Creo un jugador con posicion invalida, debe fallar: ",false);
        	
		} catch (IllegalArgumentException e) {
			print_test("Creo un jugador con posicion invalida, debe fallar: ",true);
			nota+=1;
		}


    }

    @Test
    public void test03CreoUnaSeleccionDeMasDe10Jugadores(){
    	System.out.println("Test 3 - Valor: 1 pto");
    	try {
           	int def,med,del;
        	do {
        		def=getRandomNumberInRange(-100, 200);
        		med=getRandomNumberInRange(-100, 200);
        		del=getRandomNumberInRange(-100, 200);
    			
			} while (def+med+del==10);
        	SeleccionArgentina s=new SeleccionArgentina(def,med,del);
        	print_test("Creo una seleccion de un numero incorrecto de jugadores: ",false);
        	assertTrue(false);
        	
		} catch (IllegalArgumentException e) {
			print_test("Creo una seleccion de un numero incorrecto de jugadores: ",true);
			nota+=1;
		}
        
    }
    
    
    @Test
    public void test04CreoDosSeleccionesYLasCantidadesSonCorrectas(){
    	System.out.println("Test 4 - Valor: 1 pto");
       	int def,med,del;
    	do {
    		def=getRandomNumberInRange(0, 5);
    		med=getRandomNumberInRange(0, 5);
    		del=getRandomNumberInRange(0, 5);
			
		} while (def+med+del!=10);
    	SeleccionArgentina s =new SeleccionArgentina(def,med,del);
    	ArrayList<Jugador> e = s.getEquipo();
    	int contdef=0,contmed=0,contdel=0;
    	for (Jugador j : e) {
    		switch (j.getPosicion()) {
    		case "DEF":
				contdef++;
				break;
    		case "MED":
				contmed++;
				break;
    		case "DEL":
				contdel++;
				break;
			default:
				print_test("Creo una seleccion con jugadores random, bien asignadas las posciones: ",false);
    		}	
		}
    	boolean condition= contdef==def&&contmed==med&&contdel==del;
    	print_test("Creo una seleccion con jugadores random, bien asignadas las posciones: ",condition);
        if(condition) nota+=1;
    }
    
    @Test
    public void test05ComprueboCaracteristicasDEF(){
    	System.out.println("Test 5 - Valor: 1 pto");
    	HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
    	SeleccionArgentina s =new SeleccionArgentina(10,0,0);
    	ArrayList<Jugador> e = s.getEquipo();
    	boolean flag=true;
    	for (Jugador jugador : e) {
    		int f=jugador.getFuerza();
    		int v=jugador.getVelocidad();
    		int d=jugador.getDefinicion();
    		if(!hm.containsKey(f+v+d)){hm.put(f+v+d, 0);}
    		hm.put(f+v+d, hm.get(f+v+d) + 1);
    		if(!(f>=(int)(1.3*v))|| d>40){flag=false;}
		}
    	boolean condition=flag && !hm.containsValue(10); //Si esta 10 veces repetido algun valor, los valores no son al azar
    	if(condition){nota+=1;}
    	print_test("Los valores asignados a los defensores son correctos y azarosos",condition);

    }
    
    @Test
    public void test06ComprueboCaracteristicasMED(){
    	System.out.println("Test 6 - Valor: 1 pto");
    	HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
    	SeleccionArgentina s =new SeleccionArgentina(0,10,0);
    	ArrayList<Jugador> e = s.getEquipo();
    	boolean flag=true;
    	for (Jugador jugador : e) {
    		int f=jugador.getFuerza();
    		int v=jugador.getVelocidad();
    		int d=jugador.getDefinicion();
    		if(!hm.containsKey(f+v+d)){hm.put(f+v+d, 0);}
    		hm.put(f+v+d, hm.get(f+v+d) + 1);
    		if(!(v==(2*d))){flag=false;}
		}
    	boolean condition=flag && !hm.containsValue(10); //Si esta 10 veces repetido algun valor, los valores no son al azar
    	if(condition){nota+=1;}
    	print_test("Los valores asignados a los mediocampistas son correctos y azarosos",condition);
    }
    
    
    @Test
    public void test07ComprueboCaracteristicasDEL(){
    	System.out.println("Test 7 - Valor: 2 ptos");
    	HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
    	SeleccionArgentina s =new SeleccionArgentina(0,0,10);
    	ArrayList<Jugador> e = s.getEquipo();
    	boolean flag=true;
    	for (Jugador jugador : e) {
    		int f=jugador.getFuerza();
    		int v=jugador.getVelocidad();
    		int d=jugador.getDefinicion();
    		if(!hm.containsKey(f+v+d)){hm.put(f+v+d, 0);}
    		hm.put(f+v+d, hm.get(f+v+d) + 1);
    		if(!(d==(int)(1.2*f))|| v<20){flag=false;}
		}
    	boolean condition=flag && !hm.containsValue(10); //Si esta 10 veces repetido algun valor, los valores no son al azar
    	if(condition){nota+=2;}
    	print_test("Los valores asignados a los delanteros son correctos y azarosos",condition);


    }
    
    @Test
    public void test08BuscoUnParecidoAMessi(){
    	System.out.println("Test 8 - Valor: 2 ptos");
    	SeleccionArgentina s = new SeleccionArgentina(4, 4, 2);
    	ArrayList<Jugador> e = s.getEquipo();
    	Jugador messi = new Jugador(99,99,99,"DEL");
    	e.add(messi);
    	Jugador test = s.getParecidoAMessi();
    	print_test("Inserto y busco un jugador parecido a messi y lo encuentro",test==messi);
    	if(test==messi){nota+=2;}
    	
    	
    	

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
