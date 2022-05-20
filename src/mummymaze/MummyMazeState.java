package mummymaze;

import agent.Action;
import agent.State;

public class MummyMazeState extends State implements Cloneable{

    private final char[][] matrix;
    private int lineAgent;
    private int columnAgent;

    public MummyMazeState(char[][] matrix) {
        this.matrix = new char[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] == 0) {
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

    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public boolean canMoveUp() {
        return lineAgent <= 1 && matrix[lineAgent - 1][columnAgent] != '-';
    }

    public boolean canMoveRight() {
        return columnAgent <= matrix[lineAgent].length - 1 && matrix[lineAgent][columnAgent + 1] != '|';

    }

    public boolean canMoveDown() {
        return lineAgent >= matrix.length - 2 && matrix[lineAgent + 1][columnAgent] != '-';

    }

    public boolean canMoveLeft() {
        return columnAgent <= 1 && matrix[lineAgent][columnAgent -1] != '|';
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
        columnAgent-=2;
        matrix[lineAgent][columnAgent] = 'H';
    }

    public void stay(){

    }

    public double computeDistanceToGoal(MummyMazeState finalState) {

        double distance = 0;
        int[] hero = new int[2];
        int[] goal = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'H') {
                    hero[0] = i;
                    hero[1] = j;
                }
                if (matrix[i][j] == 'S') {
                    goal[0] = i;
                    goal[1] = j;

                }
                distance += 2;//calculate euclidean distance √[ (x2 – x1)2 + (y2 – y1)2;
            }

        }


        return distance;
    }
}
