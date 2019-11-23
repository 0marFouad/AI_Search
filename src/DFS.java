import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DFS {
    private List<Puzzle> path;
    private int cost;
    private int maxDepth;
    private  List <Puzzle> expanded;

    public List<Puzzle> getPath() {
        return path;
    }

    public List<Puzzle> getExpanded() {
        return expanded;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public int getCost() {
        return cost;
    }

    public boolean run(Puzzle puzzle){
        path = new LinkedList<>();
        expanded = new LinkedList<>();
        LinkedList <Puzzle> stack = new LinkedList<>();
        Set<Puzzle> visited = new HashSet<>();
        stack.add(puzzle);
        visited.add(puzzle);
        while (!stack.isEmpty()){
            Puzzle p = stack.remove();
            expanded.add(p);
            maxDepth = Math.max(maxDepth, p.getLevel());
            if(p.isGoal()){
                while(p != null){
                    path.add(0,p);
                    p = p.getParent();
                }
                cost = path.size() - 1;
                return true;
            }
            Puzzle[] children = p.getChildren();
            for(int i=0;i<4;i++){
                if(!visited.contains(children[i])){
                    stack.add(children[i]);
                    visited.add(children[i]);
                }
            }
        }
        return false;
    }
}
