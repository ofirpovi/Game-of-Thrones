package Game;

import Tiles.Tile;
import Tiles.Units.Enemy;
import Tiles.Units.Player;

import java.util.List;
import java.util.Scanner;

public class Level {

    private LevelBoard board;
    private List<Enemy> enemies;
    private MessageHandler m;

    public Level (LevelBoard board, List<Enemy>enemies){
        this.board = board;
        this.enemies=enemies;
        m = new CmdPrinter();
    }

    public void playLevel(Player player) {
        player.setPosition(board.getStartPositionPlayer());
        while (!enemies.isEmpty()) {
            gameTick(player);
            m.sendMessage(board.printBoard());
            printEndTickDetails(player);
        }

    }

    private void gameTick(Player player) {
//        m.sendMessage(player.getName()+ ", Enter your move");// להעביר למטודת perfomMove
//        Scanner input= new Scanner(System.in);
        player.performMove(board.getLevelBoard());
        if (player.getHealth().getHealthAmount()<=0){

        }
        else if (true)
        player.GameTick();
        for (Enemy enemy: enemies){
             enemy.performMove(player, board.getLevelBoard());
        }
    }

    private void printEndTickDetails(Player player)
    {
        m.sendMessage(player.getName()+" state: "+ player.describe());
    }



}