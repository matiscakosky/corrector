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
        assertTrue(vector1.esIgual(vector2));
    }

    @Test
    public void test02CrearDosVectoresYSumarlos(){
        Vector vector1 = new Vector(1,2);
        Vector vector2 = new Vector(3,-5);
        Vector vectorSum = vector1.sumar(vector2);
        Vector vecTest = new Vector(4,-3);
        assertTrue(vecTest.esIgual(vectorSum));
    }

    @Test
    public void test03Crear2YRestarVectores(){
        Vector vector1 = new Vector(0,-1);
        Vector vector2 = new Vector(0,1);
        Vector vectorSum = vector1.restar(vector2);
        Vector vecTest = new Vector(0,-2);
        assertTrue(vecTest.esIgual(vectorSum));
    }

    @Test
    public void test04Crear2yObtenerSuProductoInterno(){
        Vector vector1 = new Vector(5,3);
        Vector vector2 = new Vector(-1,2);
        int RESULTADO_PI = 1;
        assertEquals(vector1.calcularProductoInterno(vector2),RESULTADO_PI);
    }

    @Test
    public void test05CrearUnVectorYCaclularSuMagnitud(){
        Vector vector1 = new Vector(3,-4);
        int RESULTADO_MAG = 5;
        assertEquals(vector1.calcularMagnitud(),RESULTADO_MAG);
    }


    @Test
    public void test06CrearVectorYCambiarSuSentido(){
        Vector v1 = new Vector(1,-1);
        v1.cambiarSentido();
        assertTrue(v1.esIgual(new Vector(-1,1)));
    }
    @Test
    public void test07CrearVectoresYFijarseSiSonParalelos(){
        /*Escribir esta Prueba*/
    }

    @Test
    public void test08CrearVectorYDuplicarlo(){
        Vector vector1 = new Vector(10,-15);
        vector1.multplicarPorEscalar(2);
        Vector vecTest = new Vector(20,-30);
        assertTrue(vecTest.esIgual(vector1));
    }

    @Test(expected = AssertionError.class)
    public void testCrearUnVectorYSuInversoSumarAmbosAUnTercerVector(){
        /*Corregir y explicar Porque falla la prueba*/
        Vector v1 = new Vector(1,1);
        Vector v2 = v1;
        v2.cambiarSentido();
        Vector v3 = new Vector(3,2);

        Vector vRes31 = v3.sumar(v1);
        Vector vRes32 = v3.sumar(v2);
        assertTrue(vRes31.esIgual(new Vector(4,3)));
        assertTrue(vRes32.esIgual(new Vector(2,1)));

    }

    @Test
    public void integracion01(){
        Vector vector1 = new Vector(1,2);
        vector1.multplicarPorEscalar(3);
        vector1 = vector1.sumar(new Vector(-3,-6));
        vector1.multplicarPorEscalar(100);
        int magnitud = vector1.calcularMagnitud();
        assertEquals(magnitud,0);
    }
    @Test
    public void integracion02(){
        Vector vector1 = new Vector(3,8);
        vector1.multplicarPorEscalar(2);
        vector1.restar(new Vector(4,14));

        Vector vector2 = new Vector(0,0);
        vector2.sumar(new Vector(1,0));
        vector2.restar(new Vector(0,-2));
        vector2.multplicarPorEscalar(50);
        assertTrue(vector1.sonParalelos(vector2));
    }






}
