package es.madhava.billymobile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class NumberMatching {

  public NumberMatching() {

  }

  public static List<Integer> getMatch(List<Integer> intList, Integer objective) {
    List<Integer> result = null;
    Collections.sort(intList);
    if (!isOffLimits(intList, objective)) {
      topLoop: for (int j = intList.size() - 1; j >= 0; j--) {
        int current = objective;
        for (int i = 0; i < j; i++) {
          current = intList.get(i) + intList.get(j);
          if (current == objective) {
            result = new ArrayList<Integer>();
            result.add(intList.get(i));
            result.add(intList.get(j));
            break topLoop;
          } else if (current > objective) {
            break;
          }
        }
        if (current < objective) {
          break;
        }
      }
    }
    return result;
  }

  protected static boolean isOffLimits(List<Integer> intList, Integer objective) {
    return (objective < intList.get(0) + intList.get(1)
        || objective > intList.get(intList.size() - 1) + intList.get(intList.size() - 2));
  }

}
