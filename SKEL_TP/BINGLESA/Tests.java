
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class Tests {

	int CANT_CARTAS_MAX = 48;

	@Test
	public void test01ComprueboQueAlCrearUnaCartaSeMuestreCorrectamente(){
		Carta c = new Carta("2","PICA");
		print_test("Compruebo que la carta se muestre correctamente", c.toString().contentEquals("2 de PICA"));

	}

	@Test
	public void test01bisCreoDosCartasSonIguales(){
		Carta c1 = new Carta("AS","PICA");
		Carta c2 = new Carta("AS","PICA");
		print_test("Creo dos cartas iguales", c1.equals(c2));

	}

	@Test
	public void test01bisCreoDosCartasDiferentes(){
		Carta c1 = new Carta("AS","PICA");
		Carta c2 = new Carta("AS","TREBOL");
		print_test("Creo dos cartas diferentes", !c1.equals(c2));

	}

	@Test
	public void test02ComprueboQueAlCrearUnaCartaSeMuestreCorrectamente2daPrueba(){
		Carta c = new Carta("3","DIAMANTE");
		print_test("Compruebo que otra carta se muestre correctamente", c.toString().contentEquals("3 de DIAMANTE"));
	}

	@Test
	public void test03CreoUnaCartaInvalidaDebeFallarPorNumero10(){
		try {
			Carta c = new Carta("10","PICA");
			print_test("Creo una carta invalida, coloco 10 en vez de J, debe fallar", false);

		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, coloco 10 en vez de J, debe fallar", true);
		}
	}

	@Test
	public void test04CreoUnaCartaInvalidaDebeFallarPorPaloInvalido(){
		try {
			Carta c = new Carta("2","ESPADA");
			print_test("Creo una carta invalida, palo invalido, debe fallar", false);

		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, palo invalido, debe fallar", true);
		}
	}

	@Test
	public void test05CreoUnaCartaInvalidaDebeFallarPorNumeroNegativo(){
		try {
			Carta c = new Carta("-9","TREBOL");
			print_test("Creo una carta invalida, numero negativo, debe fallar", false);

		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, numero negativo, debe fallar", true);
		}
	}

	@Test
	public void test06CreoLos4Palos(){
		Carta c1 = new Carta("AS","PICA");
		Carta c2 = new Carta("AS","DIAMANTE");
		Carta c3 = new Carta("AS","TREBOL");
		Carta c4 = new Carta("AS","CORAZON");
		print_test("Creo los 4 palos sin fallar", c1!=null && c2!=null && c3!=null && c4!=null);
		assertTrue(c1!=null && c2!=null && c3!=null && c4!=null);
	}

	@Test
	public void test071CreoUnASconNumeroUnoDebeFallar(){
		try {
			Carta c = new Carta("1","PICAS");
			print_test("Creo una carta invalida, numero 1 en vez de AS, debe fallar", false);

		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, numero 1 en vez de AS, debe fallar", true);
		}
	}


	@Test
	public void test072CreoUnQconNumeroONCEDebeFallar(){
		try {
			Carta c = new Carta("11","PICAS");
			print_test("Creo una carta invalida, numero 11 en vez de Q, debe fallar", false);

		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, numero 11 en vez de Q, debe fallar", true);
		}
	}




		@Test
		public void test073CreoUnKconNumeroDOCEDebeFallar(){
			try {
				Carta c = new Carta("12","PICAS");
				print_test("Creo una carta invalida, numero 12 en vez de K, debe fallar", false);

			} catch (IllegalArgumentException e) {
				print_test("Creo una carta invalida, numero 12 en vez de K, debe fallar", true);
			}
		}


	@Test
	public void test073CreoCartaConNumeroInvalidoRandom(){
			try {
				Carta c = new Carta("1241","PICAS");
				print_test("Creo una carta invalida,numero invalido random", false);

			} catch (IllegalArgumentException e) {
				print_test("Creo una carta invalida,numero invalido random", true);
			}
		}


	@Test
	public void test08CreoUnPaloYNumeroInvalidosDebeFallar(){
		try {
			Carta c = new Carta("150","ESPADA");
			print_test("Creo una carta invalida, palo y numero invalidos, debe fallar", false);

		} catch (IllegalArgumentException e) {
			print_test("Creo una carta invalida, palo y numero invalidos, debe fallar", true);
		}
	}


@Test
public void test081ComprueboMapeoJ(){
	Carta c = new Carta("J","DIAMANTE");
	print_test("Compruebo que otra carta se muestre correctamente", c.getNumero()==10 && c.getPalo().equals("DIAMANTE"));
}

	@Test
	public void test081ComprueboMapeoQ(){
		Carta c = new Carta("Q","DIAMANTE");
		print_test("Compruebo que otra carta se muestre correctamente", c.getNumero()==11 && c.getPalo().equals("DIAMANTE"));
	}

	@Test
	public void test081ComprueboMapeoK(){
		Carta c = new Carta("K","DIAMANTE");
		print_test("Compruebo que otra carta se muestre correctamente", c.getNumero()==12 && c.getPalo().equals("DIAMANTE"));
	}

	@Test
		public void test081ComprueboMapeoAS(){
			Carta c = new Carta("AS","DIAMANTE");
			print_test("Compruebo que otra carta se muestre correctamente", c.getNumero()==1 && c.getPalo().equals("DIAMANTE"));
	}

	@Test
	public void test09CreoUnaNuevaBarajaComprueboQueSeCreeCorrectamente(){
		BarajaInglesa m = new BarajaInglesa();
		print_test("El mazo no es nulo", m!= null);
		print_test("La cantidad de cartas del mazo es 48", m.cartas.size() == CANT_CARTAS_MAX);
	}

	@Test
	public void test10ComprueboQueBarajeCorrectamenteMostrandolasCartasPorPantalla(){
		BarajaInglesa m = new BarajaInglesa();
		String s1 = new String();
		for (int i=0; i<m.cartas.size();i++){
			s1 += m.cartas.get(i).toString();
		}
		m.mezclar();
		String s2 = new String();
		for (int i=0; i<m.cartas.size();i++){
			s2 += m.cartas.get(i).toString();
		}
		print_test("Muestro el mazo, lo barajo y lo vuelvo a mostrar, es diferente",!s1.contentEquals(s2));
		assertTrue(!s1.contentEquals(s2));

	}

	@Test
	public void test11BarajoElMazoNoSonIgualesLasPrimeras10Cartas(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=0; i<10;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.mezclar();
		l2 = new ArrayList<Carta>();
		for (int i=0; i<10;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las primeras 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}

	@Test
	public void test12BarajoElMazoNoSonIgualesLasSegundas10Cartas(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=9; i<20;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.mezclar();
		l2 = new ArrayList<Carta>();
		for (int i=9; i<20;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las segundas 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}

	@Test
	public void test13BarajoElMazoNoSonIgualesLasTerceras10Cartas(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=19; i<30;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.mezclar();
		l2 = new ArrayList<Carta>();
		for (int i=19; i<30;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las terceras 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}

	@Test
	public void test14BarajoElMazoNoSonIgualesLasUltimas10Cartas(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = new ArrayList<Carta>();
		for (int i=29; i<CANT_CARTAS_MAX;i++){
			l1.add(m.cartas.get(i));
			l2.add(m.cartas.get(i));
		}
		assertTrue(l1.equals(l2));
		m.mezclar();
		l2 = new ArrayList<Carta>();
		for (int i=29; i<CANT_CARTAS_MAX;i++){
			l2.add(m.cartas.get(i));
		}
		print_test("Tomo las ultimas 10 cartas, barajo el mazo y vuelvo a tomar esas 10 cartas, son diferentes",!l1.equals(l2));
		assertTrue(!l1.equals(l2));
	}

	@Test
	public void test15SacoUnaCartaEsLaProximaCorrecta(){
		BarajaInglesa m = new BarajaInglesa();
		m.mezclar();
		Carta c1 = m.cartas.get(0);
		Carta c2 = m.next();
		print_test("Tomo la primer carta del mazo, es correctamente la del tope",c1.equals(c2));
		assertTrue(c1.equals(c2));
	}

	@Test
	public void test16SacoLas48CartasDelMazoDeAUnaConnext(){
		BarajaInglesa m = new BarajaInglesa();
		m.mezclar();
		for (int i = 0; i < CANT_CARTAS_MAX; i++) {
			Carta c1 = m.cartas.get(i);
			Carta c2 = m.next();
			if (!c1.equals(c2)){
				print_test("Tomo la proxima carta del mazo todas las veces, el mazo nunca pierde cartas",false);
			}
			assertTrue(c1.equals(c2) && m.cartas.size() == CANT_CARTAS_MAX);
		}

		print_test("Tomo la proxima carta del mazo todas las veces",true);
	}

	@Test
	public void test17tomo3Cartas(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = m.repartir(3);
		for (int i=0; i<3;i++){
			l1.add(m.cartas.get(i));
		}
		print_test("Tomo 3 cartas del principio, son correctas",l1.equals(l2));
		assertTrue(l1.equals(l2));

	}

	@Test
	public void test18tomo5CartasYBarajoYVuelvoATomar(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = new ArrayList<Carta>();
		ArrayList<Carta> l2 = m.repartir(5);
		for (int i=0; i<5;i++){
			l1.add(m.cartas.get(i));
		}
		print_test("Tomo 3 cartas del principio previo a barajar, son correctas",l1.equals(l2));
		assertTrue(l1.equals(l2));
		m.mezclar();
		l1 = new ArrayList<Carta>();
		for (int i=0; i<5;i++){
			l1.add(m.cartas.get(i));
		}
		print_test("Tomo 3 cartas del principio despues de barajar, son diferentes a las primeras",!l1.equals(l2));
		assertTrue(!l1.equals(l2));

	}



	@Test
	public void test19tomo3CartasMeFijoQueNingunaDeEsasSeaLaProximna(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = m.repartir(3);
		int cont = 1;
		for (Carta c: l1){
			print_test("Tomo carta " + cont + ", no es la proxima",!c.equals(m.next()));
			assertTrue(!c.equals(m.next()));
			cont++;
		}
		print_test("Tomo 3 cartas del principio, ninguna de esas es la proxima",true);

	}

	@Test
	public void test20tomo3CartasMeFijoQueNingunaEstaEnElMazo(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = m.repartir(3);
		for (Carta c: l1){
			for (int i=3;i<CANT_CARTAS_MAX;i++){
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
		BarajaInglesa m = new BarajaInglesa();
		m.mezclar();
		for (int i = 0; i <= m.cartas.size(); i++) {
			print_test("Salieron "+ i +" quedan " + (CANT_CARTAS_MAX-i),m.cuantasQuedan()==CANT_CARTAS_MAX-i);
			assertTrue(m.cuantasQuedan()==CANT_CARTAS_MAX-i);
			if (i==CANT_CARTAS_MAX) break;
			m.next();

		}
		print_test("Compruebo el numero de cartas a repartir",true);
	}

	@Test
	public void test22Saco10CartasJuntasQuedaLasCartasDisponiblesSonCorrectas(){
		BarajaInglesa m = new BarajaInglesa();
		m.mezclar();
		ArrayList<Carta> l1 = m.repartir(10);
		print_test("Salieron 10 quedan " + (CANT_CARTAS_MAX-10),m.cuantasQuedan()==(CANT_CARTAS_MAX-10));
	}


	@Test
	public void test23tomo3CartasSonLasQueSalieron(){
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = m.repartir(3);
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
		BarajaInglesa m = new BarajaInglesa();
		ArrayList<Carta> l1 = m.repartir(3);
		m.next();
		m.next();
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
