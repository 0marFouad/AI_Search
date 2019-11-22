import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        int n = 1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j] = n;
                n++;
            }
        }
        grid[0][0] = 0;
        Set<Puzzle> s = new HashSet<Puzzle>();
        Puzzle p = new Puzzle(grid);
        Puzzle[] childres = p.getChildren();
        for(int k=0;k<4;k++){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(childres[k].getGrid()[i][j] + " ");
                    s.add(childres[k]);
                }
                System.out.println();
            }
            System.out.println("===============");
        }
        System.out.println("mostafa"); // check connection
        System.out.println(s.contains(childres[0])); // true
        int myGrid [][] = {{0,1,2},{3,4,5},{6,7,8}};
        System.out.println(s.contains(new Puzzle(myGrid))); //false

    }
}
