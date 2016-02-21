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

  private Integer[] getIntArray(int a, int b) {
    Integer[] array = { a, b };
    return array;
  }
}
