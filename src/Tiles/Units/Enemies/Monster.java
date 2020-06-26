package Tiles.Units.Enemies;

import Game.LevelBoard;
import Tiles.Structs.Health;
import Tiles.Structs.Position;
import Tiles.Tile;
import Tiles.Units.Enemy;
import Tiles.Units.Player;

public class Monster extends Enemy {
    protected Integer visionRang;

    public Monster (char tile, Position position, String name, Integer attackPoints, Integer defence , Health health, Integer experienceValue, Integer visionRang){
        super(tile, position, name, attackPoints, defence , health, experienceValue);
        this.visionRang = visionRang;
    }

    @Override
    public void performMove (Player player, Tile [][] levelBoard){
        if (rangeFrom(player.getPosition())< visionRang){
            int dx = this.position.getX()-player.getPosition().getX();
            int dy = this.position.getY()-player.getPosition().getY();
            if (Math.abs(dx)>Math.abs(dy)){
                if (dx > 0){
                    MoveLeft(levelBoard);
                }
                else {
                    MoveRight(levelBoard);
                }
            }
            else {
                if (dy > 0){
                    MoveUp(levelBoard);
                }
                else{
                    MoveDown(levelBoard);
                }
            }
        }
        else {
            MoveRandomly();
        }

    }
}
