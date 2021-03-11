package tasks.first;

public class Main {

    public static boolean[][] makeAdjacencyMatrixBoolean(int[][] matrix) {
        boolean[][] booleanAdjacencyMatrix = new boolean[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    booleanAdjacencyMatrix[i][j] = true;
                } else {
                    booleanAdjacencyMatrix[i][j] = false;
                }
            }
        }

        return booleanAdjacencyMatrix;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrixInNumbers = {
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0}
        };

        boolean[][] booleanMatrix = makeAdjacencyMatrixBoolean(adjacencyMatrixInNumbers);

        FirstTaskSolution myUtil = new FirstTaskSolution();

        String graph = myUtil.breadthFirst(booleanMatrix, 5);
        System.out.println(graph);

        long number = myUtil.polishCalculation("2 6 2 / -");
        System.out.println(number);

        boolean isBrackets = myUtil.validateBrackets("(())");
        System.out.println(isBrackets);
    }
}
