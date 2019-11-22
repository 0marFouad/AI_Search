import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS {
    private class Node{
        private  Node parent;
        private Puzzle child;
        public Node(Node parent, Puzzle child){
            this.parent = parent;
            this.child = child;
        }
        public Node getParent() {
            return parent;
        }
        public Puzzle getChild() {
            return child;
        }
    }
    private List <Puzzle> path;
    private int cost;
    private  List <Puzzle> expanded;
    public BFS(Puzzle puzzle){
        run(puzzle);
    }
    public void  reRun(Puzzle puzzle){
        run(puzzle);
    }

    private  void run(Puzzle puzzle){
        path = new LinkedList<>();
        cost = 0;
        expanded =new LinkedList<>();
        LinkedList <Node> queue = new LinkedList<>();
        queue.add(new Node(null,puzzle));
        Set <Puzzle> set = new HashSet<>();
        while (!queue.isEmpty()){
            Node n = queue.remove();
            Puzzle p =  n.getChild();
        }
    }


}
