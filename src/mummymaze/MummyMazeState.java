package mummymaze;

import agent.Action;
import agent.State;

import java.util.Arrays;

public class MummyMazeState extends State implements Cloneable{

    private final char[][] matrix;
    private int lineAgent;
    private int columnAgent;

    public MummyMazeState(char[][] matrix) {
        this.matrix = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] == 'H') {
                    lineAgent = i;
                    columnAgent = j;
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
        action.execute(this);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public boolean canMoveUp() {
        return lineAgent > 1 && matrix[lineAgent - 1][columnAgent] != '-';
    }

    public boolean canMoveRight() {
        return columnAgent != matrix[lineAgent].length - 2 && matrix[lineAgent][columnAgent + 1] != '|';

    }

    public boolean canMoveDown() {
        return lineAgent != matrix.length - 2 && matrix[lineAgent + 1][columnAgent] != '-';

    }

    public boolean canMoveLeft() {
        return columnAgent >= 2 && matrix[lineAgent][columnAgent - 1] != '|';
    }

    public boolean canStay() {return true;}

    /*
     * In the next four methods we don't verify if the actions are valid.
     * This is done in method executeActions in class EightPuzzleProblem.
     * Doing the verification in these methods would imply that a clone of the
     * state was created whether the operation could be executed or not.
     */
    public void moveUp() {
        matrix[lineAgent][columnAgent] = matrix[lineAgent - 2][columnAgent];
        lineAgent -= 2;
        matrix[lineAgent][columnAgent] = 'H';
    }

    public void moveRight() {
        matrix[lineAgent][columnAgent] = matrix[lineAgent][columnAgent + 2];
        columnAgent += 2;
        matrix[lineAgent][columnAgent] = 'H';
    }

    public void moveDown() {
        matrix[lineAgent][columnAgent] = matrix[lineAgent + 2][columnAgent];
        lineAgent += 2;
        matrix[lineAgent][columnAgent] = 'H';
    }

    public void moveLeft() {
        matrix[lineAgent][columnAgent] = matrix[lineAgent][columnAgent - 2];
        columnAgent = columnAgent - 2;
        matrix[lineAgent][columnAgent] = 'H';
    }

    public void stay(){

    }

    public double computeDistanceToGoal(MummyMazeState finalState) {

        int[] goal = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] == 'S') {
                    goal[0] = i;
                    goal[1] = j;
                    break;
                }
                //calculate euclidean distance √[ (x2 – x1)2 + (y2 – y1)2;

            }
        }
        int lineDif = lineAgent > goal[0] ? lineAgent - goal[0] : goal[0] - lineAgent;
        int colDif = columnAgent > goal[1] ? columnAgent - goal[1] : goal[1] - columnAgent;
        //A distancia eucliadiana daria uma linha a direito, e no caso o que queremos pode ser um L.
        //Como está agora, simplesmente vê a diferença entre a linha e a coluna do agente vs a da saída, que é o que queremos
        return lineDif + colDif;
    }

    public boolean nearExit(){
        return matrix[lineAgent+1][columnAgent] == 'S' || matrix[lineAgent-1][columnAgent] == 'S' || matrix[lineAgent][columnAgent+1] == 'S' || matrix[lineAgent][columnAgent-1] == 'S';
    }
}
