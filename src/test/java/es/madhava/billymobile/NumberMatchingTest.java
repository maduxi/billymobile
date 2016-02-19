package es.madhava.billymobile;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NumberMatchingTest {

  private List<Integer> intList;

  @Before
  public void initialize() {
    intList = new ArrayList<Integer>();
    intList.add(2);
    intList.add(3);
    intList.add(4);
    intList.add(5);
    intList.add(5);
    intList.add(7);
  }

  @Test
  public void isOffLimitsTest() {
    assertEquals("1 is offlimits", true, NumberMatching.isOffLimits(intList, 1));
    assertEquals("7 is in the range", false, NumberMatching.isOffLimits(intList, 7));
    assertEquals("15 is offlimits", true, NumberMatching.isOffLimits(intList, 15));
  }

  @Test
  public void getMatchTest() {
    List<Integer> match = NumberMatching.getMatch(intList, 7);
    Collections.sort(match);
    assertEquals("First numeber", 2, (int) match.get(0));
    assertEquals("First numeber", 5, (int) match.get(1));
  }

  @Test
  public void getMatchTest11() {
    List<Integer> match = NumberMatching.getMatch(intList, 11);
    Collections.sort(match);
    assertEquals("First numeber", 4, (int) match.get(0));
    assertEquals("First numeber", 7, (int) match.get(1));
  }

}
