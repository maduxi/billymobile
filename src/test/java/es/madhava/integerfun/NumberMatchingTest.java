package es.madhava.integerfun;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
  public void getMatchTest7() {
    List<Integer> match = getSingleMatchResult(7);
    assertEquals("First number", 2, (int) match.get(0));
    assertEquals("First number", 5, (int) match.get(1));
  }

  @Test
  public void getMatchTest11() {
    List<Integer> match = getSingleMatchResult(11);
    assertEquals("First number", 4, (int) match.get(0));
    assertEquals("First number", 7, (int) match.get(1));
  }

  @Test
  public void getMatchTest4() {
    List<Integer> match = getSingleMatchResult(4);
    assertEquals("No pair", null, match);
  }

  @Test
  public void getMatchTest10() {
    List<Integer> match = getSingleMatchResult(10);
    assertEquals("First number", 3, (int) match.get(0));
    assertEquals("First number", 7, (int) match.get(1));
  }

  @Test
  public void getMatchOfflimits() {
    List<Integer> match = getSingleMatchResult(14);
    assertEquals("Offlimits", null, match);
  }

  @Test
  public void getMultipleMatch() {
    List<Integer> input = new ArrayList<Integer>();
    input.add(3);
    input.add(7);
    input.add(10);
    input.add(11);
    input.add(14);
    Map<Integer, List<Integer>> matchMap = NumberMatching.getMatch(intList, input);
    assertEquals("First number", null, matchMap.get(3));
    assertEquals("First number", 2, (int) matchMap.get(7).get(0));
    assertEquals("First number", 5, (int) matchMap.get(7).get(1));
    assertEquals("First number", 3, (int) matchMap.get(10).get(0));
    assertEquals("First number", 7, (int) matchMap.get(10).get(1));
    assertEquals("First number", 4, (int) matchMap.get(11).get(0));
    assertEquals("First number", 7, (int) matchMap.get(11).get(1));
    assertEquals("First number", null, matchMap.get(14));
  }

  private List<Integer> getSingleMatchResult(int test) {
    List<Integer> input = new ArrayList<Integer>();
    input.add(test);
    Map<Integer, List<Integer>> matchMap = NumberMatching.getMatch(intList, input);
    List<Integer> match = matchMap.get(test);
    if (match != null) {
      Collections.sort(match);
    }
    return match;
  }

}
