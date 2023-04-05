package mypack;

public class magic_square_gpt {
	public static void main(String[] args) {
        int n = 3; // size of the magic square
        
        int[][] magicSquare = new int[n][n];
        
        // initialize the magic square with zeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                magicSquare[i][j] = 0;
            }
        }
        
        int row = n-1;
        int col = n/2;
        magicSquare[row][col] = 1;
        
        for (int i = 2; i <= n*n; i++) {
            if (magicSquare[(row + 1) % n][(col + 1) % n] == 0) {
                row = (row + 1) % n;
                col = (col + 1) % n;
            } else {
                row = (row - 1 + n) % n;
            }
            magicSquare[row][col] = i;
        }
        
        // print the magic square
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }
}
