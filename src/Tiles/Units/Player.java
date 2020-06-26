package Tiles.Units;

import Tiles.Tile;
import Tiles.Unit;
import Tiles.Structs.Health;
import Tiles.Structs.Position;
//import Tiles.Units.Actions.Action;

import java.util.*;


public abstract class Player extends Unit {
    protected Integer experience;
    protected Integer GameLevel;
    protected Integer PlayLevel;

    public Player (Position position, String name, Integer attackPoints, Integer defence, Integer healthPool, Integer healthAmount ){
        super ('@', position, name, attackPoints, defence, new Health(healthPool, healthAmount));
        this.experience = 0;
        this.GameLevel = 1;
    }

    public abstract void CastAbility (List<Enemy> enemies);
    public abstract void LevelUp ();
    public abstract void GameTick();
    @Override
    public void accept (Unit unit, Tile[][]levelBoard){
        unit.encounter(this, levelBoard);
    }

    @Override
    public void encounter (Player player, Tile[][] levelBoard){}
    @Override
    public void encounter (Enemy enemy, Tile[][] levelBoard){
        this.attack(enemy);
        if (enemy.getHealth().getHealthAmount()<=0){

        }
    }


    public void  PlayerLevelUp (){
        experience = experience-(50* GameLevel);
        GameLevel = GameLevel +1;
        health.setHealthPool(health.getHealthPool()+(10* GameLevel));
        health.setHealthAmount(health.getHealthPool());
        attackPoints=attackPoints+(4* GameLevel);
        defence=defence+ GameLevel;
    }

    public List<Enemy> EnemiesInRange (List <Enemy> enemies, double range) {
        List<Enemy> enemiesInRange = new LinkedList<>();
        for (int i=0 ; i<enemies.size() ; i++){
            Enemy enemy = enemies.get(i);
            if (enemy.rangeFrom(position)<range){
                enemiesInRange.add(enemy);
            }
        }
        return enemiesInRange;
    }

    public Enemy SelectRandomEnemy (List <Enemy> enemies, double range){
        Enemy randomEnemy;
        List<Enemy> enemiesInRange = EnemiesInRange(enemies, range);
        if (enemiesInRange.size()==0){
            randomEnemy=null;
        }
        else {
            Random rand = new Random();
            int randomInd = rand.nextInt(enemies.size() - 1);
            randomEnemy=enemies.get(randomInd);
        }
        return randomEnemy;
    }

    public void performMove(Tile[][] board){
        //Map<Character, Action> map = new HashMap<>();
    }

    public abstract String describe();


    public String getName() { return  name;
    }
}