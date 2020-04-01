import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
	
	
	@Test
	public void test01creoUnaPilaDeUnElemento(){
		new Pila(1);
		print_test("Se creo la pila correctamente", true);
	}
	
	@Test
	public void test02creoUnaPilaDePocosElementosYApiloMenosComprueboLongitud(){
		Pila p = new Pila(5);
		p.apilar(1);
		p.apilar(2);
		p.apilar(3);
		boolean condition = p.longitud() == 3;
		print_test("Creo una pila chica, apilo algunos elementos y compruebo su tamanio", condition);
	}
	
	@Test
	public void test03creoUnaPilaDePocosElementosYApiloMenosComprueboTope(){
		Pila p = new Pila(5);
		p.apilar(1);
		p.apilar(2);
		p.apilar(3);
		boolean condition = p.verTope() == 3;
		print_test("Creo una pila chica, apilo algunos elementos y compruebo el tope", condition);
	}
	
	@Test
	public void test04creoUnaPilaDePocosElementosYApiloMenosComprueboDesapilar(){
		Pila p = new Pila(5);
		p.apilar(1);
		p.apilar(2);
		p.apilar(3);
		boolean condition = p.desapilar() == 3;
		print_test("Creo una pila chica, apilo algunos elementos y compruebo desapilar", condition);
	}
	
	@Test
	public void test04creoUnaPilaVaciaComprueboTope(){
		Pila p = new Pila(5);
		boolean condition = p.verTope() == -1;
		print_test("Creo una pila vacia, compruebo el tope", condition);
	}
	
	@Test
	public void test05creoUnaPilaVaciaComprueboDesapilar(){
		Pila p = new Pila(5);
		boolean condition = p.desapilar() == -1;
		print_test("Creo una pila vacia, compruebo el desapilar", condition);
	}
	
	@Test
	public void test06creoUnaPilaApiloTodosLosElementosAlMaximoComprueboElTope(){
		Pila p = new Pila(20);
		for (int i = 0; i < 20; i++) {
			p.apilar(i);
		}
		boolean condition = p.verTope() == 19;
		print_test("Compruebo tope despues de apilar al maximo los elementos", condition);
	}
	@Test
	public void test07creoUnaPilaApiloTodosLosElementosAlMaximoComprueboDesapilar(){
		Pila p = new Pila(20);
		for (int i = 0; i < 20; i++) {
			p.apilar(i);
		}
		boolean condition = p.desapilar() == 19;
		print_test("Compruebo desapilar despues de apilar al maximo los elementos", condition);
	}
	
	@Test
	public void test08creoUnaPilaApiloTodosLosElementosAlMaximoComprueboTopeLuegoDeDesapilar(){
		Pila p = new Pila(20);
		for (int i = 0; i < 20; i++) {
			p.apilar(i);
		}
		p.desapilar();
		boolean condition = p.verTope() == 18;
		print_test("Compruebo tope despues de apilar al maximo los elementos y desapilar uno", condition);
	}
	
	@Test
	public void test10creoUnaPilaApiloTodosLosElementosAlMaximoDesapiloYComprueboLongitud(){
		Pila p = new Pila(20);
		for (int i = 0; i < 20; i++) {
			p.apilar(i);
		}
		p.desapilar();
		boolean condition = p.longitud() == 19;
		print_test("Compruebo longitud despues de apilar al maximo los elementos y desapilar " , condition);
	}
	
	@Test
	public void test11creoUnaPilaApiloTodosLosYComprueboMientrasDesapiloTodos(){
		int MAX= 30;
		Pila p = new Pila(MAX);
		boolean condition = true;
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);
		}
		
		for (int i = MAX-1; i < -1; i++) {
			int desapilado = p.desapilar();
			if (desapilado != i) condition = false;
		}
		
		print_test("Creo una pila pequeña y apilo todos los elementos al maximo, desapilo todos y compruebo el orden", condition);
	}
	
	@Test
	public void test12creoUnaPilaApiloTodosLosYComprueboEnCadaIteracionSuLongitud(){
		int MAX= 20;
		Pila p = new Pila(MAX);
		boolean condition = p.longitud()==0;
		for (int i = 0; i < MAX; i++) {
			condition= condition && p.longitud()==i;
			print_test("Apilo el elemento "+i+" fue correctamente apilado",condition);
			p.apilar(i);			
		}
		for (int i = MAX-1; i > -1; i--) {
			condition= condition && p.longitud()==i+1;
			print_test("Desapilo el elemento "+i+" fue correctamente desapilado",condition);
			p.desapilar();
		}
		condition = condition && p.longitud() == 0;
		print_test("Creo una pila pequeña y apilo todos los elementos al maximo, desapilo todos, compruebo que la longitud sea correcta en cada iteracion y vacia al final", condition);
	}
	
	
	@Test
	public void test13creoUnaPilaApiloVolumenYComprueboMientrasDesapiloTodos(){
		int MAX= 5000;
		Pila p = new Pila(MAX);
		boolean condition = true;
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);
		}
		
		for (int i = MAX-1; i < -1; i++) {
			int desapilado = p.desapilar();
			if (desapilado != i) condition = false;
		}
		
		print_test("Prueba de volumen, desapilo todos y compruebo el orden", condition);
	}
	
	@Test
	public void test14creoUnaPilaApiloVolumenYComprueboLongitud(){
		int MAX= 5000;
		Pila p = new Pila(MAX);
		boolean condition = p.longitud()==0;
		for (int i = 0; i < MAX; i++) {
			condition= condition && p.longitud()==i;
			p.apilar(i);			
		}
		for (int i = MAX-1; i < -1; i++) {
			condition= condition && p.longitud()==i;
			p.desapilar();
		}
		
		print_test("Prueba de volumen, desapilo todos y compruebo longitud", condition);
	}
	
	
	@Test
	public void test15DuplicoLongPilaSePuede(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		boolean succes = p.duplicar();
		
		print_test("Duplico longitud de pila al llenarla", succes);
	}
	
	@Test
	public void test16DuplicoLongPilaNoSePuede(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX-1; i++) {
			p.apilar(i);			
		}
		boolean succes = p.duplicar();
		
		print_test("Duplico longitud de pila sin llenarla, debe fallar", !succes);
	}
	
	
	@Test
	public void test17DuplicoLongPilaYLaLlenoComprueboLongitud(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		boolean succes = p.duplicar();
		for (int i = MAX; i < 2*MAX; i++) {
			p.apilar(i);			
		}
		boolean condition = p.longitud() == 2*MAX;
		print_test("Duplico y compruebo longitud de pila al llenarla", condition);
	}
	
	@Test
	public void test18DuplicoLongPilaYLaLlenoComprueboTope(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		p.duplicar();
		for (int i = MAX; i < 2*MAX; i++) {
			p.apilar(i);			
		}
		boolean condition = p.verTope() == 2*MAX-1;
		print_test("Duplico longitud de pila al llenarla compruebo el tope", condition);
	}
	
	
	@Test
	public void test19creoUnaPilaApiloVolumenYComprueboVaciaConElTope(){
		int MAX= 5000;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		for (int i = MAX-1; i > -1; i--) {
			p.desapilar();
		}
		boolean condition = p.verTope()==-1;
		print_test("Prueba de volumen, desapilo todos y tope devuelve -1 ", condition);
	}
	
	@Test
	public void test21contieneConPocosElementos(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 1; i <= MAX; i++) {
			p.apilar(i);			
		}
		boolean succes = p.contiene(3);
		print_test("Creo pila y apilo 5 elementos, contiene el 3", succes);
	}
	
	@Test
	public void test22contieneActualizaTopeConPocosElementos(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 1; i <= MAX; i++) {
			p.apilar(i);			
		}
		p.contiene(3);
		boolean condition = p.verTope() == 3;
		print_test("Creo pila y apilo 5 elementos, contiene actualiza bien el tope", condition);
	}
	
	@Test
	public void test23contieneActualizaLongitudConPocosElementos(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 1; i <= MAX; i++) {
			p.apilar(i);			
		}
		p.contiene(3);
		boolean condition = p.longitud() == 3;
		print_test("Creo pila y apilo 5 elementos, contiene actualiza bien longitud", condition);
	}
	
	@Test
	public void test24contieneConVolumen(){
		int MAX= 50000;
		Pila p = new Pila(MAX);
		for (int i = 1; i <= MAX; i++) {
			p.apilar(i);			
		}
		boolean succes = p.contiene(3);
		print_test("Creo pila y apilo 50000 elementos, contiene funciona", succes);
	}
	
	@Test
	public void test25contieneConVolumen(){
		int MAX= 100;
		int trap = 75;
		Pila p = new Pila(MAX);
		for (int i = 1; i <= MAX; i++) {
			if (i==trap)continue;
			p.apilar(i);			
		}
		boolean succes = p.contiene(trap);
		print_test("Creo pila y apilo varios elementos con elemento trampa, contiene devuelve false", !succes);
	}
	
		
	@Test
	public void test26ApiloNegativo(){
		int MAX= 100;
		Pila p = new Pila(MAX);
		for (int i = 1; i <= MAX; i++) {
			p.apilar(-1*i);			
		}
		boolean condition = p.longitud() == 0;
		print_test("Creo pila y apilo varios elementos negativos, sigue vacia", condition);
	}
	
	@Test
	public void test27ApiloNegativosComprueboTope(){
		int MAX= 100;
		Pila p = new Pila(MAX);
		for (int i = 1; i <= MAX; i++) {
			p.apilar(-1*i);			
		}
		boolean condition = p.verTope() == -1;
		print_test("Creo pila y apilo varios elementos negativos, tope correcto", condition);
	}
	
	@Test
	public void test28actualizoMaximoAlDuplicar(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		boolean succes = p.duplicar();
		for (int i = MAX; i < 2*MAX; i++) {
			p.apilar(i);			
		}
		succes = succes && p.duplicar();
		for (int i = 2*MAX; i < 4*MAX; i++) {
			p.apilar(i);			
		}
		succes = succes && p.duplicar();
		
		print_test("El maximo de la lista se actualiza al duplicar", succes);
	}
	
	@Test
	public void test29actualizoMaximoAlDuplicarComprueboLongitud(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		p.duplicar();
		for (int i = MAX; i < 2*MAX; i++) {
			p.apilar(i);			
		}
		p.duplicar();
		for (int i = 2*MAX; i < 4*MAX; i++) {
			p.apilar(i);			
		}
		boolean condition = p.longitud() == 4*MAX;
		
		print_test("Duplicar varias veces y llenar pila, longitud correcta", condition);
	}
	
	@Test
	public void test30actualizoMaximoAlDuplicarComprueboTope(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		p.duplicar();
		for (int i = MAX; i < 2*MAX; i++) {
			p.apilar(i);			
		}
		p.duplicar();
		for (int i = 2*MAX; i < 4*MAX; i++) {
			p.apilar(i);			
		}
		boolean condition = p.verTope() == 4*MAX - 1;
		
		print_test("Duplicar varias veces y llenar pila, tope correcto", condition);
	}
	
	@Test
	public void test30actualizoMaximoAlDuplicarComprueboDesapilar(){
		int MAX= 5;
		Pila p = new Pila(MAX);
		for (int i = 0; i < MAX; i++) {
			p.apilar(i);			
		}
		p.duplicar();
		for (int i = MAX; i < 2*MAX; i++) {
			p.apilar(i);			
		}
		p.duplicar();
		for (int i = 2*MAX; i < 4*MAX; i++) {
			p.apilar(i);			
		}
		p.desapilar();
		boolean condition = p.verTope() == 4*MAX - 2;
		
		print_test("Duplicar varias veces y llenar pila luego desapilar, tope correcto", condition);
	}
	 
	public void print_test(String msg, boolean ok) {
		System.out.flush();
		String res = ok ? "OK":"ERROR";
		System.out.printf("%s...%s \n", msg, res);
		assertTrue(ok);
	}
}