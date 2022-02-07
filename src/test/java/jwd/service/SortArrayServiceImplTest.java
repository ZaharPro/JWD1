package jwd.service;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.entity.impl.NumberArrayImpl;
import edu.epam.jwd.exception.SortArrayException;
import edu.epam.jwd.service.NumberArrayService;
import edu.epam.jwd.service.factory.NumberArrayServiceFactory;
import edu.epam.jwd.service.impl.SortArrayServiceImpl;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

public class SortArrayServiceImplTest {
    @Test(groups = "SortArrayException")
    public void testSortIfArrayNull() {
        SortArrayServiceImpl service = new SortArrayServiceImpl();
        assertThrows(SortArrayException.class, () -> service.sort(null, (n1, n2) -> 0));
    }

    @Test(groups = "SortArrayException")
    public void testSortIfComparatorNull() {
        SortArrayServiceImpl service = new SortArrayServiceImpl();
        assertThrows(SortArrayException.class, () -> service.sort(new NumberArrayImpl(new Number[1]), null));
    }

    @Test(groups = "SortArrayException")
    public void testSort() {
        SortArrayServiceImpl service = new SortArrayServiceImpl();
        Number[] numbers = {-3, 1, -2, 3, 14, 5};
        NumberArray sortedArray = service.sort(new NumberArrayImpl(numbers.clone()), NumberArrayService.DEFAULT_COMPARATOR);
        Arrays.sort(numbers);
        NumberArrayServiceFactory instance = NumberArrayServiceFactory.getInstance();
        NumberArrayService arrayService = instance.getDefaultService();
        Number[] javaArray = arrayService.asJavaArray(sortedArray);
        assertTrue(Arrays.equals(javaArray, numbers));
    }
}
