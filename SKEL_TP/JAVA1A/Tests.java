	
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
    public void test01CrearNuevoContacto() {
    	System.out.println("Test 1 - Valor: 0.5 pto");
    	int ntel=15;
    	String ncont="Matias";
        Contacto c = new Contacto(ncont,ntel);
        print_test("Creo un contacto nuevo, nombre correcto: ", c.getNombre()==ncont);
        assertTrue(c.getNombre()==ncont);
        print_test("Creo un contacto nuevo, nombre correcto: ",c.getNumero()==ntel);
        assertTrue(c.getNumero()==ntel);
        if(c.getNumero()==ntel && c.getNombre()==ncont){nota+=0.5;}

    }

    @Test
    public void test02CreaoDosContactosConMismoNombreDebeFallar() {
    	System.out.println("Test 2 - Valor: 1 pto");
        Contacto c1 = new Contacto("Matias",155345);
        Contacto c2 = new Contacto("Matias",155346);
        try {
            Agenda a = new Agenda(2);
            a.agregarContacto(c1);
            a.agregarContacto(c2);
            print_test("Creo una agenda con nombre repetido: ",false);
            assertTrue(false);
        }
        catch (IllegalArgumentException e){
            print_test("Creo una agenda con nombre repetido: ",true);
            nota+=1;
        }

    }

    @Test
    public void test03CreoAgendaCon2ContactosFallaPorExcederLaCapacidad(){
    	System.out.println("Test 3 - Valor: 1 pto");
        try {
            Agenda a = new Agenda(1);
            a.agregarContacto(new Contacto("Matias",155312));
            a.agregarContacto(new Contacto("Andres",155312));
            print_test("Creo una agenda con capacidad excedida: ",false);
            assertTrue(false);
        }
        catch (IllegalArgumentException e){
            print_test("Creo una agenda con capacidad excedida: ",true);
            nota+=1;
        }
    }
    
    
    @Test
    public void test04BuscoUnContactoExistente(){
    	System.out.println("Test 4 - Valor: 0.5 pto");
    	String buscado="Andres";
    	int nBuscado=155312;
        Agenda a = new Agenda(10);
        a.agregarContacto(new Contacto("Matias",1555));
        a.agregarContacto(new Contacto(buscado,nBuscado));
        Contacto c = a.buscar(buscado);
        print_test("Agrego un contacto nuevo a la agenda y lo busco, el numero es el que corresponde", c.getNumero()==nBuscado);
        if(c.getNumero()==nBuscado) nota+=0.5;
        assertTrue(c.getNumero()==nBuscado);
    }
    
    @Test
    public void test05BuscoUnContactoIxistenteDebeSerNulo(){
    	System.out.println("Test 5 - Valor: 1 pto");
    	String buscado="Joaquin";
        Agenda a = new Agenda(10);
        a.agregarContacto(new Contacto("Matias",1555));
        Contacto c = a.buscar(buscado);
        print_test("Busco contacto inexsistente en la agenda", c==null);
        if( c==null) nota+=1;
        assertTrue( c==null);
    }
    
    @Test
    public void test06ComprueboLaAgendaCompleta(){
    	System.out.println("Test 6 - Valor: 0.5 pto");
        Agenda a = new Agenda(100);
        Agenda b = new Agenda(101);
        for (int i = 0; i < 100; i++) {
			a.agregarContacto(new Contacto("c"+i,i));
			b.agregarContacto(new Contacto("c"+i,i));
		}
        print_test("Completo la capacidad de la agenda A pero no la de agenda B", a.estaCompleta() && !b.estaCompleta());
        if(a.estaCompleta() && !b.estaCompleta()) nota+=0.5;
        assertTrue( a.estaCompleta() && !b.estaCompleta());
    }
    
    
    @Test
    public void test07EliminoAUnContactoDeMiAgenda(){
    	System.out.println("Test 7 - Valor: 0.5 pto");
        Agenda a = new Agenda(100);
        a.agregarContacto(new Contacto("Ruben", 12));
        if(a.existeContacto("Ruben")){
        	a.eliminarContacto("Ruben");
        	print_test("Agrego contacto y chequeo que este en la agenda, luego lo borro y vuelvo a chequear", !a.existeContacto("Ruben"));
            if(!a.existeContacto("Ruben")) nota+=0.5;
            assertTrue(!a.existeContacto("Ruben"));
            return;
        }
        print_test("Agrego contacto y chequeo que este en la agenda, luego lo borro y vuelvo a chequear", false);
        assertTrue(false);
    }
    
    @Test
    public void test08IntegracionEliminoTodosLosContactosDeLaAgenda(){
    	System.out.println("Test 8 - Valor: 1 ptos");
        Agenda a = new Agenda(101);
        Agenda b = new Agenda(100);
        for (int i = 0; i < 100; i++) {
			a.agregarContacto(new Contacto(String.valueOf(i),i));
			b.agregarContacto(new Contacto(String.valueOf(i),i));
		}
        a.agregarContacto(new Contacto("Ruben", 12));
        for (int i = 0; i < 100; i++) {
			a.eliminarContacto(String.valueOf(i));
			b.eliminarContacto(String.valueOf(i));
		}
        boolean final_condition=!a.estaCompleta() && a.existeContacto("Ruben") && b.buscar("c1")==null && !b.existeContacto("Ruben");
        print_test("Test de integracion: Prueba varias funcionalidades al mismo tiempo", final_condition );
        if(final_condition){nota+=1;}
        assertTrue(final_condition);
    }
    
    @Test
    public void test09PrueboUnaListaDeUnaSolaFraccionAlCuadrado(){
    	System.out.println("Test 9 - Valor: 2 ptos");
    	Fraccion f = new Fraccion(1,5);
    	ArrayList<Fraccion> lista = new ArrayList<Fraccion>();
    	lista.add(f);
    	Fraccion resultado = Fraccion.sumatoriaDeFraccionesCuadradas(lista);
    	boolean condition=resultado.es_igual(new Fraccion(1,25));
    	if(condition){nota+=2;}
    	print_test("Sumo una lista de una sola fraccion al cuadrado el resultado es correcto",condition );
    	assertTrue(condition);
    }
    
    @Test
    public void test10PrueboUnaListaVariasFraccionesAlCuadrado(){
    	System.out.println("Test 10 - Valor: 2 ptos");
    	ArrayList<Fraccion> lista = new ArrayList<Fraccion>();
    	for (int i = 1; i < 10; i++) {
			lista.add(new Fraccion(1,i));
		}
    	Fraccion resultado = Fraccion.sumatoriaDeFraccionesCuadradas(lista);
    	boolean condition=resultado.es_igual(new Fraccion(9778141,6350400));
    	print_test("Tomo una lista de varias fracciones al azar y las sumo, el resultado es correcto", condition );
        
    	if(condition){nota+=2;}
    	assertTrue(condition);
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
    }

}
