package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        ArrayList<Vertex> resultVertexes = new ArrayList<>();
        ArrayDeque<Vertex> vertexesInQueue = new ArrayDeque<>();
        int indexNow = startIndex;

        while (resultVertexes.size() != adjacencyMatrix.length) {
            if (checkEqualVertexes(resultVertexes, new Vertex(indexNow))) {
                vertexesInQueue.offerLast(new Vertex(indexNow));
            }

            for (int j = 0; j < adjacencyMatrix.length; j++) {

                if (adjacencyMatrix[indexNow][j]) {
                    Vertex vertex = new Vertex(j);

                    if (checkEqualVertexes(resultVertexes, vertex) && checkEqualVertexes(vertexesInQueue, vertex)) {
                        vertexesInQueue.offerLast(vertex);
                    }
                }
            }

            Vertex newReadyVertex = vertexesInQueue.peekFirst();
            resultVertexes.add(newReadyVertex);
            vertexesInQueue.pollFirst();
            indexNow = newReadyVertex.getNumber();
        }

        String result = "";
        for (int i = 0; i < resultVertexes.size(); i++) {
            if (i != (resultVertexes.size() - 1)) {
                result += (resultVertexes.get(i).getNumber() + ", ");
            } else {
                result += resultVertexes.get(i).getNumber();
            }
        }

        return result;
    }

    private boolean checkEqualVertexes(Collection<Vertex> vertexes, Vertex soughtVertex) {
        for (Vertex vertex : vertexes) {
            if (vertex.getNumber() == soughtVertex.getNumber()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean validateBrackets(String s) {
        ArrayDeque<Character> openBracketsDequeue = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        String openBrackets = "({[";
        String closedBrackets = ")}]";
        String roundBrackets = "()";
        String figureBrackets = "{}";
        String squareBrackets = "[]";

        for (char elem : chars) {
            if (openBrackets.contains(Character.toString(elem))) {
                openBracketsDequeue.push(elem);
            }

            if (closedBrackets.contains(Character.toString(elem))) {
                if (openBracketsDequeue.size() == 0) {
                    return false;
                }

                if (roundBrackets.contains(Character.toString(openBracketsDequeue.peek())) &&
                        roundBrackets.contains(Character.toString(elem))) {
                    openBracketsDequeue.pop();
                } else if (figureBrackets.contains(Character.toString(openBracketsDequeue.peek())) &&
                        figureBrackets.contains(Character.toString(elem))) {
                    openBracketsDequeue.pop();
                } else if (squareBrackets.contains(Character.toString(openBracketsDequeue.peek())) &&
                        squareBrackets.contains(Character.toString(elem))) {
                    openBracketsDequeue.pop();
                } else {
                    return false;
                }
            }
        }

        return openBracketsDequeue.isEmpty();
    }

    @Override
    public Long polishCalculation(String s) {
        String possibleOperators = "+-*/";
        ArrayDeque<Long> numbers = new ArrayDeque<>();
        ArrayList<String> operators = new ArrayList<>();
        String[] strings = s.split(" ");

        for (String elem : strings) {
            if (possibleOperators.contains(elem)) {
                operators.add(elem);
            } else {
                numbers.push(Long.parseLong(elem));
            }
        }

        for (String operator : operators) {
            long firstNumber = numbers.pop();
            long secondNumber = numbers.pop();
            long result = 0;

            switch (operator) {
                case "+":
                    result = secondNumber + firstNumber;
                    break;
                case "-":
                    result = secondNumber - firstNumber;
                    break;
                case "*":
                    result = secondNumber * firstNumber;
                    break;
                case "/":
                    result = secondNumber / firstNumber;
                    break;
            }

            numbers.push(result);
        }

        return numbers.peek();
    }
}
