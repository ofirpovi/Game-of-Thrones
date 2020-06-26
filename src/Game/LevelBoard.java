package Game;
import Tiles.Structs.Position;
import Tiles.Tile;
import Tiles.Units.Player;

import java.util.List;

public class LevelBoard {
    private Tile [][] levelBoard;
    private Position startPositionPlayer;

    public LevelBoard(Tile [][] levelBoard, Position startPositionPlayer){
        this.levelBoard = levelBoard;
        this.startPositionPlayer=startPositionPlayer;
    }

    private void createBoard(Player player){
        /// כאן מייצרים את הלוח ומעדכנים את המיקום ההתחלתי של השחקן
    }

    public Tile [][] getLevelBoard(){
        return this.levelBoard;
    }

    public void changePosition (Tile tile, Position newPosition){
        tile.setPosition(newPosition);
    }

    public Position getStartPositionPlayer() {
        return startPositionPlayer;
    }

    public void setStartPositionPlayer(Position startPositionPlayer) {
        this.startPositionPlayer = startPositionPlayer;
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< levelBoard.length; i++) {
            for (int j = 0; j < levelBoard[i].length; j++) {
                sb.append(levelBoard[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
