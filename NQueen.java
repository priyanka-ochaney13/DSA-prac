class NQueen {
    static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check if any queen exists in the same column above this row
        for(int i=0; i<row; i++) 
            if(board[i][col] == 1) return false;
        // Check upper-left diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) 
            if(board[i][j] == 1) return false;
        // Check upper-right diagonal
        for(int i=row, j=col; i>=0 && j<n; i--, j++)
            if(board[i][j] == 1) return false;
        return true;
    }
    
    static boolean solveNQueens(int[][] board, int row, int n) {
        // Base case: all queens placed successfully
        if(row >= n) return true;
        
        // Try placing queen in each column of current row
        for(int col=0; col<n; col++) {
            if(isSafe(board, row, col, n)) {
                //place queen
                board[row][col] = 1;
                //recursively solve for next row
                if(solveNQueens(board, row+1, n)) return true;
                //backtrack if no solution found
                board[row][col] = 0;
            }
        }
        return false;
    }
    
    public static void printBoard(int[][] board, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : "_ ");
            }
            System.out.println();
        }
    }
    /* 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("N-Queens Problem");
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        if(solveNQueens(board, 0, n)) printBoard(board, n);
        else System.out.println("Solution doesn't exist");
    }
     */
}