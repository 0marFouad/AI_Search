import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS {
    private class Node{
        private  Node parent;
        private Puzzle child;

        public int getDepth() {
            return depth;
        }

        private int depth;
        public Node(Node parent, Puzzle child, int depth){
            this.parent = parent;
            this.child = child;
            this.depth = depth;
        }
        public Node getParent() {
            return parent;
        }
        public Puzzle getChild() {
            return child;
        }
    }
    private List <Puzzle> path;
    private int costPath;
    private int searchDepth;
    private  List <Puzzle> expanded;
    private boolean success;
    public BFS(Puzzle puzzle){
        reRun(puzzle);
    }

    public List<Puzzle> getPath() {
        return path;
    }

    public List<Puzzle> getExpanded() {
        return expanded;
    }

    public int getCostPath() {
        return costPath;
    }

    public int getSearchDepth() {
        return searchDepth;
    }

    public boolean getSuccess(){
        return this.success;
    }

    public void  reRun(Puzzle puzzle){
        Node n = run(puzzle);
        if (n== null){
            success =false;
        }else{
            success = true;
            setPath(n);
        }
    }
    private  Node run(Puzzle puzzle){
        expanded = new LinkedList<>();
        LinkedList <Node> queue = new LinkedList<>();
        Set <Puzzle> explored = new HashSet<>();
        Set <Puzzle> inQueue = new HashSet<>();
        queue.add(new Node(null,puzzle , 0));
        inQueue.add(puzzle);
        searchDepth = 0;
        costPath =0;
        path = null;
        while (!queue.isEmpty()){
            Node n = queue.remove();
            Puzzle p =  n.getChild();
            explored.add(p);
            inQueue.remove(p);
            if(p.isGoal()){
                return n;
            }
            expanded.add(p);
            Puzzle []children = p.getChildren();
            for(int i=0;i<children.length;i++){
                if(!explored.contains(children[i]) && !inQueue.contains(children[i])){
                    queue.add(new Node(n , children[i],n.getDepth()+1));
                    searchDepth = Math.max(searchDepth, n.getDepth()+1);
                    inQueue.add(children[i]);
                }
            }
        }
        return null;
    }
    private void setPath(Node n){
        path = new LinkedList<>();
        path.add(n.getChild());
        while (n.getParent()!= null){
            n = n.getParent();
            ((LinkedList<Puzzle>)path).addFirst(n.getChild());
        }
        costPath = path.size()-1;
    }

    public void print(){
        if (!success){
            System.out.println("Fail");
            System.out.printf("depth: %s\n",searchDepth);
            System.out.printf("expanded: %s\n", expanded.size());
        }else{
            System.out.println("success");
            System.out.printf("cost: %d\nDepth: %d\n",costPath,searchDepth);
            for(int i=0;i<path.size();i++){
                path.get(i).printPuzzle();
            }
            System.out.println(path.get(path.size()-1).isGoal());
        }
    }
}
