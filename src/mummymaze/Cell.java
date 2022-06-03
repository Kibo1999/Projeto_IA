package mummymaze;

public class Cell {
    private int line;
    private int col;

    public Cell(int line, int col) {
        this.line = line;
        this.col = col;
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
}
