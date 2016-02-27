package es.madhava.integerfun;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RangeMergeTest {

  @Test
  public void includedNumbersTest() {
    List<Integer[]> ranges = new ArrayList<Integer[]>();

    ranges.add(getIntArray(1, 4));
    ranges.add(getIntArray(6, 10));
    ranges.add(getIntArray(13, 15));
    ranges.add(getIntArray(2, 4));

    assertEquals("Included 12 numbers", 12, RangeMerge.includedNumbers(ranges));
  }

  @Test
  public void includedNumbersTestLarge() {
    List<Integer[]> ranges = new ArrayList<Integer[]>();
    ranges.add(getIntArray(855, 3789));
    ranges.add(getIntArray(9, 7310));
    assertEquals("Included 7302 numbers", 7302, RangeMerge.includedNumbers(ranges));
  }

  @Test
  public void includedNumbersTestSmall() {
    List<Integer[]> ranges = new ArrayList<Integer[]>();

    ranges.add(getIntArray(49, 74));
    ranges.add(getIntArray(78, 113));
    ranges.add(getIntArray(24, 89));
    ranges.add(getIntArray(47, 107));
    ranges.add(getIntArray(12, 42));
    ranges.add(getIntArray(74, 165));
    ranges.add(getIntArray(43, 63));
    ranges.add(getIntArray(51, 105));
    ranges.add(getIntArray(30, 68));
    ranges.add(getIntArray(6, 7));
    ranges.add(getIntArray(63, 149));
    ranges.add(getIntArray(54, 88));
    ranges.add(getIntArray(84, 178));
    ranges.add(getIntArray(46, 69));
    ranges.add(getIntArray(46, 106));
    ranges.add(getIntArray(181, 182));
    ranges.add(getIntArray(64, 108));
    ranges.add(getIntArray(1, 3));
    ranges.add(getIntArray(72, 137));
    ranges.add(getIntArray(29, 127));

    assertEquals("Included 12 numbers", 174, RangeMerge.includedNumbers(ranges));
  }

  private Integer[] getIntArray(int a, int b) {
    Integer[] array = { a, b };
    return array;
  }
}
