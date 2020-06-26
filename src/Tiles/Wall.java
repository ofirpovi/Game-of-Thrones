package Tiles;

import Game.LevelBoard;
import Tiles.Structs.Position;

public class Wall extends Tile {

    public Wall (Position position)
    {
        super ('#',position);
    }
    @Override
    public void accept (Unit unit, Tile[][]levelBoard){
        unit.encounter(this, levelBoard);
    }
}