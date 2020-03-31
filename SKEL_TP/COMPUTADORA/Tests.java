import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
	private int USO_CPU_COMPTUADORA_ENCENDIDA = 90;
	private int COSTO_CPU_INSTALAR_PROGRAMA= 20;
	private int COSTO_CPU_DESINSTALAR_PROGRAMA= 15;
	private int COSTO_CPU_ABRIR_PROGRAMA= 5;
	
	@Test
	public void test01CreoObjetoComputadora() {
		new Computadora("Windows",1024,4096);
		print_test("Esta creada la clase computadora correctamente",true);
	}
	
	@Test
	public void test02ComprueboAtributosInicialesComputadora() {
		Computadora c = new Computadora("Windows",1024,4096);
		int cantAbiertos = c.cantidadProgramasAbiertos();
		int cantInstalados = c.cantidadProgramasInstalados();
		int pRestanteCPU = c.porcentajeRestanteCPU();
		ArrayList<String> instalados = c.getInstalados();
		ArrayList<String> abiertos = c.getAbiertos();
		boolean encendida = c.encendida();
		String sisop = c.sistemaOperativo();
		print_test("Al crear una nueva Computadora la cantidad de programas abiertos es 0",cantAbiertos==0);
		print_test("Al crear una nueva Computadora la cantidad de programas instalados es 0", cantInstalados==0);
		print_test("Al crear una nueva Computadora el porcentaje restante de CPU es 100", pRestanteCPU==100);
		print_test("Al crear una nueva Computadora la lista de programas abiertos esta vacia", abiertos.isEmpty());
		print_test("Al crear una nueva Computadora la lista de programas instalados esta vacia", instalados.isEmpty());
		print_test("Al crear la Computadora se crea apagada",!encendida);
		print_test("Elegi Windows para la Computadora nueva, al consultar el SO devuelve Windows",sisop.equals("Windows"));
		print_test("Creo la Computadora con 1024 GB de almacenamiento, restan 1024 GB", c.almacenamientoDisponible()==1024);
		print_test("Creo la Computadora con 4096 MB de memoria, restan 4096 MB", c.memoriaDisponible()==4096);
		
	}
	
	@Test
	public void test03EnciendoUnaComputadoraApagada(){
		Computadora c = new Computadora("Ubuntu",1024,4096);
		print_test("La computadora inicialmente esta apagada",!c.encendida());
		c.encenderApagar();
		boolean condition = c.encendida() && c.porcentajeRestanteCPU()==USO_CPU_COMPTUADORA_ENCENDIDA;
		print_test("Luego de encender la computadora, la misma figura encendida y su procentaje restante de CPU es del 90 porciento",condition);		
	}
	
	@Test
	public void test04ApagoUnaComputadoraEncendida(){
		Computadora c = new Computadora("Ubuntu",1024,4096);
		c.encenderApagar();
		print_test("La computadora inicialmente esta encendida",c.encendida());
		c.encenderApagar();
		boolean condition = !c.encendida() && c.porcentajeRestanteCPU()==100;
		print_test("Luego de apagar la computadora, la misma figura no encendida y su procentaje restante de CPU es del 100 porciento",condition);		
	}
	
	@Test
	public void test05ApagoYPrendoMuchasVeces(){
		Computadora c = new Computadora("Ubuntu",1024,4096);
		for (int i = 0; i < 100; i++) {
			c.encenderApagar();
		}
		print_test("Ejecuto 100 veces consecutivas el metodo encenderApagar, la Computadora queda apagada",!c.encendida());			
	}
	
	@Test
	public void test06InstaloUnProgramaConPCApagada(){
		Computadora c = new Computadora("Ubuntu",10,10);
		boolean succes = c.instalarPrograma("Eclipse",1,1);
		print_test("Intento instalar un programa con la computadora apagada, no se puede",!succes);
	}
	
	@Test
	public void test07InstaloProgramaCorrectamente(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		boolean succes = c.instalarPrograma("Eclipse",1,1);
		print_test("Instalo un programa de la manera correcta", succes);
	}
	
	@Test
	public void test08InstaloProgramaSinAlmacenamientoSuficiente(){
		Computadora c = new Computadora("Ubuntu",1,10);
		c.encenderApagar();
		boolean succes = c.instalarPrograma("Eclipse",10,1);
		print_test("Instalo un programa sin capacidad suficente de almacenamiento en la Computadora", succes);
	
		
	}
	
	@Test
	public void test09ComprueboUsoDeCPULuegDeInstalarPrograma(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",10,1);
		boolean condition = c.porcentajeRestanteCPU() == USO_CPU_COMPTUADORA_ENCENDIDA;
		print_test("Compruebo el uso del CPU luego de instalar un programa, no debe verse modificado", condition);
	
	}

	@Test
	public void test10ComprueboAlmacenamientoLuegoDeInstalarPrograma(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",10,20);
		int almacenamiento_restante_eseperado = 90;
		boolean condition = c.almacenamientoDisponible() == almacenamiento_restante_eseperado;
		print_test("Una vez instalado un programa el alamcenamiento disponible se reduce en exactamente la cantidad de GB del programa instlaado",condition);
		
	}
	
	@Test
	public void test11ComprueboMemoriaLuegoDeInstalarProgramaNoDebeTenerModificaciones(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",10,20);
		int memoria_restante_eseperada = 100;
		boolean condition = c.memoriaDisponible() == memoria_restante_eseperada;
		print_test("Una vez instalado un programa la memoria disponible no se redujo",condition);
				
	}
	
	@Test
	public void test12ComprueboProgramaEnLaListaDeInstalados(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		ArrayList<String> lista = c.getInstalados();
		boolean condition = lista.contains("Eclipse");
		print_test("Instalo un programa y compruebo que este en la lista de programas instalados", condition);
	}
	
	
	@Test
	public void test12bisInstaloDosVecesElMismoProgramaDebeSerFalse(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		boolean succes = c.instalarPrograma("Eclipse", 2, 2);
		print_test("Instalo 2 veces un programa con el mismo nombre, la instalacion debe fallar", !succes);
	}
	
	@Test
	public void test12bis2InstaloDosVecesElMismoProgramaLaListaDeInstaladosDebeContenerloUnaVez(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		c.instalarPrograma("Eclipse", 2, 2);
		ArrayList<String> lista = c.getInstalados();
		boolean condition = Collections.frequency(lista, "Eclipse") == 1;
		print_test("Instalo 2 veces un programa con el mismo nombre, en la lista de instalados aparece una sola vez", condition);
	}
	
	
	@Test
	public void test13ComprueboProgramaEnCantidadDeProgramasInstalados(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		int cant = c.cantidadProgramasInstalados();
		boolean condition = cant == 1;
		print_test("Instalo un programa y compruebo que este en la lista de programas instalados", condition);
	}
	
	@Test
	public void test14CDesistaloProgramaConComputadoraApagada(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		c.encenderApagar();
		boolean succes = c.desInstalarPrograma("Eclipse");
		print_test("Desisntalo un programa con la Computadora apagada, debe fallar la desisntalacion", !succes);
	
	}
	
	@Test
	public void test15CDesistaloProgramaNoInstalado(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		boolean succes = c.desInstalarPrograma("Eclipse");
		print_test("Desisntalo un programa no instalado, debe fallar la desisntalacion", !succes);
	
	}
	
	@Test
	public void test16CDesistaloProgramaCorrectamente(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		boolean succes = c.desInstalarPrograma("Eclipse");
		print_test("Desisntalo un programa correctamente", succes);
	
	}
	
	@Test
	public void test17CDesistaloProgramaComprueboAlmacenamientoVuelveAInicial(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		c.desInstalarPrograma("Eclipse");
		boolean condition = c.almacenamientoDisponible() == 10;
		print_test("Desisntalo un programa, devuelve el almacenamiento de manera correcta", condition);
	}
	
	@Test
	public void test17bisCDesistalo2ProgramasComprueboAlmacenamientoVuelveAInicial(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		c.instalarPrograma("NetBeans",3,3);
		c.desInstalarPrograma("Eclipse");
		boolean condition1 = c.almacenamientoDisponible() == 7;
		print_test("Desisntalo primer programa, devuelve el almacenamiento de manera correcta", condition1);
		c.desInstalarPrograma("NetBeans");
		boolean condition2 = c.almacenamientoDisponible() == 10;
		print_test("Desisntalo segundo programa, devuelve el almacenamiento de manera correcta", condition2);
		
	}
	
	@Test
	public void test18CDesistaloProgramaAbiertoDebeFallar(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		c.abrirPrograma("Eclipse");
		boolean succes = c.desInstalarPrograma("Eclipse");
		print_test("Desisntalo un programa abierto, debe fallar", !succes);
	
	}
	
	@Test
	public void test19CDesistaloProgramaYComprueboMemoriaNoDebeTenerModificaciones(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",10,20);
		c.desInstalarPrograma("Eclipse");
		int memoria_restante_eseperada = 100;
		boolean condition = c.memoriaDisponible() == memoria_restante_eseperada;
		print_test("Una vez desinstalado un programa la memoria disponible no se redujo",condition);
		
	}
	
	@Test
	public void test20CDesistaloProgramaYComprueboListaDeProgramasInstalados(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		c.desInstalarPrograma("Eclipse");
		ArrayList<String> lista = c.getInstalados();
		boolean condition = !lista.contains("Eclipse");
		print_test("Desisntalo un programa abierto, debe fallar", condition);
	}

	@Test
	public void test21CDesistaloProgramaYComprueboCantidadDeProgramasInstalados(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse",1,1);
		c.desInstalarPrograma("Eclipse");
		int cantidad  = c.cantidadProgramasInstalados();
		boolean condition = cantidad==0;
		print_test("Desisntalo un programa abierto, debe fallar", condition);
	}
	
	@Test
	public void test22InstaloProgramaSinCapacidadDeCPU(){
		Computadora c = new Computadora("Ubuntu",10,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		for (int i = 0; i < 15; i++) {
			c.abrirPrograma("Eclipse");
		}
		boolean succes = c.instalarPrograma("NetBeans", 5, 3);
		print_test("Instalo un programa sin capacidad suficiente de CPU, no se completa la instalacion",!succes);
	}
	
	@Test
	public void test23DesinstaloProgramaSinCapacidadDeCPU(){
		Computadora c = new Computadora("Ubuntu",10,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans", 5, 3);
		for (int i = 0; i < 18; i++) {
			c.abrirPrograma("Eclipse");
		}
		boolean succes = c.desInstalarPrograma("NetBeans");
		print_test("Desinstalo un programa sin capacidad suficiente de CPU, no se completa la instalacion",!succes);
	
	}
	
	@Test
	public void test24AbroProgramaCorrectamente(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		boolean succes = c.abrirPrograma("Eclipse");
		print_test("Abro programa de forma correcta",succes);
	}
	

	@Test
	public void test25AbroProgramaYComprueboUsoCPU(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.abrirPrograma("Eclipse");
		int cpu_esperado = USO_CPU_COMPTUADORA_ENCENDIDA - COSTO_CPU_ABRIR_PROGRAMA;
		boolean condition = cpu_esperado == c.porcentajeRestanteCPU();
		print_test("Abro un programa y compruebo el uso de CPU de la Computadora",condition);
		
	}
	

	@Test
	public void test26AbroProgramaVariasVecesYComprueboUsoCPU(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		int cpu_esperado = USO_CPU_COMPTUADORA_ENCENDIDA - 5 * COSTO_CPU_ABRIR_PROGRAMA;
		boolean condition = cpu_esperado == c.porcentajeRestanteCPU();
		print_test("Abro varias veces un programa y compruebo el uso de CPU de la Computadora",condition);
	}
	

	@Test
	public void test27AbroProgramasDiferentesYComprueboUsoCPU(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans",2,3);
		c.instalarPrograma("AndroidStudio", 3, 4);
		c.instalarPrograma("Atom", 5, 6);
		c.instalarPrograma("VisualStudio Code", 7, 8);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("AndroidStudio");
		c.abrirPrograma("Atom");
		c.abrirPrograma("VisualStudio Code");
		int cpu_esperado = USO_CPU_COMPTUADORA_ENCENDIDA - 5 * COSTO_CPU_ABRIR_PROGRAMA;
		boolean condition = cpu_esperado == c.porcentajeRestanteCPU();
		print_test("Abro varios programas diferentes y compruebo el uso de CPU de la Computadora",condition);
		
	}
	
	
	@Test
	public void test28AbroProgramaYComprueboUsoDeMemoria(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 5);
		c.abrirPrograma("Eclipse");
		int memoria_esperada = 5;
		boolean condition = memoria_esperada == c.memoriaDisponible();
		print_test("Abro un programa y compruebo el uso de memoria de la Computadora",condition);	
	}
	

	@Test
	public void test29AbroProgramaVariasVecesYComprueboUsoDeMemoria(){
		Computadora c = new Computadora("Ubuntu",10,10);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		int memoria_esperada = 5;
		boolean condition = memoria_esperada == c.memoriaDisponible();
		print_test("Abro varias veces un programa y compruebo el uso de memoria de la Computadora",condition);	
	
	}
	

	@Test
	public void test30AbroProgramasDiferentesYComprueboUsoDeMemoria(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans",2,3);
		c.instalarPrograma("AndroidStudio", 3, 4);
		c.instalarPrograma("Atom", 5, 6);
		c.instalarPrograma("VisualStudio Code", 7, 8);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("AndroidStudio");
		c.abrirPrograma("Atom");
		c.abrirPrograma("VisualStudio Code");
		int memoria_esperada = 100-1-3-4-6-8;
		boolean condition = memoria_esperada == c.memoriaDisponible();
		print_test("Abro varios programas diferentes y compruebo el uso de memoria de la Computadora",condition);	
	
		
	}
	
	
	@Test
	public void test30bisAbroProgramasDiferentesVariasVecesYComprueboUsoDeMemoria(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans",2,3);
		c.instalarPrograma("AndroidStudio", 3, 4);
		c.instalarPrograma("Atom", 5, 6);
		c.instalarPrograma("VisualStudio Code", 7, 8);

		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");

		c.abrirPrograma("NetBeans");
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("NetBeans");
		
		c.abrirPrograma("AndroidStudio");
		c.abrirPrograma("AndroidStudio");
		
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		
		c.abrirPrograma("VisualStudio Code");
		c.abrirPrograma("VisualStudio Code");
		c.abrirPrograma("VisualStudio Code");
		
		int memoria_esperada = 100- 2*1 - 3*3 - 2*4 - 5*6 - 3*8;
		boolean condition = memoria_esperada == c.memoriaDisponible();
		print_test("Abro varias veces varios programas distintos y compruebo el uso de memoria de la Computadora",condition);	
	
		
	}

	@Test
	public void test31AbroDosProgramasDiferentesYDejoSinMemoriaLaPCDebeFallar(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 99);
		c.instalarPrograma("NetBeans",2,2);
		c.abrirPrograma("Eclipse");
		boolean succes = c.abrirPrograma("NetBeans");
		print_test("Abro dos programas diferentes, el segundo no entra en la memoria, falla su apertura", !succes);
		
	}
	
	

	@Test
	public void test32AbroProgramasNoInstalado(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		boolean succes = c.abrirPrograma("NetBeans");
		print_test("Intento abrir programa no instalado, falla la apertura", !succes);
	
	}
	
	@Test
	public void test33ComprueboListaProgramasAbiertos(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans",2,3);
		c.instalarPrograma("AndroidStudio", 3, 4);
		c.instalarPrograma("Atom", 5, 6);
		c.instalarPrograma("VisualStudio Code", 7, 8);

		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");

		c.abrirPrograma("NetBeans");
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("NetBeans");
		
		c.abrirPrograma("AndroidStudio");
		c.abrirPrograma("AndroidStudio");
		
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		c.abrirPrograma("Atom");
		
		c.abrirPrograma("VisualStudio Code");
		c.abrirPrograma("VisualStudio Code");
		c.abrirPrograma("VisualStudio Code");
		
		ArrayList<String> lista = c.getAbiertos();
		boolean c1 = lista.contains("Eclipse") && Collections.frequency(lista, "Eclipse") == 2;
		boolean c2 = lista.contains("NetBeans") && Collections.frequency(lista, "NetBeans") == 3;
		boolean c3 = lista.contains("AndroidStudio") && Collections.frequency(lista, "AndroidStudio") == 2;
		boolean c4 = lista.contains("Atom") && Collections.frequency(lista, "Atom") == 5;
		boolean c5 = lista.contains("VisualStudio Code") && Collections.frequency(lista, "VisualStudio Code") == 3;
		boolean condition = c1 && c2 && c3 && c4 && c5;
		print_test("Compruebo lista de programas abiertos con varias aperturas de diferentes programas",condition);
	}
	
	@Test
	public void test34AbroProgramaComputadoraApagada(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.encenderApagar();
		boolean succes = c.abrirPrograma("Eclipse");
		print_test("Intento abrir programa con Computadora apagada, debe fallar",!succes);
	}
	
	
	@Test
	public void test35CierroProgramaConComputadoraApagada(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.abrirPrograma("Eclipse");
		c.encenderApagar();
		boolean succes = c.cerrarPrograma("Eclipse");
		print_test("Intento cerrar programa con Computadora apagada, debe fallar",!succes);
	}
	
	@Test
	public void test36CierroProgramaAntesDeAbrir(){
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		boolean succes = c.cerrarPrograma("Eclipse");
		print_test("Intento cerrar programa antes de abrirlo",!succes);
	
	}
	
	@Test
	public void test37CierroProgramaVariasVecesHastaQueNoSePuedaMas() {
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		
		boolean succes = c.cerrarPrograma("Eclipse");
		print_test("Intento 1 cerrar programa abierto, debe cerrar bien",succes);
		succes = c.cerrarPrograma("Eclipse");
		print_test("Intento 2 cerrar programa abierto, debe cerrar bien",succes);
		succes = c.cerrarPrograma("Eclipse");
		print_test("Intento 3 cerrar programa abierto, debe cerrar bien",succes);
		succes = c.cerrarPrograma("Eclipse");
		print_test("Intento 4 cerrar programa abierto, debe cerrar bien",succes);
		succes = c.cerrarPrograma("Eclipse");
		print_test("Intento 5 cerrar programa abierto, debe cerrar bien",succes);
		succes = c.cerrarPrograma("Eclipse");
		print_test("Ya no quedan programas abierto, intento cerrar igual y falla",!succes);
		
	}

	@Test
	public void test38CierroProgramaComprueboCPU() {
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.abrirPrograma("Eclipse");
		c.cerrarPrograma("Eclipse");
		boolean condition = c.porcentajeRestanteCPU() == USO_CPU_COMPTUADORA_ENCENDIDA;
		print_test("Cierro un programa, compruebo que devolvio el uso del CPU",condition);
	}
	
	@Test
	public void test39CierroProgramaVariasVecesComprueboCPU() {
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		
		for (int i = 4; i> 0; i--) {
			c.cerrarPrograma("Eclipse");
			boolean condition = c.porcentajeRestanteCPU() == USO_CPU_COMPTUADORA_ENCENDIDA - COSTO_CPU_ABRIR_PROGRAMA * i;
			print_test("Cierro "+ (5-i) + " programa/s de 5, compruebo que devolvio el uso del CPU",condition);
		}
	}
	
	@Test
	public void test40CierroVariosProgramaComprueboCPU() {
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans", 1, 1);
		c.instalarPrograma("Atom", 1, 1);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("Atom");
		c.cerrarPrograma("Eclipse");
		c.cerrarPrograma("NetBeans");
		c.cerrarPrograma("Atom");
		boolean condition = c.porcentajeRestanteCPU() == USO_CPU_COMPTUADORA_ENCENDIDA;
		print_test("Cierro varios programas, compruebo que devolvio el uso del CPU en su totalidad",condition);
	}
	
	
	@Test
	public void test41CierroProgramaComprueboMemoria() {
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 15);
		c.abrirPrograma("Eclipse");
		c.cerrarPrograma("Eclipse");
		boolean condition = c.memoriaDisponible() == 100;
		print_test("Cierro un programa, compruebo que devolvio el uso de memoria en su totalidad",condition);
	}
	
	@Test
	public void test42CierroProgramaVariasVecesComprueboMemoria() {
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 15);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("Eclipse");
		
		for (int i = 4; i> 0; i--) {
			c.cerrarPrograma("Eclipse");
			boolean condition = c.memoriaDisponible() == 100 - 15 * i;
			print_test("Cierro "+ (5-i) + " programa/s de 5, compruebo que devolvio el uso de memoria",condition);
		}
	}
	
	@Test
	public void test43CierroVariosProgramaComprueboMemoria() {
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans", 1, 1);
		c.instalarPrograma("Atom", 1, 1);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("Atom");
		c.cerrarPrograma("Eclipse");
		c.cerrarPrograma("NetBeans");
		c.cerrarPrograma("Atom");
		boolean condition = c.memoriaDisponible() == 100;
		print_test("Cierro varios programas, compruebo que devolvio el uso de memoria en su totalidad",condition);
	}
	
	
	
	@Test
	public void testIntegracio01(){
		System.out.println("Test de integracion 1: Prueba de memoria");
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 99);
		c.instalarPrograma("NetBeans",2,2);
		c.abrirPrograma("Eclipse");
		boolean succes = c.abrirPrograma("NetBeans");
		boolean condition = !succes && c.memoriaDisponible() == 1;
		print_test("Instalo un programa de mucha memoria y otro de poca, Abro el de mucha y no puedo abrir el de poca", condition);
		c.cerrarPrograma("Eclipse");
		condition = c.memoriaDisponible()==100;
		print_test("Cierro el que consume mucha memoria y devolvio todo", condition);
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("NetBeans");
		condition = c.memoriaDisponible()==96;
		print_test("Abro dos de los que consumen poco, la memoria sigue coherente", condition);
		c.cerrarPrograma("NetBeans");
		c.cerrarPrograma("NetBeans");
		condition = c.memoriaDisponible()==100;
		print_test("Cierro dos de los que consumen poco. La memoria vuelve a su capacidad total", condition);
		System.out.println("FIN: Test de integracion 1");
		
		
	}
	
	@Test
	public void testIntegracio02(){
		// prendo instalo abro cierro y desisntalo y apago
		System.out.println("Test de integracion 2: Ciclo de vida completo");
		
		Computadora c = new Computadora("Ubuntu",100,100);
		boolean condition = "Ubuntu".equals(c.sistemaOperativo()) && !c.encendida();
		print_test("Creo una pc con Ubuntu y apgada", condition);
		
		c.encenderApagar();
		condition = c.encendida();
		print_test("Enciendo Computadora", condition);
		
		condition = c.instalarPrograma("Eclipse", 1, 10) && c.almacenamientoDisponible() == 99;
		print_test("Instalo programa y consume espacio de almacenamiento", condition);
		
		condition = c.abrirPrograma("Eclipse");
		print_test("Abro programa instalado", condition);
		
		condition = c.porcentajeRestanteCPU() == USO_CPU_COMPTUADORA_ENCENDIDA - COSTO_CPU_ABRIR_PROGRAMA && c.memoriaDisponible() == 90;
		print_test("Consume correctamente CPU y memoria", condition);
		
		condition = c.cerrarPrograma("Eclipse");
		print_test("Cierro programa abierto", condition);
		
		condition = c.porcentajeRestanteCPU() == USO_CPU_COMPTUADORA_ENCENDIDA && c.memoriaDisponible() == 100;
		print_test("Devuelve correctamente CPU y memoria", condition);
		
		condition = c.desInstalarPrograma("Eclipse") && c.almacenamientoDisponible() == 100;
		print_test("Desisntalo programa y devuelve almacenamiento", condition);
		
		c.encenderApagar();;
		condition = !c.encendida() && c.porcentajeRestanteCPU() == 100;
		print_test("Apago computadora todo el CPU disponible", condition);
		
		System.out.println("FIN: Test de integracion 2.");
		
		
		
		
	}
	
	
	
	@Test
	public void testIntegracion03() {
		System.out.println("Test integracion 3: Cierro todo apagando Computadora");
		Computadora c = new Computadora("Ubuntu",100,100);
		c.encenderApagar();
		c.instalarPrograma("Eclipse", 1, 1);
		c.instalarPrograma("NetBeans", 1, 1);
		c.instalarPrograma("Atom", 1, 1);
		c.abrirPrograma("Eclipse");
		c.abrirPrograma("NetBeans");
		c.abrirPrograma("Atom");
		c.encenderApagar();
		boolean condition = !c.encendida() && c.memoriaDisponible() == 100 && c.porcentajeRestanteCPU() == 100 && c.cantidadProgramasAbiertos() == 0;
		print_test("Cierro programas, apagando la computadora",condition);
		System.out.println("FIN: Test integracion 3");
		
	}
	
	
	
	
	
	
	

	public void print_test(String msg, boolean ok) {
		System.out.flush();
		String res = ok ? "OK":"ERROR";
		System.out.printf("%s...%s \n", msg, res);
		assertTrue(ok);
	}
}
