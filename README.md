# CSCI145-HW1
Java Project One. 2D Dungeon Adventure Game.

## TO DO:

0. Rene will finish the player class and implement it in main.
1. Finish the "Monster" and "Player" classes.
2. Create the DungeonGame, DungeonMap, and Room Classes.
3. Get an A on this project and Profit.

## Requirements:

1. The dungeon’s rooms must be stored in a 2d array. The default size of a dungeon is 10 x 10. A custom size can be passed in through command line arguments, but a dungeon must be 1 x 1 or larger, so that there is at least one room.
2. The player must be able to choose between Warrior and Thief, which changes the player’s health, damage, and gold looted.
3. At the start of each turn, the dungeon map, the players gp, and the players hp must be displayed. The map must show the player’s location (W for warrior; T for thief), marking visited rooms, and clearly indicating walls. (Note that walls are not part of the dungeon, they are just a border. For instance, the dungeon in the example provided earlier is 5 x 8, and the player started at [0, 0].)
4. Each turn when not in combat, the user should be prompted to choose to move up, down, left, or right. The player’s initial location should be at a corner of the map, and a player can move into visited and unvisited rooms, but cannot move through the walls.
5. An encounter should start whenever a player moves to an unvisited room. The encounter type should be random.
6. Loot should be picked up and applied to the character automatically. The amount of gold or healing should be random. A thief’s bonus should be added to looted gold, and a player’s health can’t go over their max health.
7. Monster encounters should give a player an option to run or attack. A monster should hit and damage a player if they run or attack. The amount of damage is random, but should be no more than the monster’s max damage. A player should do full damage to a monster, and get an option to keep attacking or run until either the monster is dead, the player is dead, or the player runs away.
8. The game must have the four types of monsters described earlier, where the monster type determines a monster’s hp and max damage.
9. Random values for damage, gold, and healing should be reasonable. We don’t want the game to end in one turn or take over nine thousand turns.
10. The game should end with an appropriate message when a player gets 100 gp or more (win) or the player dies (lose).
11. The game must include proper error handling, so that the program does not terminate abnormally due to bad user input.


## Dirs and Files

1. ".idea" : All the project specific settings for the Intellij IDE.
2. "src" : Java project source files.
3. "HW1.iml" : Module file created by IntelliJ IDEA; stores information about a development module, which may be a Java, Plugin, Android, or Maven component; saves the module paths, dependencies, and other settings.