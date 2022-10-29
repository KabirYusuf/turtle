package turtle;

public class SketchPad {
    private int[][] floor;
    private int noOfRows;
    private  int noOfColumns;

    public SketchPad(int noOfRows, int noOfColumns){
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        floor = new int[noOfRows][noOfColumns];

    }

    public int[][] getFloor() {
        return floor;
    }
    public void display(){
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                if(floor[i][j] == 1){
                    System.out.print("*   ");
                }
                else System.out.print("#   ");
            }
            System.out.println();

        }
    }
}
