/**
 * Created by garberj2 on 1/25/19.
 */

import java.util.Scanner;

public class TestRoom {
    public void run(){
    	Scanner input = new Scanner(System.in);
    	Player player = new Player("t");

        Room room = new Room(1,1);
        room.enter(player, input);

        

    }
}
