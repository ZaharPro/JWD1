package jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.service.impl.CalculationArrayServiceImpl;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.*;

public class CalculationArrayServiceImplTest {

    @Test(groups = "CalculationArrayException")
    public void testFindMinIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt min = service.findMin(new NumberArray(new int[0]));
        assertFalse(min.isPresent());
    }

    @Test(groups = "CalculationArrayException")
    public void testFindMaxIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt max = service.findMax(new NumberArray(new int[0]));
        assertFalse(max.isPresent());
    }

    @Test(groups = "CalculationArrayException")
    public void testSumIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt sum = service.sum(new NumberArray(new int[0]));
        assertFalse(sum.isPresent());
    }

    @Test(groups = "CalculationArrayException")
    public void testAverageIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt average = service.average(new NumberArray(new int[0]));
        assertFalse(average.isPresent());
    }

    ///
    @Test(groups = "CalculationArrayException")
    public void testFindMin() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt min = service.findMin(new NumberArray(new int[]{1, 2, 3}));
        assertTrue(min.isPresent());
        assertEquals(min.getAsInt(), 1);
    }

    @Test(groups = "CalculationArrayException")
    public void testFindMax() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt max = service.findMax(new NumberArray(new int[]{1, 2, 3}));
        assertTrue(max.isPresent());
        assertEquals(max.getAsInt(), 3.0);
    }

    @Test(groups = "CalculationArrayException")
    public void testSum() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt sum = service.sum(new NumberArray(new int[]{1, 2, 3}));
        assertTrue(sum.isPresent());
        assertEquals(sum.getAsInt(), 6.0);
    }

    @Test(groups = "CalculationArrayException")
    public void testAverage() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        OptionalInt average = service.average(new NumberArray(new int[]{1, 2, 3}));
        assertTrue(average.isPresent());
        assertEquals(average.getAsInt(), 2.0);
    }

    @Test(groups = "CalculationArrayException")
    public void testCountPositive() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        long count = service.countPositive(new NumberArray(new int[]{1, -2, -1, 2, -3, 3}));
        assertEquals(count, 3.0);
    }

    @Test(groups = "CalculationArrayException")
    public void testCountNegative() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        long count = service.countNegative(new NumberArray(new int[]{1, -2, -1, 2, -3, 3}));
        assertEquals(count, 3.0);
    }
}
