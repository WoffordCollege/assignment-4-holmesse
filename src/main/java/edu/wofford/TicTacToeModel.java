package edu.wofford;


public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };
    protected Mark[][] board;
    protected boolean xTurn;

    public TicTacToeModel() {
      this.xTurn = true;
      this.board = new Mark[3][3];
      for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.board[i][j] = Mark.EMPTY;
            }
        }
    }

    public boolean setMarkAt(int row, int col) {
      boolean success = false;
      if(this.getResult() == Result.NONE){
        if(this.getMarkAt(row,col) != Mark.EMPTY){
          success = false;
        } else {
          if(this.xTurn){
            this.board[row][col] = Mark.XMARK;
            this.xTurn = false;
            success = true;
          } else {
            this.board[row][col] = Mark.OMARK;
            this.xTurn = true;
            success = true;
          }
        }
      }
      return success;
    }

    public Mark getMarkAt(int row, int col) {
        return this.board[row][col];
    }

    public Result getResult() {
      Result result = Result.NONE;
      //Row victories
      if(this.getMarkAt(0,0) == Mark.OMARK && this.getMarkAt(0,1) == Mark.OMARK&& this.getMarkAt(0,2) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(0,0) == Mark.XMARK && this.getMarkAt(0,1) == Mark.XMARK&& this.getMarkAt(0,2) == Mark.XMARK){
        result = Result.XWIN;
      }
      else if(this.getMarkAt(1,0) == Mark.OMARK && this.getMarkAt(1,1) == Mark.OMARK&& this.getMarkAt(1,2) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(1,0) == Mark.XMARK && this.getMarkAt(1,1) == Mark.XMARK&& this.getMarkAt(1,2) == Mark.XMARK){
        result = Result.XWIN;
      }
      else if(this.getMarkAt(2,0) == Mark.OMARK && this.getMarkAt(2,1) == Mark.OMARK&& this.getMarkAt(2,2) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(2,0) == Mark.XMARK && this.getMarkAt(2,1) == Mark.XMARK&& this.getMarkAt(2,2) == Mark.XMARK){
        result = Result.XWIN;
      }

      //Column victories
      else if(this.getMarkAt(0,0) == Mark.OMARK && this.getMarkAt(1,0) == Mark.OMARK&& this.getMarkAt(2,0) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(0,0) == Mark.XMARK && this.getMarkAt(1,0) == Mark.XMARK&& this.getMarkAt(2,0) == Mark.XMARK){
        result = Result.XWIN;
      }
      else if(this.getMarkAt(0,1) == Mark.OMARK && this.getMarkAt(1,1) == Mark.OMARK&& this.getMarkAt(2,1) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(0,1) == Mark.XMARK && this.getMarkAt(1,1) == Mark.XMARK&& this.getMarkAt(2,1) == Mark.XMARK){
        result = Result.XWIN;
      }
      else if(this.getMarkAt(0,2) == Mark.OMARK && this.getMarkAt(1,2) == Mark.OMARK&& this.getMarkAt(2,2) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(0,2) == Mark.XMARK && this.getMarkAt(1,2) == Mark.XMARK&& this.getMarkAt(2,2) == Mark.XMARK){
        result = Result.XWIN;
      }

      //Diagonal victories
      else if(this.getMarkAt(0,0) == Mark.OMARK && this.getMarkAt(1,1) == Mark.OMARK&& this.getMarkAt(2,2) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(0,0) == Mark.XMARK && this.getMarkAt(1,1) == Mark.XMARK&& this.getMarkAt(2,2) == Mark.XMARK){
        result = Result.XWIN;
      }
      else if(this.getMarkAt(0,2) == Mark.OMARK && this.getMarkAt(1,1) == Mark.OMARK&& this.getMarkAt(2,0) == Mark.OMARK){
        result = Result.OWIN;
      }
      else if(this.getMarkAt(0,2) == Mark.XMARK && this.getMarkAt(1,1) == Mark.XMARK&& this.getMarkAt(2,0) == Mark.XMARK){
        result = Result.XWIN;
      }

      //Full board tie
      else {
        for(int i = 0; i < 3; i++){
          for(int j = 0; j < 3; j++){
            if(this.board[i][j] == Mark.EMPTY){
              return Result.NONE;
            }
          }
        }
        result = Result.TIE;
      }
      return result;
    }

    public Boolean contains(Mark mark){
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          if(this.board[i][j] == mark){
            return true;
          }
        }
      }
      return false;
    }

    public String markToString(Mark mark){
      String strMark = "";
      switch (mark) {
            case EMPTY:  strMark = " ";
                 break;
            case XMARK:  strMark = "X";
                 break;
            case OMARK:  strMark = "O";
                 break;
               }
      return strMark;
    }

    public String toString() {
        return this.markToString(this.getMarkAt(0,0)) + "|" + this.markToString(this.getMarkAt(0,1)) + "|" + this.markToString(this.getMarkAt(0,2)) + "\n" +
         "-----" + "\n" + this.markToString(this.getMarkAt(1,0)) + "|" + this.markToString(this.getMarkAt(1,1)) + "|" + this.markToString(this.getMarkAt(1,2)) + "\n" +
         "-----" + "\n" + this.markToString(this.getMarkAt(2,0)) + "|" + this.markToString(this.getMarkAt(2,1)) + "|" + this.markToString(this.getMarkAt(2,2));
    }

}
