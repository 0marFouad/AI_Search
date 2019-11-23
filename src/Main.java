
public class Main {


    public static void main(String[] args) {
        int myGrid [][] = {
                {1,2,3},
                {0,4,6},
                {7,5,8}
        };
        Puzzle initial_state = new Puzzle(myGrid,null,0);

        String algorithm = "am";
        if(algorithm == "bfs"){
            BFS solverBFS = new BFS(initial_state);
            solverBFS.print();
        }else if(algorithm == "dfs"){
            DFS solverDFS = new DFS(initial_state);
            solverDFS.print();
        }else if(algorithm == "ae"){
            Astar solverEuclidean = new Astar(initial_state, "Edistance");
            solverEuclidean.print();
        }else if(algorithm == "am"){
            Astar solverManhattan = new Astar(initial_state, "Mdistance");
            solverManhattan.print();
        }



    }
}
