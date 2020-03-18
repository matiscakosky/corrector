import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class Tests {
	@Test
	public void test01ComprueboQueSeHayaCorregidoElErrorDeLPerimetro() {
		Repaso r = new Repaso();
		for (int i = 1; i < 12; i++) {
			int resultado = r.calcularPerimetroRectangulo(i, i * 2);
			int test = i * 6;
			print_test("Compruebo perimetro con un rectangulo de base=" + Integer.toString(i) + " altura=" + Integer.toString(2 * i)
					+ " el resultado debe ser " + Integer.toString(test), resultado == test);
		}

	}

	@Test
	public void test02ComprueboEjercicioDeArea(){
		Repaso r = new Repaso();
		for (int i = 1; i<12; i++) {
			int resultado = r.calularAreaRectangulo(i,i*2);
			int test = i*(2*i);
			print_test("Compruebo area con un rectangulo de base="+Integer.toString(i)+" altura="+Integer.toString(2*i)+" el resultado debe ser "+Integer.toString(test),resultado==test);
		}
	}

	@Test
	public void test03multiplos1() {
		int n1 = 2;
		int n2 = 16;
		int test = 6;
		Repaso r = new Repaso();
		int resultado = r.multiplos_for(n1, n2);
		print_test("Compruebo multiplos entre " + Integer.toString(n1) + " y " + Integer.toString(n2) + ", el resultado debe ser " + Integer.toString(test),
				resultado == test);
	}

	@Test
	public void test04multiplos21() {
		int n1 = 13;
		int n2 = 20;
		int test = 0;
		Repaso r = new Repaso();
		int resultado = r.multiplos_for(n1, n2);
		print_test(
				"Compruebo multiplos_for entre " + Integer.toString(n1) + " y " + Integer.toString(n2) + ", el resultado debe ser " + Integer.toString(test),
				resultado == test);
	}

	@Test
	public void test05multiplos31() {
		int n1 = 5;
		int n2 = 1010;
		int test = 200;
		Repaso r = new Repaso();
		int resultado = r.multiplos_for(n1, n2);
		print_test(
				"Compruebo multiplos_for entre " + Integer.toString(n1) + " y " + Integer.toString(n2) + ", el resultado debe ser " + Integer.toString(test),
				resultado == test);
	}

	@Test
	public void test06multiplosVolumen() {
		Repaso r = new Repaso();
		boolean finalAns = true;
		for (int i = 1; i < 200; i++) {
			int resultado = r.multiplos_for(i, i * i);
			int test = multiplos_for_wd(i, i * i);
			if (resultado != test)
				finalAns = false;
		}
		print_test("Ejecuto una prueba de volumen con muchos numeros multiplos_for", finalAns);
	}

	@Test
	public void test07multiplos4() {
		int n1 = 2;
		int n2 = 16;
		int test = 6;
		Repaso r = new Repaso();
		int resultado = r.multiplos_while(n1, n2);
		print_test(
				"Compruebo multiplos_while entre " + Integer.toString(n1) + " y " + Integer.toString(n2) + ", el resultado debe ser " + Integer.toString(test),
				resultado == test);
	}

	@Test
	public void test08multiplos2() {
		int n1 = 13;
		int n2 = 20;
		int test = 0;
		Repaso r = new Repaso();
		int resultado = r.multiplos_while(n1, n2);
		print_test(
				"Compruebo multiplos_while entre " + Integer.toString(n1) + " y " + Integer.toString(n2) + ", el resultado debe ser " + Integer.toString(test),
				resultado == test);
	}

	@Test
	public void test09multiplos3() {
		int n1 = 5;
		int n2 = 1010;
		int test = 200;
		Repaso r = new Repaso();
		int resultado = r.multiplos_while(n1, n2);
		print_test(
				"Compruebo multiplos_while entre " + Integer.toString(n1) + " y " + Integer.toString(n2) + ", el resultado debe ser " + Integer.toString(test),
				resultado == test);
	}

	@Test
	public void test10multiplosVolumen2() {
		Repaso r = new Repaso();
		boolean finalAns = true;
		for (int i = 1; i < 200; i++) {
			int resultado = r.multiplos_while(i, i * i);
			int test = multiplos_for_wd(i, i * i);
			if (resultado != test)
				finalAns = false;
		}
		print_test("Ejecuto una prueba de volumen con muchos numeros multiplos_while", finalAns);
	}

	@Test
	public void test11SignosAries() {
		Repaso r = new Repaso();
		boolean finalAns = true;
		for (int i = 21; i < 32; i++) {
			String resultado = r.deQueSignoSoy("Marzo", i);
			if (!resultado.equals("Aries")) finalAns = false;
		}
		for (int i = 1; i < 20; i++) {
			String resultado = r.deQueSignoSoy("Abril", i);
			if (!resultado.equals("Aries")) {
				finalAns = false;
			}
		}
		print_test("Compruebo Aries", finalAns);
	}

	@Test
	public void test12SignosTauro() {
		Repaso r = new Repaso();
		boolean finalAns = true;
		String test = "Tauro";
		for (int i = 20; i < 31; i++) {
			String resultado = r.deQueSignoSoy("Abril", i);
			if (!resultado.equals(test))
				finalAns = false;
		}
		for (int i = 1; i < 21; i++) {
			String resultado = r.deQueSignoSoy("Mayo", i);
			if (!resultado.equals(test))
				finalAns = false;
		}
		print_test("Compruebo " + test, finalAns);
	}

	@Test
	public void test13SignosGeminis() {
		Repaso r = new Repaso();
		boolean finalAns = true;
		String test = "Geminis";
		for (int i = 21; i < 32; i++) {
			String resultado = r.deQueSignoSoy("Mayo", i);
			if (!resultado.equals(test))
				finalAns = false;
		}
		for (int i = 1; i < 21; i++) {
			String resultado = r.deQueSignoSoy("Junio", i);
			if (!resultado.equals(test))
				finalAns = false;
		}
		print_test("Compruebo " + test, finalAns);
	}

	@Test
	public void test14SignosCancer() {
		Repaso r = new Repaso();
		boolean finalAns = true;
		String test = "Cancer";
		for (int i = 25; i < 31; i++) {
			String resultado = r.deQueSignoSoy("Junio", i);
			if (!resultado.equals(test))
				finalAns = false;
		}
		for (int i = 1; i < 23; i++) {
			String resultado = r.deQueSignoSoy("Julio", i);
			if (!resultado.equals(test))
				finalAns = false;
		}
		print_test("Compruebo " + test, finalAns);
	}

	@Test
	public void test16SignosLeo() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Leo";
		for (int i = 23; i < 32; i++) {
			String resultado = r.deQueSignoSoy("Julio", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		for (int i = 1; i < 23; i++) {
			String resultado = r.deQueSignoSoy("Agosto", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
	}

	@Test
	public void test17SignosVirgo() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Virgo";
		for (int i = 24; i < 32; i++) {
			String resultado = r.deQueSignoSoy("Agosto", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		for (int i = 1; i < 23; i++) {
			String resultado = r.deQueSignoSoy("Septiembre", i);
			if (!resultado.equals(test)) finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
		
	}

	@Test
	public void test18SignosLibra() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Libra";
		for (int i = 24; i < 31; i++) {
			String resultado = r.deQueSignoSoy("Septiembre", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		for (int i = 1; i < 23; i++) {
			String resultado = r.deQueSignoSoy("Octubre", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
	}

	@Test
	public void test19SignosEscorpio() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Escorpio";
		for (int i = 23; i < 32; i++) {
			String resultado = r.deQueSignoSoy("Octubre", i);
			if (!resultado.equals(test)) finalAnsAns = false;
		}
		for (int i = 1; i < 23; i++) {
			String resultado = r.deQueSignoSoy("Noviembre", i);
			if (!resultado.equals(test)) finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
	}

	@Test
	public void test20SignosSagitario() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Sagitario";
		for (int i = 23; i < 31; i++) {
			String resultado = r.deQueSignoSoy("Noviembre", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		for (int i = 1; i < 22; i++) {
			String resultado = r.deQueSignoSoy("Diciembre", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
	}

	@Test
	public void test22SignosCapriconio() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Capricornio";
		for (int i = 22; i < 32; i++) {
			String resultado = r.deQueSignoSoy("Diciembre", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		for (int i = 1; i < 20; i++) {
			String resultado = r.deQueSignoSoy("Enero", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
	}

	@Test
	public void test23SignosAcuario() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Acuario";
		for (int i = 20; i < 32; i++) {
			String resultado = r.deQueSignoSoy("Enero", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		for (int i = 1; i < 19; i++) {
			String resultado = r.deQueSignoSoy("Febrero", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
	}

	@Test
	public void test24SignosPiscis() {
		Repaso r = new Repaso();
		boolean finalAnsAns = true;
		String test = "Piscis";
		for (int i = 19; i < 30; i++) {
			String resultado = r.deQueSignoSoy("Febrero", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		for (int i = 1; i < 21; i++) {
			String resultado = r.deQueSignoSoy("Marzo", i);
			if (!resultado.equals(test))
				finalAnsAns = false;
		}
		print_test("Compruebo " + test, finalAnsAns);
	}

	@Test
		public void test26PositivosFor(){
			ArrayList<Integer> lista = new ArrayList<Integer>();
			for (int i=-50;i<51; i++ ){
				if (i == 0) continue;
				lista.add(i);
			}
			Repaso r = new Repaso();
			int cant = r.cant_positivos_for(lista);
			print_test("Cuento la cantidad de positivos con for",cant==50);
		}

	@Test
	public void test27PositivosForExt() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for (int i = -50; i < 51; i++) {
			if (i == 0)
				continue;
			lista.add(i);
		}
		Repaso r = new Repaso();
		int cant = r.cant_positivos_for_extendido(lista);
		print_test("Cuento la cantidad de positivos con for extendido", cant == 50);
	}

	public int multiplos_for_wd(int a, int b) {
		int cont = 0;
		for (int i = a + 1; i < b; i++) {
			if (i % a == 0) {
				cont++;
			}
		}
		return cont;
	}

	public void print_test(String msg, boolean ok) {
		System.out.flush();
		String res;
		if (ok) {
			res = "OK";
		} else {
			res = "ERROR";
		}
		System.out.printf("%s...%s \n", msg, res);
		assertTrue(ok);
	}
}
