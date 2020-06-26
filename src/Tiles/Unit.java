package Tiles;

import Game.LevelBoard;
import Tiles.Structs.Health;
import Tiles.Structs.Position;
import Tiles.Units.Enemy;
import Tiles.Units.Player;
import Tiles.VisitorP.Visitor;

import java.util.Map;
import java.util.Random;

public abstract class Unit extends Tile implements Visitor {
    protected String name;
    protected Integer attackPoints;
    protected Integer defence;
    protected Health health;

    public Unit (char tile, Position position, String name, Integer attackPoints, Integer defence , Health health ){
        super (tile, position);
        this.name = name;
        this.attackPoints = attackPoints;
        this.defence = defence;
        this.health = health;
    }


    public double rangeFrom (Position other){
        return (Math.sqrt(Math.pow(super.position.getX()-other.getX(), 2 )+ Math.pow(super.position.getY()- other.getY(), 2)));
    }

    public Health getHealth() {
        return health;
    }

    public void attack (Unit unit){
        Random rand = new Random();
        int randomAttack = rand.nextInt(attackPoints);
        int randomDefence = rand.nextInt(unit.defence);
        int attackSum = randomAttack-randomDefence;
        if (attackSum>0){
            unit.health.setHealthAmount(unit.getHealth().getHealthAmount()-attackSum);
        }
    }

    public void encounter (Empty empty, Tile[][]levelBoard){
        Position temp = empty.getPosition();
        empty.setPosition(this.position);
        this.position=temp;
    }
    public void encounter (Wall wall, Tile[][]levelBoard){}

    public abstract void encounter (Player player, Tile [][] levelBoard);
    public abstract void encounter (Enemy enemy, Tile [][] levelBoard);

    public void MoveLeft (Tile[][]levelBoard){
        if (position.getX()!=0){
            Tile tile = levelBoard[position.getX()-1][position.getY()];
            encounter(tile, levelBoard);
        }
    }


    public void MoveRight (Tile[][]levelBoard){
        if (position.getX()!=levelBoard.length){
            Tile tile = levelBoard[position.getX()+1][position.getY()];
            encounter(tile, levelBoard);
        }
    }
    public void MoveUp (Tile[][]levelBoard){
        if (position.getY()!=0) {
            Tile tile = levelBoard[position.getX()][position.getY() + 1];
            encounter(tile, levelBoard);
        }
    }
    public void MoveDown (Tile[][]levelBoard){
        if (position.getY()!=levelBoard[0].length) {
            Tile tile = levelBoard[position.getX()][position.getY()-1];
            encounter(tile,levelBoard);
        }
    }
    public void MoveRandomly (){

    }

    public void encounter (Tile tile, Tile[][]levelBoard){
        tile.accept(this, levelBoard);
    }
}
