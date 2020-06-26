package Tiles.VisitorP;

import Game.LevelBoard;
import Tiles.Tile;
import Tiles.Unit;

public interface Visited {
    public void accept (Unit unit, Tile[][]levelBoard);
}
