import java.util.Scanner;

public class DungeonGame {
    private DungeonMap map;
    private Player player;
    private Scanner input;


    public DungeonGame(){
        String classChoice;
        int dungeonSize;
        input = new Scanner(System.in);

        printIntro();

        dungeonSize = constructMap();

        setPlayer(dungeonSize);

        map = new DungeonMap(dungeonSize, dungeonSize, player);

        Point2d xyPlayer = new Point2d(0,0);
        player.setPosition(xyPlayer);
    }



    public void play(){

        System.out.println("\n" + player.getEntranceText());

        while(player.isAlive() && player.getGold() < 100  && !completedAllRooms()){

            printDivide();
            map.getRooms()[player.getPosition().getX()][player.getPosition().getY()].enter(player, input);

            printDisplay();
            map.getRooms()[player.getPosition().getX()][player.getPosition().getY()].initiateCombat(player, input);

            if(map.getRooms().length == 1 || !player.isAlive() || (player.getGold() >= 100)){
                break;
            }

            navigate();

        }

        if(player.getGold() >= 100){
            System.out.println("You acquired 100 cookies! YOU WIN!");
        }
        else if(player.isAlive()){
            System.out.println();
            System.out.println("There are no more rooms. You did not get 100 cookies.");
            System.out.println("GAME OVER");
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
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------" + "\n");
    }

    public void printDisplay(){
        map.Print();

        System.out.print("COOKIES: " + player.getGold() + "\n");
        System.out.print("HP: " + player.getHealth() + "\n");
        System.out.print("\n");
    }

    public void navigate() {
        String choice;
        boolean loopActive = true;

        while (loopActive) {
            System.out.print("What room would you like to go to? [W]Up, [S]Down, [A]Left, [D]Right:");
            choice = input.nextLine();
            choice = choice.toUpperCase();

            switch(choice){
                case "W":
                    if(player.getPosition().getX() == 0){
                        System.out.println();
                        System.out.println("You cannot move through walls!");
                        System.out.println();

                        continue;
                    }
                    else{
                        player.getPosition().moveUp();
                    }
                    loopActive = false;
                    break;

                case "S":
                    if(player.getPosition().getX() == map.getRooms().length -1){
                        System.out.println();
                        System.out.println("You cannot move through walls!");
                        System.out.println();
                        continue;
                    }
                    else{
                        player.getPosition().moveDown();
                    }
                    loopActive = false;
                    break;

                case "A":
                    if(player.getPosition().getY() == 0){
                        System.out.println();
                        System.out.println("You cannot move through walls!");
                        System.out.println();
                        continue;
                    }
                    else{
                        player.getPosition().moveLeft();
                    }
                    loopActive = false;
                    break;

                case "D":
                    if(player.getPosition().getY() == map.getRooms()[0].length - 1){
                        System.out.println();
                        System.out.println("You cannot move through walls!");
                        System.out.println();
                        continue;
                    }
                    else{
                        player.getPosition().moveRight();
                    }
                    loopActive = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Please enter W,S,A, or D only.");
                    System.out.println();
                    break;
            }
        }
    }

    private int constructMap(){
        boolean breakLoop = false;
        String stringEntry;
        int dungeonSize = 10;

        while(!breakLoop) {
            System.out.println("Choose dungeon size 1 or greater. (Enter '0' for default size 10 rows x 10 columns).");
            System.out.println();
            System.out.print("Enter number of rows and columns: ");

            stringEntry = input.nextLine();

            try {
                dungeonSize = Integer.parseInt(stringEntry);
                breakLoop = true;
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter an integer.");
                System.out.println();
                continue;
            }
        }
        return dungeonSize;
    }


    private void setPlayer(int mapSize){
        boolean breakLoop = false;
        String classChoice;

        while(!breakLoop) {
            System.out.println("Thief: 70 hp, 10 dmg, +120% Cookies");
            System.out.println("Warrior: 100 hp, 15 dmg, +100% Cookies");
            System.out.print("Choose your class, Warrior or Thief? (W/T): ");

            classChoice = input.nextLine();
            if(classChoice.equalsIgnoreCase("w") || classChoice.equalsIgnoreCase("t")){
                player = new Player(classChoice, mapSize);
                breakLoop = true;
            }
            else{
                System.out.println();
                System.out.println("Please enter W or T.");
                System.out.println();
            }

        }
    }

    private boolean completedAllRooms(){
        for(int x = 0; x < map.getRooms().length; x++){
            for(int y = 0; y < map.getRooms()[0].length; y++){
                if(map.getRooms()[x][y].hasVisited() == false) {
                    return false;
                }
                else if(map.getRooms()[x][y].hasMonster()){
                    if(!map.getRooms()[x][y].isMonsterDefeated()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
