package Tiles.Units;

import Game.LevelBoard;
import Tiles.Structs.Health;
import Tiles.Structs.Position;
import Tiles.Tile;
import Tiles.Unit;

public abstract class Enemy extends Unit {
    protected Integer experienceValue;

    public Enemy (char tile, Position position, String name, Integer attackPoints, Integer defence , Health health, Integer experienceValue){
        super(tile, position, name, attackPoints, defence , health);
        this.experienceValue=experienceValue;

    }

    public Integer getExperienceValue(){ return experienceValue;}
    public abstract void performMove(Player player, Tile [][] levelBoard);

    @Override
    public void accept (Unit unit, Tile[][]levelBoard){
        unit.encounter(this, levelBoard);
    }

    public void encounter (Player player, Tile[][]levelBoard){
        this.attack(player);

    }
    public void encounter (Enemy enemy, Tile[][]levelBoard){}


}