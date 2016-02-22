package es.madhava.integerfun;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws IOException {
    App myApp = new App();
    myApp.numberMatching();
    myApp.rangeMerge();
  }

  private void rangeMerge() {
    System.out.println("Calculating numbers in ranges for files provided:");
    List<Integer[]> rangeSmall = getRanges("range_small.txt");
    System.out
        .println("range_small.txt ranges include " + RangeMerge.includedNumbers(rangeSmall) + " diferent numbers.");
    List<Integer[]> rangeLarge = getRanges("range_large.txt");
    System.out
        .println("range_large.txt ranges include " + RangeMerge.includedNumbers(rangeLarge) + " diferent numbers.");
  }

  private List<Integer[]> getRanges(String rangeFile) {
    List<Integer[]> result = new ArrayList<Integer[]>();
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(rangeFile).getFile());
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        Integer[] array = { Integer.parseInt(split[0]), Integer.parseInt(split[1]) };
        result.add(array);
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  private List<Integer> getIntList() {
    List<Integer> intList = new ArrayList<Integer>();
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("int_list.txt").getFile());
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        intList.add(Integer.parseInt(scanner.nextLine()));
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return intList;
  }

  private void numberMatching() {
    List<Integer> intList = getIntList();
    List<Integer> objectives = getObjectives();
    System.out.println("\nCalculating matching pairs for numbers provided:");
    Map<Integer, List<Integer>> result = NumberMatching.getMatch(intList, objectives);
    // This output could probably be a little bit nicer...
    System.out.println("Results summary: " + result);
  }

  private List<Integer> getObjectives() {
    List<Integer> objectives = new ArrayList<Integer>();
    objectives.add(231552);
    objectives.add(234756);
    objectives.add(596873);
    objectives.add(648219);
    objectives.add(726312);
    objectives.add(981237);
    objectives.add(988331);
    objectives.add(1277361);
    objectives.add(1283379);
    return objectives;
  }

}
