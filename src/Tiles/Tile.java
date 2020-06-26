package Tiles;

import Tiles.Structs.Position;
import Tiles.VisitorP.Visited;

public abstract class Tile implements Visited {
    protected char tile;
    protected Position position;

    public Tile(char tile, Position position){
        this.tile = tile;
        this.position=  position;
    }

    public Position getPosition() {
        return position;
    }

    public char getTileChar() {
        return tile;
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }





}