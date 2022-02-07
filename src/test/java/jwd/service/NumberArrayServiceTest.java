package jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.entity.impl.NumberArrayImpl;
import edu.epam.jwd.exception.CalculationArrayException;
import edu.epam.jwd.exception.NumberArrayException;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.impl.NumberArrayServiceImpl;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class NumberArrayServiceTest {

    @Test(groups = "CalculationArrayException")
    public void testAsJavaArrayIfArrayEmpty() {
        NumberArrayService service = new NumberArrayServiceImpl();
        assertThrows(NumberArrayException.class, () -> service.asJavaArray(null));
    }

    @Test(groups = "CalculationArrayException")
    public void testFromJavaArrayIfArrayEmpty() {
        NumberArrayService service = new NumberArrayServiceImpl();
        assertThrows(NumberArrayException.class, () -> service.fromJavaArray(null));
    }

    @Test(groups = "CalculationArrayException")
    public void testReplacing() {
        NumberArrayService service = new NumberArrayServiceImpl();
        NumberArrayImpl original = new NumberArrayImpl(new Number[]{1, -2, 3, 4, -5, 6});
        NumberArray replaced = service.replaceIf(original, (n) -> n.doubleValue() < 0, 12);
        assertTrue(Arrays.equals(service.asJavaArray(replaced), new Number[]{1.0, 12.0, 3.0, 4.0, 12.0, 6.0}));
    }
}