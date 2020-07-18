package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

public class Worm {

    private List<Piece> pieces;
    private int x;
    private int y;
    private Direction direction;
    private boolean grow;

    public Worm(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(x, y));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLength() {
        return pieces.size();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        int newX = pieces.get(pieces.size() - 1).getX();
        int newY = pieces.get(pieces.size() - 1).getY();

        if (direction == Direction.RIGHT) {
            newX++;
        } else if (direction == Direction.LEFT) {
            newX--;
        } else if (direction == Direction.DOWN) {
            newY++;
        } else {
            newY--;
        }

        if (!grow && getLength() > 2) {
            pieces.remove(0);
        } else {
            grow = false;
        }

        pieces.add(new Piece(newX, newY));
    }

    public void grow() {
        grow = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : pieces) {
            if (same(p, piece)) {
                return true;
            }
        }

        return false;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < pieces.size(); i++) {
            for (int j = i + 1; j < pieces.size(); j++) {
                if (same(pieces.get(i), pieces.get(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean same(Piece p1, Piece p2) {
        return p1.getX() == p2.getX() && p1.getY() == p2.getY();
    }
}