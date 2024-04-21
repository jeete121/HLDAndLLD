package tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import tictactoe.model.Board;
import tictactoe.model.Pair;
import tictactoe.model.PieceType;
import tictactoe.model.Player;
import tictactoe.model.PlayingPieceO;
import tictactoe.model.PlayingPieceX;

public class TicTacToeGame {
	private Deque<Player> players;
	private Board gameBoard;

	public TicTacToeGame() {
		initializeGame();
	}

	public void initializeGame() {
		players = new LinkedList<>();
		players.add(new Player("player1", new PlayingPieceX()));
		players.add(new Player("player2", new PlayingPieceO()));
		gameBoard = new Board(3);

	}

	public String startGame() {
		boolean noWinner = true;
		while (noWinner) {

			Player playerTurn = players.removeFirst();

			gameBoard.printBoard();
			List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
			if (freeSpaces.isEmpty()) {
				noWinner = false;
				continue;
			}
			System.out.println("Player " + playerTurn.getName() + " Enter row,col: ");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			String values[] = s.split(",");
			int row = Integer.parseInt(values[0]);
			int col = Integer.parseInt(values[1]);

			boolean pieceAddedSuccessfully = gameBoard.addPiece(row, col, playerTurn.getPlayingPiece());
			if (!pieceAddedSuccessfully) {
				System.out.println("Incorrect Possition");
				players.addFirst(playerTurn);
				continue;
			}
			players.addLast(playerTurn);

			boolean winner = isThereWinner(row, col, playerTurn.playingPiece.pieceType);
			if (winner) {
				return playerTurn.name;
			}

		}

		return "tie";
	}

	public boolean isThereWinner(int row, int col, PieceType pieceType) {

		boolean rowMatch = true;
		boolean colMatch = true;
		boolean diagonalMatch = true;
		boolean antiDiagonalMatch = true;

		for (int i = 0; i < gameBoard.size; i++) {
			if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
				rowMatch = false;
			}
		}

		for (int i = 0; i < gameBoard.size; i++) {
			if (gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType != pieceType) {
				colMatch = false;
			}
		}

		for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
			if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
				diagonalMatch = false;
			}
		}

		for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
			if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
				antiDiagonalMatch = false;
			}
		}
		return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
	}
}
