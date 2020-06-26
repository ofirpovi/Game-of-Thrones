package Tiles.VisitorP;

import Game.LevelBoard;
import Tiles.Empty;
import Tiles.Tile;
import Tiles.Units.Enemy;
import Tiles.Units.Player;
import Tiles.Wall;

public interface Visitor {
    public void encounter (Wall wall, Tile[][]levelBoard);
    public void encounter (Empty empty, Tile[][]levelBoard);
    public void encounter (Player player, Tile[][]levelBoard);
    public void encounter (Enemy enemy, Tile[][]levelBoard);
}
