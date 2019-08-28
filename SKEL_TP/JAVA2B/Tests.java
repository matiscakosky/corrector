import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import java.util.ArrayList;
import java.lang.reflect.Modifier;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    public static float nota=0;

    @Test
    public void test01ComprueboQueVehiculoTengaLosAtributos() {
    	System.out.println("Test 1 - Valor: 1 pto");
    	Vehiculo v = new Taxi();
    	ArrayList<Rueda> ar = v.getRuedas();
    	ArrayList<Ventana> av = v.getVentanas();
    	Motor m = v.getMotor();
    	    	
    	boolean condition = m instanceof Motor && ar.size()==4 && av.size()==4;
    	print_test("Las ventanas son 4, las ruedas son 4, y el motor existe",condition);
    	if(condition) nota+=1;

    }

    @Test
    public void test02LosVehiculosImplementanBienLasInterfaces() {
    	System.out.println("Test 2 - Valor: 1 pto");
    	Taxi t = new Taxi();
    	Uber u = new Uber();
    	Colectivo c = new Colectivo();
    	boolean condition = t instanceof Imponible && t instanceof Tarifable && c instanceof Imponible && c instanceof Tarifable && c instanceof Imponible && u instanceof Tarifable && !(u instanceof Imponible);  
    	print_test("Los vehiculos implementan a las interfaces que corresponde",condition);
    	if(condition) nota+=1;
    }

    @Test
    public void test03ComprueboLosCobrarColectivo(){
    	System.out.println("Test 3 - Valor: 0.5 pto");
    	Colectivo c = new Colectivo();
    	double mrecorridos0 = 5;
    	double mrecorridos1 = 500;
    	double mrecorridos2 = 5000;
    	boolean condition = true;

    	if(c.cobrar(mrecorridos0) != 18) condition=false;
    	if(c.cobrar(mrecorridos1) != 20) condition=false;
    	if(c.cobrar(mrecorridos2) != 21) condition=false;
    	
    	print_test("Los intervalos del cobrar del colectivo son correctos",condition);
    	if(condition)nota+=0.5;
    }
    
    
    @Test
    public void test04ComprueboMetodoCobrarDeLasClases(){
    	System.out.println("Test 4 - Valor: 1 pto");
    	Taxi t = new Taxi();
    	Uber u = new Uber();
    	
    	double mrecorridos = 5;
    	double RTAXI = 5*mrecorridos*mrecorridos - 2*mrecorridos + 50;
    	double RUBER = 6*mrecorridos;
    	boolean condition = RTAXI == t.cobrar(mrecorridos) && RUBER == u.cobrar(mrecorridos);
    	print_test("Compruebo que los metodos cobrar de Uber y Taxi se ejecuten correctamente",condition);
    	if(condition)nota+=1;
    
    }
    
    @Test
    public void test05ComprueboPagarColectivoUber(){
    	System.out.println("Test 5 - Valor: 2 pto");
    	
    	Taxi t = new Taxi();
    	Colectivo c = new Colectivo();
    	
    	double mrecorridos = 5;
    	double RTAXI = 2*mrecorridos;
    	double RCOLECTIVO = 5000;
    	boolean condition = RTAXI == t.pagar(mrecorridos) && RCOLECTIVO == c.pagar(mrecorridos);
    	print_test("Compruebo que los metodos pagar de Uber y Taxi se ejecuten correctamente",condition);
    	if(condition)nota+=2;
    

    }
    
    @Test
    public void test06ComprueboLaHerenciaDeAnimal(){
    	System.out.println("Test 6 - Valor: 1 pto");
    	Perro p = new Perro();
    	Leon l = new Leon();
    	Gato g = new Gato();
    	boolean condition = p instanceof Animal && l instanceof Animal && g instanceof Animal;
    	print_test("Los animales son de la clase Animal", condition);
    	if(condition)nota+=1;
    }
    
    
    @Test
    public void test07SonidoPerro(){
    	System.out.println("Test 7 - Valor: 0.5 pto");
    	Perro p = new Perro();
    	String s = p.hacerSonido();
    	boolean condition = s.equals("Guau");
    	print_test("Perro hace Guau", condition);
    	if(condition)nota+=0.5;

    }
    
    @Test
    public void test08SonidoGato(){
    	System.out.println("Test 8 - Valor: 0.5 ptos");
    	Gato g = new Gato();
    	String s = g.hacerSonido();
    	boolean condition = s.equals("Miau");
    	print_test("Gato hace Miau", condition);
    	if(condition)nota+=0.5;
    }
    
    @Test
    public void test09SonidoLeon(){
    	System.out.println("Test 9 - Valor: 0.5 ptos");
    	Leon l = new Leon();
    	String s = l.hacerSonido();
    	boolean condition = s.equals("Groar");
    	print_test("Leon hace Groar", condition);
    	if(condition)nota+=0.5;
    }
        
    @Test
    public void test10ComprueboClaseAbstracta(){
    	System.out.println("Test 10 - Valor: 2 ptos");
    	boolean condition = Modifier.isAbstract(Animal.class.getModifiers());
    	print_test("La clase Animal fue correctamente definida como abstracta",condition);
    	if(condition)nota+=2;
    }
    
    
    
    
    
    
    @AfterClass
    public static void Mostrar(){
    	System.out.println("--------------");
    	System.out.println("FIN DEL EXAMEN");
    	System.out.println("--------------");
    	System.out.println("La nota obtenida es " + Math.round(nota) );
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