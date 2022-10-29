package turtle;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString(){
        return "Position{" +
                "row=" + row +
                ", Column=" + column +
                "}";
    }
    @Override
    public boolean equals(Object obj){
//        boolean isEqual = false;
        if(!obj.getClass().equals(this.getClass()))return false;
        Position comparePosition = (Position) obj;
        boolean rowsAreEqual = comparePosition.getRow() == this.row;
        boolean columnsAreEqual = comparePosition.getColumn() == this.column;
        return rowsAreEqual && columnsAreEqual;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int newColumn) {
        column = newColumn;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int newRow) {
        row = newRow;
    }
}
