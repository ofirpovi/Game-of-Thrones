package Tiles.Units.Players;

import Game.LevelBoard;
import Tiles.Structs.Position;
import Tiles.Tile;
import Tiles.Units.Enemy;
import Tiles.Units.Player;

import java.util.List;

public class Mage extends Player {
    private Integer manaPool;
    private Integer currentMana;
    private Integer manaCost;
    private Integer spellPower;
    private Integer hitsCount;
    private Integer abilityRange;


    public Mage (Position position, String name, Integer attackPoints, Integer defence, Integer healthPool, Integer healthAmount,
                 Integer manaPool,Integer manaCost, Integer spellPower, Integer hitsCount, Integer abilityRang ){
        super(position, name, attackPoints, defence, healthPool, healthAmount);
        this.manaPool = manaPool;
        this. currentMana = manaPool/4;
        this.manaCost = manaCost;
        this.spellPower= spellPower;
        this.hitsCount = hitsCount;
        this.abilityRange = abilityRang;
    }



    @Override
    public void CastAbility(List<Enemy> enemies) {
        if (currentMana < manaCost) {
            System.out.println("error");
        }
        else {
            currentMana = currentMana - manaCost;
            int hits = 0;
            while (hits < hitsCount) {
                for (int i = 0; i < enemies.size() ; i++) {
                    Enemy randomEnemy = SelectRandomEnemy(enemies, abilityRange);
                    if (randomEnemy != null) {
                        randomEnemy.getHealth().setHealthAmount(spellPower);
                        if (randomEnemy.getHealth().getHealthPool() <= 0) { //////////listener
                            enemies.remove(randomEnemy);
                        }
                        hits = hits + 1;
                    }
                }
            }
        }
    }


    @Override
    public void LevelUp() {
        manaPool=manaPool+(25* GameLevel);
        currentMana=Math.min(currentMana+(manaPool/4), manaPool);
        spellPower=spellPower+(10* GameLevel);
    }

    @Override
    public void GameTick() {
        currentMana=Math.min(manaPool, currentMana+ GameLevel);
    }

    @Override
    public String describe() {
        {
            StringBuilder sb = new StringBuilder(" Attack damage: "+this.attackPoints+
                    " Defence points: "+ this.defence+" Level: "+this.GameLevel+" Experience: "+ this.experience+
                    " Mana pool: "+ this.manaPool+" Mana cost: "+ this.manaCost+ " Spell power: "+this.spellPower+
                    " Hit count: "+this.hitsCount+" Range: "+this.abilityRange);
            return sb.toString();
        }
    }

    @Override
    public void performMove(Tile[][] board) {

    }
}
