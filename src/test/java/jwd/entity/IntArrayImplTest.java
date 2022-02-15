package jwd.entity;

import edu.epam.jwd.entity.IntArray;
import edu.epam.jwd.exception.SuperException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class IntArrayImplTest {
    @Test(groups = "NumberArrayException")
    public void testNumberArrayIsNull() {
        assertThrows(SuperException.class, () -> new IntArray(null));
    }

    @Test(groups = "NumberArrayException")
    public void testNumberArrayGetIllegalIndex() throws SuperException {
        IntArray intArray = new IntArray(new int[]{1, 2, 3});
        assertThrows(SuperException.class, () -> intArray.get(5));
    }

    @Test(groups = "NumberArrayException")
    public void testNumberArraySetIllegalIndex() throws SuperException {
        IntArray intArray = new IntArray(new int[]{1, 2, 3});
        assertThrows(SuperException.class, () -> intArray.set(5, -1));
    }
}
