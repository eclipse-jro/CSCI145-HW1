public class Treasure {
    private String treasureType;
    private int effectQuantity;
    private String findText;
    private String takeText;
    public int treasureMult;

    public Treasure() { // 1 treasure needs sizes passed to it
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

    public int getTreasureMult() { return treasureMult; }

    public void setTreasureMult(int mult){
        this.treasureMult = mult;
    }
}
