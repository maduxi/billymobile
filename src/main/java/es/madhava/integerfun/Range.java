package es.madhava.integerfun;

import java.util.ArrayList;
import java.util.List;

public class Range {

  int max;
  int min;

  public Range(Integer[] range) {
    min = range[0];
    max = range[1];
  }

  public boolean merge(Range range) {
    boolean result = false;
    if ((range.getMax() <= max && range.getMax() >= min) || (range.getMin() >= min && range.getMin() <= max)) {
      min = Math.min(min, range.getMin());
      max = Math.max(max, range.getMax());
      result = true;
    }
    return result;
  }

  public List<Integer> getNumbers() {
    List<Integer> result = new ArrayList<Integer>();
    for (int i = min; i <= max; i++) {
      result.add(i);
    }
    return result;
  }

  public int getMax() {
    return max;
  }

  public int getMin() {
    return min;
  }

  public Integer[] getArray() {
    Integer[] array = { min, max };
    return array;
  }

  @Override
  public String toString() {
    return "Range: " + min + " - " + max;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Range other = (Range) obj;
    if (max != other.max) {
      return false;
    }
    if (min != other.min) {
      return false;
    }
    return true;
  }

}