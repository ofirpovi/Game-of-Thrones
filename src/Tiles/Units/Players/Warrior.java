package Tiles.Units.Players;

import Game.LevelBoard;
import Tiles.Structs.CoolDown;
import Tiles.Structs.Position;
import Tiles.Units.Enemy;
import Tiles.Units.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Warrior extends Player {
    private CoolDown coolDown;

    public Warrior (Position position, String name, Integer attackPoints, Integer defence, Integer healthPool, Integer healthAmount, Integer abilityCoolDown, Integer remainingCoolDown ){
        super(position, name, attackPoints, defence, healthPool, healthAmount);
        this.coolDown = new CoolDown( abilityCoolDown, remainingCoolDown );
    }

    @Override
    public void CastAbility(List<Enemy> enemies) {
        if (coolDown.getRemainingCoolDown()>0){
            System.out.println("error");
        }
        else {
            coolDown.setRemainingCoolDown(coolDown.getAbilityCoolDown());
            health.setHealthAmount(health.getHealthAmount()+10*defence);
            Enemy randomEnemy = SelectRandomEnemy(enemies, 3);
            if (randomEnemy!=null){
                randomEnemy.getHealth().setHealthAmount(randomEnemy.getHealth().getHealthAmount()-this.getHealth().getHealthPool()*10/100);
                if (randomEnemy.getHealth().getHealthAmount() <= 0){
                    enemies.remove(randomEnemy);
                }
            }
        }
    }

    @Override
    public void LevelUp() {
        coolDown.setRemainingCoolDown(0);
        health.setHealthPool(health.getHealthPool()+5* GameLevel);
        attackPoints=attackPoints+(2* GameLevel);
        defence=defence+ GameLevel;
    }

    public void GameTick(){
        coolDown.setRemainingCoolDown(coolDown.getRemainingCoolDown()-1);
    }

    @Override
    public String describe() {
        {
            StringBuilder sb = new StringBuilder(" Attack damage: "+this.attackPoints+
                    " Defence points: "+ this.defence+" Level: "+this.GameLevel+" Experience: "+ this.experience+
                    " Cool down: "+ this.coolDown);
            return sb.toString();
        }
    }


}
