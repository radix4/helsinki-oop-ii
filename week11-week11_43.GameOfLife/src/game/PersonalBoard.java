package game;

import gameoflife.GameOfLifeBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    private List<Integer> viewDirection;

    public PersonalBoard(int width, int height) {
        super(width, height);
        viewDirection = new ArrayList<Integer>();
        viewDirection.add(-1);
        viewDirection.add(0);
        viewDirection.add(1);
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (!isInsideTheBoard(x, y)) {
            return false;
        }

        boolean[][] board = getBoard();
        return board[x][y];
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (!isInsideTheBoard(x, y)) {
            return;
        }

        boolean[][] board = getBoard();
        board[x][y] = true;
    }

    @Override
    public void turnToDead(int x, int y) {
        if (!isInsideTheBoard(x, y)) {
            return;
        }

        boolean[][] board = getBoard();
        board[x][y] = false;
    }

    @Override
    public void initiateRandomCells(double probability) {
        Random rnd = new Random();

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (rnd.nextDouble() < probability) {
                    turnToLiving(x, y);
                } else {
                    turnToDead(x, y);
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int livingNeighbours = 0;

        for (int xNeighbour : viewDirection) {
            for (int yNeigbour : viewDirection) {
                if (xNeighbour == 0 && yNeigbour == 0) {
                    continue;
                }

                if (!isAlive(x + xNeighbour, y + yNeigbour)) {
                    continue;
                }

                livingNeighbours++;
            }
        }

        return livingNeighbours;
    }

    @Override
    public void manageCell(int x, int y, int neighbours) {
        if (!isAlive(x, y)) {
            if (neighbours == 3) {
                turnToLiving(x, y);
            }

            return;
        }

        if (neighbours < 2 || neighbours > 3) {
            turnToDead(x, y);
        }
    }

    public boolean isInsideTheBoard(int x, int y) {
        if (x >= getWidth() || x < 0) {
            return false;
        }

        if (y >= getHeight() || y < 0) {
            return false;
        }

        return true;
    }
}