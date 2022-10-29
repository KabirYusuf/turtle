package turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static turtle.Direction.*;

class TurtleTest {
    private Turtle ijapa;
    private SketchPad sketchPad;
    @BeforeEach
    void setUp(){
        ijapa = new Turtle();
        sketchPad = new SketchPad(5,5);
    }
    @Test
    public void turtleCanMovePenUpTest(){
        ijapa.penUp();
        assertTrue(ijapa.isPenIsUp());
    }
    @Test
    public void turtleCanMovePenDownTest(){
        ijapa.penUp();
        assertTrue(ijapa.isPenIsUp());
        ijapa.penDown();
        assertFalse(ijapa.isPenIsUp());
    }
    @Test
    public void turtleCanTurnRight_FacingEastTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnRight_FacingSouthTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnRight_FacingWestTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnRight_FacingNorthTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnRight();
        assertEquals(EAST, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_FacingNorthTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_FacingWestTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_FacingSouthTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanTurnLeft_FacingEastTest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.turnLeft();
        assertEquals(EAST, ijapa.getCurrentDirection());
    }
    @Test
    public void turtleCanMoveWhileFacingEastAndPenIsUpTest(){
        assertEquals(new Position(0,0),ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0,2), ijapa.getCurrentPosition());
    }
    @Test
    public void turtleCanMoveWhileFacingSouthAndPenIsUpTest(){
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3, sketchPad);
        ijapa.turnRight();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
    }
    @Test
    public void turtleCanMoveWhileFacingWestAndPenIsUpTest(){
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3, sketchPad);
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,0), ijapa.getCurrentPosition());
    }
    @Test
    public void turtleCanMoveWhileFacingNorthAndPenIsUpTest(){
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        ijapa.penUp();
        ijapa.move(3, sketchPad);
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,0), ijapa.getCurrentPosition());
        ijapa.turnRight();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0,0),ijapa.getCurrentPosition());
    }
//    @Test
//    public void turtleCanMoveWhile_FacingNorth(){
//        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
//        ijapa.turnLeft();
//        assertEquals(NORTH,ijapa.getCurrentDirection());
//        ijapa.move(3);
//        assertEquals(new Position(0,0),ijapa.getCurrentPosition());
//    }
//    @Test
//    public void test(){
//        ijapa.turnRight();
//        ijapa.move(6);
//        assertEquals(new Position(6,0), ijapa.getCurrentPosition());
//        ijapa.turnRight();
//        ijapa.turnRight();
//        assertEquals(NORTH,ijapa.getCurrentDirection());
//        ijapa.move(3);
//        assertEquals(new Position(3,0),ijapa.getCurrentPosition());
//    }
    @Test
    public void turtleCanWriteWhenPenIsDownFacingEastTest(){
        ijapa.penDown();
        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
        assertFalse(ijapa.isPenIsUp());
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        sketchPad.display();
    }
    @Test
    public void turtleCanWriteWhenPenIsDownTestFacingSouth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        assertEquals(1,floor[0][2]);
        assertEquals(1,floor[1][2]);
        assertEquals(1,floor[2][2]);
        assertEquals(0,floor[3][2]);
        sketchPad.display();
    }
    @Test
    public void turtleCanWriteWhenPenIsDownTestFacingWest(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        assertEquals(1,floor[0][2]);
        assertEquals(1,floor[1][2]);
        assertEquals(1,floor[2][2]);
        assertEquals(0,floor[3][2]);
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(1,floor[2][0]);
        assertEquals(1,floor[2][1]);
        assertEquals(1,floor[2][2]);
        sketchPad.display();
    }
    @Test
    public void turtleCanWriteWhenPenIsDownTestFacingNorth(){
        assertEquals(EAST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(0, 2), ijapa.getCurrentPosition());
        int [][] floor = sketchPad.getFloor();
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[0][1]);
        assertEquals(1,floor[0][2]);
        assertEquals(0,floor[0][3]);
        ijapa.turnRight();
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(2,2), ijapa.getCurrentPosition());
        assertEquals(1,floor[0][2]);
        assertEquals(1,floor[1][2]);
        assertEquals(1,floor[2][2]);
        assertEquals(0,floor[3][2]);
        ijapa.turnRight();
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3, sketchPad);
        assertEquals(new Position(2,0),ijapa.getCurrentPosition());
        assertEquals(1,floor[2][0]);
        assertEquals(1,floor[2][1]);
        assertEquals(1,floor[2][2]);
        ijapa.turnRight();
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.penDown();
        ijapa.move(3,sketchPad);
        assertEquals(new Position(0,0),ijapa.getCurrentPosition());
        assertEquals(1,floor[0][0]);
        assertEquals(1,floor[1][0]);
        assertEquals(1,floor[2][0]);
        assertEquals(0,floor[3][0]);
        sketchPad.display();
    }



}