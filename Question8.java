public class Question8 {
    public static void main(String[] args) {
        System.out.println("\t\tName : Aakash Pavar Roll No: 3057");
        int rows = 2, columns = 3;
        int[][] firstMatrix = { { 2, 3, 4 }, { 5, 2, 3 } };
        int[][] secondMatrix = { { -4, 5, 3 }, { 5, 6, 3 } };

        // Adding Two matrices
        int[][] sum = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        // Displaying the result
        System.out.println("Sum of two matrices is: ");
        for (int[] row : sum) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
    }
}
