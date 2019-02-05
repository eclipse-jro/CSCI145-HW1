import java.util.Scanner;

public class DungeonGame {
    //private DungeonMap map;

    public void play(){
        Player player;
        int dungeonSize;
        String classChoice;

        printIntro();
        System.out.println("Choose dungeon size 1 or greater. (Enter '0' for default size 10 rows x 10 columns)." + "\n");
        System.out.println("Enter number of rows and columns: ");
        Scanner inputDungeonsize = new Scanner(System.in);
        dungeonSize = inputDungeonsize.nextInt();

        System.out.println("Thief: 70HP , 10DMG, 120%GOLD (Enter 't' to select)");
        System.out.println("Warrior: 100HP, 15DMG, 100%GOLD (Enter 'w' to select)");
        System.out.print("Choose your class, Warrior or Thief? (W/T): ");
        Scanner inputClass = new Scanner(System.in);
        classChoice = inputClass.next();
        player = new Player(classChoice);
        // testing dungeonMap
        DungeonMap map = new DungeonMap(dungeonSize, dungeonSize, player);
        Point2d xyPlayer = new Point2d(0,0);
        player.setPosition(xyPlayer);

        System.out.println("\n" + player.getEntranceText());

        while(player.isAlive() //&& player.getGold < 100
        ){
            printDisplay(map, player);
            // break is here temporarily for testing
            break;

        }
        if(player.isAlive()){
            System.out.println("You acquired 100 cookies! YOU WIN!");
        }
        else{
            System.out.println("GAME OVER!");
        }


    }

    private void printIntro(){
        System.out.println(" ________________________________________________________________________________");
        System.out.println("|    ___    __    __   _  _ ___  ____     ___    _    _  ____   _____  _______   |");
        System.out.println("|   /   \\  /  \\  /  \\  | /   |   |       /   \\   |    |  |     |    |     |      |");
        System.out.println("|  |      |    ||    | |/    |   |__    |     |  |    |  |___   \\___      |      |");
        System.out.println("|   \\   |  \\  /  \\  /  | \\   |   |       \\  \\/   |    |  |          |     |      |");
        System.out.println("|     --    --    --   '  '  ---  ---     -- \\    \\__/    ---- |____/     |      |");
        System.out.println("|________________________________________________________________________________|");

        System.out.println();

        System.out.println("One hero needs to collect 100 cookies to satisfy the evil King.");
        System.out.println("You are in the fabled Dungeon of Delights, to gather those cookies.");
        System.out.println("You are not alone in the dungeon...");
        System.out.println("In each room, you may find goodies, or one of the greedy inhabitants.");
        System.out.println("Don't let its inhabitants get you... cookies are the gold of the underworld...");
        System.out.println();
    }

    public void printDivide(){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------" + "\n");
    }

    public void printDisplay(DungeonMap displayMap, Player displayPlayer){
        printDivide();
        displayMap.Print();
        System.out.print("GP =" + displayPlayer.getGold() + "\n");
        System.out.print("HP =" + displayPlayer.getHealth() + "\n");
        System.out.print("\n");
        printDivide();
    }
}
