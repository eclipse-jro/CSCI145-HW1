////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | DungeonMap.java prints out Room 2d array map, player position,  and rooms visited / not visited.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class DungeonMap {
    private Room[][] room;
    private Player player;
    private final char WALL_MAP_POSITION = '|';
    private final String EMPTY_MAP_POSITION = "  ";
    private final String VISTED_MARKER = "* ";
    private String player_map_position = "P ";


    // constructor, creates input sized 2D array and initializes player.
    // default size 10
    public DungeonMap(int rows, int columns, Player player) {
        if ( rows == 0 && columns == 0 || (rows < 0 || columns < 0) ) {
            rows = 10;
            columns = 10;
        }
        room = new Room[rows][columns];
        this.player = player;
        initializeMap();

        // get player map position class symbol to display position
        if(player.getType() == "Thief") {
            player_map_position = "T ";
        } else if (player.getType() == "Warrior") {
            player_map_position = "W ";
        }

    }

    // displays the non-boundaries  section of the map to user.
    public void Print() {
        printUpperLowerWall();

        for (int r = 0; r < room.length; r++) {
            System.out.print(WALL_MAP_POSITION);

            for (int c = 0; c < room[r].length; c++) {
                if (r == player.getPosition().getX() &&
                    c == player.getPosition().getY()
                ){
                    System.out.print(player_map_position);
                }
                else if(room[r][c].hasVisited()) {
                    System.out.print(VISTED_MARKER);
                } else {
                    System.out.print(EMPTY_MAP_POSITION);
                }
            }

            System.out.println(WALL_MAP_POSITION);
        }

        printUpperLowerWall();
    }

    //prints boundaries section of the map to the user.
    private void printUpperLowerWall() {
        System.out.print("+-");
        for (int r = 0; r < room[r].length - 1; r++) {
            //System.out.print(WALL_MAP_POSITION);
            System.out.print("--");
        }
        System.out.print("-+");
        System.out.println();
    }

    //initializes the map 2d array
    public void initializeMap() {
        for (int r = 0; r < room.length; r++) {
            for (int c = 0; c < room[r].length; c++) {
                room[r][c] = new Room();
            }
        }
    }

    //accessor method
    public Room[][] getRooms() {
        return room;
    }
}