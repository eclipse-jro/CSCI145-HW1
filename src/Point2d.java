////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | Point2d.java creates an object that describes the players location on the map.
//          | This can be updated to shift the player up, down, left or right on the map, or return a coordinate.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Point2d {
    private int x;
    private int y;

    public Point2d(int x, int y){
        this.x = x;
        this.y = y;
    }

//    public Point2d(){
//        this.x = 0;
//        this.y = 0;
//    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public Point2d distance(Point2d other){
        int deltaX = Math.abs(this.x - other.getX());
        int deltaY = Math.abs(this.y - other.getY());
        Point2d distance = new Point2d(deltaX, deltaY);

        return distance;
    }

    public void moveUp(){
        x -= 1;
    }

    public void moveDown(){
        x += 1;
    }

    public void moveLeft(){
        y -= 1;
    }

    public void moveRight(){
        y += 1;
    }
}
