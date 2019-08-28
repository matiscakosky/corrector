import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import java.util.ArrayList;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    public static float nota=0;

    @Test
    public void test01ComprueboQueLosGuerrerosSonGuerrerosZ() {
    	System.out.println("Test 1 - Valor: 0.5 pto");
    	Goku g = new Goku();
    	Gohan go = new Gohan();
    	Piccolo p = new Piccolo();
    	boolean condition = g instanceof GuerreroZ && go instanceof GuerreroZ && p instanceof GuerreroZ;
    	print_test("Goku, Gohan y Piccolo son Guerreros Z",condition);
    	if(condition) nota+=0.5;

    }

    @Test
    public void test02ComprueboLosPunietazosDePiccoloYGohan() {
    	System.out.println("Test 2 - Valor: 1 pto");
    	EnemigoDeLaTierra e = new EnemigoDeLaTierra();
    	Gohan go = new Gohan();
    	Piccolo p = new Piccolo();
    	go.punietazo(e);
    	boolean ca = e.vida == 150;
    	p.punietazo(e);
    	boolean cb= e.vida==100;
    	boolean condition = ca&&cb;
    	print_test("Los punietazos de Gohan y Piccolo restan  50 cada uno",condition);
    	if(condition) nota+=1;

    }

    @Test
    public void test03ComprueboLaException(){
    	System.out.println("Test 3 - Valor: 1 pto");
    	String s = "Compruebo lanzar un ataque a un enemigo debilitado";
    	try {
    		EnemigoDeLaTierra e = new EnemigoDeLaTierra();
    		e.restarVida(200);
        	Gohan go = new Gohan();
        	go.masenko(e);
        	print_test(s, false);
						
		} catch (EnemigoDebilitadoException e) {
			print_test(s, true);
			nota+=1;

		}
    }
    
    
    @Test
    public void test04ComprueboPunietazoGoku(){
    	System.out.println("Test 4 - Valor: 1 pto");
    	EnemigoDeLaTierra e = new EnemigoDeLaTierra();
    	Goku g = new Goku();
    	g.punietazo(e);
    	boolean condition = e.vida == 145;
    	print_test("Funciona la redefincion del punietazo de goku",condition);
    	if(condition) nota+=1;
 }
    
    @Test
    public void test05ComprueboAtaquesEspeciales(){
    	System.out.println("Test 5 - Valor: 1.5 pto");
    	EnemigoDeLaTierra e = new EnemigoDeLaTierra();
    	Gohan go = new Gohan();
    	Piccolo p = new Piccolo();
    	Goku g = new Goku();
    	g.kamehameha(e);
    	boolean ca = e.vida == 50;
    	e=new EnemigoDeLaTierra();
    	go.masenko(e);
    	boolean cb= e.vida==90;
    	e=new EnemigoDeLaTierra();
    	p.makankosappo(e);
    	boolean cc = e.vida==110;
    	boolean condition = ca&&cb&&cc;
    	print_test("Los ataques especiales estan bien definidos y hacen el danio correspondiente",condition);
    	if(condition) nota+=1.5;


    }
    
    @Test
    public void test06LaCocinaCongelaBienComida(){
    	System.out.println("Test 6 - Valor: 1 pto");
    	Cocina cocina = new Cocina();
    	Comida c = new Comida();
    	Heladera h = new Heladera();
    	Freezer f=h.getFreezer();
    	boolean condition =cocina.guardarLargoPlazo(c) && c.estaCongelada();
    	print_test("La comida se congela bien a travesde guardarLargoPlazo",condition);
    	if(condition)nota+=1;


    }
    
    
    @Test
    public void test07FreezerLanzaException(){
    	System.out.println("Test 7 - Valor: 1.5 ptos");
        Freezer f = new Freezer();
        Comida c = new Comida();
        c.congelar();
        String s = "El freezer lanza correctamente la excepcion de la comida ya congelada";
        try {
        	f.congelar(c);
        	print_test(s,false);
		} catch (ComidaYaCongeladaException e) {
			print_test(s,true);
			nota+=1.5;
		}

    }
    
    @Test
    public void test08CocinaManejaException(){
    	System.out.println("Test 8 - Valor: 0.5 ptos");
        Cocina co = new Cocina();
        Comida c = new Comida();
        String s = "Cocina maneja correctamente la excepcion de comida ya congelada";
        c.congelar();
        boolean condition;
        condition=co.guardarLargoPlazo(c);
		print_test(s,!condition);
		if(!condition)nota+=0.5;
		
    }
    
    @Test
    public void test09ComprueboArrayDeComidas(){
    	System.out.println("Test 9 - Valor: 1 ptos");
    	ArrayList<Comida> a = new ArrayList<Comida>();
    	for (int i = 0; i < 10; i++) {
			a.add(new Comida());
		}
    	Cocina c = new Cocina();
    	boolean condition = c.guardarLargoPlazo(a);
    	for (Comida comida : a) {
			if(!comida.estaCongelada()) condition=false;
		}
    	print_test("Pruebo el metodo sobrecargado, congela todas las comidas",condition);
    	
    	if (condition) nota+=1;

    	

    }
    
    @Test
    public void test10ComprueboArrayDeComidasCongeladasClaseCocinaTerminaEjecucion(){
    	System.out.println("Test 10 - Valor: 1 pto");
    	String s = "Compruebo el array de comidas congeladas, guardarLargo plazo continua manejando correctamente la exception";
    	ArrayList<Comida> a = new ArrayList<Comida>();
    	for (int i = 0; i < 10; i++) {
			Comida comida= new Comida();
			comida.congelar();
    		a.add(comida);
		}
    	Cocina c = new Cocina();
    	boolean condition = c.guardarLargoPlazo(a);
        print_test(s,!condition);
		if(!condition)nota+=1;
		

    }
    
    
    
    
    
    
    @AfterClass
    public static void Mostrar(){
    	System.out.println("--------------");
    	System.out.println("FIN DEL EXAMEN");
    	System.out.println("--------------");
    	System.out.println("La nota obtenida es " + nota );
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