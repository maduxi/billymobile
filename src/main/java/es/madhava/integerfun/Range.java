package es.madhava.integerfun;

public class Range {

  int max;
  int min;

  public Range(Integer[] range) {
    min = range[0];
    max = range[1];
  }

  public boolean merge(Range range) {
    boolean result = false;
    if (shouldMerge(this, range)) {
      min = Math.min(min, range.getMin());
      max = Math.max(max, range.getMax());
      result = true;
    }
    return result;
  }

  protected static boolean shouldMerge(Range range, Range range2) {
    return (range.getMax() <= range2.getMax() && range.getMax() >= range2.getMin())
        || (range.getMin() >= range2.getMin() && range.getMin() <= range2.getMax())
        || (range.getMin() <= range2.getMin() && range.getMax() >= range2.getMax());
  }

  public Integer getSize() {
    return max - min + 1;
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