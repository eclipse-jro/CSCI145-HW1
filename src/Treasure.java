////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | Treasure.java controls the loot behavior and attributes.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Treasure {
    private String treasureType;
    private int effectQuantity;
    private String findText;
    private String takeText;
    private String killFindText;

    //default constructor
    public Treasure() {
        //randomly chooses between cookies or health soda
        RandomGenerator randomSelect = new RandomGenerator();
        int treasureTypeSelection = randomSelect.randInt(1,2);

        //depending on random selection, instantiates fields with appropriate info
        switch(treasureTypeSelection) {
            case 1:
                treasureType = "cookies";
                //selects random amount of cookies
                effectQuantity = randomSelect.randInt(10, 20);
                findText = "You found some cookies!";
                takeText = "OBTAINED %d COOKIES";
                killFindText = "You found cookies among the monster's remains.";
                break;
            case 2:
                treasureType = "health soda";
                //selects random amount of healing
                effectQuantity = randomSelect.randInt(10, 20);
                findText = "You found a health soda!";
                takeText = "RESTORED %d HEALTH";
                killFindText = "You found a health soda among the monster's remains.";
                break;
        }
    }

    //constructer that dictates what the maximum value the random generator can produce
    public Treasure(int max){
        RandomGenerator randomSelect = new RandomGenerator();
        int treasureTypeSelection = randomSelect.randInt(1,2);
        switch(treasureTypeSelection) {
            case 1:
                treasureType = "cookies";
                //randomly produces cookie quantity between the MAX argument and half of that
                effectQuantity = randomSelect.randInt((int)(max/2), max);
                findText = "You found some cookies!";
                takeText = "OBTAINED %d COOKIES";
                killFindText = "You found cookies among the monster's remains.";
                break;
            case 2:
                treasureType = "health soda";
                //randomly produces healing quantity between the MAX argument and half of that
                effectQuantity = randomSelect.randInt((int)(max/2), max);
                findText = "You found a health soda!";
                takeText = "RESTORED %d HEALTH";
                killFindText = "You found a health soda among the monster's remains.";
                break;
        }
    }

    //public getters

    public String getType() {
        return treasureType;
    }

    public int getQuantity() {
        return effectQuantity;
    }

    public String getFindText() {
        return findText;
    }

    public String getTakeText() {
        return takeText;
    }

    public String getKillFindText() {
        return killFindText;
    }

}
