////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | Main.java initializes a DungeonGame object and executes its play() method.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {

        //option to set dungeon size through the command line.
        if (args.length > 0) {
            int dungeonSize = Integer.parseInt(args[0]);
            DungeonGame game = new DungeonGame(dungeonSize);
            game.play();
        }
        else {
            DungeonGame game = new DungeonGame();
            game.play();
        }
    }
}