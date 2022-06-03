package mummymaze;

import agent.Action;
import agent.State;

import java.util.ArrayList;
import java.util.Arrays;

public class MummyMazeState extends State implements Cloneable{

    private final char[][] matrix;
    private Cell hero;
    private ArrayList<Cell> enemies;

    public MummyMazeState(char[][] matrix) {
        this.matrix = new char[matrix.length][matrix[0].length];
        enemies = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                switch(matrix[i][j]) {
                    case 'H' :
                        hero = new Cell(i,j);
                        break;
                    case 'M' :
                        enemies.add(new Cell(i,j));
                        break;
                    case 'V' :
                        enemies.add(new Cell(i,j));
                        break;
                    case 'E' :
                        enemies.add(new Cell(i,j));
                        break;
                    default:
                        this.matrix[i][j] = matrix[i][j];
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MummyMazeState state = (MummyMazeState) o;
        return hero.getLine() == state.getHero().getLine() && hero.getCol() == state.getHero().getCol();
    }

    public boolean canMoveUp() {
        return hero.getLine() > 1 && matrix[hero.getLine() - 1][hero.getCol()] != '-';
    }

    public boolean canMoveRight() {
        return hero.getCol() < matrix[hero.getLine()].length - 2 && matrix[hero.getLine()][hero.getCol() + 1] != '|';

    }

    public boolean canMoveDown() {
        return hero.getLine() < matrix.length - 2 && matrix[hero.getLine() + 1][hero.getCol()] != '-';

    }

    public boolean canMoveLeft() {
        return hero.getCol() > 1 && matrix[hero.getLine()][hero.getCol() - 1] != '|';
    }

    public boolean canStay() {return true;}

    /*
     * In the next four methods we don't verify if the actions are valid.
     * This is done in method executeActions in class EightPuzzleProblem.
     * Doing the verification in these methods would imply that a clone of the
     * state was created whether the operation could be executed or not.
     */
    public void moveUp() {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine() - 2][hero.getCol()];
        hero.setLine(-2);
        matrix[hero.getLine()][hero.getCol()] = 'H';
    }

    public void moveRight() {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine()][hero.getCol() + 2];
        hero.setCol(2);
        matrix[hero.getLine()][hero.getCol()] = 'H';
    }

    public void moveDown() {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine() + 2][hero.getCol()];
        hero.setLine(2);
        matrix[hero.getLine()][hero.getCol()] = 'H';
    }

    public void moveLeft() {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine()][hero.getCol() - 2];
        hero.setCol(-2);
        matrix[hero.getLine()][hero.getCol()] = 'H';
    }

    public void stay(){

    }

    public double computeDistanceToGoal() {

        int[] goal = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 'S') {
                    goal[0] = i;
                    goal[1] = j;
                    break;
                }
                //calculate euclidean distance √[ (x2 – x1)2 + (y2 – y1)2;

            }
        }
        int lineDif = hero.getLine() > goal[0] ? hero.getLine() - goal[0] : goal[0] - hero.getLine();
        int colDif = hero.getCol() > goal[1] ? hero.getCol() - goal[1] : goal[1] - hero.getCol();
        //A distancia eucliadiana daria uma linha a direito, e no caso o que queremos pode ser um L.
        //Como está agora, simplesmente vê a diferença entre a linha e a coluna do agente vs a da saída, que é o que queremos
        return lineDif + colDif;
    }

    public boolean nearExit(){
        return matrix[hero.getLine()+1][hero.getCol()] == 'S' || matrix[hero.getLine()-1][hero.getCol()] == 'S' || matrix[hero.getLine()][hero.getCol()+1] == 'S' || matrix[hero.getLine()][hero.getCol()-1] == 'S';
    }


    @Override
    public String toString() {
        String stateString = "";

        for (char[] line : matrix) {
            for (char letter : line) {
                stateString += letter + " ";
            }
            stateString += "\n";
        }

        return stateString;
    }

    public Cell getHero() {
        return hero;
    }
}
