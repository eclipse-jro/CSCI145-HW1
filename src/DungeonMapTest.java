public class DungeonMapTest {
    public void runTest(){
        Player mapPlayerTest = new Player("t");

        Point2d point2d = new Point2d(0,0);
        mapPlayerTest.setPosition(point2d);

        DungeonMap map = new DungeonMap(10, 10, mapPlayerTest);
        map.Print();
    }
}
