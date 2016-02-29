package es.madhava.integerfun;

import java.util.ArrayList;
import java.util.List;

public class RangeMerge {

  public static int includedNumbers(List<Integer[]> ranges) {
    Integer numbers = 0;
    List<Range> rangesList = new ArrayList<Range>();
    for (Integer[] range : ranges) {
      addRange(rangesList, range);
    }
    for (Range range : rangesList) {
      numbers += range.getSize();
    }
    return numbers;
  }

  private static void addRange(List<Range> rangesList, Integer[] rangeArray) {
    Range newRange = new Range(rangeArray);
    Range merged = null;
    for (Range range : rangesList) {
      if (range.merge(newRange)) {
        merged = range;
        break;
      }
    }
    if (merged == null) {
      rangesList.add(newRange);
    } else {
      rangesList.remove(merged);
      addRange(rangesList, merged.getArray());
    }
  }

}
