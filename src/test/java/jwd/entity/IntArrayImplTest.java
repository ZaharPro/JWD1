package jwd.entity;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.NumberArrayException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class IntArrayImplTest {
    @Test(groups = "NumberArrayException")
    public void testNumberArrayIsNull() {
        assertThrows(NumberArrayException.class, () -> new IntArray(null));
    }

    @Test(groups = "NumberArrayException")
    public void testNumberArrayGetIllegalIndex() {
        IntArray intArray = new IntArray(new int[]{1, 2, 3});
        assertThrows(NumberArrayException.class, () -> intArray.get(5));
    }

    @Test(groups = "NumberArrayException")
    public void testNumberArraySetIllegalIndex() {
        IntArray intArray = new IntArray(new int[]{1, 2, 3});
        assertThrows(NumberArrayException.class, () -> intArray.set(5, -1));
    }
}
