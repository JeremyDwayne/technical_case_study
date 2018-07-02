import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
 * Given a set of rectangles that contain the barren land
 * output all the fertile land area in square meters 
 * sorted from smallest area to greatest
 */
public class LandAnalysis {

  public static final int W = 400, H = 600;
  public static Node[][] field;
  public static ArrayList<Integer> fertileAreas;

  /*
   * Helper function to parse strings into an int array of coordinates
   */
  public static int[] parseCoords(String coords) {
    return Arrays.stream(coords.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  /*
   * In a 2D array, marks barren land to signify unuseable land.
   * "coloring" the nodes is another term for this process
   */
  public static void toggleBarrenLand(int[] arr) {
    for (var y = arr[1]; y <= arr[3]; ++y){   // rows
      for (var x = arr[0]; x <= arr[2]; ++x){ // columns
        field[y][x] = new Node(x,y,-1);
      }
    }
  }

  // Flood Fill / Forest Fire
  // https://en.wikipedia.org/wiki/Flood_fill
  public static void findFertileLand(Node node, int targetStatus, int replacementStatus) {
    if (targetStatus == replacementStatus) return;
    if (node.status != targetStatus) return;
    Queue<Node> q = new LinkedList<Node>();
    node.status = replacementStatus;
    q.add(node);
    int count = 0;
    while(q.peek() != null){
      count++;
      Node n = q.remove();
      if (n.y > 0) {   // north
        if (targetStatus == field[n.y-1][n.x].status) {
          field[n.y-1][n.x].status = replacementStatus;
          q.add(field[n.y-1][n.x]);
        }
      }
      if (n.y < H-1) { // south
        if (targetStatus == field[n.y+1][n.x].status){
          field[n.y+1][n.x].status = replacementStatus;
          q.add(field[n.y+1][n.x]);
        }
      }
      if (n.x > 0) {   // west
        if (targetStatus == field[n.y][n.x-1].status){
          field[n.y][n.x-1].status = replacementStatus;
          q.add(field[n.y][n.x-1]);
        }
      }
      if (n.x < W-1) { // east
        if (targetStatus == field[n.y][n.x+1].status){
          field[n.y][n.x+1].status = replacementStatus;
          q.add(field[n.y][n.x+1]);
        }
      }
    }
    fertileAreas.add(count);
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Example input format: " +
        "{\"48 192 351 207\", \"48 392 351 407\", \"120 52 135 547\", \"260 52 275 547\"}");

    // Regex to catch anything between two quotes
    // Not that robust of a regex: it won't catch outlier cases 
    // but will capture provided sample input formatting
    String pattern = "\"(.*?)\"";
    Pattern regex = Pattern.compile(pattern);

    var line = "";
    System.out.print("Please enter coordinates for barren land: ");
    while (!(line = scan.nextLine()).equals("q")) {
      field = new Node[H][W];
      fertileAreas = new ArrayList<Integer>();
      // Initialize blank 2D Node Array for new calculation
      for (var y = 0; y < H; ++y) {
        for (var x = 0; x < W; ++x) {
          field[y][x] = new Node(x,y,0);;
        }
      }

      // Use regex to go through user input of barren land
      Matcher matcher = regex.matcher(line);
      while (matcher.find()) {
        var matched = matcher.group(0).replace("\"","");
        toggleBarrenLand(parseCoords(matched)); // Set status of barren land to -1
      }

      // Find connected plots of fertile land
      for (var y = 0; y < H; ++y) {
        for (var x = 0; x < W; ++x) {
          findFertileLand(field[y][x], 0, 1);
        }
      }

      // Sort and print final fertile land areas
      if (fertileAreas.size() == 0) System.out.print(0); 
      else {
        Collections.sort(fertileAreas);
        System.out.println(fertileAreas.stream()
            .map(Object::toString)
            .collect(Collectors.joining(" "))
        );
      }

      System.out.print("Please enter coordinates for barren land: ");
    }
  }


}


/*
 * Implementation of basic node structure for custom color/status tracking
 */
class Node {
  public int x, y;
  public int status;

  public Node(int x, int y, int status){
    this.x = x;
    this.y = y;
    this.status = status;
  }
}
