package mummymaze;

import agent.Action;
import agent.State;

import java.util.ArrayList;
import java.util.Arrays;

public class MummyMazeState extends State implements Cloneable{

    private final char[][] matrix;
    private Cell hero;
    private ArrayList<Enemy> enemies;
    private boolean isHeroDead;

    public MummyMazeState(char[][] matrix) {
        this.matrix = new char[matrix.length][matrix[0].length];
        enemies = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                switch(matrix[i][j]) {
                    case 'H' :
                        hero = new Cell(i,j, 'H');
                        break;
                    case 'M' :
                        enemies.add(new WhiteMummy(new Cell(i,j,'M')));
                        break;
                    case 'V' :
                        //enemies.add(new Cell(i,j,'V'));
                        break;
                    case 'E' :
                        //enemies.add(new Cell(i,j,'E'));
                        break;
                    default:
                        this.matrix[i][j] = matrix[i][j];
                }
            }
        }
        isHeroDead = false;
    }

    public MummyMazeState(MummyMazeState m){
        this(m.matrix);
        this.enemies = new ArrayList<>();
        for (Enemy enemy: m.enemies) {
            this.enemies.add(enemy);

        }
        this.hero = (Cell) m.hero.clone();
    }

    public Object clone() {
        return new MummyMazeState(this);
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
        //hero moves ONLY if he is alive
        action.execute(this,hero);


        //enemies move after the hero does
        for (Enemy enemy:enemies) {
            enemy.move(this,hero);
        }

        atualizarMatriz();
        checkHeroDead();
    }

    private void checkHeroDead() {
        for (Enemy enemy: enemies) {
            if (enemy.getCell().getLine() == hero.getLine() && enemy.getCell().getCol() == hero.getCol()){
                isHeroDead = true;
                break;
            }
        }
    }

    private void atualizarMatriz() {
        matrix[hero.getLine()][hero.getCol()] = 'H';
        for (Enemy enemy:enemies) {
            matrix[enemy.getCell().getLine()][enemy.getCell().getCol()] = enemy.getCell().getCharacter();
        }
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
        return Arrays.deepEquals(this.matrix, state.matrix);
    }

    public boolean canMoveUp(Cell character) {
        if (character == hero && isHeroDead){
            return false;
        }
        return character.getLine() > 1 && matrix[character.getLine() - 1][character.getCol()] != '-';
    }

    public boolean canMoveRight(Cell character) {
        if (character == hero && isHeroDead){
            return false;
        }
        return character.getCol() < matrix[character.getLine()].length - 2 && matrix[character.getLine()][character.getCol() + 1] != '|';

    }

    public boolean canMoveDown(Cell character) {
        if (character == hero && isHeroDead){
            return false;
        }
        return character.getLine() < matrix.length - 2 && matrix[character.getLine() + 1][character.getCol()] != '-';
    }

    public boolean canMoveLeft(Cell character) {
        if (character == hero && isHeroDead){
            return false;
        }
        return character.getCol() > 1 && matrix[character.getLine()][character.getCol() - 1] != '|';
    }

    public boolean canStay(Cell character) {
        if (character == hero && isHeroDead){
            return false;
        }
        return true;
    }

    /*
     * In the next four methods we don't verify if the actions are valid.
     * This is done in method executeActions in class EightPuzzleProblem.
     * Doing the verification in these methods would imply that a clone of the
     * state was created whether the operation could be executed or not.
     */
    public void moveUp(Cell character) {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine() - 2][hero.getCol()];
        hero.setLine(-2);
    }

    public void moveRight(Cell character) {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine()][hero.getCol() + 2];
        hero.setCol(2);
    }

    public void moveDown(Cell character) {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine() + 2][hero.getCol()];
        hero.setLine(2);
    }

    public void moveLeft(Cell character) {
        matrix[hero.getLine()][hero.getCol()] = matrix[hero.getLine()][hero.getCol() - 2];
        hero.setCol(-2);
    }

    public void stay(Cell character){

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
