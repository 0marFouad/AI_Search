public class DFS {
    private static DFS ourInstance = new DFS();

    public static DFS getInstance() {
        return ourInstance;
    }

    private DFS() {
    }
}
