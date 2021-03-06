package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {

			// first move
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsPiece(p2) && getMoveCount() ==0) {
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
			//special move En Passant, WHITE PIECES!
			if (position.getRow() == 3){
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereEnemyPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
					}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereEnemyPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
					}
				}				
		}
		
		else {

			// first move
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsPiece(p2) && getMoveCount() == 0) {
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
			
			//special move En Passant, BLACK PIECES!
			if (position.getRow() == 4){
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereEnemyPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
					}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereEnemyPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
					}
				}	
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
