package es.madhava.integerfun;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RangeMerge {

  public static int includedNumbers(List<Integer[]> ranges) {
    Set<Integer> numbers = new HashSet<Integer>();
    List<Range> rangesList = new ArrayList<Range>();
    for (Integer[] range : ranges) {
      addRange(rangesList, range);
    }
    for (Range range : rangesList) {
      numbers.addAll(range.getNumbers());
    }
    return numbers.size();
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
