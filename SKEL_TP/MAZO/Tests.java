	
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class Tests {
	
	@Test
	public void test01ComprueboQueAlCrearUnaCartaSeMuestreCorrectamente(){
		Carta c = new Carta(1,"ESPADA");
		print_test("Compruebo que la carta se muestre correctamente", c.toString().contentEquals("1 de ESPADA"));
		
	}
	
	@Test
	public void test01bisCreoDosCartasSonIguales(){
		Carta c1 = new Carta(1,"ESPADA");
		Carta c2 = new Carta(1,"ESPADA");
		print_test("Creo dos cartas iguales", c1.equals(c2));
		
	}

		@Test
	public void test01bisCreoDosCartasDiferentes(){
		Carta c1 = new Carta(1,"ESPADA");
		Carta c2 = new Carta(2,"ESPADA");
		print_test("Creo dos cartas diferentes", !c1.equals(c2));
		
	}
	
	@Test
	public void test02ComprueboQueAlCrearUnaCartaSeMuestreCorrectamente2daPrueba(){
		Carta c = new Carta(10,"ORO");
		print_test("Compruebo que otra carta se muestre correctamente", c.toString().contentEquals("10 de ORO"));
	}
	
	@Test
	public void test03CreoUnaCartaInvalidaDebeFallarPorNumero8(){
		try {
			Carta c = new Carta(8,"ORO");
			print_test("Creo una carta invalida, palo invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, debe fallar, numero 8", true);
		}
	}
	
	@Test
	public void test04CreoUnaCartaInvalidaDebeFallarPorNumero9(){
		try {
			Carta c = new Carta(9,"ORO");
			print_test("Creo una carta invalida, palo invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, numero 9, debe fallar", true);
		}
	}
	
	@Test
	public void test05CreoUnaCartaInvalidaDebeFallarPorNumeroNegativo(){
		try {
			Carta c = new Carta(-9,"ORO");
			print_test("Creo una carta invalida, palo invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, numero negativo, debe fallar", true);
		}
	}
	
	@Test
	public void test06CreoLos4Palos(){
		Carta c1 = new Carta(1,"ESPADA");
		Carta c2 = new Carta(1,"ORO");
		Carta c3 = new Carta(1,"BASTO");
		Carta c4 = new Carta(1,"COPA");
		print_test("Creo los 4 palos sin fallar", c1!=null && c2!=null && c3!=null && c4!=null);
		assertTrue(c1!=null && c2!=null && c3!=null && c4!=null);
	}
	
	@Test
	public void test07CreoUnPaloInvalidoDebeFallar(){
		try {
			Carta c = new Carta(10,"PICAS");
			print_test("Creo una carta invalida, palo invalido, debe fallar", false);
				
		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, palo invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test08CreoUnPaloYNumeroInvalidosDebeFallar(){
		try {
			Carta c = new Carta(150,"PICAS");
			print_test("Creo una carta invalida, palo y numero invalidos, debe fallar", false);
				
		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, palo y numero invalidos, debe fallar", true);
		}
	}
	
	@Test
	public void test09CreoUnaNuevaBarajaComprueboQueSeCreeCorrectamente(){
		Mazo m = new Mazo();
		print_test("El mazo no es nulo", m!= null);
		assertTrue(m!= null);
		print_test("La cantidad de cartas del mazo es 40", m.cartas.size() == 40);
		assertTrue(m.cartas.size() == 40);
	}
	
	@Test
	public void test10ComprueboQueBarajeCorrectamenteMostrandolasCartasPorPantalla(){
		Mazo m = new Mazo();
		String s1 = new String();
		for (int i=0; i<m.cartas.size();i++){
			s1 += m.cartas.get(i).toString();
		}
		m.barajar();
		String s2 = new String();
		for (int i=0; i<m.cartas.size();i++){
			s2 += m.cartas.get(i).toString();
		}
		print_test("Muestro el mazo, lo barajo y lo vuelvo a mostrar, es diferente",!s1.contentEquals(s2));
		assertTrue(!s1.contentEquals(s2));
		
	}
	
	@Test
	public void test11BarajoElMazoNoSonIgualesLasPrimeras10Cartas(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=0; i<10;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.barajar();
		l2 = new ArrayList<Carta>();
		for (int i=0; i<10;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las primeras 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}
	
	@Test
	public void test12BarajoElMazoNoSonIgualesLasSegundas10Cartas(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=9; i<20;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.barajar();
		l2 = new ArrayList<Carta>();
		for (int i=9; i<20;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las segundas 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}
	
	@Test
	public void test13BarajoElMazoNoSonIgualesLasTerceras10Cartas(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=19; i<30;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.barajar();
		l2 = new ArrayList<Carta>();
		for (int i=19; i<30;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las terceras 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}
	
	@Test
	public void test14BarajoElMazoNoSonIgualesLasUltimas10Cartas(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=29; i<40;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.barajar();
		l2 = new ArrayList<Carta>();
		for (int i=29; i<40;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las ultimas 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}
	
	@Test
	public void test15SacoUnaCartaEsLaProximaCorrecta(){
		Mazo m = new Mazo();
		m.barajar();
		Carta c1 = m.cartas.get(0);
		Carta c2 = m.proxima();
		print_test("Tomo la primer carta del mazo, es correctamente la del tope",c1.equals(c2));
		assertTrue(c1.equals(c2));
	}
	
	@Test
	public void test16SacoLas40CartasDelMazoDeAUnaConProxima(){
		Mazo m = new Mazo();
		m.barajar();
		for (int i = 0; i < 40; i++) {
			Carta c1 = m.cartas.get(i);
			Carta c2 = m.proxima();
			if (!c1.equals(c2)){
				print_test("Tomo la proxima carta del mazo 40 veces, el mazo nunca pierde cartas",false);
			}
			assertTrue(c1.equals(c2) && m.cartas.size() == 40);
		}

		print_test("Tomo la proxima carta del mazo 40 veces",true);
	}
	
	@Test
	public void test17tomo3Cartas(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = m.darCartas(3);
		for (int i=0; i<3;i++){
			l1.add(m.cartas.get(i));
		}
		print_test("Tomo 3 cartas del principio, son correctas",l1.equals(l2));
		assertTrue(l1.equals(l2));
		
	}
	
	@Test
	public void test18tomo5CartasYBarajoYVuelvoATomar(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = m.darCartas(5);
		for (int i=0; i<5;i++){
			l1.add(m.cartas.get(i));
		}
		print_test("Tomo 3 cartas del principio previo a barajar, son correctas",l1.equals(l2));
		assertTrue(l1.equals(l2));
		m.barajar();
		l1 = new ArrayList<Carta>();
		for (int i=0; i<5;i++){
			l1.add(m.cartas.get(i));
		}
		print_test("Tomo 3 cartas del principio despues de barajar, son diferentes a las primeras",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
		
	}
	
	

	@Test
	public void test19tomo3CartasMeFijoQueNingunaDeEsasSeaLaProximna(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = m.darCartas(3);
		int cont = 1;
		for (Carta c: l1){
			print_test("Tomo carta " + cont + ", no es la proxima",!c.equals(m.proxima()));
			assertTrue(!c.equals(m.proxima()));
			cont++;
		}
		print_test("Tomo 3 cartas del principio, ninguna de esas es la proxima",true);
		
	}
	
	@Test
	public void test20tomo3CartasMeFijoQueNingunaEstaEnElMazo(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = m.darCartas(3);
		for (Carta c: l1){
			for (int i=3;i<40;i++){
				Carta otra = m.cartas.get(i);
				if(c.equals(otra)){
					print_test("Tomo 3 cartas del principio, ninguna de esas quedó en el mazo", false);
				}
				assertTrue(!c.equals(otra));
		
			}
		}
		print_test("Tomo 3 cartas del principio, ninguna de esas quedó en el mazo",true);
	}	
	
	@Test
	public void test21ComprueboElNumerodeCartasARepartir(){
		Mazo m = new Mazo();
		m.barajar();
		for (int i = 0; i <= m.cartas.size(); i++) {
			print_test("Salieron "+ i +" quedan " + (40-i),m.cartasDisponibles()==40-i);
			assertTrue(m.cartasDisponibles()==40-i);
			if (i==40) break;
			m.proxima();
			
		}
		print_test("Compruebo el numero de cartas a repartir",true);
	}	
	
	@Test
	public void test22Saco10CartasJuntasQuedaLasCartasDisponiblesSonCorrectas(){
		Mazo m = new Mazo();
		m.barajar();
		ArrayList<Carta> l1 = m.darCartas(10);
		print_test("Salieron 10 quedan 30",m.cartasDisponibles()==30);
		assertTrue(m.cartasDisponibles()==30);
		print_test("Saco 10 cartas juntas las cartas disponibles son correctas",true);
	}	
	

	@Test
	public void test23tomo3CartasSonLasQueSalieron(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = m.darCartas(3);
		ArrayList<Carta> salieron = m.cualesSalieron();
		int cont=0;
		for (Carta c: salieron){
			for (int i = 0; i <= 3; i++) {
				Carta salio = m.cartas.get(i);
				if (c.equals(salio)) cont++;
			}
		
		}
		print_test("Tomo 3 cartas del principio, son las que salieron",cont==3);
	}
	
	@Test
	public void test23tomo3YSaco2CartasSonLasQueSalieron(){
		Mazo m = new Mazo();
		ArrayList<Carta> l1 = m.darCartas(3);
		m.proxima();
		m.proxima();
		ArrayList<Carta> salieron = m.cualesSalieron();
		int cont=0;
		for (Carta c: salieron){
			for (int i = 0; i <= 5; i++) {
				Carta salio = m.cartas.get(i);
				if (c.equals(salio)) cont++;
			}
		
		}
		print_test("Tomo 3 cartas del principio, saco 2 mas, son las que salieron",cont==5);
		
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
