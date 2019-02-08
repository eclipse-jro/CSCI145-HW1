//I can' run this; error = "class file has wrong version 54.0, should be 52.0"

public class Treasure {
    private String treasureType;
    private int effectQuantity;
    private String findText;
    private String takeText;

    public Treasure() {
        RandomGenerator randomSelect = new RandomGenerator();
        int treasureTypeSelection = randomSelect.randInt(1,2);

        switch(treasureTypeSelection) {
            case 1:
                treasureType = "cookies";
                effectQuantity = randomSelect.randInt(12, 21);
                findText = "You found some cookies!";
                takeText = "OBTAINED %d COOKIES";
                break;
            case 2:
                treasureType = "health soda";
                effectQuantity = randomSelect.randInt(12, 21);
                findText = "You found a health soda!";
                takeText = "RESTORED %d HEALTH";
                break;
        }
    }

    public Treasure(int choice){
        RandomGenerator randomSelect = new RandomGenerator();
        switch(choice){
            case 1:
                treasureType = "cookies";
                effectQuantity = randomSelect.randInt(5, 30);
                findText = "You found some cookies!";
                takeText = "OBTAINED %d COOKIES";
                break;
            case 2:
                treasureType = "health soda";
                effectQuantity = randomSelect.randInt(10, 20);
                findText = "You found a health soda!";
                takeText = "RESTORED %d HEALTH";
                break;
        }
    }

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
}
