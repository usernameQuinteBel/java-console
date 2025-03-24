package fact.it.examplebicycle;

import fact.it.examplebicycle.model.Bicycle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class BicycleTest {


    @Test
    public void testNoArgConstructorAndGetters() {
        Bicycle myBike = new Bicycle();
        assertEquals("not defined", myBike.getType());
        assertEquals(0, myBike.getYear());
        assertEquals(0.0, myBike.getRentalPrice(), 0.01);
    }
    @Test
    public void testConstructorAndGetters() {
        Bicycle myBike = new Bicycle("ladies large bicycle", 2018);
        assertEquals("ladies large bicycle", myBike.getType());
        assertEquals(2018, myBike.getYear());
        assertEquals(0.0, myBike.getRentalPrice(), 0.01);
    }

    @Test
    public void testSetType() {
        Bicycle myBike = new Bicycle();
        myBike.setType("ladies large bicycle");
        assertEquals("ladies large bicycle", myBike.getType());

    }


    @Test
    public void testSetYear() {
        Bicycle myBike = new Bicycle();
        myBike.setYear(2016);
        assertEquals(2016, myBike.getYear());

    }


    @Test
    public void testSetRentalPrice() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(5.5);
        assertEquals(5.5, myBike.getRentalPrice(), 0.01);

    }


    @Test
    public void testIncreasePrice() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.increasePrice();
        assertEquals(5.0, myBike.getRentalPrice(), 0.01);
    }

    @Test
    public void testIncreasePrice2() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.increasePrice(0.3);
        assertEquals(4.8, myBike.getRentalPrice(), 0.01);
    }



    @Test
    public void testGetPricePerYearWithYearGreaterThan2014() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.setYear(2016);

        assertEquals(54.0, myBike.getPricePerYear(), 0.01);
    }


    @Test
    public void testGetPricePerYearWithYearSmallerThan2014() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.setYear(2013);
        assertEquals(51.3, myBike.getPricePerYear(), 0.01);
    }


    @Test
    public void testGetPricePerYearWithYearEqualTo2014() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.setYear(2014);
        assertEquals(54.0, myBike.getPricePerYear(), 0.01);
    }



}
