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
    public void test01ComprueboQueLasFigurasImplementanAFigura() {
    	System.out.println("Test 1 - Valor: 0.5 pto");
    	Circulo c = new Circulo(5);
    	Rectangulo r = new Rectangulo(5,3);
    	Cuadrado s = new Cuadrado(7);
    	boolean condition = s instanceof Figura && c instanceof Figura && r instanceof Figura;
    	print_test("Cuadrado, Circulo y Rectangulo implementan correctamente a Figura",condition);
    	if(condition) nota+=0.5;

    }

    @Test
    public void test02ComprueboElAreaDeCirculo() {
    	System.out.println("Test 2 - Valor: 0.5 pto");
    	double RADIO=5;
    	Circulo c = new Circulo(RADIO);
    	double area = c.area();
    	boolean condition = area == (Math.PI * RADIO * RADIO);
    	print_test("El circulo calcula correctamente el area",condition);
    	if(condition) nota+=0.5;
    }

    @Test
    public void test03ComprueboElAreaDeRectanguloYCuadrado(){
    	System.out.println("Test 3 - Valor: 0.5 pto");
    	Rectangulo r = new Rectangulo(7,7);
    	Cuadrado s = new Cuadrado(7);
    	double area = 7 * 7;
    	boolean condition = s.area() == area && r.area() == area;
    	print_test("El cuadrado y el rectangulo calculan bien el area, siendo base = altura = lado",condition);
    	if(condition) nota+=0.5;
    }
    
    
    @Test
    public void test04ComprueboSumarNAreas(){
    	System.out.println("Test 4 - Valor: 1 pto");
    	ArrayList<Figura> figuras = new ArrayList<Figura>();
    	double RADIO=5;
    	double LADO=7;
    	double BASE=5;
    	double ALTURA=3;
    	figuras.add(new Circulo(5));
    	figuras.add(new Rectangulo(5,3));
    	figuras.add(new Cuadrado(7));
    	
    	double test = Math.PI * RADIO * RADIO + BASE * ALTURA + LADO*LADO;
    	double resultado = AreaOperations.sumarNAreas(figuras);	
    	boolean condition = test==resultado;
    	print_test("Sumo el area de cada figura con el metodo estatico",condition);
    	if(condition)nota+=1;
    
    }
    
    @Test
    public void test05ComprueboSinFigurasDebeDevolver0(){
    	System.out.println("Test 5 - Valor: 1 pto");
    	ArrayList<Figura> figuras = new ArrayList<Figura>();
    	double resultado = AreaOperations.sumarNAreas(figuras);	
    	boolean condition = 0==resultado;
    	print_test("Sumo el area de 0 figuras",condition);
    	if(condition)nota+=1;
    	

    }
    
    @Test
    public void test06ComprueboReproducirUnaBanda (){
    	System.out.println("Test 6 - Valor: 1 pto");
    	try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","E",12,220);
			print_test("Pruebo un electrodomestico nuevo, con el cambio de tabla 220V -E", true);
			nota+=1;
			
		} catch (IllegalArgumentException e) {
			print_test("Pruebo un electrodomestico nuevo, con el cambio de tabla 220V -E", false);
		}

    }
    
    
    @Test
    public void test07NuevoColorValido(){
    	System.out.println("Test 7 - Valor: 0.5 pto");
    	try {
			Electrodomestico e = new Electrodomestico();
			e.pintar("BEIGE");
			print_test("Electrodomestico soporta el BEIGE", e.getColor().equals("BEIGE"));
			if(e.getColor().equals("BEIGE"))nota+=0.5;
			
		} catch (IllegalArgumentException e) {
			print_test("Pruebo un electrodomestico nuevo, con el cambio de tabla 220V -E", false);
		}

    }
    
    @Test
    public void test08ComprueboConstructorPorDefectoHorno(){
    	System.out.println("Test 8 - Valor: 1 ptos");
    	HornoElectrico e = new HornoElectrico();
    	boolean condition = e.getPrecioBase() == 800 && e.getColor().equals("BEIGE") && e.getConsumoElectrico().equals("E") && e.getPeso() == 5 && e.getVoltaje() == 220 && e.getCalorias()==1000;
		print_test("Nuevo Hornito usando el constructor por defecto", condition);
		if(condition)nota+=1;
    }
    
    @Test
    public void test09ComprueboConstructorReducidoHorno(){
    	System.out.println("Test 9 - Valor: 2 ptos");
    	HornoElectrico e = new HornoElectrico(1200,2000);
    	boolean condition = e.getPrecioBase() == 1200 && e.getColor().equals("BEIGE") && e.getConsumoElectrico().equals("E") && e.getPeso() == 5 && e.getVoltaje() == 220 && e.getCalorias()==2000;
		print_test("Nuevo Hornito usando el constructor por defecto", condition);
		if(condition)nota+=2;
     	
    	

    }
    
    @Test
    public void test10ComprueboIntentarCalentar(){
    	System.out.println("Test 10 - Valor: 2 ptos");
    	HornoElectrico h = new HornoElectrico();
    	boolean condition = h.puedoCalentar(500) && !h.puedoCalentar(2000);
    	print_test("Intento Calentar en un hornito de 1000 cal, 500 y puedo, 2000 y no puedo",condition);
    	if (condition) nota+=2;
    	

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