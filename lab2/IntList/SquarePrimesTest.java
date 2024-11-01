package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        IntList lst1 = IntList.of(32, 33, 34, 35, 36, 37, 38, 39);

        boolean changed = IntListExercises.squarePrimes(lst);
        boolean changed1 = IntListExercises.squarePrimes(lst1);

        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);

        assertEquals("32 -> 33 -> 34 -> 35 -> 36 -> 1369 -> 38 -> 39", lst1.toString());
        assertTrue(changed1);
    }
    @Test
    public void testSquarePrimesByUser1() {
        IntList lst = IntList.of(14, 15, 16, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 18", lst.toString());
        assertTrue(!changed);
    }
    @Test
    public void testSquarePrimesByUser2() {
        IntList lst = IntList.of(1, 2, 3, 4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 9 -> 4", lst.toString());
        assertTrue(changed);
    }
}
