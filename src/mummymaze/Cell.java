package mummymaze;

public class Cell implements Cloneable{
    private int line;
    private int col;
    private char character;

    public Cell(int line, int col, char character) {
        this.line = line;
        this.col = col;
        this.character = character;
    }

    public Cell(Cell c) {
        this.line = c.line;
        this.col = c.col;
        this.character = c.character;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line += line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col += col;
    }

    public char getCharacter() {
        return character;
    }


    protected Object clone(){
        return new Cell(this);
    }
}
