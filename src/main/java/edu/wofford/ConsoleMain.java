package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		TicTacToeModel model = new TicTacToeModel();
		int row;
		int column;

		while(model.getResult() == TicTacToeModel.Result.NONE){
			System.out.println(model);
			row = keyboard.nextInt();
			column = keyboard.nextInt();
			model.setMarkAt(row, column);
		}
		if(model.getResult() == TicTacToeModel.Result.XWIN){
			System.out.println("X wins");
		}
		else if(model.getResult() == TicTacToeModel.Result.OWIN){
			System.out.println("O wins");
		}
		else if(model.getResult() == TicTacToeModel.Result.TIE){
			System.out.println("Tie");
		}


	}
}
