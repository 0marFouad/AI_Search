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
                    //System.out.print(childres[k].getGrid()[i][j] + " ");
                    s.add(childres[k]);
                }
               // System.out.println();
            }
            //System.out.println("===============");
        }
        //System.out.println("mostafa beeh"); // check connection
        //System.out.println(s.contains(childres[0])); // true
        int myGrid [][] = {{3,0,4},{5,2,1},{7,8,6}}; // not solvable
        //System.out.println((new Puzzle(myGrid)).isGoal()); //false

        BFS b = new BFS(new Puzzle(myGrid));
        b.printStates();

    }
}
