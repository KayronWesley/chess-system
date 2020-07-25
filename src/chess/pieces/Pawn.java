package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {

			// first move
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (!getBoard().thereIsPiece(p) && getBoard().positionExists(p) && !getBoard().thereIsPiece(p2) && getBoard().positionExists(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// normal move to white pawn
			p.setValues(position.getRow() - 1, position.getColumn());
			if (!getBoard().thereIsPiece(p) && getBoard().positionExists(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// capture enemy piece in NW
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereEnemyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// capture enemy piece in NE
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereEnemyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		else {

			// first move
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (!getBoard().thereIsPiece(p) && getBoard().positionExists(p) && !getBoard().thereIsPiece(p2) && getBoard().positionExists(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// normal move to white pawn
			p.setValues(position.getRow() + 1, position.getColumn());
			if (!getBoard().thereIsPiece(p) && getBoard().positionExists(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// capture enemy piece in SW
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereEnemyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			// capture enemy piece in SE
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereEnemyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
