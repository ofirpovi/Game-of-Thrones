package Game;


import Tiles.Empty;
import Tiles.Structs.Health;
import Tiles.Structs.Position;
import Tiles.Tile;
import Tiles.Units.Enemies.Monster;
import Tiles.Units.Enemies.Trap;
import Tiles.Units.Enemy;
import Tiles.Wall;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            String ar = args[0];
            List<String> levelFiles = Files.list(Paths.get(args[0])).sorted().map(Path::toString).collect(Collectors.toList());
            List<Level> levels = new ArrayList<>();

            for (String levelPath : levelFiles) {
                List<String> levelData = Files.readAllLines(Paths.get(levelPath));
                Level L = parcLevel(levelData);
                levels.add(L);
            }
            GamePlay game = new GamePlay(levels);
            game.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Level parcLevel(List<String> levelData) {
        int numRows = levelData.size();
        int numColumns = levelData.get(0).length();
        Tile[][] levelBoard = new Tile[numRows][numColumns];
        int i = 0;
        Position positionPlayer = null;
        List<Enemy> enemies = new LinkedList<>();
        for (String level : levelData) {
            for (int j = 0; j < level.length() - 1; j++) {
                char ch = level.charAt(j);
                Position coordinate = new Position(i, j);
                switch (ch) {
                    case '.':
                        levelBoard[i][j] = new Empty(coordinate);
                    case '#':
                        levelBoard[i][j] = new Wall(coordinate);
                    case '@':
                        positionPlayer = new Position(i, j);
                    case 's': {
                        Monster toAdd = new Monster('s', coordinate, "Lannister Solider", 8, 3, new Health(80, 80), 25, 3);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'k': {
                        Monster toAdd = new Monster('k', coordinate, "Lannister Knight", 14, 8, new Health(200, 200), 50, 4);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'q': {
                        Monster toAdd = new Monster('q', coordinate, "Queen's Guard", 20, 15, new Health(400, 400), 100, 5);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'z': {
                        Monster toAdd=  new Monster('z', coordinate, "Wright", 30, 3, new Health(600, 600), 100, 3);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'b': {
                        Monster toAdd = new Monster('b', coordinate, "Bear-Wright", 75, 30, new Health(1000, 1000), 250, 4);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'g': {
                        Monster toAdd = new Monster('g', coordinate, "Giant-Wright", 100, 40, new Health(1500, 1500), 500, 5);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'w': {
                        Monster toAdd = new Monster('w', coordinate, "White Walker", 150, 50, new Health(2000, 2000), 1000, 6);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'M': {
                        Monster toAdd = new Monster('M', coordinate, "The Mountain", 60, 25, new Health(1000, 1000), 500, 6);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'C': {
                        Monster toAdd =new Monster('C', coordinate, "Queen Cersei", 10, 10, new Health(100, 100), 1000, 1);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'K': {
                        Enemy toAdd = new Monster('K', coordinate, "Night's king", 300, 150, new Health(5000, 5000), 5000, 8);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'B': {
                        Trap toAdd= new Trap('B', coordinate, "Bonus Trap", 1, 1, new Health(1, 1), 250, 1, 5);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'Q': {
                        Trap toAdd = new Trap('Q', coordinate, "Queen's Trap", 50, 10, new Health(250, 250), 100, 3, 7);
                        levelBoard[i][j] = toAdd;
                        enemies.add(toAdd);
                    }
                    case 'D': {
                        Trap toAdd =  new Trap('D', coordinate, "Death Trap", 100, 20, new Health(500, 500), 250, 1, 10);
                        levelBoard[i][j] = toAdd;
                        enemies.add((toAdd));
                    }
                }
            }
        }
        LevelBoard board = new LevelBoard(levelBoard, positionPlayer);
        Level l = new Level(board, enemies);
        return l;
    }
}


