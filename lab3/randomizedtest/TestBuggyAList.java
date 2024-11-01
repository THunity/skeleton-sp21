package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  @Test
    public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> correctAlist = new AListNoResizing<>();
      BuggyAList<Integer> wrongAlist = new BuggyAList<>();

      correctAlist.addLast(4);
      wrongAlist.addLast(4);

      correctAlist.addLast(5);
      wrongAlist.addLast(5);

      correctAlist.addLast(6);
      wrongAlist.addLast(6);

      assertEquals(correctAlist.size(), wrongAlist.size());
      assertEquals(correctAlist.removeLast(), wrongAlist.removeLast());
      assertEquals(correctAlist.removeLast(), wrongAlist.removeLast());
      assertEquals(correctAlist.removeLast(), wrongAlist.removeLast());

  }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> wrong = new BuggyAList<>();

        int N = 1000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
                System.out.println("size: " + size);
            }else if (operationNumber == 2 && correct.size() > 0) {
                // getLast
                if (correct.getLast() != null && wrong.getLast() != null) {
                    int correctLast = correct.getLast();
                    int wrongLast = wrong.getLast();
                    assertEquals(correctLast, wrongLast);
                    System.out.println("getLast:(" + correctLast + ")");
                }
            } else if (operationNumber == 3 && correct.size() > 0) {
                if (correct.getLast() != null && wrong.getLast() != null) {
                // removeLast
                int correctRemove = correct.removeLast();
                int wrongRemove = wrong.removeLast();
                assertEquals(correctRemove, wrongRemove);
                System.out.println("removeLast:(" + correctRemove + ")");
                }
            }
        }
    }
}
