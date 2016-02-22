package es.madhava.integerfun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Hello world!
 */
public class NumberMatching {

  public NumberMatching() {

  }

  public static Map<Integer, List<Integer>> getMatch(List<Integer> intList, List<Integer> objectives) {
    Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
    TreeSet<Integer> sortedInts = new TreeSet<Integer>();
    sortedInts.addAll(intList);

    // Can we make it?
    addOfflimits(intList, objectives, result);
    if (!objectives.isEmpty()) {
      for (int j = 0; j < intList.size(); j++) {
        List<Integer> toRemove = new ArrayList<Integer>();
        for (Integer objective : objectives) {
          if (sortedInts.contains(objective - intList.get(j))) {
            addResult(result, intList.get(j), objective - intList.get(j), objective);
            toRemove.add(objective);
          }
        }
        objectives.removeAll(toRemove);
        // Finish?
        if (objectives.isEmpty()) {
          break;
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
    Collections.sort(intList);
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
