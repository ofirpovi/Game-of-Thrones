package Tiles.Units.Enemies;

import Game.LevelBoard;
import Tiles.Structs.Health;
import Tiles.Structs.Position;
import Tiles.Tile;
import Tiles.Units.Enemy;
import Tiles.Units.Player;

public class Trap extends Enemy {
    protected Integer visibilityTime;
    protected Integer invisibilityTime;
    protected Integer ticksCount;
    protected Boolean visible;

    public Trap (char tile, Position position, String name, Integer attackPoints, Integer defence , Health health, Integer experienceValue, Integer visibilityTime, Integer invisibilityTime){
        super(tile, position, name, attackPoints, defence , health, experienceValue);
        this.ticksCount=0;
        this.visible = true;
    }

    @Override
    public void performMove(Player player, Tile[][] levelBoard) {

    }
}