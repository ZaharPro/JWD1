package jwd.entity.impl;

import edu.epam.jwd.entity.NumberArray;
import edu.epam.jwd.entity.impl.NumberArrayImpl;
import edu.epam.jwd.exception.NumberArrayException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class NumberArrayImplTest {
    @Test(groups = "NumberArrayException")
    public void testNumberArrayIsNull() {
        assertThrows(NumberArrayException.class, () -> new NumberArrayImpl(null));
    }

    @Test(groups = "NumberArrayException")
    public void testNumberArrayGetIllegalIndex() {
        NumberArray numberArray = new NumberArrayImpl(new Number[]{1, 2, 3});
        assertThrows(NumberArrayException.class, () -> numberArray.get(5));
    }

    @Test(groups = "NumberArrayException")
    public void testNumberArraySetIllegalIndex() {
        NumberArray numberArray = new NumberArrayImpl(new Number[]{1, 2, 3});
        assertThrows(NumberArrayException.class, () -> numberArray.set(5, -1));
    }
}
