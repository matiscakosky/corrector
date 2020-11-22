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
    public void test01ComprueboQueLasBandasImplementenABandan() {
    	System.out.println("Test 1 - Valor: 0.5 pto");
    	TheBeatles tb = new TheBeatles();
    	ACDC a = new ACDC();
    	boolean condition = a instanceof Banda && tb instanceof Banda;
    	print_test("TheBeatles y ACDC implementan correctamente a Banda",condition);
    	if(condition) nota+=0.5;

    }

    @Test
    public void test02ComprueboReproducirTheBeatles() {
    	System.out.println("Test 2 - Valor: 0.5 pto");
    	TheBeatles tb = new TheBeatles();
    	ACDC a = new ACDC();
    	String s1 = tb.reproducir();
    	String s2 = a.reproducir();
    	boolean condition = s1.equals("Suena TheBeatles") && s2.contentEquals("Suena ACDC");
    	print_test("Los metodos de reproducir de TheBeatles y ACDC funcionan correctamente",condition);
    	if(condition) nota+=0.5;

    }

    @Test
    public void test03ComprueboLaException(){
    	System.out.println("Test 3 - Valor: 0.5 pto");
    	String s = "Compruebo reproducirTodas con una lista vacia, lanza correctamente la exception";
    	try {
    		ArrayList<Banda> bandas = new ArrayList<Banda>();
    		String testString = Concierto.reproducirTodas(bandas);   
    		print_test(s, false);
						
		} catch (NoHayBandasException e) {
			print_test(s, true);
			nota+=0.5;

		}
    }
    
    
    @Test
    public void test04ComprueborReproducirTodas(){
    	System.out.println("Test 4 - Valor: 1 pto");
    	ArrayList<Banda> bandas = new ArrayList<Banda>();
    	ACDC a =new ACDC();
    	TheBeatles tb = new TheBeatles();
    	bandas.add(a);
    	bandas.add(tb);
    	String testString = Concierto.reproducirTodas(bandas);
    	
    	boolean condition = testString.equals(a.reproducir() + tb.reproducir());
    	print_test("Agrego bandas al concierto y las reproduzco a todas, funciona correctamente",condition);
    	if(condition) nota+=1;
    }
    
    @Test
    public void test05ComprueboAgregarUnaBandaDesconocida(){
    	System.out.println("Test 5 - Valor: 1 pto");
    	ArrayList<Banda> bandas = new ArrayList<Banda>();
    	ACDC a =new ACDC();
    	TheBeatles tb = new TheBeatles();
    	Marama m = new Marama();
    	bandas.add(a);
    	bandas.add(tb);
    	bandas.add(m);
    	
    	String testString = Concierto.reproducirTodas(bandas);
    	
    	boolean condition = testString.equals(a.reproducir() + tb.reproducir() + m.reproducir());
    	print_test("Agrego una banda nueva, desconocida para la consigna, funciona tambien",condition);
    	if(condition)nota+=1;


    }
    
    @Test
    public void test06DataBaseFuncionaImplementandoLaInterfaz(){
    	System.out.println("Test 6 - Valor: 1 pto");
    	DataBaseService db = new DataBaseService();
    	db.abrirConexion();
    	boolean condition = db.successful() == (db.conectado && db.consultado && db.procesado);
    	print_test("La dataBase funciona mediante los metodos de la interfaz",condition==true);
    	if(condition==true)nota+=1;


    }
    
    
    @Test
    public void test07AmbosServiciosImplementanAConexion(){
    	System.out.println("Test 7 - Valor: 0.5 pto");
    	DataBaseService db = new DataBaseService();
    	APIService a = new APIService();
    	boolean condition = db instanceof Conexion && a instanceof Conexion;
    	print_test("Los servicios implementan correctamente a Conexion",condition);
    	if(condition) nota+=0.5;


    }
    
    @Test
    public void test08ComprueboAPIServiceFuncionaBienConLaInterfaz(){
    	System.out.println("Test 8 - Valor: 1 ptos");
    	APIService a = new APIService();
    	a.abrirConexion();
    	boolean condition = a.successful() == (a.response && a.trafic && a.generatedToken);
    	print_test("La APIService funciona mediante los metodos de la interfaz",condition==true);
    	if(condition==true)nota+=1;

    }
    
    @Test
    public void test09ComprueboClaseAccesoADatos(){
    	System.out.println("Test 9 - Valor: 2 ptos");
    	DataBaseService db = new DataBaseService();
    	AccesoADatos ad1 = new AccesoADatos(db);
    	boolean a1 = ad1.obtenerAccesoAlServicio();
    	a1 = a1 && (db.conectado && db.consultado && db.procesado);
    	print_test("Clase AccesoADatos funciona con DataBase",a1==true);
    	
    	
    	APIService a = new APIService();
    	AccesoADatos ad2= new AccesoADatos(a);
    	boolean a2 = ad2.obtenerAccesoAlServicio();
    	a.response=false;
    	
    	print_test("Rompo encapsulamiento de API service, falla el acceso a datos",a2 == !a.successful());
    	
    	boolean condition = a1 && a2;
    	if (condition) nota+=2;

    	

    }
    
    @Test
    public void test10AgregoCloudService(){
    	System.out.println("Test 10 - Valor: 2 ptos");
    	CloudService c = new CloudService();
    	AccesoADatos ad1 = new AccesoADatos(c);
    	boolean a1 = ad1.obtenerAccesoAlServicio();
    	a1 = a1 && (c.a1&& c.a2 && c.a3);
    	print_test("Clase AccesoADatos funciona con DataBase",a1==true);
    	if (a1) nota+=2;

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
