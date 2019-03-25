import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Usuario on 26/09/2017.
 */


public class Tests {
    @Test
    public void test01CrearDosVectoresIgualesDebenSerElMismo(){
        Vector vector1 = new Vector(1,2);
        Vector vector2 = new Vector(1,2);
        print_test("Crear dis vectiores iguales y deben ser el mismo",vector1.esIgual(vector2));
        assertTrue(vector1.esIgual(vector2));
    }

    @Test
    public void test02CrearDosVectoresYSumarlos(){
        Vector vector1 = new Vector(1,2);
        Vector vector2 = new Vector(3,-5);
        Vector vectorSum = vector1.sumar(vector2);
        Vector vecTest = new Vector(4,-3);
        print_test("Sumo dos vectores",vecTest.esIgual(vectorSum));
        assertTrue(vecTest.esIgual(vectorSum));
    }
    
    
    @Test
    public void testCrearTresVectoresYSumarlos(){
        Vector vector1 = new Vector(1,2);
        Vector vector2 = new Vector(3,-5);
        Vector vector3 = new Vector(4,10);
        Vector vectorSum = vector1.sumar(vector2);
        vectorSum = vectorSum.sumar(vector3);
        Vector vecTest = new Vector(8,7);
        print_test("Crear 3 vectores consecutivos y sumar",vecTest.esIgual(vectorSum));
        assertTrue(vecTest.esIgual(vectorSum));
    }
    
    @Test
    public void sumarVectorNulo(){
        Vector vector1 = new Vector(1,1);
        Vector vector2 = new Vector(0,0);
        Vector vector3 = new Vector(0,0);
        Vector vectorSum = vector1.sumar(vector2);
        vectorSum = vectorSum.sumar(vector3);
        Vector vecTest = new Vector(1,1);
        print_test("Crear 3 vectores consecutivos y sumar",vecTest.esIgual(vectorSum));
        assertTrue(vecTest.esIgual(vectorSum));
    }
    
    @Test
    public void pruebaDeVolumendeSumar(){
        Vector v = new Vector(0,0);
        for (int i=1;i<=1000;i++){
            v=v.sumar(new Vector(i,i));
        }
        Vector vres= new Vector(500500,500500);
        print_test("Creo mil vectores y los sumo todos",vres.esIgual(v));
        assertTrue(v.esIgual(vres));
    }

    @Test
    public void test03Crear2YRestarVectores(){
        Vector vector1 = new Vector(0,-1);
        Vector vector2 = new Vector(0,1);
        Vector vectorSum = vector1.restar(vector2);
        Vector vecTest = new Vector(0,-2);
        print_test("Prueba de restar vectores",vecTest.esIgual(vectorSum));
        assertTrue(vecTest.esIgual(vectorSum));
    }

    @Test
    public void test04Crear2yObtenerSuProductoInterno(){
        Vector vector1 = new Vector(5,3);
        Vector vector2 = new Vector(-1,2);
        int RESULTADO_PI = 1;
        print_test("Prueba del producto interno con positivos",vector1.calcularProductoInterno(vector2)==RESULTADO_PI);
        assertEquals(vector1.calcularProductoInterno(vector2),RESULTADO_PI);
    }
    
    @Test
    public void productoInternoConCero(){
        Vector vector1 = new Vector(1,5);
        Vector vector2 = new Vector(0,0);
        int RESULTADO_PI = 0;
        print_test("Prueba del producto interno con vector nulo",vector1.calcularProductoInterno(vector2)==RESULTADO_PI);
        assertEquals(vector1.calcularProductoInterno(vector2),RESULTADO_PI);
    }
    
    @Test
    public void productoInternoConNegativos(){
        Vector vector1 = new Vector(-5,-3);
        Vector vector2 = new Vector(-1,-2);
        int RESULTADO_PI = 11;
        print_test("Prueba del producto interno con negativos",vector1.calcularProductoInterno(vector2)==RESULTADO_PI);
        assertEquals(vector1.calcularProductoInterno(vector2),RESULTADO_PI);
    }

    @Test
    public void test05CrearUnVectorYCaclularSuMagnitud(){
        Vector vector1 = new Vector(8,5);
        int RESULTADO_MAG = 9;
        print_test("Prueba de calculo de magnitud no entera debe truncar",vector1.calcularMagnitud()==RESULTADO_MAG);
        assertEquals(vector1.calcularMagnitud(),RESULTADO_MAG);
    }


    @Test
    public void test06CrearVectorYCambiarSuSentido(){
        Vector v1 = new Vector(1,-1);
        v1.cambiarSentido();
        print_test("Prueba de cambio de sentido de un vector",v1.esIgual(new Vector(-1,1)));
        assertTrue(v1.esIgual(new Vector(-1,1)));
    }
    
    
    @Test
    public void CrearVectorNuloYCambiarSuSentido(){
        Vector v1 = new Vector(0,0);
        v1.cambiarSentido();
        print_test("Crear vector nulo y cambiarle el sentido",v1.esIgual(new Vector(0,0)));
        assertTrue(v1.esIgual(new Vector(0,0)));
    }
    
    
    @Test
    public void crearVectorNoIgualDebeFallar(){
        Vector vector1 = new Vector(1,2);
        Vector vector2 = new Vector(3,2);
        print_test("Crear dos vectores diferentes para es igual, debe fallar",!vector1.esIgual(vector2));
        assertTrue(!vector1.esIgual(vector2));
    } 
    
    @Test
    public void testVolumenParaParalelos(){
        Vector vector1= new Vector(1,1);
        for(int i=0;i<1000;i++){
            Vector paralelo= new Vector(i,i);
            if (!vector1.sonParalelos(paralelo)){
                throw new AssertionError();
            }
        }
        print_test("Prueba de parelelos en volumen", true);
    }
    
    @Test
    public void test07CrearVectoresYFijarseSiSonParalelos(){
        Vector v1=new Vector(1,-2);
        Vector v2=new Vector(2,-4);
        print_test("Prueba de paralelos",v1.sonParalelos(v2));
        assertTrue(v1.sonParalelos(v2));
    }
    
    @Test
    public void test07CrearVectoresYFijarseSiSonParalelosConCerosEnSusCoordenadas(){
        Vector v1=new Vector(0,-2);
        Vector v2=new Vector(0,-4);
        print_test("Creo dos vectores y checkeo que sean paralelos, tienen un cero en sus coordenadas",v1.sonParalelos(v2));
        assertTrue(v1.sonParalelos(v2));
    }
    
    @Test
    public void test09crearDosVectoresConNumerosGrandesYFijarseSiSonParalelos(){
        Vector v1=new Vector(1,8);
        Vector v2=new Vector(5,40);
        print_test("Pruebo paralelos con nuemeros grandes",v1.sonParalelos(v2));
        assertTrue(v1.sonParalelos(v2));
    }
    
    @Test
    public void test07CrearVectoresYFijarseSiSonParalelosConCambioDeSigno(){
        Vector v1=new Vector(-5,2);
        Vector v2=new Vector(10,-4);
        print_test("Crear vectores y fijarse si son paralelos con cambio de signo",v1.sonParalelos(v2));
        assertTrue(v1.sonParalelos(v2));
    }
    
    @Test(expected = AssertionError.class)
    public void test07CrearVectoresYFijarseSiNoSonParalelosDebeFallar(){
        Vector v1=new Vector(0,-2);
        Vector v2=new Vector(1,74);
        print_test("Crear vectores y fijarse si no son paralelos debe fallar",!v1.sonParalelos(v2));
        assertTrue(v1.sonParalelos(v2));
    }
    
    
    @Test(expected = AssertionError.class)
    public void pruebaRestarDosVectoresYQueNoLosSume(){
        Vector v1=new Vector(1,1);
        Vector v2=new Vector(1,1);
        v2=v1.restar(v2);
        print_test("Resto dos vectores, checkeo quen no los sume",!v2.esIgual(new Vector(2,2)));
        assertTrue(v2.esIgual(new Vector(2,2)));
    }
    
    
    @Test
    public void test08CrearVectorYDuplicarlo(){
        Vector vector1 = new Vector(10,-15);
        vector1.multiplicarPorEscalar(2);
        Vector vecTest = new Vector(20,-30);
        print_test("Creo un vector y lo multplico por 2",vecTest.esIgual(vector1));
        assertTrue(vecTest.esIgual(vector1));
    }

    @Test
    public void testCrearUnVectorYSuInversoSumarAmbosAUnTercerVector(){
        Vector v1 = new Vector(1,1);
        Vector v2 = new Vector(1,1);
        v2.cambiarSentido();
        Vector v3 = new Vector(3,2);

        Vector vRes31 = v3.sumar(v1);
        Vector vRes32 = v3.sumar(v2);
        print_test("Sumo al (1,1) el (3,2) da bien",vRes31.esIgual(new Vector(4,3)));
        assertTrue(vRes31.esIgual(new Vector(4,3)));
        print_test("Sumo al (-1,-1) el (3,2) da bien",vRes32.esIgual(new Vector(2,1)));
        assertTrue(vRes32.esIgual(new Vector(2,1)));

    }

    @Test
    public void testCreoVectoresYOperoParaLograrUnaMagnitud0(){
        Vector vector1 = new Vector(1,2);
        vector1.multiplicarPorEscalar(3);
        vector1 = vector1.sumar(new Vector(-3,-6));
        vector1.multiplicarPorEscalar(100);
        int magnitud = vector1.calcularMagnitud();
        print_test("opero para lograr una magnitud 0",magnitud==0);
        assertEquals(magnitud,0);
    }
    @Test
    public void testCreoVectoresYOperoParaLograrQueSeanParalelos(){
        Vector vector1 = new Vector(3,8);
        vector1.multiplicarPorEscalar(2);
        vector1 =vector1.restar(new Vector(4,14));

        Vector vector2 = new Vector(0,0);
        vector2=vector2.sumar(new Vector(1,0));
        vector2=vector2.sumar(new Vector(0,1));
        vector2.multiplicarPorEscalar(50);
        print_test("Creo dos vectores diferentes y opero hasta que sean paralelos",vector1.sonParalelos(vector2));
        assertTrue(vector1.sonParalelos(vector2));
    }
    
    @Test
    public void testIntentoConseguirElAnguloConLasHerramientasTenidas(){
        Vector v1 = new Vector(0,1);
        Vector v2 = new Vector(1,0);
        double cosTita= v1.calcularProductoInterno(v2) / v1.calcularMagnitud() * v2.calcularMagnitud();
        int tita = (int)Math.toDegrees(Math.acos(cosTita));
        assertEquals(90,tita);
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
