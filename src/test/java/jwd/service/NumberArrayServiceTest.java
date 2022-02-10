package jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.impl.NumberArrayServiceImpl;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class NumberArrayServiceTest {

    @Test(groups = "CalculationArrayException")
    public void testReplacing() {
        NumberArrayService service = new NumberArrayServiceImpl();
        NumberArray original = new NumberArray(new int[]{1, -2, 3, 4, -5, 6});
        NumberArray replaced = service.replaceIf(original, (n) -> n < 0, 12);
        assertTrue(Arrays.equals(replaced.asJavaArray(), new int[]{1, 12, 3, 4, 12, 6}));
    }
}