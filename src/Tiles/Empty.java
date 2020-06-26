package Tiles;

import Game.LevelBoard;
import Tiles.Structs.Position;

import java.util.List;

public class Empty extends Tile {
    public Empty (Position position){
        super ('.', position);
    }

    @Override
    public void accept (Unit unit, Tile[][]levelBoard){
        unit.encounter(this, levelBoard);
    }
}