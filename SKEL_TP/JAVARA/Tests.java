	
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
    public void test01PrueboUnaListaDeUnaSolaFraccionAlCuadrado(){
    	System.out.println("Test 1 - Valor: 2.5 ptos");
    	Fraccion f = new Fraccion(1,5);
    	ArrayList<Fraccion> lista = new ArrayList<Fraccion>();
    	lista.add(f);
    	Fraccion resultado = Fraccion.sumatoriaDeFraccionesCuadradas(lista);
    	boolean condition=resultado.es_igual(new Fraccion(1,25));
    	if(condition){nota+=2.5;}
    	print_test("Sumo una lista de una sola fraccion al cuadrado el resultado es correcto",condition );
    	assertTrue(condition);
    }
    

    @Test
    public void test02PrueboUnaListaDeDosFraccionesAlCuadrado(){
        System.out.println("Test 2 - Valor: 1 pto");
        ArrayList<Fraccion> lista = new ArrayList<Fraccion>();
        for (int i = 0; i < 2; i++) {
            lista.add(new Fraccion(1,2));
        }
        Fraccion resultado = Fraccion.sumatoriaDeFraccionesCuadradas(lista);
        boolean condition=resultado.es_igual(new Fraccion(1,2));
        print_test("Tomo una lista de varias fracciones al azar y las sumo, el resultado es correcto", condition);
        
        if(condition){nota+=1;}
        assertTrue(condition);
    }
    
    
    @Test
    public void test03PrueboUnaListaVariasFraccionesAlCuadrado(){
        System.out.println("Test 3 - Valor: 2.5 ptos");
        ArrayList<Fraccion> lista = new ArrayList<Fraccion>();
        for (int i = 1; i < 10; i++) {
            lista.add(new Fraccion(1,i));
        }
        Fraccion resultado = Fraccion.sumatoriaDeFraccionesCuadradas(lista);
        boolean condition=resultado.es_igual(new Fraccion(9778141,6350400));
        print_test("Tomo una lista de varias fracciones al azar y las sumo, el resultado es correcto", condition );
        
        if(condition){nota+=2.5;}
        assertTrue(condition);
    }


    @Test
    
    public void test04PrueboNormalizarUnVectorDeNormaUnoConUnCero(){
        System.out.println("Test 4 - Valor: 1 ptos");
        Vector v = new Vector(0,1);
        Vector normalizado = v.normalizarVector();
        boolean condition = normalizado.esIgual(new Vector(0,1));
        print_test("Pruebo normalizar un vector normalizado con cero en alguna componente",condition);
        if (condition) nota+=1;
    }

    @Test
    public void test05PrueboNormalizarUnVectorDeNormaUno(){
        System.out.println("Test 5 - Valor: 1 ptos");
        Vector v = new Vector(1.0/Math.sqrt(2),1.0/Math.sqrt(2));
        Vector normalizado = v.normalizarVector();
        boolean condition = normalizado.esIgual(v);
        print_test("Pruebo normalizar un vector ya de norma uno como (1/sqrt(2),1/sqrt(2))",condition);
        if (condition) nota+=1;
    }
    
    @Test
    public void test06PrueboNormalizarElVectorDelEnunciado(){
        System.out.println("Test 6 - Valor: 2 ptos");
        Vector v = new Vector(3.0,4.0);
        Vector normalizado = v.normalizarVector();
        boolean condition = normalizado.esIgual(new Vector(3.0/5,4.0/5));
        print_test("Pruebo normalizar el vector del enunciado",condition);
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
    }

}
