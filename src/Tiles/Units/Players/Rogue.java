package Tiles.Units.Players;

import Game.LevelBoard;
import Tiles.Structs.Health;
import Tiles.Structs.Position;
import Tiles.Tile;
import Tiles.Units.Enemy;
import Tiles.Units.Player;

import java.util.List;

public class Rogue extends Player {
    private Integer cost;
    private Integer currentEnergy;

    public Rogue (Position position, String name, Integer attackPoints, Integer defence, Integer healthPool, Integer healthAmount, Integer cost){
        super(position, name, attackPoints, defence, healthPool, healthAmount);
        this.cost = cost;
        this.currentEnergy = 100;
    }


    @Override
    public void CastAbility(List<Enemy> enemies) {
        if (currentEnergy < cost){
            System.out.println("error");
        }
        else {
            currentEnergy=currentEnergy-cost;
            List <Enemy> enemiesInRange = EnemiesInRange(enemies, 2);
            for (int i=0 ; i<enemies.size() ; i++){
                Enemy enemy = enemiesInRange.get(i);
                Health h =enemy.getHealth();
                h.setHealthAmount(h.getHealthAmount()-this.attackPoints);
            }
        }
    }

    @Override
    public void LevelUp() {
        currentEnergy=100;
        attackPoints=attackPoints+3* GameLevel;

    }

    @Override
    public void GameTick() {
        currentEnergy=Math.min(currentEnergy+10, 100);
    }

    @Override
    public String describe() {
        {
            StringBuilder sb = new StringBuilder(" Attack damage: "+this.attackPoints+
                    " Defence points: "+ this.defence+" Level: "+this.GameLevel+" Experience: "+ this.experience+
                    " Cost: "+ this.cost);
            return sb.toString();
        }
    }

    @Override
    public void performMove(Tile[][] board) {

    }
}
