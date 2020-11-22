	
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    public static float nota=0;

    @Test
    public void test01CrearProductosConSusCaracteristicas() {
    	System.out.println("Test 1 - Valor: 1 pto");
    	Bebida a = new Bebida("villavicencio","agua",15.0);
    	Bebida b = new Bebida("coca-cola","cola",18.0);
    	Helado h = new Helado("kibon","magnum",50.0);
    	Helado h1 = new Helado("frigor","titanio",50.0);
    	Colacion col = new Colacion("Terrabusi","alfajor",12.4);
    	Colacion col1 = new Colacion("ksyo","rapsodia",15);
    	
    	boolean condition = !a.azucarada() && b.azucarada() && h.getPrecio()==75.0 && h1.getPrecio()==50.0 && col.getPrecio()==14.26 && col1.getPrecio()==15.0;
        print_test("Creo productos con sus caracteristicas especiales, todas funcionan: ",condition);
        if(condition){nota+=1;}
        assertTrue(condition);

    }

    @Test
    public void test02AgregoDosProdcutosIgualesAUnaMismaEstanteriaDebeFallar() {
    	System.out.println("Test 2 - Valor: 1 pto");
    	Caramelo c1 = new Caramelo("arcor","yumi",0.1);
    	Caramelo c2 = new Caramelo("arcor","yumi",0.1);
        try {
            Kiosco a = new Kiosco();
            a.agregarCaramelo(c1);
            a.agregarCaramelo(c2);
            print_test("Agrego un producto repetido a la estanteria y falla: ",false);
            assertTrue(false);
        }
        catch (IllegalArgumentException e){
            print_test("Agrego un producto repetido a la estanteria y falla: ",true);
            nota+=1;
        }

    }

    @Test
    public void test03AgregoVariosDeUnMismoTipoYCalculoElPrecio(){
    	System.out.println("Test 3 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	Bebida a = new Bebida("villavicencio","agua",15.0);
    	Bebida b = new Bebida("coca-cola","cola",18.0);
    	Bebida c = new Bebida("coca-cola","sprite",18.0);
    	Bebida d = new Bebida("coca-cola","aquarius",17.5);
    	k.agregarBebida(a);
    	k.agregarBebida(b);
    	k.agregarBebida(c);
    	k.agregarBebida(d);
    	double pFinal = k.calcularPrecioBebidas();
    	boolean condition = pFinal==68.5;
        print_test("Agrego varios productos a una estanteria, el precio es el correcto: ",condition);
        if(condition){nota+=1;}
        assertTrue(condition);
        
    }
    
    
    @Test
    public void test04DescuentoParaBebidasNoAzucaradas(){
    	System.out.println("Test 4 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	Bebida a1 = new Bebida("villavicencio","agua",15.0);
    	Bebida a2 = new Bebida("eco","agua",10.0);
    	Bebida a3 = new Bebida("glaciar","agua",8.0);
    	Bebida a4 = new Bebida("villa del sur","agua",16.0);
    	k.setDescuentoBebidasNoAzucaradas(10);
    	k.agregarBebida(a1);
    	k.agregarBebida(a2);
    	k.agregarBebida(a3);
    	k.agregarBebida(a4);
    	double pFinal = k.calcularPrecioBebidas();
    	boolean condition = pFinal==44.1;
        print_test("Varios tipos de bebidas no azucaradas, todas tienen el descuento", condition);
        if(condition) nota+=1;
        assertTrue(condition);
    }
    
    @Test
    public void test05CreoVariosProductosEnEstanteriasCaclculoSusPrecios(){
    	System.out.println("Test 5 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	Helado h1 = new Helado("frigor","titanio",50.0);
    	Helado h2 = new Helado("frigor","EPA",150.0);
    	Helado h3 = new Helado("frigor","Canion",250.0);
    	Caramelo c1 = new Caramelo("arcor","yumi",0.1);
    	Caramelo c2 = new Caramelo("arcor","fort",0.5);
    	Caramelo c3 = new Caramelo("arcor","masticable",1.6);
    	Bebida a = new Bebida("villavicencio","agua",15.0);
    	Bebida b = new Bebida("coca-cola","cola",18.0);
    	Bebida c = new Bebida("coca-cola","sprite",18.0);
    	Colacion col = new Colacion("Aguila","Torta",15);
    	Colacion col1 = new Colacion("ksyo","rapsodia",30);
    	Colacion col2 = new Colacion("Vauquita","Vauquita",20);
    	
       	k.agregarBebida(a);
    	k.agregarBebida(b);
    	k.agregarBebida(c);

    	
       	k.agregarHelado(h1);
    	k.agregarHelado(h2);
    	k.agregarHelado(h3);

    	
       	k.agregarCaramelo(c1);
    	k.agregarCaramelo(c2);
    	k.agregarCaramelo(c3);
    	
       	k.agregarColacion(col);
    	k.agregarColacion(col1);
    	k.agregarColacion(col2);
    	
    	
    	double pFinal = k.calcularPrecioBebidas() + k.calcularPrecioColaciones() + k.calcularPrecioCaramelos() + k.calcularPrecioHelados();
    	boolean condition = pFinal==568.2;
    	print_test("Varios tipos de productos, calculo el precio de todas las estanterias", condition);
        if(condition) nota+=1;
        assertTrue(condition);
    }
    
    @Test
    public void test06LosPreciosDeCiertaMarcaDeHelados(){
    	System.out.println("Test 6 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	k.agregarHelado( new Helado("frigor","titanio",50.0));
    	k.agregarHelado( new Helado("frigor","EPA",150.0));
    	k.agregarHelado( new Helado("frigor","Canion",250.0));
    	k.agregarHelado( new Helado("kibon","magnum",50.0));
    	k.agregarHelado( new Helado("kibon","torpedo",55.0));
    	k.agregarHelado( new Helado("kibon","comino",57.0));
    	
    	
        double precio1 = k.calcularPreciosHeladosDe("frigor");
        double precio2 = k.calcularPreciosHeladosDe("kibon");
        boolean condition = precio1==450.0 && precio2==187.0;
        print_test("Comparo los precios de cierta marca de helados", condition);
        if(condition) nota+=1;
        assertTrue(condition);
    }
    
    
    @Test
    public void test07EstanteriaDeBebidasConDescuentoYSinDescuento(){
    	System.out.println("Test 7 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	Bebida a1 = new Bebida("villavicencio","agua",15.0);
    	Bebida a2 = new Bebida("eco","agua",10.0);
    	Bebida a3 = new Bebida("glaciar","agua",8.0);
    	Bebida a4 = new Bebida("villa del sur","agua",16.0);
    	k.setDescuentoBebidasNoAzucaradas(10);
    	k.agregarBebida(a1);
    	k.agregarBebida(a2);
    	k.agregarBebida(a3);
    	k.agregarBebida(a4);
    	k.agregarBebida(new Bebida("coca-cola","cola",18.0));
    	k.agregarBebida(new Bebida("coca-cola","sprite",19.0));
    	k.agregarBebida(new Bebida("coca-cola","acquarius",16.5));
    	k.agregarBebida(new Bebida("coca-cola","fanta",18.5));
    	double pFinal = k.calcularPrecioBebidas();
    	boolean condition = pFinal==116.1;
        print_test("Varios tipos de bebidas no azucaradas, y azucaradas unas tienen el descuento y las otras no", condition);
        if(condition) nota+=1;
        assertTrue(condition);
    }
    
    @Test
    public void test08VariasBebidasConDescuentosDiferentes(){
    	System.out.println("Test 8 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	k.agregarBebida(new Bebida("villavicencio","agua",15.0));
    	k.agregarBebida( new Bebida("eco","agua",10.0));
    	k.agregarBebida( new Bebida("glaciar","agua",8.0));
    	k.agregarBebida( new Bebida("villa del sur","agua",16.0));
    	k.setDescuentoBebidasNoAzucaradas(100);
    	k.setDescuentoBebidasAzucaradas(100);
    	k.agregarBebida(new Bebida("coca-cola","cola",18.0));
    	k.agregarBebida(new Bebida("coca-cola","sprite",19.0));
    	k.agregarBebida(new Bebida("coca-cola","acquarius",16.5));
    	k.agregarBebida(new Bebida("coca-cola","fanta",18.5));
    	double pFinal = k.calcularPrecioBebidas();
    	boolean condition = pFinal==0;
        print_test("Varios tipos de bebidas no azucaradas, y azucaradas todas tienen el mismo descuento", condition);
        if(condition) nota+=1;
        assertTrue(condition);
    }
    
    @Test
    public void test09AgregoDosColacionesALaEstanteriaUnaEsUnAlfajor(){
    	System.out.println("Test 9 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	k.agregarColacion(new Colacion("Terrabusi","alfajor",20));
    	k.agregarColacion(new Colacion("ksyo","rapsodia",15));
    	boolean condition = k.calcularPrecioColaciones() == 38;
        print_test("Coloco dos colaciones en la estanteria, una es un alfajor, se aplica correctamente el recargo", condition);
        if(condition) nota+=1;
        assertTrue(condition);
    }
    
    @Test
    public void test10AgregoVariasColacionesALaEstanteriaTodasAlfajoresDiferenteMarca(){
    	System.out.println("Test 10 - Valor: 1 pto");
    	Kiosco k = new Kiosco();
    	k.agregarColacion(new Colacion("Terrabusi","alfajor",20));
    	k.agregarColacion(new Colacion("ksyo","alfajor",15));
    	k.agregarColacion(new Colacion("felfort","alfajor",18));
    	k.agregarColacion(new Colacion("Aguila","alfajor",35));
    	boolean condition = k.calcularPrecioColaciones() == 101.2;
        print_test("Coloco Varios alfajores de diferente marca en la estanteria, se aplica correctamente el recargo", condition);
        if(condition) nota+=1;
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
        assertTrue(ok);
    }

}
