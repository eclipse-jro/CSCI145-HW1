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
                treasureType = "gold";
                effectQuantity = randomSelect.randInt(5, 30);
                findText = "You found some gold!";
                takeText = "OBTAINED " + effectQuantity + " GOLD";
                break;
            case 2:
                treasureType = "health potion";
                effectQuantity = randomSelect.randInt(10, 20);
                findText = "You found a health potion!";
                takeText = "RESTORED " + effectQuantity + " HEALTH";
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
