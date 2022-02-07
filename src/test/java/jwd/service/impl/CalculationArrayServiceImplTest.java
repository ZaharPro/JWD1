package jwd.service.impl;

import edu.epam.jwd.entity.impl.NumberArrayImpl;
import edu.epam.jwd.exception.CalculationArrayException;
import edu.epam.jwd.service.impl.CalculationArrayServiceImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class CalculationArrayServiceImplTest {

    @Test(groups = "CalculationArrayException")
    public void testFindMinIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertThrows(CalculationArrayException.class, () -> service.findMin(new NumberArrayImpl(new Number[0])));
    }

    @Test(groups = "CalculationArrayException")
    public void testFindMaxIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertThrows(CalculationArrayException.class, () -> service.findMax(new NumberArrayImpl(new Number[0])));
    }

    @Test(groups = "CalculationArrayException")
    public void testSumIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertThrows(CalculationArrayException.class, () -> service.sum(new NumberArrayImpl(new Number[0])));
    }

    @Test(groups = "CalculationArrayException")
    public void testAverageIfArrayEmpty() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertThrows(CalculationArrayException.class, () -> service.average(new NumberArrayImpl(new Number[0])));
    }

    ///
    @Test(groups = "CalculationArrayException")
    public void testFindMin() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertEquals(service.findMin(new NumberArrayImpl(new Number[]{1, 2, 3})), 1);
    }

    @Test(groups = "CalculationArrayException")
    public void testFindMax() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertEquals(service.findMax(new NumberArrayImpl(new Number[]{1, 2, 3})), 3);
    }

    @Test(groups = "CalculationArrayException")
    public void testSum() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertEquals(service.sum(new NumberArrayImpl(new Number[]{1, 2, 3})).doubleValue(), 6.0);
    }

    @Test(groups = "CalculationArrayException")
    public void testAverage() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertEquals(service.average(new NumberArrayImpl(new Number[]{1, 2, 3})), 2.0);
    }

    @Test(groups = "CalculationArrayException")
    public void testCountPositive() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertEquals(service.countPositive(new NumberArrayImpl(new Number[]{1, -2, -1, 2, -3, 3})).doubleValue(), 3.0);
    }

    @Test(groups = "CalculationArrayException")
    public void testCountNegative() {
        CalculationArrayServiceImpl service = new CalculationArrayServiceImpl();
        assertEquals(service.countNegative(new NumberArrayImpl(new Number[]{1, -2, -1, 2, -3, 3})).doubleValue(), 3.0);
    }
}
