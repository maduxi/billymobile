package es.madhava.integerfun;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RangeMerge {

  public static int includedNumbers(List<Integer[]> ranges) {
    Set<Integer> numbers = new HashSet<Integer>();
    for (Integer[] range : ranges) {
      numbers.addAll(getNumbers(range));
    }
    return numbers.size();
  }

  private static Set<Integer> getNumbers(Integer[] range) {
    Set<Integer> result = new HashSet<Integer>();
    for (int i = range[0]; i <= range[1]; i++) {
      result.add(i);
    }
    return result;
  }

}
