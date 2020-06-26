package Game;
import Tiles.Units.Player;
import Tiles.Units.Players.Mage;
import Tiles.Units.Players.Rogue;
import Tiles.Units.Players.Warrior;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GamePlay {

    private List<Level> levelBoards;
    private Map<Integer, Player> playersMap;
    private Player player;
    private CmdPrinter m;

    public GamePlay (List<Level> levelBoards){
      this.levelBoards = levelBoards;
      this.player = null;
      this.m = new CmdPrinter();
      this.playersMap = new HashMap<>();
      playersMap.put(0, new Warrior(null,"Jon Snow", 30, 4, 300, 300, 3,3));
      playersMap.put(1, new Warrior(null, "The hound", 20, 6, 400,400,5,5));
      playersMap.put(2, new Mage(null, "Melisandre", 5, 1, 100, 100, 300, 30, 15, 5, 6));
      playersMap.put(3, new Mage(null,"Thoros of Myr", 25,4,250,250,150,20,20,3,4));
      playersMap.put(4, new Rogue(null, "Arya Stark", 40,3,150,150,20));
      playersMap.put(5, new Rogue(null, "Bronn", 35,3,250,250,50));
    }

    public void setPlayer(Player chosenPlayer){
        player = chosenPlayer;
    }

    public void startGame(){
        printPlayersDetails();
        Scanner input= new Scanner(System.in);
        m.sendMessage("Chose your player by enter his Id");
        int playerNumber= input.nextInt();
        setPlayer(playersMap.get(playerNumber));
        m.sendMessage("You can start play! May the odds be ever in your favor... ");

        for (Level level : levelBoards) {
            level.playLevel(player);
            player.PlayerLevelUp();
            if(player.getHealth().getHealthAmount()== 0){
                m.sendMessage("Game Over");
                break;
            }
        }
    }

    public  void printPlayersDetails(){
        StringBuilder sb = new StringBuilder();
        sb.append("Players information:"+"\n");
        for (int i=0; i< playersMap.size();i++){
             sb.append("Player ID: "+i+" "+ playersMap.get(i).describe()+"\n");
        }
    }

}
