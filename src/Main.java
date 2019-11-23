import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int myGrid [][] = {{1,2,8},{0,4,3},{7,6,5}};
        Puzzle initial_state = new Puzzle(myGrid,null,0);
        DFS solver = new DFS();
        System.out.println(solver.run(initial_state));
        System.out.println(solver.getCost());
        System.out.println(solver.getMaxDepth());
        System.out.println(solver.getExpanded().size());
    }
}
