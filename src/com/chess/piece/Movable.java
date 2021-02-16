package com.chess.piece;

import com.chess.board.Board;
import com.chess.commun.Location;
import com.chess.square.Square;

import java.util.List;

public interface Movable {
    List<Location> getValidMoves(Board board);
    List<Location> getValidMoves(Board board, Square square);
    void makeMove(Square square);
}
