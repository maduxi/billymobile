package es.madhava.integerfun;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RangeMergeTest {

  @Test
  public void includedNumbersTest() {
    List<Integer[]> ranges = new ArrayList<Integer[]>();

    ranges.add(getArray(1, 4));
    ranges.add(getArray(6, 10));
    ranges.add(getArray(13, 15));
    ranges.add(getArray(2, 4));

    assertEquals("Included 12 numbers", 12, RangeMerge.includedNumbers(ranges));
  }

  private Integer[] getArray(int a, int b) {
    Integer[] d = { a, b };
    return d;
  }
}
