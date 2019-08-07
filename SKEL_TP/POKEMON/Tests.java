

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

public class Tests {
	//Declaro las constantes
	final double VIDA_HOOH=500;
	final double VIDA_ARTICUNO=450;
	final double VIDA_LAPRAS=450;
	final double VIDA_TREECKO=90;
	final double VIDA_ENTEI=350;
	
	final double ATAQUE_HOOH=350;
	final double ATAQUE_ARTICUNO=250;
	final double ATAQUE_LAPRAS=150;
	final double ATAQUE_TREECKO=90;
	final double ATAQUE_ENTEI=300;
	
	final double DEFENSA_HOOH=150;
	final double DEFENSA_ARTICUNO=200;
	final double DEFENSA_LAPRAS=300;
	final double DEFENSA_TREECKO=120;
	final double DEFENSA_ENTEI=100;
	

	final double VELOCIDAD_HOOH=150;
	final double VELOCIDAD_ARTICUNO=200;
	final double VELOCIDAD_LAPRAS=50;
	final double VELOCIDAD_TREECKO=150;
	final double VELOCIDAD_ENTEI=250;
		

	final double RESISTENCIA_HOOH=10;
	final double RESISTENCIA_ARTICUNO=9;
	final double RESISTENCIA_LAPRAS=4;
	final double RESISTENCIA_TREECKO=2;
	final double RESISTENCIA_ENTEI=8;


	final double PODER_LLAMARADA = 20;
	final double PODER_SOFOCO = 50;
	final double PODER_VENTISCA = 50;
	final double PODER_ATAQUEDEALA = 10;
	final double PODER_TORNADO= 5;
	final double PODER_SURF= 15;
	final double PODER_HIDROBOMBA=30;
	final double PODER_LATIGOCEPA= 20;
	final double PODER_HOJAAGUDA=35;
	final double PODER_INFINITO=1000000;
	
	final int USOS_HOJA_AGUDA=5;
	
	
	
	@Test
	public void test01CreoHoOhQueVerifiQueLasInterfacesCorrespondientes(){
		HoOh h = new HoOh();
		boolean condition=false;
		if (h instanceof TipoFuego && h instanceof TipoVolador) condition=true;
		print_test("Nuevo Ho-Oh, es tipo fuego y tipo volador", condition);
	}

	@Test
	public void test02CreoArticunoQueVerifiQueLasInterfacesCorrespondientes(){
		Articuno a = new Articuno();
		boolean condition=false;
		if (a instanceof TipoHielo && a instanceof TipoVolador) condition=true;
		print_test("Nuevo Articuno, es tipo hielo y tipo volador", condition);
	}
	
	@Test
	public void test03CreoLaprasQueVerifiQueLasInterfacesCorrespondientes(){
		Lapras l = new Lapras();
		boolean condition=false;
		if (l instanceof TipoAgua && l instanceof TipoHielo) condition=true;
		print_test("Nuevo Lapras, es tipo agua y tipo hielo", condition);
	}
	
	@Test
	public void test04CreoTreeckoQueVerifiQueLasInterfacesCorrespondientes(){
		Treecko t = new Treecko();
		boolean condition=false;
		if (t instanceof TipoPlanta) condition=true;
		print_test("Nuevo Treecko, es tipo planta", condition);
	}
	
	@Test
	public void test05CreoEnteiQueVerifiQueLasInterfacesCorrespondientes(){
		Entei h = new Entei();
		boolean condition=false;
		if (h instanceof TipoFuego) condition=true;
		print_test("Nuevo Entei, es tipo fuego", condition);
	}
	@Test
	public void test06ComprueboAtributosInicialesHoOh(){
		HoOh h = new HoOh();
		boolean condition = h.getAtaque() == ATAQUE_HOOH
				&& h.getDefensa() == DEFENSA_HOOH
				&& h.getVida() == VIDA_HOOH
				&& h.getVelocidad() == VELOCIDAD_HOOH
				&& h.getResistencia() == RESISTENCIA_HOOH
				&& h.getSalvaje()==true;
		print_test("Compruebo los atributos iniciales de Ho-Oh", condition);
		
	}

	@Test
	public void test07ComprueboAtributosInicialesArticuno(){
		Articuno h = new Articuno();
		boolean condition = h.getAtaque() == ATAQUE_ARTICUNO
				&& h.getDefensa() == DEFENSA_ARTICUNO
				&& h.getVida() == VIDA_ARTICUNO
				&& h.getVelocidad() == VELOCIDAD_ARTICUNO
				&& h.getResistencia() == RESISTENCIA_ARTICUNO
				&& h.getSalvaje()==true;
		print_test("Compruebo los atributos iniciales de Articuno", condition);
		
	}
	
	@Test
	public void test08ComprueboAtributosInicialesLapras(){
		Lapras h = new Lapras();
		boolean condition = h.getAtaque() == ATAQUE_LAPRAS
				&& h.getDefensa() == DEFENSA_LAPRAS
				&& h.getVida() == VIDA_LAPRAS
				&& h.getVelocidad() == VELOCIDAD_LAPRAS
				&& h.getResistencia() == RESISTENCIA_LAPRAS
				&& h.getSalvaje()==true;
		print_test("Compruebo los atributos iniciales de Lapras", condition);
		
	}
	@Test
	public void test09ComprueboAtributosInicialesTreecko(){
		Treecko h = new Treecko();
		boolean condition = h.getAtaque() == ATAQUE_TREECKO
				&& h.getDefensa() == DEFENSA_TREECKO
				&& h.getVida() == VIDA_TREECKO
				&& h.getVelocidad() == VELOCIDAD_TREECKO
				&& h.getResistencia() == RESISTENCIA_TREECKO
				&& h.getSalvaje()==true;
		print_test("Compruebo los atributos iniciales de Treecko", condition);
		
	}
	@Test
	public void test10ComprueboAtributosInicialesEntei(){
		Entei h = new Entei();
		boolean condition = h.getAtaque() == ATAQUE_ENTEI
				&& h.getDefensa() == DEFENSA_ENTEI
				&& h.getVida() == VIDA_ENTEI
				&& h.getVelocidad() == VELOCIDAD_ENTEI
				&& h.getResistencia() == RESISTENCIA_ENTEI
				&& h.getSalvaje()==true;
		print_test("Compruebo los atributos iniciales de Ho-Oh", condition);
		
	}
	@Test
	public void test11ComprueboLosAtaquesYDanioDeHoOh(){
		HoOh h = new HoOh();
		HoOh test = new HoOh();

		//Compruebo la llamarada
		h.llamarada(test);
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo la llamarada de HoOh, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();

		//Compruebo el sofoco
		h.sofoco(test);
		potenciaDeAtaque = h.getAtaque() * PODER_SOFOCO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el sofoco de HoOh, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el ataque de ala
		h.ataqueDeAla(test);
		potenciaDeAtaque = h.getAtaque() * PODER_ATAQUEDEALA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque de ala de HoOh, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el tornado
		h.tornado(test);
		potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el tornado de HoOh, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
						
		
		
	}
	
	@Test
	public void test12ComprueboOrdenDeAtaquesYDanioDeHoOh(){
		HoOh h = new HoOh();
		HoOh test = new HoOh();

		//Compruebo la llamarada
		h.atacar(test, 1);
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque 1 de HoOh, es la llamarada",vidaActual==test.getVida());
		test.curar();

		//Compruebo el sofoco
		h.atacar(test, 2);
		potenciaDeAtaque = h.getAtaque() * PODER_SOFOCO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque 2 de HoOh, es sofoco",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el ataque de ala
		h.atacar(test, 3);
		potenciaDeAtaque = h.getAtaque() * PODER_ATAQUEDEALA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque 3 de HoOh, es ataque de ala",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el tornado
		h.atacar(test, 4);
		potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque de HoOh, es tornado",vidaActual==test.getVida());
		test.curar();		
	}
	
	@Test
	public void test13ComprueboLosAtaquesYDanioDeArticuno(){
		Articuno h = new Articuno();
		HoOh test = new HoOh();

		//Compruebo el rayo hielo
		h.rayoHielo(test);
		print_test("Pruebo la el rayo hielo de articuno, el rival queda congelado",test.congelado());
		test.curar();

		//Compruebo la ventisca
		h.ventisca(test);
		double potenciaDeAtaque = h.getAtaque() * PODER_VENTISCA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo la ventisca de Articuno, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el ataque de ala
		h.ataqueDeAla(test);
		potenciaDeAtaque = h.getAtaque() * PODER_ATAQUEDEALA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque de ala de Articuno, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el tornado
		h.tornado(test);
		potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el tornado de Articuno, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
				
	}

	@Test
	public void test14ComprueboOrdenDeAtaquesDeArticuno(){
		Articuno h = new Articuno();
		HoOh test = new HoOh();

		//Compruebo el rayo hielo
		h.atacar(test,1);
		print_test("Pruebo el ataque 1 de Articuno, es rayo hielo",test.congelado());
		test.curar();

		//Compruebo la venteisca
		h.atacar(test,2);
		double potenciaDeAtaque = h.getAtaque() * PODER_VENTISCA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque 2 de Articuno, es ventisca",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el ataque de ala
		h.atacar(test,3);
		potenciaDeAtaque = h.getAtaque() * PODER_ATAQUEDEALA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque 3 de Articuno, es ataque de ala",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el tornado
		h.atacar(test,4);
		potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque 4 de Articuno, es tornado",vidaActual==test.getVida());
		test.curar();
				
	}
	
	@Test
	public void test15ComprueboLosAtaquesYDanioDeLapras(){
		Lapras h = new Lapras();
		HoOh test = new HoOh();

		//Compruebo el rayo hielo
		h.rayoHielo(test);
		print_test("Pruebo la el rayo hielo de Lapras, el rival queda congelado",test.congelado());
		test.curar();

		//Compruebo la ventisca
		h.ventisca(test);
		double potenciaDeAtaque = h.getAtaque() * PODER_VENTISCA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo la ventisca de Lapras, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo el surf
		h.surf(test);
		potenciaDeAtaque = h.getAtaque() * PODER_SURF / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el surf de Lapras, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo hidrobomba
		h.hidrobomba(test);
		potenciaDeAtaque = h.getAtaque() * PODER_HIDROBOMBA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo la hidrobomba de Lapras, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
				
	}

	@Test
	public void test16ComprueboOrdenDeAtaquesDeLapras(){
		Lapras h = new Lapras();
		HoOh test = new HoOh();

		//Compruebo el surf
		h.atacar(test,1);
		double potenciaDeAtaque = h.getAtaque() * PODER_SURF / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el surf de Lapras, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo hidrobomba
		h.atacar(test,2);
		potenciaDeAtaque = h.getAtaque() * PODER_HIDROBOMBA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo la hidrobomba de Lapras, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo rayo hielo
		h.atacar(test,3);
		print_test("Pruebo el ataque 3 de Lapras, es rayo hielo",test.congelado());
		test.curar();
		
		//Compruebo ventisca
		h.atacar(test,4);
		potenciaDeAtaque = h.getAtaque() * PODER_VENTISCA/ h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo el ataque 4 de Lapras, es hidrobomba",vidaActual==test.getVida());
		test.curar();
				
	}
	
	
	
	@Test
	public void test17ComprueboLosAtaquesYDanioDeTreecko(){
		Treecko h = new Treecko();
		HoOh test = new HoOh();


		//Compruebo latigo cepa
		h.latigoCepa(test);
		double potenciaDeAtaque = h.getAtaque() * PODER_LATIGOCEPA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo latigo cepa de Treecko, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		

		//Compruebo hoja aguda
		h.hojaAguda(test);
		potenciaDeAtaque = h.getAtaque() * PODER_HOJAAGUDA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo hoja aguda de Treecko, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
	}

	@Test
	public void test18ComprueboOrdenDeAtaquesDeTreecko(){
		Treecko h = new Treecko();
		HoOh test = new HoOh();

		//Compruebo latigo cepa
		h.atacar(test,1);
		double potenciaDeAtaque = h.getAtaque() * PODER_LATIGOCEPA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo ataque 1 de Treecko, es latigo cepa",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo hidrobomba
		h.atacar(test,2);
		potenciaDeAtaque = h.getAtaque() * PODER_HOJAAGUDA / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo ataque 2 de Treecko, es hoja aguda",vidaActual==test.getVida());
		test.curar();	
	}
	

	
	@Test
	public void test19ComprueboLosAtaquesYDanioDeEntei(){
		Entei h = new Entei();
		HoOh test = new HoOh();


		//Compruebo llamarada
		h.llamarada(test);
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo llamarada de Entei, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
		

		//Compruebo sofoco
		h.sofoco(test);
		potenciaDeAtaque = h.getAtaque() * PODER_SOFOCO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo sofoco de Entei, la potencia del ataque es correcta",vidaActual==test.getVida());
		test.curar();
	}

	@Test
	public void test20ComprueboOrdenDeAtaquesDeEntei(){
		Entei h = new Entei();
		HoOh test = new HoOh();

		//Compruebo llamarada
		h.atacar(test,1);
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=test.defender(potenciaDeAtaque);
		double vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo ataque 1 de Entei, es llamarada",vidaActual==test.getVida());
		test.curar();
		
		//Compruebo sofoco
		h.atacar(test,2);
		potenciaDeAtaque = h.getAtaque() * PODER_SOFOCO / h.getVelocidad();
		defensa=test.defender(potenciaDeAtaque);
		vidaActual= VIDA_HOOH - potenciaDeAtaque + defensa; 
		print_test("Pruebo ataque 2 de Entei, es sofoco",vidaActual==test.getVida());
		test.curar();	
	}
	
	
	@Test
	public void test21comprueboNinvalidoHoOh() {
		try {
			Pokemon p = new HoOh();
			p.atacar(new HoOh(),5);
			print_test("Numero n de ataque invalido HoOh", false);

		} catch (IllegalArgumentException e) {
			print_test("Numero n de ataque invalido HoOh", true);
		}
	}
	

	@Test
	public void test22comprueboNinvalidoArticuno() {
		try {
			Pokemon p = new Articuno();
			p.atacar(new HoOh(),5);
			print_test("Numero n de ataque invalido Articuno", false);

		} catch (IllegalArgumentException e) {
			print_test("Numero n de ataque invalido Articuno", true);
		}
	}
	
	@Test
	public void test23comprueboNinvalidoLapras() {
		try {
			Pokemon p = new Lapras();
			p.atacar(new HoOh(),5);
			print_test("Numero n de ataque invalido Lapras", false);

		} catch (IllegalArgumentException e) {
			print_test("Numero n de ataque invalido Lapras", true);
		}
	}
	
	@Test
	public void test24comprueboNinvalidoTreecko() {
		try {
			Pokemon p = new Treecko();
			p.atacar(new HoOh(),3);
			print_test("Numero n de ataque invalido Treecko", false);

		} catch (IllegalArgumentException e) {
			print_test("Numero n de ataque invalido Treecko", true);
		}
	}
	
	@Test
	public void test25comprueboNinvalidoEntei() {
		try {
			Pokemon p = new Entei();
			p.atacar(new HoOh(),3);
			print_test("Numero n de ataque invalido Entei", false);

		} catch (IllegalArgumentException e) {
			print_test("Numero n de ataque invalido Entei", true);
		}
	}
	
	@Test
	public void test26comprueboControncanteHoOh() {
		try {
			Pokemon p = new HoOh();
			p.atacar(null,1);
			print_test("Contrincante invalido HoOh", false);

		} catch (IllegalArgumentException e) {
			print_test("Contrincante invalido HoOh", true);
		}
	}
	
	@Test
	public void test27comprueboControncanteArticuno() {
		try {
			Pokemon p = new Articuno();
			p.atacar(null,1);
			print_test("Contrincante invalido Articuno", false);

		} catch (IllegalArgumentException e) {
			print_test("Contrincante invalido Articuno", true);
		}
	}
	
	@Test
	public void test28comprueboControncanteLapras() {
		try {
			Pokemon p = new Lapras();
			p.atacar(null,1);
			print_test("Contrincante invalido Lapras", false);

		} catch (IllegalArgumentException e) {
			print_test("Contrincante invalido Lapras", true);
		}
	}
	
	@Test
	public void test29comprueboControncanteTreecko() {
		try {
			Pokemon p = new Treecko();
			p.atacar(null,1);
			print_test("Contrincante invalido Treecko", false);

		} catch (IllegalArgumentException e) {
			print_test("Contrincante invalido Treecko", true);
		}
	}
	
	@Test
	public void test30comprueboControncanteHoEntei() {
		String s = "Contrincante invalido Entei";
		try {
			Pokemon p = new Entei();
			p.atacar(null,1);
			print_test(s, false);

		} catch (IllegalArgumentException e) {
			print_test(s, true);
		}
	}
		
	@Test
	public void test31DefensaAtaqueChicoHoOH(){
		Pokemon p = new HoOh();
		double d = p.getDefensa()-PODER_LATIGOCEPA/2;
		print_test("Defensa de Ho-Oh de un ataque de baja intensidad", d==p.defender(PODER_LATIGOCEPA));
	}
	
	@Test
	public void test32DefensaAtaqueChicoArticuno(){
		Pokemon p = new Articuno();
		double d = p.getDefensa()-PODER_LATIGOCEPA/2;
		print_test("Defensa de Articuno de un ataque de baja intensidad", d==p.defender(PODER_LATIGOCEPA));
	}
	
	@Test
	public void test33DefensaAtaqueChicoLapras(){
		Pokemon p = new Lapras();
		double d = p.getDefensa()-PODER_LATIGOCEPA/2;
		print_test("Defensa de Lapras de un ataque de baja intensidad", d==p.defender(PODER_LATIGOCEPA));
	}
	
	@Test
	public void test34DefensaAtaqueChicoTreecko(){
		Pokemon p = new Treecko();
		double d = p.getDefensa()-PODER_LATIGOCEPA/2;
		print_test("Defensa de Treecko de un ataque de baja intensidad", d==p.defender(PODER_LATIGOCEPA));
	}
	
	@Test
	public void test35DefensaAtaqueChicoEntei(){
		Pokemon p = new Entei();
		double d = p.getDefensa()-PODER_LATIGOCEPA/2;
		print_test("Defensa de Entei de un ataque de baja intensidad", d==p.defender(PODER_LATIGOCEPA));
	}
	
	@Test
	public void test36DefensaAtaqueGrandeHoOh(){
		Pokemon p = new HoOh();
		print_test("Defensa de HoOh de un ataque de baja intensidad", p.defender(PODER_INFINITO)==0);
	}
	
	@Test
	public void test36DefensaAtaqueGrandeArticuno(){
		Pokemon p = new Articuno();
		print_test("Defensa de Articuno de un ataque de baja intensidad", p.defender(PODER_INFINITO)==0);
	}
	
	@Test
	public void test36DefensaAtaqueGrandeTreecko(){
		Pokemon p = new Treecko();
		print_test("Defensa de Treecko de un ataque de baja intensidad", p.defender(PODER_INFINITO)==0);
	}
	
	@Test
	public void test36DefensaAtaqueGrandeLapras(){
		Pokemon p = new Lapras();
		print_test("Defensa de Lapras de un ataque de baja intensidad", p.defender(PODER_INFINITO)==0);
	}
	
	@Test
	public void test36DefensaAtaqueGrandeEntei(){
		Pokemon p = new Entei();
		print_test("Defensa de Entei de un ataque de baja intensidad", p.defender(PODER_INFINITO)==0);
	}
	
	@Test
	public void test37ComprueboRestarVidaYCurarHoOh(){
		Pokemon p = new HoOh();
		p.restarVida(20);
		print_test("Resto vida a HoOh, queda se resta bien",p.getVida()==VIDA_HOOH - 20);
		p.curar();
		print_test("curo a HoOh, queda curado",p.getVida()==VIDA_HOOH);
		
	}
	
	@Test
	public void test37ComprueboRestarVidaYCurarTreecko(){
		Pokemon p = new Treecko();
		p.restarVida(20);
		print_test("Resto vida a Treecko, queda se resta bien",p.getVida()==VIDA_TREECKO - 20);
		p.curar();
		print_test("Curo a Treecko, queda curado",p.getVida()==VIDA_TREECKO);
		
	}
	
	@Test
	public void test37ComprueboRestarVidaYCurarLapras(){
		Pokemon p = new Lapras();
		p.restarVida(20);
		print_test("Resto vida a Lapras, queda se resta bien",p.getVida()==VIDA_LAPRAS - 20);
		p.curar();
		print_test("Curo a Lapras, queda curado",p.getVida()==VIDA_LAPRAS);
		
	}
	
	@Test
	public void test37ComprueboRestarVidaYCurarArticuno(){
		Pokemon p = new Articuno();
		p.restarVida(20);
		print_test("Resto vida a Articuno, queda se resta bien",p.getVida()==VIDA_ARTICUNO - 20);
		p.curar();
		print_test("Curo a Articuno, queda curado",p.getVida()==VIDA_ARTICUNO);
		
	}
	
	@Test
	public void test37ComprueboRestarVidaYCurarEntei(){
		Pokemon p = new Entei();
		p.restarVida(20);
		print_test("Resto vida a Entei, queda se resta bien",p.getVida()==VIDA_ENTEI - 20);
		p.curar();
		print_test("Curo a Entei, queda curado",p.getVida()==VIDA_ENTEI);
		
	}
	
	@Test
	public void test38ComprueboIntentarCapturarPokemonRecienCreado(){
		HoOh h = new HoOh();
		double p = h.intentar_capturar();
		print_test("Creo un nuevo Pokemon, al inciar la probabilidad de captura es 0 ", p==0);
	}
	
	@Test
	public void test39ComprueboIntentarCapturarPokemonConVidaSinResistencia(){
		HoOh h = new HoOh();
		double p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		p = h.intentar_capturar();
		
		double res = 1 - 0.7;
		print_test("Creo un nuevo Pokemon, calculo la probabilidad de captura cuando el pkmn no tiene resistencia", p==res);
	}
	
	
	@Test
	public void test40ComprueboIntentarCapturarHoOhSinVidaConResistencia(){
		Pokemon h = new HoOh();
		h.restarVida(VIDA_HOOH-1);
		double p = h.intentar_capturar();
		double res = 1 - (1 / VIDA_HOOH * 0.7 + 0.3);
		print_test("Calculo la probabilidad de captura cuando Ho-Oh no tiene vida, pero si resistencia", p==res);
	}
	
	@Test
	public void test41ComprueboIntentarCapturarArticunoSinVidaConResistencia(){
		Pokemon h = new Articuno();
		h.restarVida(VIDA_ARTICUNO-1);
		double p = h.intentar_capturar();
		double res = 1 - (1 / VIDA_ARTICUNO * 0.7 + 0.3);
		print_test("Calculo la probabilidad de captura cuando Articuno no tiene vida, pero si resistencia", p==res);
	}
	
	@Test
	public void test42ComprueboIntentarCapturarLaprasSinVidaConResistencia(){
		Pokemon h = new Lapras();
		h.restarVida(VIDA_LAPRAS-1);
		double p = h.intentar_capturar();
		double res = 1 - ((1/VIDA_LAPRAS)*0.7 + 0.3);
		print_test("Calculo la probabilidad de captura cuando Lapras no tiene vida, pero si resistencia", p==res);
	}
	
	@Test
	public void test43ComprueboIntentarCapturarTreeckoSinVidaConResistencia(){
		Pokemon h = new Treecko();
		h.restarVida(VIDA_TREECKO-1);
		double p = h.intentar_capturar();
		double res = 1 - ((1/VIDA_TREECKO)*0.7 + 0.3);
		print_test("Calculo la probabilidad de captura cuando Treecko no tiene vida, pero si resistencia", p==res);
	}
	

	@Test
	public void test44ComprueboIntentarCapturarEnteiSinVidaConResistencia(){
		Pokemon h = new Entei();
		h.restarVida(VIDA_ENTEI-1);
		double p = h.intentar_capturar();
		double res = 1 - ((1/VIDA_ENTEI)*0.7 + 0.3);
		print_test("Calculo la probabilidad de captura cuando Entei no tiene vida, pero si resistencia", p==res);
	}
	
	@Test
	public void test45CalculoProbabilidadCapturaEnCasoGeneralConRandomHoOh(){
		Pokemon p = new HoOh();
		int intentos = getRandomNumberInRange(0, (int)	RESISTENCIA_HOOH);
		int restar = getRandomNumberInRange(0, (int)VIDA_HOOH);
		double prob=0;
		p.restarVida(restar);
		for (int i = 0; i < intentos; i++) {
			prob=p.intentar_capturar();
		}
		double res = 1 - (((VIDA_HOOH-restar)/VIDA_HOOH) * 0.7 + ((RESISTENCIA_HOOH-(intentos - 1))/RESISTENCIA_HOOH) * 0.3);
		print_test("Despues de "+ intentos +" intentos y con vida "+ p.getVida()+" la probabilidad de captura es correcta",prob==res);
	}
	
	
	public void test46comprueboRayoHieloPokemonQuedaCongelado(){
		Pokemon p = new HoOh();
		Articuno a = new Articuno();
		a.rayoHielo(p);
		print_test("Ataco un pokemon con rayo hielo, queda congelado",p.congelado());
	}
	
	public void test46comprueboRayoHieloPokemonCongeladoNoPuedeAtacar(){
		String s = "Congelo a un pokemon, intenta atacar y no puede";
		try {
			HoOh p = new HoOh();
			Articuno a = new Articuno();
			a.rayoHielo(p);
			p.llamarada(a);
			print_test(s, false);

		} catch (PokemonCongeladoException e) {
			print_test(s, true);
		}
	}
	
	public void test47comprueboRayoHieloPokemonCongeladoPuedeAtacarLuegoDe3Intentos(){
		String s = "Congelo a un pokemon, se descongela luego de realizar 3 ataques";
		HoOh p = new HoOh();
		Articuno a = new Articuno();
		
		try {
			a.rayoHielo(p);
			p.llamarada(a);
			print_test(s, false);

		} catch (PokemonCongeladoException e) {
			print_test("Primer ataque, congleado, no pudo",p.congelado());
		}
		
		try {
			p.llamarada(a);
			print_test(s, false);
			
		} catch (PokemonCongeladoException e2) {
			print_test("Segundo ataque, congleado, no pudo",p.congelado());
		}
		

		try {
			p.llamarada(a);
			print_test(s, false);
			
		} catch (PokemonCongeladoException e2) {
			print_test("Tercer ataque, congleado, no pudo",p.congelado());
		}
		
		try {
			p.llamarada(a);
			print_test(s, true);
			
		} catch (PokemonCongeladoException e2) {
			print_test(s + " y sigue congelado en el 4to", false);
		}
		
	}
	
	public void test48comprueboSofoRestaAtaquePropioHoOh(){
		HoOh h = new HoOh();
		Lapras l = new Lapras();
		h.sofoco(l);
		print_test("Ho-Oh ataca con sofoco, su propio ataque disminuye",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO);	
	}
	
	public void test49comprueboSofoCuandoNoHayMasAtaque(){
		HoOh h = new HoOh();
		Lapras l = new Lapras();
		System.out.println("Pruebas de ataques de sofoco para HoOH");
		h.sofoco(l);
		l.curar();
		print_test("Primer sofoco el ataque total disminuye en 50 luego del ataque",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO);	
		
		h.sofoco(l);
		l.curar();
		print_test("Segundo sofoco el ataque total disminuye en 100 luego del ataque",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO*2);	
		
		h.sofoco(l);
		l.curar();
		print_test("Tercer sofoco el ataque total disminuye en 150 luego del ataque",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO*3);	
		
		h.sofoco(l);
		l.curar();
		print_test("Cuarto sofoco el ataque total disminuye en 200 luego del ataque",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO*4);	
		
		
		h.sofoco(l);
		l.curar();
		print_test("Quinto sofoco el ataque total disminuye en 250 luego del ataque",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO*5);	
		
		h.sofoco(l);
		l.curar();
		print_test("Sexto sofoco el ataque total disminuye en 300 luego del ataque",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO*6);	
		
		//este ataque es el ultimo que puede realizar 
		h.sofoco(l);
		l.curar();
		print_test("Seprtimo sofoco el ataque total disminuye en 350 luego del ataque",h.getAtaque()==ATAQUE_HOOH-PODER_SOFOCO*7);	
		
		
		print_test("Ho-Oh ataca con sofoco, el ataque final queda en 1",h.getAtaque()==1);	
	}
	
	
	
	@Test
	public void test50compruueboCantidadMaximaDeUsosHojaAguda(){
		Treecko t = new Treecko();
		String s ="Hoja aguda se puede usar maximo 5 veces";
		for (int i = 0; i < USOS_HOJA_AGUDA; i++) {
			t.hojaAguda(new HoOh());
		}
		try {
			t.hojaAguda(new HoOh());
			print_test(s,false);
			
		} catch (AtaqueInsuficienteException e) {
			print_test(s,true);
		}
	}
	
	@Test
	public void test51comprueboCantidadMaximaUsosSofocoEntei(){
		Entei e = new Entei();
		String s ="Compruebo la excepcion de sofoco";
		
		while (e.getAtaque() != 1) {
			e.sofoco(new Entei());
		}
		try {
			e.sofoco(new HoOh());
			print_test(s,false);
			
		} catch (AtaqueInsuficienteException ex) {
			print_test(s,true);
		}
	}
	
	@Test
	public void test52ClaseBatallaJ1A1(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new Batalla(h,l);
		b.ataca1(1);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		print_test("El jugador 1 realizo el ataque correcto",vidaActual==l.getVida());	
	}
	
	
	@Test
	public void test53ClaseBatallaJ1A4(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new Batalla(h,l);
		b.ataca1(4);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		 
		print_test("El jugador 1 realizo el ataque 4 correctamente",vidaActual==l.getVida());
		
	}
	
	@Test
	public void test53ClaseBatallaJ1AtaqueInvalido(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new Batalla(h,l);
		try {
			b.ataca1(5);
			print_test("El jugador 1 realizo el ataque invalido, error",false);
			
		} catch (IllegalArgumentException e) {
			print_test("El jugador 1 realizo el ataque invalido, error",true);
		}
	}
	
	@Test
	public void test54ClaseBatallaJ2A1(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new Batalla(l,h);
		b.ataca2(1);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		print_test("El jugador 2 realizo el ataque correcto",vidaActual==l.getVida());	
	}
	
	
	@Test
	public void test55ClaseBatallaJ2A4(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new Batalla(l,h);
		b.ataca2(4);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		 
		print_test("El jugador 2 realizo el ataque 4 correctamente",vidaActual==l.getVida());
		
	}
	
	@Test
	public void test56ClaseBatallaJ1AtaqueInvalido(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new Batalla(l,h);
		try {
			b.ataca2(5);
			print_test("El jugador 2 realizo el ataque invalido, error",false);
			
		} catch (IllegalArgumentException e) {
			print_test("El jugador 2 realizo el ataque invalido, error",true);
		}
	}
	
	@Test
	public void test57ComprueboGanador(){
		HoOh h = new HoOh();
		Lapras l = new Lapras();
		l.restarVida(VIDA_LAPRAS);
		Batalla b = new Batalla(h, l);
		Pokemon g = b.getGanador();
		print_test("Hubo un ganador, es el correcto",g == h);
	}
	
	@Test
	public void test58ComprueboNoGanador(){
		HoOh h = new HoOh();
		Lapras l = new Lapras();
		Batalla b = new Batalla(h, l);
		Pokemon g = b.getGanador();
		print_test("No hay ningun debilitado, no hay ganador",g == null);
	}
	
	
	
	@Test
	public void test59ClaseBatallaSalvajeJ1A1(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new BatallaSalvaje(h,l);
		b.ataca1(1);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		print_test("El jugador 1 realizo el ataque correcto",vidaActual==l.getVida());	
	}
	
	
	@Test
	public void test53ClaseBatallaSalvajeJ1A4(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new BatallaSalvaje(h,l);
		b.ataca1(4);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		 
		print_test("El jugador 1 realizo el ataque 4 correctamente",vidaActual==l.getVida());
		
	}
	
	@Test
	public void test53ClaseBatallaSalvajeJ1AtaqueInvalido(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new BatallaSalvaje(h,l);
		try {
			b.ataca1(5);
			print_test("El jugador 1 realizo el ataque invalido, error",false);
			
		} catch (IllegalArgumentException e) {
			print_test("El jugador 1 realizo el ataque invalido, error",true);
		}
	}
	
	@Test
	public void test54ClaseBatallaSalvajeJ2A1(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new BatallaSalvaje(l,h);
		b.ataca2(1);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_LLAMARADA / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		print_test("El jugador 2 realizo el ataque correcto",vidaActual==l.getVida());	
	}
	
	
	@Test
	public void test55ClaseBatallaSalvajeJ2A4(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new BatallaSalvaje(l,h);
		b.ataca2(4);
		
		double potenciaDeAtaque = h.getAtaque() * PODER_TORNADO / h.getVelocidad();
		double defensa=l.defender(potenciaDeAtaque);
		double vidaActual= VIDA_LAPRAS - potenciaDeAtaque + defensa; 
		 
		print_test("El jugador 2 realizo el ataque 4 correctamente",vidaActual==l.getVida());
		
	}
	
	@Test
	public void test56ClaseBatallaSalvajeJ1AtaqueInvalido(){
		Lapras l = new Lapras();
		HoOh h = new HoOh();
		Batalla b = new BatallaSalvaje(l,h);
		try {
			b.ataca2(5);
			print_test("El jugador 2 realizo el ataque invalido, error",false);
			
		} catch (IllegalArgumentException e) {
			print_test("El jugador 2 realizo el ataque invalido, error",true);
		}
	}
	
	@Test
	public void test57ComprueboGanadorSalvaje(){
		HoOh h = new HoOh();
		Lapras l = new Lapras();
		l.restarVida(VIDA_LAPRAS);
		Batalla b = new BatallaSalvaje(h, l);
		Pokemon g = b.getGanador();
		print_test("Hubo un ganador, es el correcto",g == h);
	}
	
	@Test
	public void test58ComprueboSalvajeNoGanador(){
		HoOh h = new HoOh();
		Lapras l = new Lapras();
		Batalla b = new BatallaSalvaje(h, l);
		Pokemon g = b.getGanador();
		print_test("No hay ningun debilitado, no hay ganador",g == null);
	}
	
	@Test 
	public void test70integracionFinal(){
		String s ="Genero una batalla salvaje y capturo al segundo pokemon, intento volver a generar una batalla salvaje con el mismo";
		Lapras t = new Lapras();
		Entei e = new Entei();
		BatallaSalvaje b = new BatallaSalvaje(t, e);
		e.restarVida(VIDA_ENTEI-1);
		while (e.getSalvaje()) {
			b.lanzar_pokeball();
		}
		
		try {
			BatallaSalvaje b2 = new BatallaSalvaje(t,e);
			print_test(s,false);
		} catch (PokemonNoSalvajeException e2) {
			print_test(s,true);
		}
	}
	//probar clase batalla y batalla salvaje
	//probar captrar un pokemon on salvaje desde batalla salvaje
	
	



    private  int getRandomNumberInRange(int min, int max) {
    		if (min >= max) {
    			throw new IllegalArgumentException("max debe ser mayor que min");
    		}
    		Random r = new Random();
    		return r.nextInt((max - min) + 1) + min;
    }
    public void print_test(String msg, boolean ok){;
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
