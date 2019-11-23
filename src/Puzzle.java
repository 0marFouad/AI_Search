public class Puzzle {
    private int[][] grid;
    private int blankRow;
    private int blankCol;
    private int level;
    private Puzzle parent;
    private static final int  MAX_ROW = 3;
    private static final int  MAX_COL = 3;

    Puzzle(int[][] grid){
        this.grid = grid;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j] == 0){
                    blankRow = i;
                    blankCol = j;
                }
            }
        }
    }
    Puzzle(int[][] grid, Puzzle parent, int level){
        this.grid = grid;
        this.level = level;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j] == 0){
                    blankRow = i;
                    blankCol = j;
                }
            }
        }
        this.parent = parent;
    }

    public Puzzle getParent() {
        return parent;
    }

    public int getLevel() {
        return level;
    }

    public int[][] getGrid() {
        return grid;
    }

    private boolean isValid(int i,int j){
        if(i >= 0 && i <= 2 && j >= 0 && j<= 2){
            return true;
        }
        return false;
    }

    private void swapGrid(int[][] grid,int iOld,int jOld,int iNew,int jNew){
        if(isValid(iNew, jNew)){
            int temp = grid[iOld][jOld];
            grid[iOld][jOld] = grid[iNew][jNew];
            grid[iNew][jNew] = temp;
        }
    }

    private int[][] getClone(){
        int[][] newGrid = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                newGrid[i][j] = grid[i][j];
            }
        }
        return newGrid;
    }

    public boolean isGoal(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i != 2 || j != 2){
                    if(grid[i][j] != 3*i + j + 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    Puzzle[] getChildren(){
        int[][] leftGrid = getClone();
        int[][] rightGrid = getClone();
        int[][] upGrid = getClone();
        int[][] downGrid = getClone();
        swapGrid(leftGrid,blankRow,blankCol,blankRow,blankCol-1);
        swapGrid(rightGrid,blankRow,blankCol,blankRow,blankCol+1);
        swapGrid(upGrid,blankRow,blankCol,blankRow-1,blankCol);
        swapGrid(downGrid,blankRow,blankCol,blankRow+1,blankCol);
        Puzzle[] children = new Puzzle[4];
        children[0] = new Puzzle(leftGrid,this,this.level + 1);
        children[1] = new Puzzle(upGrid,this,this.level + 1);
        children[2] = new Puzzle(rightGrid,this,this.level + 1);
        children[3] = new Puzzle(downGrid,this, this.level + 1);
        return children;
    }

    @Override
    public int hashCode() {
        int [][] grid = getClone();
        int result =0;
        final int base = 10;
        for(int i =0 ;i< MAX_ROW;i++){
            for(int j=0;j<MAX_COL;j++){
                result = base*result + grid[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        int [][] objGrid = ((Puzzle)obj).getGrid();
        for(int i=0;i<MAX_ROW;i++){
            for(int j=0;j<MAX_COL;j++){
                if(grid[i][j] != objGrid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public void printPuzzle(){
        for(int i=0;i<MAX_ROW;i++){
            for(int j=0;j<MAX_COL;j++){
                System.out.printf("%d ",grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("===================");
    }
}
