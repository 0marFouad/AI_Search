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

        Puzzle p = new Puzzle(grid);
        Puzzle[] childres = p.getChildren();
        for(int k=0;k<4;k++){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(childres[k].getGrid()[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("===============");
        }
    }
}
