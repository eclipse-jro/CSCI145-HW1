////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | DungeonGame.java directs the flow of the game and all major classes.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class DungeonGame {
    private DungeonMap map;
    private Player player ;
    private Scanner input;


    //initiates intro and constructs the player and map
    public DungeonGame(){
        int dungeonSize;
        input = new Scanner(System.in);

        //intro text
        printIntro();

        //constructs map and player objects
        dungeonSize = constructMap();
        setPlayer(dungeonSize);

        map = new DungeonMap(dungeonSize, dungeonSize, player);
        Point2d xyPlayer = new Point2d(0,0);
        player.setPosition(xyPlayer);
    }

    //over loaded constructor to handle command line argument for dungeon size
    //initiates intro and constructs the player and map
    public DungeonGame(int dungeonSize){
        input = new Scanner(System.in);

        //intro text
        printIntro();

        //constructs player objects
        setPlayer(dungeonSize);

        map = new DungeonMap(dungeonSize, dungeonSize, player);
        Point2d xyPlayer = new Point2d(0,0);
        player.setPosition(xyPlayer);
    }

    // initiates gameplay
    public void play(){

        System.out.println("\n" + player.getEntranceText());

        //keeps the game going util player wins/loses
        while(player.isAlive() && player.getGold() < 100  && !completedAllRooms()){
            printDivide();

            //player enters the Room object from Room array in DungeonMap
            map.getRooms()[player.getPosition().getX()][player.getPosition().getY()].enter(player, input);

            printDisplay();

            //begins combat
            map.getRooms()[player.getPosition().getX()][player.getPosition().getY()].initiateCombat(player, input);

            //checks for win/lose conditions
            if(!player.isAlive() || (player.getGold() >= 100) || completedAllRooms()){
                break;
            }

            navigate();

        }

        //win condition
        if(player.getGold() >= 100){
            System.out.println("You acquired 100 cookies! YOU WIN!");
        }
        //lose conditions
        else if(player.isAlive()){
            System.out.println();
            System.out.println("There are no more rooms. You did not get 100 cookies.");
            System.out.println("GAME OVER");
        }
        else{
            System.out.println("GAME OVER!");
        }
    }


    //intro text
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

    //turn divider Strings
    public void printDivide(){
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------" + "\n");
    }

    //displays map and stats
    public void printDisplay(){
        map.Print();

        System.out.print("COOKIES: " + player.getGold() + "\n");
        System.out.print("HP: " + player.getHealth() + "\n");
        System.out.print("\n");
    }

    //prompts user for dungeon movement and executes movement
    public void navigate() {
        String choice;
        boolean loopActive = true;

        //loops if incorrect input is submitted
        while (loopActive) {
            System.out.print("What room would you like to go to? [W]Up, [S]Down, [A]Left, [D]Right:");
            choice = input.nextLine();
            choice = choice.toUpperCase();

            //switch statement code blocks check if user's move choice is possible
            switch(choice){
                case "W":
                    //if at the edge of map
                    if(player.getPosition().getX() == 0){
                        System.out.println();
                        System.out.println("You cannot move through walls!");
                        System.out.println();
                        //goes back to beginning of loop
                        continue;
                    }
                    //moves player
                    else{
                        player.getPosition().moveUp();
                    }
                    //breaks loop
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
                //incorrect input
                default:
                    System.out.println();
                    System.out.println("Please enter W,S,A, or D only.");
                    System.out.println();
                    break;
            }
        }
    }

    //takes input from user, checks validity, returns integer for map size
    private int constructMap(){
        boolean breakLoop = false;
        String stringEntry;
        int dungeonSize = 10;

        while(!breakLoop) {
            System.out.println("Choose dungeon size 1 or greater. (Enter '0' for default size 10 rows x 10 columns).");
            System.out.println();
            System.out.print("Enter number of rows and columns: ");

            stringEntry = input.nextLine();

            //turns input into integer unless produces error
            try {
                dungeonSize = Integer.parseInt(stringEntry);
                breakLoop = true;
                System.out.println();
              //if throws error, notifies user and loops prompt again
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter an integer.");
                System.out.println();
                continue;
            }
        }
        return dungeonSize;
    }

    //chooses player class and instantiates player
    private void setPlayer(int mapSize){
        boolean breakLoop = false;
        String classChoice;

        //loops until correct input is submitted
        while(!breakLoop) {
            System.out.println("Thief: 70 hp, 10 dmg, +120% Cookies");
            System.out.println("Warrior: 100 hp, 15 dmg, +100% Cookies");
            System.out.print("Choose your class, Warrior or Thief? (W/T): ");

            //checks for correct input
            classChoice = input.nextLine();
            if(classChoice.equalsIgnoreCase("w") || classChoice.equalsIgnoreCase("t")){
                //instantiates new Player object with user's class choice
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

    //checks if the whole dungeon is complete (all rooms visited and all monsters killed)
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
