package mummymaze;

import agent.Action;
import agent.State;
import eightpuzzle.EightPuzzleState;

public class MummyMazeState extends State implements Cloneable{

    private final char[][] matrix;
    private int lineBlank;
    private int columnBlank;

    public MummyMazeState(char[][] matrix) {
        this.matrix = new char[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] == 0) {
                    lineBlank = i;
                    columnBlank = j;
                }
            }
        }
    }

    public Object clone() {
        return new MummyMazeState(matrix);
    }

    public void showState() {
        for (char[] line : matrix) {
            for (char letter : line) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void executeAction(Action action) {

    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
