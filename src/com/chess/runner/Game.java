package com.chess.runner;

import com.chess.board.Board;
import com.chess.commun.File;
import com.chess.commun.Location;
import com.chess.piece.Movable;
import com.chess.square.Square;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();

        Scanner scanner = new Scanner(System.in);
        // true -> game is not finished.
        while(true) {
            // E2 -> E4

            String line = scanner.nextLine();
            String[] fromTo = line.split("->");
            File fromFile = File.valueOf(String.valueOf(Character.toUpperCase(fromTo[0].charAt(0))));
            int fromRank = Integer.parseInt(String.valueOf(fromTo[0].charAt(1)));
            File toFile = File.valueOf(String.valueOf(Character.toUpperCase(fromTo[1].charAt(0))));
            int toRank = Integer.parseInt(String.valueOf(fromTo[1].charAt(1)));

            Square fromSq = board.getLocationSquareMap().get(new Location(fromFile, fromRank));
            Square toSq = board.getLocationSquareMap().get(new Location(toFile, toRank));

            fromSq.getCurrentPiece().makeMove(toSq);
            fromSq.reset();

            board.printBoard();

        }

    }

    public static void printPiece(Movable piece) {
        piece.getValidMoves(null);
    }
}
