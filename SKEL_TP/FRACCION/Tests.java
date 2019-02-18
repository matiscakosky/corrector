

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Matias on 18/02/2019.
 */


public class Tests {
	@Test
	public void test01PruebaDelConstructor(){
		Fraccion f= new Fraccion(10,1);
		print_test("Compruebo que el constructor me devuelva un objeto Fraccion",f != null);
		assertTrue(f != null);
	}
	
	@Test
	public void test01bisPruebaDelConstructorConCeroEnElDenominador(){
		try{
			Fraccion f1= new Fraccion(1,0);
			print_test("Creo una fraccion invalida y el constructor debe fallar", f1==null);
			assertTrue(f1==null);
		}
		catch(IllegalArgumentException e){
			print_test("Creo una fraccion invalida y el constructor debe fallar", true);
		}

	}
	
	
	@Test
	public void test02CreoDosFraccionesYComprueboQueSeanIguales(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,2);
		print_test("Creo dos fracciones y son iguales",f1.es_igual(f2));
		assertTrue(f1.es_igual(f2));
	}
	
	@Test
	public void test02bisCreoDosFraccionesYComprueboQueSeanIgualesConSigno(){
		Fraccion f1= new Fraccion(-1,-2);
		Fraccion f2= new Fraccion(1,2);
		print_test("Creo dos fracciones y son iguales, una de las dos tiene ambos argumentos negativos",f1.es_igual(f2));
		assertTrue(f1.es_igual(f2));
	}
	
	@Test
	public void test03CreoDosFraccionesYComprueboQueSeanIgualesConSigno(){
		Fraccion f1= new Fraccion(1,-2);
		Fraccion f2= new Fraccion(-1,2);
		print_test("Dos fracciones iguales, al crear una tiene el signo en el numerador, y la otra en el denominador, deben ser iguales",f1.es_igual(f2));
		assertTrue(f1.es_igual(f2));
	}
	
	@Test
	public void test03CreoDosFraccionesYComprueboQueSeanDiferentesReferencias(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,2);
		print_test("Creo dos fracciones y son diferentes referencias de memoria", f1!=f2);
		assertTrue(f1!=f2);
	}
	
	@Test
	public void test04CreoDosFraccionesDiferentes(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,3);
		print_test("Creo dos fracciones y son diferentes y es_igual da False", !f1.es_igual(f2));
		assertTrue(!f1.es_igual(f2));
	}

	@Test
	public void test05ComprueboQueImprimaBienLaFraccionPorPantalla(){
		Fraccion f1= new Fraccion(1,2);
		print_test("Creo una fraccion y sale por pantalla bien", f1.toString().contentEquals("1/2"));
		assertTrue(f1.toString().contentEquals("1/2"));
	}

	@Test
	public void test06CreoUnaFraccionYLaSimplifico(){
		Fraccion f1= new Fraccion(2,4);
		print_test("Simplifico una fraccion chica par", f1.es_igual(new Fraccion(1,2)));
		assertTrue(f1.es_igual(new Fraccion(1,2)));
	}
	
	@Test
	public void test07CreoUnaFraccionYLaSimplificoImpar(){
		Fraccion f1= new Fraccion(7,21);
		print_test("Simplifico una fraccion chica impar", f1.es_igual(new Fraccion(1,3)));
		assertTrue(f1.es_igual(new Fraccion(1,3)));
	}
	
	@Test
	public void test08CreoUnaFraccionGrandeYLaSimplifico(){
		Fraccion f1= new Fraccion(128992,220);
		print_test("Simplifico una fraccion con numeros grandes", f1.es_igual(new Fraccion(32248,55)));
		assertTrue(f1.es_igual(new Fraccion(32248,55)));
	}
	
	@Test
	public void test09CreoUnaFraccionYSimplificoConCeroEnElNumerador(){
		Fraccion f1= new Fraccion(0,220);
		print_test("Simplifico una fraccion con numeros ceros en el numerador", f1.es_igual(new Fraccion(0,1)));
		assertTrue(f1.es_igual(new Fraccion(0,1)));
	}
	
	@Test
	public void test10CreoUnaFraccionYSimplificoConVariasInstanciasDeSimplificacion(){
		Fraccion f1= new Fraccion(636,12);
		print_test("Simplifico una fraccion con varios instancias de simplificacion", f1.es_igual(new Fraccion(53,1)));
		assertTrue(f1.es_igual(new Fraccion(53,1)));
	}
	
	@Test
	public void test11CreoUnaFraccionYSimplificoConDenominadorGrande(){
		Fraccion f1= new Fraccion(27,19683);
		print_test("Simplifico una fraccion con denominador grande", f1.es_igual(new Fraccion(1,729)));
		assertTrue(f1.es_igual(new Fraccion(1,729)));
	}
	
	@Test
	public void test11CreoUnaFraccionYaSimplificada(){
		Fraccion f1= new Fraccion(127,59);
		print_test("Creo una fraccion ya simplificada", f1.es_igual(new Fraccion(127,59)));
		assertTrue(f1.es_igual(new Fraccion(127,59)));
	}
	
	@Test
	public void test12CreoDosFraccionesYLasSumoEnUnEntero(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,2);
		f1=f1.sumar(f2);
		Fraccion ftest= new Fraccion(1,1);
		print_test("Creo dos fracciones y las sumo, el resultado es entero", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	
	@Test
	public void test13CreoDosFraccionesYLasSumoEnFraccion(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,3);
		f1=f1.sumar(f2);
		Fraccion ftest= new Fraccion(5,6);
		print_test("Creo dos fracciones y las sumo, el resultado es fraccional simplificado", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test14CreoDosFraccionesYLasSumoEnFraccionNoSimplificada(){
		Fraccion f1= new Fraccion(17,18);
		Fraccion f2= new Fraccion(17,19);
		f1=f1.sumar(f2);
		Fraccion ftest= new Fraccion(629,342);
		print_test("Creo dos fracciones y las sumo, el resultado es fraccional y lo debe simplificar bien", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test15SumoLaFraccionCeroDebeQuedarIgual(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(0,1800000);
		f1=f1.sumar(f2);
		Fraccion ftest= new Fraccion(1,2);
		print_test("A una fraccion le sumo otra con cero en el numerador, debe quedar igual a la fraccion primera", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test16CreoDosFraccionesYLasRestoEnUnEntero(){
		Fraccion f1= new Fraccion(3,2);
		Fraccion f2= new Fraccion(1,2);
		f1=f1.restar(f2);
		Fraccion ftest= new Fraccion(1,1);
		print_test("Creo dos fracciones y las sumo, el resultado es entero", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	
	@Test
	public void test18CreoDosFraccionesYLasRestoEnFraccion(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,3);
		f1=f1.restar(f2);
		Fraccion ftest= new Fraccion(1,6);
		print_test("Creo dos fracciones y las resto, el resultado es fraccional simplificado", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test19CreoDosFraccionesYLasRestoEnFraccionNoSimplificada(){
		Fraccion f1= new Fraccion(17,18);
		Fraccion f2= new Fraccion(17,19);
		f1=f1.restar(f2);
		Fraccion ftest= new Fraccion(17,342);
		print_test("Creo dos fracciones y las resto, el resultado es fraccional y lo debe simplificar bien", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test20RestoLaFraccionCeroDebeQuedarIgual(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(0,1800000);
		f1=f1.restar(f2);
		Fraccion ftest= new Fraccion(1,2);
		print_test("A una fraccion le resto otra con cero en el numerador, debe quedar igual a la fraccion primera", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test17integracionSumarYRestar(){
		System.out.println("Prueba de integracion restar una fraccion negativa debe ser lo mismo que sumar");
		Fraccion f1= new Fraccion(-1,2);
		Fraccion f2= new Fraccion(1,2);
		Fraccion f3 =f2.restar(f1);
		Fraccion f4 =f2.sumar(f2);
		Fraccion ftest= new Fraccion(1,1);
		print_test("1/2 - -1/2 = 1", f3.es_igual(ftest));
		assertTrue(f3.es_igual(ftest));
		print_test("1/2 + 1/2 = 1", f4.es_igual(ftest));
		assertTrue(f4.es_igual(ftest));
	}
	
	@Test
	public void test21SumarVolumen(){
		Fraccion f1= new Fraccion(1,3);
		for (int i=1;i<10001;i++){
			f1=f1.sumar(new Fraccion(i,i*3));
		}
		Fraccion ftest= new Fraccion(10001,3);
		print_test("Sumo 10.000 veces 1/3 a 1/3", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test22RestarVolumen(){
		Fraccion f1= new Fraccion(1,3);
		for (int i=1;i<10001;i++){
			f1=f1.restar(new Fraccion(i,i*3));
		}
		Fraccion ftest= new Fraccion(-3333,1);
		print_test("Resto 10.000 veces 1/3 a 1/3", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test23CreoDosFraccionesYLasMultiplicoEnFraccion(){
		Fraccion f1= new Fraccion(3,2);
		Fraccion f2= new Fraccion(1,2);
		f1=f1.multiplicar(f2);
		Fraccion ftest= new Fraccion(3,4);
		print_test("Creo dos fracciones y las multiplico, el resultado es una fraccion simplificada", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test24CreoDosFraccionesYLasMultiplicoEnEntero(){
		Fraccion f1= new Fraccion(2,5);
		Fraccion f2= new Fraccion(5,2);
		f1=f1.multiplicar(f2);
		Fraccion ftest= new Fraccion(1,1);
		print_test("Creo dos fracciones y las multiplico, el resultado es un entero", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test25CreoDosFraccionesYLasMultiplicoEnFraccionNoSimplificada(){
		Fraccion f1= new Fraccion(21,4);
		Fraccion f2= new Fraccion(8,17);
		f1=f1.multiplicar(f2);
		Fraccion ftest= new Fraccion(42,17);
		print_test("Creo dos fracciones y las multiplico, el resultado es una fraccion sin simplificar", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test26DividoDosFraccionesElResultadoEsEntero(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,2);
		f1=f1.dividir(f2);
		Fraccion ftest= new Fraccion(1,1);
		print_test("Divido dos fracciones, el resultado es entero", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test27DividoDosFraccionesElResultadoEsFraccion(){
		Fraccion f1= new Fraccion(1,2);
		Fraccion f2= new Fraccion(1,3);
		f1=f1.dividir(f2);
		Fraccion ftest= new Fraccion(3,2);
		print_test("Divido dos fracciones, el resultado es fraccion simplificada", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test28DividoDosFraccionesGrandesElResultadoEsFraccion(){
		Fraccion f1= new Fraccion(128,257);
		Fraccion f2= new Fraccion(1001,303);
		f1=f1.dividir(f2);
		Fraccion ftest= new Fraccion(38784,257257);
		print_test("Divido dos fracciones grandes, el resultado es fraccion simplificada", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
	}
	
	@Test
	public void test28DividoDosFraccionesNegativasElResultadoEsFraccion(){
		Fraccion f1= new Fraccion(-1,-7);
		Fraccion f2= new Fraccion(1,7);
		f1=f1.dividir(f2);
		Fraccion ftest= new Fraccion(1,1);
		System.out.println(f1);
		print_test("Divido dos fracciones iguales, una de doble arg. negativo, el resultado es 1", f1.es_igual(ftest));
		assertTrue(f1.es_igual(ftest));
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
