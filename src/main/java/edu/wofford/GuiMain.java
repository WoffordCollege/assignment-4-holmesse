package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiMain extends JFrame implements ActionListener {
    private TicTacToeModel model;
    private JLabel result;
    private JButton location00;
    private JButton location01;
    private JButton location02;
    private JButton location10;
    private JButton location11;
    private JButton location12;
    private JButton location20;
    private JButton location21;
    private JButton location22;

    public void actionPerformed(ActionEvent event) {
      Object source = event.getSource();
      JButton btn = (JButton)source;
      String locName = btn.getName();
      int row = Integer.parseInt(locName.substring(locName.length() - 2, locName.length() - 1));
      int column = Integer.parseInt(locName.substring(locName.length() - 1));

      model.setMarkAt(row, column);
      btn.setText(this.model.markToString(this.model.getMarkAt(row, column)));

      if(model.getResult() == TicTacToeModel.Result.XWIN){
        result.setText("X wins");
      }
      else if(model.getResult() == TicTacToeModel.Result.OWIN){
        result.setText("O wins");
      }
      else if(model.getResult() == TicTacToeModel.Result.TIE){
        result.setText("Tie");
      }
    }


    public GuiMain() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        model = new TicTacToeModel();
        GridLayout experimentLayout = new GridLayout(0,3);
        setLayout(experimentLayout);

        location00 = new JButton();
        location00.setName("location00");
        add(location00);
        location00.addActionListener(this);
        location01 = new JButton();
        location01.setName("location01");
        add(location01);
        location01.addActionListener(this);
        location02 = new JButton();
        location02.setName("location02");
        add(location02);
        location02.addActionListener(this);

        location10 = new JButton();
        location10.setName("location10");
        add(location10);
        location10.addActionListener(this);
        location11 = new JButton();
        location11.setName("location11");
        add(location11);
        location11.addActionListener(this);
        location12 = new JButton();
        location12.setName("location12");
        add(location12);
        location12.addActionListener(this);

        location20 = new JButton();
        location20.setName("location20");
        add(location20);
        location20.addActionListener(this);
        location21 = new JButton();
        location21.setName("location21");
        add(location21);
        location21.addActionListener(this);
        location22 = new JButton();
        location22.setName("location22");
        add(location22);
        location22.addActionListener(this);

        result = new JLabel();
        result.setName("result");
        add(result);
    }


	public static void main(String[] args) {
      GuiMain window = new GuiMain();
      window.setVisible(true);


	}
}
