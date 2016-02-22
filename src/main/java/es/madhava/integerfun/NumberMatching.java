package es.madhava.integerfun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class NumberMatching {

  public NumberMatching() {

  }

  public static Map<Integer, List<Integer>> getMatch(List<Integer> intList, List<Integer> objectives) {
    Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

    Collections.sort(intList);
    Collections.sort(objectives);
    // Can we make it?
    addOfflimits(intList, objectives, result);

    if (!objectives.isEmpty()) {
      // Start with biggest number plus smallest one
      topLoop: for (int j = intList.size() - 1; j >= 0; j--) {
        // Move up smallest till we make found it
        for (int i = 0; i < j; i++) {
          Integer current = intList.get(i) + intList.get(j);
          // Current is bigger than top objective?
          if (current > objectives.get(objectives.size() - 1)) {
            break;
          }
          List<Integer> toRemove = new ArrayList<Integer>();
          for (Integer objective : objectives) {
            if (current.equals(objective)) {
              addResult(result, intList.get(i), intList.get(j), objective);
              System.out.println(objective + ": " + intList.get(i) + ", " + intList.get(j));
              toRemove.add(objective);
            }
          }
          objectives.removeAll(toRemove);
          // Finish?
          if (objectives.isEmpty()) {
            break topLoop;
          }
        }
      }
    }
    for (Integer objective : objectives) {
      result.put(objective, null);
    }
    return result;
  }

  private static void addResult(Map<Integer, List<Integer>> result, int j, int i, Integer objective) {
    List<Integer> partialResult = createPartialResult(i, j);
    result.put(objective, partialResult);
  }

  private static void addOfflimits(List<Integer> intList, List<Integer> objectives,
      Map<Integer, List<Integer>> result) {
    List<Integer> toRemove = new ArrayList<Integer>();
    for (Integer objective : objectives) {
      if (isOffLimits(intList, objective)) {
        result.put(objective, null);
        toRemove.add(objective);
      }
    }
    objectives.removeAll(toRemove);
  }

  private static List<Integer> createPartialResult(int j, int i) {
    List<Integer> partialResult = new ArrayList<Integer>();
    partialResult.add(i);
    partialResult.add(j);
    return partialResult;
  }

  protected static boolean isOffLimits(List<Integer> intList, Integer objective) {
    return (objective < intList.get(0) + intList.get(1)
        || objective > intList.get(intList.size() - 1) + intList.get(intList.size() - 2));
  }

}
