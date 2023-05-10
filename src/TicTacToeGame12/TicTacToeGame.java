package TicTacToeGame12;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToeGame implements ActionListener {
    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] bton = new JButton[9];
    //int count = 0;
    int chance_flag=0;
    //Random random = new Random();
    static boolean pl1_chance;
    static String player1;
    static String player2;
    static int arr[]=new int[9];
    TicTacToeGame(String player1,String player2 ) throws InterruptedException
    {
    	this.player1=player1;
    	this.player2=player2;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Bold", Font.BOLD, 35));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);
        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 100);
        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(170, 150, 150));
        for (int i = 0; i < 9; i++) {
            bton[i] = new JButton();
            bt_panel.add(bton[i]);
            bton[i].setFont(new Font("", Font.ITALIC,80));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
        }
        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);
        
        startGame(player1,player2);
        //clickCount();
    }
     /* public void clickCount()
      {
    	  JButton button1 = new JButton("Button1");
          JButton button2 = new JButton("Button2"); 
          button1.addActionListener(this);
          
          //frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
          frame.add(button1);
          frame.add(button2);
          //frame.getRootPane().setDefaultButton(button1); // sets default button
          //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(150,150);
          //frame.setLocationRelativeTo(null);
          frame.setVisible(true);
      }*/
    public void startGame(String player1,String player2) throws InterruptedException {
        try {
            textfield.setText("Please wait....");
            textfield.setFont(new Font(" ", Font.BOLD, 35));
            Thread.sleep(3000);
            textfield.setText("Start");
            Thread.sleep(2000);
            textfield.setText("Toss");
            Thread.sleep(3000);
//           System.out.println(Randoms());
          
           for(int j=0;j<9;j++) {
        	   int chance=Randoms();
        	    
        	   if(pl1_chance)
          		 {
          			 pl1_chance=true;
          			 bton[chance].doClick();
          			 textfield.setText(player2);
          			 //System.out.println(chance);
                       Thread.sleep(3000);
                     
          		 }
          		 else
          		 {
          			 pl1_chance=false;
          			 bton[chance].doClick();
          			 textfield.setText(player1);
          			 //System.out.println(chance);
                       Thread.sleep(3000);
                        
          		 }
           }
            //int chance=random.nextInt();
          
//            int arr[]=new int[9];
//            for(int i=0;i<arr.length;i++)
//            {
//            	int chance=random.nextInt(9);
//            	 for(int j=0;j<arr.length;j++)
//            		{
//            		 if(pl1_chance)
//            		 {
//            			 
//            				 
//            			 pl1_chance=true;
//            			 bton[chance].doClick();
//            			 textfield.setText(player2);
//            			 System.out.println(chance);
//                         Thread.sleep(3000);
//            		 }
//            		 else
//            		 {
//            			 pl1_chance=false;
//            			 bton[chance].doClick();
//            			 textfield.setText(player1);
//            			 System.out.println(chance);
//                         Thread.sleep(3000);
//            		 }
//            		
//                     
//            	}
//            }
        }
        
    
        catch (InterruptedException e) {

            e.printStackTrace();
        }
        //textfield.setText(player1);    
    }
    public int Randoms()
    {
    	boolean b= true;
    	Random rand=new Random();
    	int i=0;
    	while(b) {
    		i=rand.nextInt(9);
    		if(arr[i] == 0) {
    			arr[i]=i+1;
    			b=false;
    		}
    	}
    	
   return i;
    }
    public void gameOver(String s){
        chance_flag=0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            try {
            	   int arr2[]=new int[9];
          	    	arr = arr2;
				new TicTacToeGame(player1,player2);
			} catch (InterruptedException e)
            {	 
				e.printStackTrace();
			}
        }
        else
        {
            frame.dispose();
        }
    }
    public void matchCheck(String player1,String player2) {
        if ((bton[0].getText() == "X") && (bton[1].getText() == "X") && (bton[2].getText() == "X")) {
            Player1(0, 1, 2);
            pl1_chance=false;
        }
        else if ((bton[0].getText() == "X") && (bton[4].getText() == "X") && (bton[8].getText() == "X")) {
            Player1(0, 4, 8);
            pl1_chance=false;
        }
        else if ((bton[0].getText() == "X") && (bton[3].getText() == "X") && (bton[6].getText() == "X")) {
            Player1(0, 3, 6);
            pl1_chance=false;
        }
        else if ((bton[1].getText() == "X") && (bton[4].getText() == "X") && (bton[7].getText() == "X")) {
            Player1(1, 4, 7);
            pl1_chance=false;
        }
        else if ((bton[2].getText() == "X") && (bton[4].getText() == "X") && (bton[6].getText() == "X")) {
            Player1(2, 4, 6);
            pl1_chance=false;
        }
        else if ((bton[2].getText() == "X") && (bton[5].getText() == "X") && (bton[8].getText() == "X")) {
            Player1(2, 5, 8);
            pl1_chance=false;
        }
       else if ((bton[3].getText() == "X") && (bton[4].getText() == "X") && (bton[5].getText() == "X")) {
            Player1(3, 4, 5);
            pl1_chance=false;
        }
       else if ((bton[6].getText() == "X") && (bton[7].getText() == "X") && (bton[8].getText() == "X")) {
            Player1(6, 7, 8);
            pl1_chance=false;
        }
        else if ((bton[0].getText() == "O") && (bton[1].getText() == "O") && (bton[2].getText() == "O")) {
            Player2(0, 1, 2);
            pl1_chance=false;
        }
        else if ((bton[0].getText() == "O") && (bton[3].getText() == "O") && (bton[6].getText() == "O")) {
            Player2(0, 3, 6);
            pl1_chance=false;
        }
        else if ((bton[0].getText() == "O") && (bton[4].getText() == "O") && (bton[8].getText() == "O")) {
            Player2(0, 4, 8);
            pl1_chance=false;
        }
        else if ((bton[1].getText() == "O") && (bton[4].getText() == "O") && (bton[7].getText() == "O")) {
            Player2(1, 4, 7);
            pl1_chance=false;
        }
        else if ((bton[2].getText() == "O") && (bton[4].getText() == "O") && (bton[6].getText() == "O")) {
            Player2(2, 4, 6);
            pl1_chance=false;
        }
        else if ((bton[2].getText() == "O") && (bton[5].getText() == "O") && (bton[8].getText() == "O")) {
            Player2(2, 5, 8);
            pl1_chance=false;
        }
        else if ((bton[3].getText() == "O") && (bton[4].getText() == "O") && (bton[5].getText() == "O")) {
            Player2(3, 4, 5);
            pl1_chance=false;
        } else if ((bton[6].getText() == "O") && (bton[7].getText() == "O") && (bton[8].getText() == "O")) {
            Player2(6, 7, 8);
            pl1_chance=false;
        }
        else if(chance_flag==9) {
            System.out.println("Match Tie");
            textfield.setText("Match Tie");
             gameOver("Match Tie");
        }
    }

    public void Player1(int x, int y, int z) {
        bton[x].setBackground(Color.RED);
        bton[y].setBackground(Color.RED);
        bton[z].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
            
        }
        
        textfield.setText(this.player2+ " win");
        System.out.println(this.player2+" win");
        gameOver(player2+" win");
    }

    public void Player2(int x, int y, int z) {
        bton[x].setBackground(Color.GREEN);
        bton[y].setBackground(Color.GREEN);
        bton[z].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        System.out.println(this.player1+" win");
        textfield.setText(this.player1+" Win");
        gameOver(player1+" win");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	//count++;
       // System.out.println("You have clicked the ACTIVE button " + count );
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bton[i]) {
                if (pl1_chance) {
                    if (bton[i].getText() == "") {
                        bton[i].setForeground(Color.red);
                        bton[i].setText("X");
                        pl1_chance = false;
                        textfield.setText(player1+" turn");
                        chance_flag++;
                        matchCheck(player1,player2);
                    }
                } else {
                    if (bton[i].getText() == "") {
                        bton[i].setForeground(Color.GREEN);
                        bton[i].setText("O");
                        pl1_chance = true;
                       textfield.setText(player2+" turn");
                        chance_flag++;
                        matchCheck(player1,player2);
                    }
                }
            }
        }
    }
}