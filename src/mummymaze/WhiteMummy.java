package mummymaze;

public class WhiteMummy extends Enemy{

    public WhiteMummy(Cell cell) {
        super(cell, 2);
    }

    @Override
    public void move(Cell heroCell) {
        int heroLine = heroCell.getLine();
        int heroCol = heroCell.getCol();



    }
}
