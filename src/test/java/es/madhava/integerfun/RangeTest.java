package es.madhava.integerfun;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RangeTest {

  @Test
  public void shouldMergeTest() {
    assertEquals("One below", false, Range.shouldMerge(new Range(getIntArray(1, 5)), new Range(getIntArray(7, 10))));
    assertEquals("Min below max inside", true,
        Range.shouldMerge(new Range(getIntArray(1, 5)), new Range(getIntArray(3, 10))));
    assertEquals("Both inside", true, Range.shouldMerge(new Range(getIntArray(4, 8)), new Range(getIntArray(3, 10))));
    assertEquals("Min inside, max outside", true,
        Range.shouldMerge(new Range(getIntArray(4, 15)), new Range(getIntArray(3, 10))));
    assertEquals("Both higher", false,
        Range.shouldMerge(new Range(getIntArray(12, 15)), new Range(getIntArray(3, 10))));
    assertEquals("Min below, max higher", true,
        Range.shouldMerge(new Range(getIntArray(1, 15)), new Range(getIntArray(3, 10))));
    assertEquals("One below", false, Range.shouldMerge(new Range(getIntArray(7, 10)), new Range(getIntArray(1, 5))));
    assertEquals("Min below max inside", true,
        Range.shouldMerge(new Range(getIntArray(3, 10)), new Range(getIntArray(1, 5))));
    assertEquals("Both inside", true, Range.shouldMerge(new Range(getIntArray(3, 10)), new Range(getIntArray(4, 8))));
    assertEquals("Min inside, max outside", true,
        Range.shouldMerge(new Range(getIntArray(3, 10)), new Range(getIntArray(4, 15))));
    assertEquals("Both higher", false,
        Range.shouldMerge(new Range(getIntArray(3, 10)), new Range(getIntArray(12, 15))));
    assertEquals("Min below, max higher", true,
        Range.shouldMerge(new Range(getIntArray(3, 10)), new Range(getIntArray(1, 15))));
  }

  private Integer[] getIntArray(int a, int b) {
    Integer[] array = { a, b };
    return array;
  }
}
