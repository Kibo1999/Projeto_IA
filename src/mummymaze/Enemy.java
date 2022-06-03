package mummymaze;

public abstract class Enemy {
    private Cell cell;
    private int moves;

    public Enemy(Cell cell, int moves) {
        this.cell = cell;
        this.moves = moves;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getMoves() {
        return moves;
    }

    public abstract void move(Cell heroCell);
}
