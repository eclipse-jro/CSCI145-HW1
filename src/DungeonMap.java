public class DungeonMap {
    private Room[][] room;
    private Player player;
    private final char WALL_MAP_POSITION = '*';
    private final char EMPTY_MAP_POSITION = ' ';
    private final char PLAYER_MAP_POSITION = 'P';

    // constructor ; custom parameter
    public DungeonMap(int rows, int columns, Player player){
        room = new Room[rows][columns];
        this.player = player;
        initializeMap();
    }

    // constructor ; 10x10
    public DungeonMap(){
        room = new Room[10][10];
        initializeMap();
    }

    public void Print(){
        printUpperLowerWall();

        for (int r = 0; r < room.length; r++){
            System.out.print(WALL_MAP_POSITION);

            for (int c = 0; c < room[r].length; c++){
                if (r == player.getPosition().getX() &&
                    c == player.getPosition().getY()
                ){
                    System.out.print(PLAYER_MAP_POSITION);
                } else {
                    System.out.print(EMPTY_MAP_POSITION);
                }
            }

            System.out.println(WALL_MAP_POSITION);
        }

        printUpperLowerWall();
    }

    private void printUpperLowerWall(){
        for(int r = 0; r < room[r].length - 1; r++){
            System.out.print(WALL_MAP_POSITION);
        }
        System.out.println();
    }

    public void initializeMap(){
        for (int r = 0; r < room.length; r++){
            for (int c = 0; c < room[r].length; c++){
                room[r][c] = new Room();
            }
        }
    }
}