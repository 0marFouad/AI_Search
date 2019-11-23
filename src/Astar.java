import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class costComparator implements Comparator<Puzzle> {
    public int compare(Puzzle s1, Puzzle s2) {
        if (s1.totalCost > s2.totalCost)
            return 1;
        else if (s1.totalCost < s2.totalCost)
            return -1;
        return 0;
    }
}


public class Astar {
    private boolean success;
    private PriorityQueue<Puzzle> Heap;
    private List <Puzzle> path;
    private Set<Puzzle> visited = new HashSet<>();
    private LinkedList<Puzzle> explored = new LinkedList<>();
    private Puzzle initialState;

    public Astar(Puzzle puzzle, String distance){
        path = new LinkedList<>();
        puzzle.setDistance(distance);
        this.initialState = puzzle;
        Heap = new PriorityQueue<>(new costComparator());
        this.success = solve(puzzle);
    }

    public boolean getSuccess(){
        return this.success;
    }


    public boolean solve(Puzzle puzzle){
        Heap.add(puzzle);
        while (!Heap.isEmpty()){
            Puzzle currentState = Heap.poll();
            explored.add(currentState);
            visited.add(puzzle);
            if(currentState.isGoal()){
                getPath(currentState);
                return true;
            }
            else{
                Puzzle[] children = currentState.getChildren();
                for(int i=0;i<4;i++){
                    if(!visited.contains(children[i]) && !checkIfFrontier(currentState)){
                        Heap.add(children[i]);
                        visited.add(children[i]);
                    }else{
                        if(checkIfFrontier(currentState)){
                            decreaseKey(children[i]);
                        }
                    }
                }
            }
        }
        initialState.printPuzzle();
        System.out.printf("%n",initialState.currentStateCost);
        System.out.printf("%n",initialState.heuristicCost);
        return false;
    }

    private boolean checkIfFrontier(Puzzle s){
        for (Puzzle x : Heap) {
            if (s.equals(x)){
                return true;
            }
        }
        return false;
    }



    private void getPath(Puzzle s){
        if(s != null){
            path.add(0,s);
            getPath(s.getParent());
        }
    }

    private void decreaseKey(Puzzle s){
        for (Puzzle x : Heap) {
            if (x.equals(s)){
                if (x.currentStateCost < s.currentStateCost){
                    return;
                }else{
                    Heap.remove(x);
                    Heap.add(s);
                }
            }
        }
    }

    public void print(){
        for(int i=0;i<path.size();i++){
            path.get(i).printPuzzle();
            System.out.printf("G = %d ", path.get(i).currentStateCost);
            System.out.printf("H = %d ", path.get(i).heuristicCost);
            System.out.printf("total = %d ", path.get(i).totalCost);
            System.out.printf("depth = %d \n", path.get(i).getLevel());
            System.out.println();
        }
    }
}

