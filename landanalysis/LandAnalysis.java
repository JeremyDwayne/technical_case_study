import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class LandAnalysis {

  public static final int W = 400, H = 600;
  public static final int[][] fertileArea = new int[H][W];
  // Coordinate Boundaries
  // (0,0) to (399, 599)

  public static int[] parseCoords(String coords) {
    return Arrays.stream(coords.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  public static int calculateArea(int[] pts) {
    var w = pts[2] - pts[0];
    var h = pts[3] - pts[1];
    System.out.println("W: " + w + " H: " + h);
    return w * h;
  }

  public static void toggleBarronLand(int[] arr) {
    for (var i = arr[0]; i <= arr[2]; ++i){ 
      for (var j = arr[1]; j <= arr[3]; ++j){ 
        fertileArea[j][i] = 1;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // String single = "0 292 399 307";
    // String[] arr  = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
    var line = "";
    while (!(line = scan.nextLine()).equals("q")) {
      String[] arr = line.split(", ");
      for (var a : arr){
        toggleBarronLand(parseCoords(a));
      }

      // for (var n : fertileArea) System.out.print(n.toString);
      var count = 0;
      for (var i : fertileArea) {
        for (var j=0; j < i.length; j++) {
          if (i[j] == 0){
            count++; 
          }
          // System.out.print(i[j]);
        }
        // System.out.println();
      }
      System.out.println(count + "m²");
    }


    // System.out.println("\nString Array");
    // for (var r : coords) {
    //   for (var n : r) System.out.print(n + " ");
    //   System.out.println();
    // }

  }


}
