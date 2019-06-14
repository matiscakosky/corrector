	

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class Tests {
	@Test
	public void test01CreoUnElectrodomesticoUsandoElConstructoPorDefecto(){
		Electrodomestico e = new Electrodomestico();
		boolean condition = e.getPrecioBase() == 500 && e.getColor().equals("BLANCO") && e.getConsumoElectrico().equals("A") && e.getPeso() == 5 && e.getVoltaje() == 220;
		print_test("Nuevo electrodomestico usando el constructor por defecto", condition);
		
	}
	
	@Test
	public void test02CreoUnElectrodomesticoUsandoElConstructorReducido(){
		Electrodomestico e = new Electrodomestico(200, 10);
		boolean condition = e.getPrecioBase() == 200 && e.getColor().equals("BLANCO") && e.getConsumoElectrico().equals("A") && e.getPeso() == 10 && e.getVoltaje() == 220;
		print_test("Nuevo electrodomestico utilizando el constructor reducido", condition);
		
	}

	@Test
	public void test03CreoUnElectrodomesticoUsandoElConstructorReducidoConPrecioInvalido(){
			try {
				Electrodomestico e = new Electrodomestico(-200, 10);
				print_test("Creo electrodomestico utilizando el constructor reducido con precio invalido, debe fallar", false);
				
			} catch (IllegalArgumentException e) {
				print_test("Creo electrodomestico utilizando el constructor reducido con precio invalido, debe fallar", true);
			}
		
	}
	
	@Test
	public void test04CreoUnElectrodomesticoUsandoElConstructorReducidoConPesoInvalido(){
		try {
			Electrodomestico e = new Electrodomestico(200, -10);
			print_test("Creo electrodomestico utilizando el constructor reducido con peso invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo electrodomestico utilizando el constructor reducido con peso invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test05CreoUnElectrodomesticoUsandoElConstructorCompleto(){
		Electrodomestico e = new Electrodomestico(200,"AZUL","B",12,110);
		boolean condition = e.getPrecioBase() == 200 && e.getColor().equals("AZUL") && e.getConsumoElectrico().equals("B") && e.getPeso() == 12 && e.getVoltaje() == 110;
		print_test("Creo electrodomestico utilizando el constructor completo", condition);
		
	}
	
	@Test
	public void test06CreoUnElectrodomesticoUsandoElConstructorCompletoConPrecioInvalido(){
		try {
			Electrodomestico e = new Electrodomestico(-200,"AZUL","B",12,110);
			print_test("Creo electrodomestico utilizando el constructor completo con precio invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo electrodomestico utilizando el constructor completo con precio invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test07CreoUnElectrodomesticoUsandoElConstructorCompletoConPesoInvalido(){
		try {
			Electrodomestico e = new Electrodomestico(200,"AZUL","B",-12,110);
			print_test("Creo electrodomestico utilizando el constructor completo con peso invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo electrodomestico utilizando el constructor completo con peso invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test08CreoUnElectrodomesticoUsandoElConstructorCompletoConColorInvalido(){
		try {
			Electrodomestico e = new Electrodomestico(200,"ROJO","B",12,110);
			print_test("Creo electrodomestico utilizando el constructor completo con color invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo electrodomestico utilizando el constructor completo con color invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test09CreoUnElectrodomesticoUsandoElConstructorCompletoConConsumoInvalido(){
		try {
			Electrodomestico e = new Electrodomestico(200,"AZUL","H",12,110);
			print_test("Creo electrodomestico utilizando el constructor completo con consumo invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo electrodomestico utilizando el constructor completo con consumo invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test10CreoUnElectrodomesticoUsandoElConstructorCompletoConVoltajeInvalido(){
		try {
			Electrodomestico e = new Electrodomestico(200,"AZUL","B",12,90);
			print_test("Creo electrodomestico utilizando el constructor completo con voltaje invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo electrodomestico utilizando el constructor completo con voltaje invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test11PintoUnElectrodomestico(){
		Electrodomestico e = new Electrodomestico();
		e.pintar("VERDE");
		print_test("Pinto un electrodomestico de color valido", e.getColor().equals("VERDE"));
		
	}
	
	@Test
	public void test12PintoUnElectrodomesticoDeColorInvalido(){
		try {
			Electrodomestico e = new Electrodomestico();
			e.pintar("VIOLETA");
			print_test("Pinto un electrodomestico de color invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Pinto un electrodomestico de color invalido, debe fallar", true);
		}

		
		
	}
	
	@Test
	public void test12CreoElectrodomesticoConConsumoNoCorrespondienteAlVoltaje110F(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"AZUL","F",12,110);
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 110V - F", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 110V - F", true);
		}
	}
	
	@Test
	public void test13CreoElectrodomesticoConConsumoNoCorrespondienteAlVoltaje220F(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"AZUL","F",12,220);
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 220V - F", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 220V - F", true);
		}
	}
	
	@Test
	public void test14CreoElectrodomesticoConConsumoBien240F(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"AZUL","F",12,240);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - F", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - F", false);
		}
	}
	
	@Test
	public void test15CreoElectrodomesticoConConsumoNoCorrespondienteAlVoltaje110E(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","E",12,110);
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 110V - E", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 110V - E", true);
		}
	}
	
	@Test
	public void test16CreoElectrodomesticoConConsumoNoCorrespondienteAlVoltaje220E(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","E",12,220);
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 220V - E", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 220V - E", true);
		}
	}
	
	@Test
	public void test17CreoElectrodomesticoConConsumoBien240E(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","E",12,240);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - E", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - E", false);
		}
	}
	
	@Test
	public void test18CreoElectrodomesticoConConsumoNoCorrespondienteAlVoltaje110D(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","D",12,110);
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 110V - D", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo excedente al voltaje 110V - D", true);
		}
	}
	
	@Test
	public void test19CreoElectrodomesticoConConsumoBien220D(){
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","D",12,220);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - D", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - D", false);
		}
	}
	
	@Test
	public void test20CreoElectrodomesticoConConsumoBien240D(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","D",12,240);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - D", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - D", false);
		}
	}
	
	@Test
	public void test21CreoElectrodomesticoConConsumoBien110C(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","C",12,110);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 110V - C", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 110V - C", false);
		}
	}
	
	@Test
	public void test22CreoElectrodomesticoConConsumoBien220C(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","C",12,220);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - C", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - C", false);
		}
	}
	
	@Test
	public void test23CreoElectrodomesticoConConsumoBien240C(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","C",12,240);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - C", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - C", false);
		}
	}
	
	@Test
	public void test24CreoElectrodomesticoConConsumoBien110B(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","B",12,110);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 110V - B", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 110V - B", false);
		}
	}
	
	@Test
	public void test25CreoElectrodomesticoConConsumoBien220B(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","B",12,220);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - B", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - B", false);
		}
	}
	
	@Test
	public void test26CreoElectrodomesticoConConsumoBien240B(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","B",12,240);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - B", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - B", false);
		}
	}
	@Test
	public void test27CreoElectrodomesticoConConsumoBien110A(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","A",12,110);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 110V - A", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 110V - A", false);
		}
	}
	
	@Test
	public void test28CreoElectrodomesticoConConsumoBien220A(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","A",12,220);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - A", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 220V - a", false);
		}
	}
	
	@Test
	public void test29CreoElectrodomesticoConConsumoBien240A(){
		
		try {
			Electrodomestico e = new Electrodomestico(200,"VERDE","A",12,240);
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - A", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo electrodomestico con consumo valido al voltaje 240V - A", false);
		}
	}
	
	@Test
	public void test30ComprueboElConsumoElectricoDeUnElectrodomestico240(){
		System.out.println("Creo un electrodomestico de 240V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Electrodomestico(200,"VERDE","A",12,240);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, se puede", e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, se puede", e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, se puede", e.comprobarConsumoElectrico("F"));
		
	}
	
	@Test
	public void test31ComprueboElConsumoElectricoDeUnElectrodomestico220(){
		System.out.println("Creo un electrodomestico de 220V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Electrodomestico(200,"VERDE","A",12,220);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, se puede", e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, no se puede", !e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, no se puede", !e.comprobarConsumoElectrico("F"));
	}
	
	@Test
	public void test31ComprueboElConsumoElectricoDeUnElectrodomestico110(){
		System.out.println("Creo un electrodomestico de 110V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Electrodomestico(200,"VERDE","A",12,110);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, no se puede", !e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, no se puede", !e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, no se puede", !e.comprobarConsumoElectrico("F"));
	}
	
	@Test
	public void test32ComprueboPrecioDeElectrodomesticoDefault(){
		Electrodomestico e = new Electrodomestico();
		int precio = e.precioFinal();
		print_test("Compruebo el precio del electrodomestico por default", precio==10250);
	}

	@Test
	public void test33ComprueboPrecioElectrodomesticoFijandoElPrecioVariandoElPeso(){
		Electrodomestico e1 = new Electrodomestico(5000, 80);
		int precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $5000 y 80kg", precio==132000);
		e1 = new Electrodomestico(5000, 50);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $5000 y 50kg", precio==110000);
		e1 = new Electrodomestico(5000, 20);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $5000 y 20kg", precio==101000);
		e1 = new Electrodomestico(5000, 20);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $5000 y 20kg", precio==101000);
		
	}

	@Test
	public void test34ComprueboPrecioElectrodomesticoFijandoElPesoVariandoElPrecio(){
		Electrodomestico e1 = new Electrodomestico(500, 30);
		int precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $500 y 30kg", precio==13000);
		e1 = new Electrodomestico(1000, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $1000 y 30kg", precio==23000);
		e1 = new Electrodomestico(3500, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $3500 y 30kg", precio==73000);
		e1 = new Electrodomestico(7000, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del electrodomestico de base $7000 y 30kg", precio==143000);
	}
	
	@Test
	public void test35ComprueboPrecioElectrodomesticoFijandoElPrecioYPesoVariandoConsumo(){
		Electrodomestico e1 = new Electrodomestico(2000,"BLANCO","A",40,240);
		int precio = e1.precioFinal();
		print_test("Precio Consumo A", precio==48000);
		e1 = new Electrodomestico(2000,"BLANCO","B",40,240);
		precio = e1.precioFinal();
		print_test("Precio Consumo B", precio==68000);
		e1 = new Electrodomestico(2000,"BLANCO","C",40,240);
		precio = e1.precioFinal();
		print_test("Precio Consumo C", precio==108000);
		e1 = new Electrodomestico(2000,"BLANCO","D",40,240);
		precio = e1.precioFinal();
		print_test("Precio Consumo D", precio==168000);
		e1 = new Electrodomestico(2000,"BLANCO","E",40,240);
		precio = e1.precioFinal();
		print_test("Precio Consumo E", precio==208000);
		e1 = new Electrodomestico(2000,"BLANCO","F",40,240);
		precio = e1.precioFinal();
		print_test("Precio Consumo F", precio==308000);
	}
	@Test
	public void test36Elijo3CualquieraYPrueboElPrecio(){
		Electrodomestico e1 = new Electrodomestico(1982,"BLANCO","D",48,240);
		int precio = e1.precioFinal();
		print_test("Elijo 3 caracteristicas cualquiera, validas, y compruebo el precio", precio==168160);
	}
	
	@Test
	public void test37CreoUnLavarropasUsandoElConstructoPorDefecto(){
		Electrodomestico e = new Lavarropas();
		boolean condition = e.getPrecioBase() == 5000 && e.getColor().equals("BLANCO") && e.getConsumoElectrico().equals("D") && e.getPeso() == 20 && e.getVoltaje() == 220 && ((Lavarropas) e).getCarga()==10;
		print_test("Nuevo Lavarropas usando el constructor por defecto", condition);
		
	}
	
	
	@Test
	public void test38CreoUnLavarropasUsandoElConstructorReducido(){
		Electrodomestico e = new Lavarropas(200, 10);
		boolean condition = e.getPrecioBase() == 200 && e.getColor().equals("BLANCO") && e.getConsumoElectrico().equals("E") && e.getPeso() == 10 && e.getVoltaje() == 220 && ((Lavarropas) e).getCarga()==10;
		print_test("Nuevo Lavarropas utilizando el constructor reducido", condition);
		
	}
	
	@Test
	public void test39CreoUnLavarropasUsandoElConstructorReducidoConPrecioInvalido(){
			try {
				Electrodomestico e = new Lavarropas(-200, 10);
				print_test("Creo Lavarropas utilizando el constructor reducido con precio invalido, debe fallar", false);
				
			} catch (IllegalArgumentException e) {
				print_test("Creo Lavarropas utilizando el constructor reducido con precio invalido, debe fallar", true);
			}
		
	}
	
	@Test
	public void test40CreoUnLavarropasUsandoElConstructorReducidoConPesoInvalido(){
		try {
			Electrodomestico e = new Lavarropas(200, -10);
			print_test("Creo Lavarropas utilizando el constructor reducido con peso invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Lavarropas utilizando el constructor reducido con peso invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test41CreoUnLavarropasUsandoElConstructorCompleto(){
		Electrodomestico e = new Lavarropas(200,"AZUL","B",12,110,100);
		boolean condition = e.getPrecioBase() == 200 && e.getColor().equals("AZUL") && e.getConsumoElectrico().equals("B") && e.getPeso() == 12 && e.getVoltaje() == 110 && ((Lavarropas) e).getCarga()==100;
		print_test("Creo Lavarropas utilizando el constructor completo", condition);
		
	}
	
	

	@Test
	public void test42CreoUnLavarropasUsandoElConstructorCompletoConPrecioInvalido(){
		try {
			Electrodomestico e = new Lavarropas(-200,"AZUL","B",12,110,100);
			print_test("Creo Lavarropas utilizando el constructor completo con precio invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Lavarropas utilizando el constructor completo con precio invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test43CreoUnLavarropasUsandoElConstructorCompletoConPesoInvalido(){
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","B",-12,110,1);
			print_test("Creo Lavarropas utilizando el constructor completo con peso invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Lavarropas utilizando el constructor completo con peso invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test45CreoUnLavarropasUsandoElConstructorCompletoConColorInvalido(){
		try {
			Electrodomestico e = new Lavarropas(200,"ROJO","B",12,110,100);
			print_test("Creo Lavarropas utilizando el constructor completo con color invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Lavarropas utilizando el constructor completo con color invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test46CreoUnLavarropasUsandoElConstructorCompletoConConsumoInvalido(){
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","H",12,110,1);
			print_test("Creo Lavarropas utilizando el constructor completo con consumo invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Lavarropas utilizando el constructor completo con consumo invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test47CreoUnLavarropasUsandoElConstructorCompletoConVoltajeInvalido(){
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","B",12,90,100);
			print_test("Creo Lavarropas utilizando el constructor completo con voltaje invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Lavarropas utilizando el constructor completo con voltaje invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test48PintoUnLavarropas(){
		Electrodomestico e = new Lavarropas();
		e.pintar("VERDE");
		print_test("Pinto un Lavarropas de color valido", e.getColor().equals("VERDE"));
		
	}
	
	
	@Test
	public void test49CreoLavarropasConConsumoNoCorrespondienteAlVoltaje110F(){
		
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","F",12,110,1);
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 110V - F", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 110V - F", true);
		}
	}
	
	
	@Test
	public void test50CreoLavarropasConConsumoValidoVoltaje110A(){
		
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","A",12,110,1);
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 110V - A", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 110V - A", false);
		}
	}
	
	@Test
	public void test51CreoLavarropasConConsumoNoCorrespondienteAlVoltaje220F(){
		
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","F",12,220,1);
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 220V - F", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 220V - F", true);
		}
	}
	
	@Test
	public void test52CreoLavarropasConConsumoValidoVoltaje220B(){
		
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","B",12,220,1);
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 220V - B", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 220V - B", false);
		}
	}
	
	@Test
	public void test53CreoLavarropasConConsumoValidoVoltaje240F(){
		
		try {
			Electrodomestico e = new Lavarropas(200,"AZUL","F",12,240,1);
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 240V - F", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Lavarropas con consumo excedente al voltaje 240V - F", false);
		}
	}
	
	@Test
	public void test54ComprueboElConsumoElectricoDeUnLavarropas240(){
		System.out.println("Creo un electrodomestico de 240V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Lavarropas(200,"VERDE","A",12,240,1);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, se puede", e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, se puede", e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, se puede", e.comprobarConsumoElectrico("F"));
		
	}
	@Test
	public void test55ComprueboElConsumoElectricoDeUnLavarropas220(){
		System.out.println("Creo un Lavarropas de 220V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Lavarropas(200,"VERDE","A",12,220,1);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, se puede", e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, no se puede", !e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, no se puede", !e.comprobarConsumoElectrico("F"));
	}
	
	@Test
	public void test56ComprueboElConsumoElectricoDeUnLavarropas110(){
		System.out.println("Creo un Lavarropas de 110V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Lavarropas(200,"VERDE","A",12,110,1);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, no se puede", !e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, no se puede", !e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, no se puede", !e.comprobarConsumoElectrico("F"));
	}
	
	
	@Test
	public void test57ComprueboPrecioDeLavarropasDefault(){
		Electrodomestico e = new Lavarropas();
		int precio = e.precioFinal();
		print_test("Compruebo el precio del Lavarropas por default", precio==501000);
	}

	@Test
	public void test58ComprueboPrecioLavarropasFijandoElPrecioVariandoElPeso(){
		Electrodomestico e1 = new Lavarropas(5000, 80);
		int precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $5000 y 80kg", precio==532000);
		e1 = new Lavarropas(5000, 50);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $5000 y 50kg", precio==510000);
		e1 = new Lavarropas(5000, 20);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $5000 y 20kg", precio==501000);
		e1 = new Lavarropas(5000, 10);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $5000 y 10kg", precio==500500);
		
	}

	@Test
	public void test59ComprueboPrecioLavarropasFijandoElPesoVariandoElPrecio(){
		Electrodomestico e1 = new Lavarropas(500, 30);
		int precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $500 y 30kg", precio==53000);
		e1 = new Lavarropas(1000, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $1000 y 30kg", precio==103000);
		e1 = new Lavarropas(3500, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $3500 y 30kg", precio==353000);
		e1 = new Lavarropas(7000, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Lavarropas de base $7000 y 30kg", precio==703000);
	}
	
	@Test
	public void test60ComprueboPrecioLavarropasFijandoElPrecioYPesoVariandoConsumo(){
		Electrodomestico e1 = new Lavarropas(2000,"BLANCO","A",40,240,1);
		int precio = e1.precioFinal();
		print_test("Lavarropas Precio Consumo A", precio==48000);
		e1 = new Lavarropas(2000,"BLANCO","B",40,240,1);
		precio = e1.precioFinal();
		print_test("Lavarropas Precio Consumo B", precio==68000);
		e1 = new Lavarropas(2000,"BLANCO","C",40,240,1);
		precio = e1.precioFinal();
		print_test("Lavarropas Precio Consumo C", precio==108000);
		e1 = new Lavarropas(2000,"BLANCO","D",40,240,1);
		precio = e1.precioFinal();
		print_test("Lavarropas Precio Consumo D", precio==168000);
		e1 = new Lavarropas(2000,"BLANCO","E",40,240,1);
		precio = e1.precioFinal();
		print_test("Lavarropas Precio Consumo E", precio==208000);
		e1 = new Lavarropas(2000,"BLANCO","F",40,240,1);
		precio = e1.precioFinal();
		print_test("Lavarropas Precio Consumo F", precio==308000);
	}
	@Test
	public void test61Elijo3CualquieraYPrueboElPrecio(){
		Electrodomestico e1 = new Lavarropas(2000,"BLANCO","A",40,240,1);
		int precio = e1.precioFinal();
		print_test("Elijo 3 caracteristicas cualquiera, validas, y compruebo el precio", precio==48000);
	}
	
	@Test
	public void test62CreoUnLavarropasUsandoElConstructorCompletoConCargaInvalida(){
		try {
			Electrodomestico e = new Lavarropas(200,"ROJO","B",12,110,-100);
			print_test("Creo Lavarropas utilizando el constructor completo con carga invalida, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Lavarropas utilizando el constructor completo con carga invalida, debe fallar", true);
		}
	}
	
	@Test
	public void test63obtengoLaCargaLavarropas(){
		Electrodomestico e1 = new Lavarropas();
		int carga = ((Lavarropas) e1).getCarga();
		print_test("Obtengo la carga de un lavarropas default", carga==10);
	}
	
	@Test
	public void test64comprueboCantidadCargaSinExcederLavarropas(){
		Electrodomestico e1 = new Lavarropas();
		boolean carga = ((Lavarropas) e1).intentar_colocar(9);
		print_test("Intento colocar menos carga de la posible", carga);
	}
	
	@Test
	public void test65comprueboCantidadCargaSinExcediendoLavarropas(){
		Electrodomestico e1 = new Lavarropas();
		boolean carga = ((Lavarropas) e1).intentar_colocar(90);
		print_test("Intento colocar mas carga de la posible", !carga);
	}
	
	
	@Test
	public void test66CreoUnTelevisorUsandoElConstructoPorDefecto(){
		Electrodomestico e = new Televisor();
		boolean condition = e.getPrecioBase() == 2000 && e.getColor().equals("NEGRO") && e.getConsumoElectrico().equals("D") && e.getPeso() == 30 && e.getVoltaje() == 220;
		print_test("Nuevo Televisor usando el constructor por defecto", condition);
		
	}
	
	
	@Test
	public void test67CreoUnTelevisorUsandoElConstructorReducido(){
		Electrodomestico e = new Televisor(200, 10);
		boolean condition = e.getPrecioBase() == 200 && e.getColor().equals("NEGRO") && e.getConsumoElectrico().equals("D") && e.getPeso() == 10 && e.getVoltaje() == 220;
		print_test("Nuevo Televisor utilizando el constructor reducido", condition);
		
	}
	
	@Test
	public void test68CreoUnTelevisorUsandoElConstructorReducidoConPrecioInvalido(){
			try {
				Electrodomestico e = new Televisor(-200, 10);
				print_test("Creo Televisor utilizando el constructor reducido con precio invalido, debe fallar", false);
				
			} catch (IllegalArgumentException e) {
				print_test("Creo Televisor utilizando el constructor reducido con precio invalido, debe fallar", true);
			}
		
	}
	
	@Test
	public void test69CreoUnTelevisorUsandoElConstructorReducidoConPesoInvalido(){
		try {
			Electrodomestico e = new Televisor(200, -10);
			print_test("Creo Televisor utilizando el constructor reducido con peso invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Televisor utilizando el constructor reducido con peso invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test70CreoUnTelevisorUsandoElConstructorCompleto(){
		Electrodomestico e = new Televisor(200,"AZUL","B",12,110,100,true);
		boolean condition = e.getPrecioBase() == 200 && e.getColor().equals("AZUL") && e.getConsumoElectrico().equals("B") && e.getPeso() == 12 && e.getVoltaje() == 110;
		print_test("Creo Televisor utilizando el constructor completo", condition);
		
	}
	
	

	@Test
	public void test71CreoUnTelevisorUsandoElConstructorCompletoConPrecioInvalido(){
		try {
			Electrodomestico e = new Televisor(-200,"AZUL","B",12,110,100,true);
			print_test("Creo Televisor utilizando el constructor completo con precio invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Televisor utilizando el constructor completo con precio invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test72CreoUnTelevisorUsandoElConstructorCompletoConPesoInvalido(){
		try {
			Electrodomestico e = new Televisor(200,"AZUL","B",-12,110,1,true);
			print_test("Creo Televisor utilizando el constructor completo con peso invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Televisor utilizando el constructor completo con peso invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test73CreoUnTelevisorUsandoElConstructorCompletoConColorInvalido(){
		try {
			Electrodomestico e = new Televisor(200,"ROJO","B",12,110,100,true);
			print_test("Creo Televisor utilizando el constructor completo con color invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Televisor utilizando el constructor completo con color invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test74CreoUnTelevisorUsandoElConstructorCompletoConConsumoInvalido(){
		try {
			Electrodomestico e = new Televisor(200,"AZUL","H",12,110,1,true);
			print_test("Creo Televisor utilizando el constructor completo con consumo invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Televisor utilizando el constructor completo con consumo invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test75CreoUnTelevisorUsandoElConstructorCompletoConVoltajeInvalido(){
		try {
			Electrodomestico e = new Televisor(200,"AZUL","B",12,90,100,true);
			print_test("Creo Televisor utilizando el constructor completo con voltaje invalido, debe fallar", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Creo Televisor utilizando el constructor completo con voltaje invalido, debe fallar", true);
		}
	}
	
	@Test
	public void test76PintoUnTelevisor(){
		Electrodomestico e = new Televisor();
		e.pintar("VERDE");
		print_test("Pinto un Televisor de color valido", e.getColor().equals("VERDE"));
		
	}
	
	
	@Test
	public void test77CreoTelevisorConConsumoNoCorrespondienteAlVoltaje110F(){
		
		try {
			Electrodomestico e = new Televisor(200,"AZUL","F",12,110,1,true);
			print_test("Nuevo Televisor con consumo excedente al voltaje 110V - F", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Televisor con consumo excedente al voltaje 110V - F", true);
		}
	}
	
	
	@Test
	public void test78CreoTelevisorConConsumoValidoVoltaje110A(){
		
		try {
			Electrodomestico e = new Televisor(200,"AZUL","A",12,110,1,true);
			print_test("Nuevo Televisor con consumo excedente al voltaje 110V - A", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Televisor con consumo excedente al voltaje 110V - A", false);
		}
	}
	
	@Test
	public void test79CreoTelevisorConConsumoNoCorrespondienteAlVoltaje220F(){
		
		try {
			Electrodomestico e = new Televisor(200,"AZUL","F",12,220,1,true);
			print_test("Nuevo Televisor con consumo excedente al voltaje 220V - F", false);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Televisor con consumo excedente al voltaje 220V - F", true);
		}
	}
	
	@Test
	public void test80CreoTelevisorConConsumoValidoVoltaje220B(){
		
		try {
			Electrodomestico e = new Televisor(200,"AZUL","B",12,220,1,true);
			print_test("Nuevo Televisor con consumo excedente al voltaje 220V - B", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Televisor con consumo excedente al voltaje 220V - B", false);
		}
	}
	
	@Test
	public void test81CreoTelevisorConConsumoValidoVoltaje240F(){
		
		try {
			Electrodomestico e = new Televisor(200,"AZUL","F",12,240,1,true);
			print_test("Nuevo Televisor con consumo excedente al voltaje 240V - F", true);
			
		} catch (IllegalArgumentException e) {
			print_test("Nuevo Televisor con consumo excedente al voltaje 240V - F", false);
		}
	}
	
	@Test
	public void test82ComprueboElConsumoElectricoDeUnTelevisor240(){
		System.out.println("Creo un electrodomestico de 240V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Televisor(200,"VERDE","A",12,240,1,true);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, se puede", e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, se puede", e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, se puede", e.comprobarConsumoElectrico("F"));
		
	}
	@Test
	public void test83ComprueboElConsumoElectricoDeUnTelevisor220(){
		System.out.println("Creo un Televisor de 220V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Televisor(200,"VERDE","A",12,220,1,true);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, se puede", e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, no se puede", !e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, no se puede", !e.comprobarConsumoElectrico("F"));
	}
	
	@Test
	public void test84ComprueboElConsumoElectricoDeUnTelevisor110(){
		System.out.println("Creo un Televisor de 110V y consumo A, intento comprobar otros consumos");
		Electrodomestico e = new Televisor(200,"VERDE","A",12,110,1,true);
		print_test("Elevo el consumo a B, se puede", e.comprobarConsumoElectrico("B"));
		print_test("Elevo el consumo a C, se puede", e.comprobarConsumoElectrico("C"));
		print_test("Elevo el consumo a D, no se puede", !e.comprobarConsumoElectrico("D"));
		print_test("Elevo el consumo a E, no se puede", !e.comprobarConsumoElectrico("E"));
		print_test("Elevo el consumo a F, no se puede", !e.comprobarConsumoElectrico("F"));
	}
	
	
	@Test
	public void test85ComprueboPrecioDeTelevisorDefault(){
		Electrodomestico e = new Televisor();
		int precio = e.precioFinal();
		print_test("Compruebo el precio del Televisor por default", precio==163000);
	}

	@Test
	public void test86ComprueboPrecioTelevisorFijandoElPrecioVariandoElPeso(){
		Electrodomestico e1 = new Televisor(5000, 80);
		int precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $5000 y 80kg", precio==432000);
		e1 = new Televisor(5000, 50);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $5000 y 50kg", precio==410000);
		e1 = new Televisor(5000, 20);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $5000 y 20kg", precio==401000);
		e1 = new Televisor(5000, 10);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $5000 y 10kg", precio==400500);
		
	}

	@Test
	public void test87ComprueboPrecioTelevisorFijandoElPesoVariandoElPrecio(){
		Electrodomestico e1 = new Televisor(500, 30);
		int precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $500 y 30kg", precio==43000);
		e1 = new Televisor(1000, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $1000 y 30kg", precio==83000);
		e1 = new Televisor(3500, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $3500 y 30kg", precio==283000);
		e1 = new Televisor(7000, 30);
		precio = e1.precioFinal();
		print_test("Compruebo el precio del Televisor de base $7000 y 30kg", precio==563000);
	}
	
	@Test
	public void test88ComprueboPrecioTelevisorFijandoElPrecioYPesoVariandoConsumo(){
		Electrodomestico e1 = new Televisor(2000,"BLANCO","A",40,240,1,true);
		int precio = e1.precioFinal();
		print_test("Televisor Precio Consumo A", precio==48000);
		e1 = new Televisor(2000,"BLANCO","B",40,240,1,true);
		precio = e1.precioFinal();
		print_test("Televisor Precio Consumo B", precio==68000);
		e1 = new Televisor(2000,"BLANCO","C",40,240,1,true);
		precio = e1.precioFinal();
		print_test("Televisor Precio Consumo C", precio==108000);
		e1 = new Televisor(2000,"BLANCO","D",40,240,1,true);
		precio = e1.precioFinal();
		print_test("Televisor Precio Consumo D", precio==168000);
		e1 = new Televisor(2000,"BLANCO","E",40,240,1,true);
		precio = e1.precioFinal();
		print_test("Televisor Precio Consumo E", precio==208000);
		e1 = new Televisor(2000,"BLANCO","F",40,240,1,true);
		precio = e1.precioFinal();
		print_test("Televisor Precio Consumo F", precio==308000);
	}
	@Test
	public void test89Elijo3CualquieraYPrueboElPrecio(){
		Electrodomestico e1 = new Televisor(2000,"BLANCO","A",40,240,1,true);
		int precio = e1.precioFinal();
		print_test("Elijo 3 caracteristicas cualquiera, validas, y compruebo el precio", precio==48000);
	}
	
	@Test
	public void test90ComprueboQueSeDupliqueElPrecioTelevisor(){
		Electrodomestico e1 = new Televisor(2000,"BLANCO","A",40,240,29,true);
		int precio = e1.precioFinal();
		print_test("Televisor 29'' SMART=SI => doble precio", precio==48000*2);
		e1 = new Televisor(2000,"BLANCO","A",40,240,29,false);
		precio = e1.precioFinal();
		print_test("Televisor 29'' SMART=SI => no doble precio", precio==48000);
	}
	
	@Test
	public void test91ObtengoLasPulgadasDeUnaTVDefault(){
		Electrodomestico e1 = new Televisor();
		boolean cond = ((Televisor) e1).getPulgadas()==21;
		print_test("Obtengo las pulgadas default de un televisor", cond);
	}
	
	@Test
	public void test92ObtengoLasPulgadasDeUnaTVDeConstructorCompleto(){
		Electrodomestico e1 = new Televisor(2000,"BLANCO","A",40,240,50,true);
		boolean cond = ((Televisor) e1).getPulgadas()==50;
		print_test("Obtengo las pulgadas de un televisorde constructor completo", cond);
	}
	
	@Test
	public void test93ObtengoSmartDeUnaTVDefault(){
		Electrodomestico e1 = new Televisor();
		boolean cond = ((Televisor) e1).getSmart();
		print_test("Obtengo Smart default de un televisor", !cond);
	}
	
	@Test
	public void test94ObtengoSmartDeUnaTVDeConstructorCompleto(){
		Electrodomestico e1 = new Televisor(2000,"BLANCO","A",40,240,50,true);
		boolean cond = ((Televisor) e1).getSmart();
		print_test("Obtengo Smart de un televisorde constructor completo", cond);
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
