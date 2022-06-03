package mummymaze;

public class WhiteMummy extends Enemy{

    public WhiteMummy(Cell cell) {
        super(cell, 2);
    }

    @Override
    public void move(MummyMazeState state, Cell heroCell) {
        int heroLine = heroCell.getLine();
        int heroCol = heroCell.getCol();
        int myLine = cell.getLine();
        int myCol = cell.getCol();


        for (int i = 0; i < moves; i++) {
         if (myCol != heroCol){
             if (myCol > heroCol){
                 if (state.canMoveLeft(cell)) state.moveLeft(cell);
             }else {
                 if (state.canMoveRight(cell)) state.moveRight(cell);
             }
             continue;
         }
         if (myLine != heroLine){
             if (myLine > heroLine){
                 if (state.canMoveUp(cell)) state.moveUp(cell);
             }else{
                 if (state.canMoveDown(cell)) state.moveDown(cell);
             }
         }
        }

    }
}
