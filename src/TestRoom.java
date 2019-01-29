/**
 * Created by garberj2 on 1/25/19.
 */

import java.util.Scanner;

public class TestRoom {
    public void run(){
    	Scanner input = new Scanner(System.in);
    	Player player = new Player("w");
        Room room = new Room();
        room.enter(player, input);
        

    }
}
