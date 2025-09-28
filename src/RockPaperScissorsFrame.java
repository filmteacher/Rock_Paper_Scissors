import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Rock Paper Scissors game with a GUI
 *
 * @author Matt Bennett
 */

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl;
    JPanel topPnl;  // Top
    JPanel statsPnl;
    JPanel middlePnl; // Center
    JPanel bottomPnl; // Bottom

    JTextField winsFld;
    JTextField lossesFld;
    JTextField tiesFld;
    JTextField gamesFld;

    JTextArea middleTA;

    JScrollPane scroller;

    JLabel titleLbl;
    JLabel winsLbl;
    JLabel lossesLbl;
    JLabel tiesLbl;
    JLabel gamesLbl;

    // --- Images: rock.png, paper.png, scissors.png, quit.png ---
    // Source: AI generated via Google Gemini
    // Date Generated: 28 September 2025
    // Description: Colorful 8-bit retro icons for a rock-paper-scissors game.
    // License: Royalty-free for commercial and personal use.
    // ---------------------------------
    ImageIcon rockIcon = new ImageIcon("src/rock.png");
    ImageIcon paperIcon = new ImageIcon("src/paper.png");
    ImageIcon scissorsIcon = new ImageIcon("src/scissors.png");
    ImageIcon quitIcon = new ImageIcon("src/quit.png");

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    int wins = 0;
    int losses = 0;
    int ties = 0;
    int games = 0;

    public RockPaperScissorsFrame()
    {
        // Use a reasonable visually pleasing arrangement of your components using BorderLayout.
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//A title for your game’s frame “Rock Paper Scissors Game” or some such.
//
//A stats panel with 3 JLabels and JTextFields (Player Wins, Computer Wins, Ties)
// each should have the count of the wins etc.
// JTextFields should be read only (not editable).
//
    private void createTopPanel()
    {
        topPnl = new JPanel();
        topPnl.setBackground(Color.BLACK);
        topPnl.setOpaque(true);
        topPnl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        titleLbl = new JLabel("Rock Paper Scissors Game", JLabel.CENTER);
        titleLbl.setFont(new Font("Verdana", Font.BOLD, 30));
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setVerticalTextPosition(JLabel.TOP);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.add(titleLbl);

        //nest statsPnl in topPnl

        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(2, 4));
        statsPnl.setBackground(Color.BLACK);
        statsPnl.setOpaque(true);
        statsPnl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        winsLbl = new JLabel("Player Wins: ", JLabel.CENTER);
        winsLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        winsLbl.setForeground(Color.LIGHT_GRAY);
        winsLbl.setHorizontalAlignment(JLabel.CENTER);
        statsPnl.add(winsLbl);

        lossesLbl = new JLabel("Computer Wins: ", JLabel.CENTER);
        lossesLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lossesLbl.setForeground(Color.LIGHT_GRAY);
        lossesLbl.setHorizontalAlignment(JLabel.CENTER);
        statsPnl.add(lossesLbl);

        tiesLbl = new JLabel("Ties: ", JLabel.CENTER);
        tiesLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tiesLbl.setForeground(Color.LIGHT_GRAY);
        tiesLbl.setHorizontalAlignment(JLabel.CENTER);
        statsPnl.add(tiesLbl);

        gamesLbl = new JLabel("Games Played: ", JLabel.CENTER);
        gamesLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        gamesLbl.setForeground(Color.LIGHT_GRAY);
        gamesLbl.setHorizontalAlignment(JLabel.CENTER);
        statsPnl.add(gamesLbl);

        winsFld = new JTextField();
        winsFld.setText(wins + "");
        winsFld.setEditable(false);
        winsFld.setFont(new Font("Tahoma", Font.PLAIN, 16));
        winsFld.setHorizontalAlignment(JTextField.CENTER);
        statsPnl.add(winsFld);

        lossesFld = new JTextField();
        lossesFld.setText(losses + "");
        lossesFld.setEditable(false);
        lossesFld.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lossesFld.setHorizontalAlignment(JTextField.CENTER);
        statsPnl.add(lossesFld);

        tiesFld = new JTextField();
        tiesFld.setText(ties + "");
        tiesFld.setEditable(false);
        tiesFld.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tiesFld.setHorizontalAlignment(JTextField.CENTER);
        statsPnl.add(tiesFld);

        gamesFld = new JTextField();
        gamesFld.setText(games + "");
        gamesFld.setEditable(false);
        gamesFld.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gamesFld.setHorizontalAlignment(JTextField.CENTER);
        statsPnl.add(gamesFld);

        topPnl.add(statsPnl);
    }
// A panel with a JTextArea with JScrollPane that displays the results of each game one per line as a text string:
//    Rock breaks scissors (Player wins)
//    or
//    Paper covers Rock (Computer Wins)
// This should accumulate (append) and display the results for each game in the session,
// one per line, not just show the results for the last game played.
// (In other words, you can scroll through all of the game results for the session.)

    private void createMiddlePanel()
    {
        middlePnl = new JPanel();
        middlePnl.setBackground(Color.BLACK);
        middlePnl.setOpaque(true);

        middleTA = new JTextArea(12, 32);
        middleTA.setFont(new Font("Tahoma", Font.PLAIN, 16));
        middleTA.setEditable(false);
        middleTA.setMargin(new Insets(10, 10, 10, 10));
        middleTA.setText("Results:\n");

        scroller = new JScrollPane(middleTA);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        middlePnl.add(scroller);
    }
// A JPanel with three JButton components for Rock, Paper, Scissors, and an additional for Quitting the game.
// (Each should have an appropriate ImageIcon. Add your images to the IntelliJ project in the src directory.)
// Put a border around this panel.
    private void createBottomPanel()
    {
        bottomPnl = new JPanel();
        bottomPnl.setBackground(Color.BLACK);
        bottomPnl.setOpaque(true);
        bottomPnl.setLayout(new GridLayout(1, 4));
        bottomPnl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        rockBtn = new JButton("Rock!", rockIcon);
        rockBtn.setPreferredSize(new Dimension(80, 110));
        rockBtn.setFont(new Font("Verdana", Font.BOLD, 16));
        rockBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        rockBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        rockBtn.setIconTextGap(1);
        rockBtn.addActionListener((ActionEvent ae) ->
        {

        });

        paperBtn = new JButton("Paper!", paperIcon);
        paperBtn.setPreferredSize(new Dimension(80, 110));
        paperBtn.setFont(new Font("Verdana", Font.BOLD, 16));
        paperBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        paperBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        paperBtn.setIconTextGap(1);
        paperBtn.addActionListener((ActionEvent ae) ->
        {

        });

        scissorsBtn = new JButton("Scissors!", scissorsIcon);
        scissorsBtn.setPreferredSize(new Dimension(80, 110));
        scissorsBtn.setFont(new Font("Verdana", Font.BOLD, 16));
        scissorsBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        scissorsBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        scissorsBtn.setIconTextGap(1);
        scissorsBtn.addActionListener((ActionEvent ae) ->
        {

        });

        quitBtn = new JButton("Quit!", quitIcon);
        quitBtn.setPreferredSize(new Dimension(80, 110));
        quitBtn.setFont(new Font("Verdana", Font.BOLD, 16));
        quitBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        quitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        quitBtn.setIconTextGap(1);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(rockBtn);
        bottomPnl.add(paperBtn);
        bottomPnl.add(scissorsBtn);
        bottomPnl.add(quitBtn);
    }

// 1. The player will click on one of the buttons to play the game.
// The computer will determine which Strategy to use to determine the symbol it will use
// and then determine the results.
// The JTextArea will be updated with the results display string.
// One line for each game.
// The stats panel keeping track of the computer and player wins
// and the ties should also be updated
// and should show a running total for all the games played during the session.
// You should append information to the display string to indicate which strategy was used
// for the computer move. (See below.)
//
//        2.	You will develop several different algorithmic schemes/strategies for choosing the computers move and then set the computer to use your schemes based on probability.
//        (Please note: the strategies nearly all require you to record information about the computer and users moves during the session.  You should carefully analyze each one to determine what additional data is required for the strategy.)
//
//    A bit of analysis here shows that this is essentially just a different method to determine the move for the computer.  One rather clever way to do this would be to use an interface.
//
//        (Consider an Interface called Strategy with an abstract method public String getMove(String playerMove)  which returns the computer’s move:  “R” “P” or “S”
//
//    This is actually an implementation of the Strategy Design Pattern!
//
//    Strategies:
//
//    a.	Least Used: Keep track of the number of times that player uses each of the 3 symbols.  Develop an algorithm scheme for the computer to pick the symbol that will win against the symbol used the least by the player.  (The assumption here is that the player will be most likely to use that symbol that they have not used recently.)  You have to implement this as an Inner class since it has to have access to the player symbol counts.
//
//    b.	Most Used: As in the previous approach keep track of the player choices but this time assume that the player will tend to pick the symbol that they use the most so the computer will pick the symbol that will beat it. You have to implement this as an Inner class since it has to have access to the player symbol counts.
//
//    c.	Last Used: Use the symbol that the player used on the last round. (Be careful not to call this on the first round of play.)  This approach is actually the solution to a famous problem in computer science known as the prisoner’s dilemma. You have to implement this as an Inner class since it has to have access to the player symbol counts.
//
//    d.	Random: Randomize the computer’s choice as in the normal game.
//        Make this an external class.
//
//    e.	Cheat: no more than 10% of the time, have the computer cheat and pick the winning symbol based on the choice the player already made.  Make this an external class.
//
//    Add the strategy used each time to the display in the JTextArea e.g. :
//        “Rock breaks scissors. (Player wins! Computer: Least Used)”
//
//        3.	Create the Strategy Interface.  Create an instance of each Strategy. Be sure to follow the notes about which are external and which must be inner classes. Create a single ActionListener for the R P and S buttons.  This should use the ActionEvent ae parameter to determine which of the 3 buttons were clicked. This represents the player move.
//
//4.	After you get the player move, determine if the computer will cheat which is 10% of the time. Least Used, Most Used, and Last Used should each get 20% probability, with Random getting the other 30%.  See table below for this:
//
//    Here generate a single random value to represent a probability value between 1 – 100 inclusive and use the Strategy indicated below.
//
// 1 -  10 Cheat
//11 -  30 Least Used
//31 -  50 Most Used
//51 -  70 Last Used
//71 -  100 Random
//
//    Then pass the players move to the corresponding Strategy implementation to get the computers move.
//
//    Here is an example:
//
//    public interface Strategy  // External File  Strategy.java
//    {
//        public String getMove(String playerMove);
//    }
//
//    Here is the Cheat Strategy:
//
//    class Cheat implements Strategy // External File  Cheat.java  Note: implemented as an inner class in the demo code but should be External Use he demo as the model for the 3 inner classes
//    {
//        @override
//        public String getMove(String playerMove)
//        {
//            String computerMove = "";
//            switch (playerMove)
//            {
//                case "R":
//                    computerMove = "P";
//                    break;
//                case "P":
//                    computerMove = "S";
//                    break;
//                case "S":
//                    computerMove = "R";
//                    break;
//                default:
//                    computerMove = "X";
//                    break;
//            }
//            return computerMove;
//        }
//
//    }
//
//
//
//5.	Note sample program files are attached for the Interface and a test program that use this Cheat Strategy.  Please note that Cheat and Random can be easily done as external classes.
//
//        However, the LeastUsed, MostUsed and LastUsed Strategies all require internal data that Cheat and Random don’t need.  It seems like the only way to do this is to implement these 3 as inner Classes.  Although, you don’t have to make Cheat an inner class, I did in the example driver program, so you can use this as a model for the 3 that require it.  Do Use an external class for Cheat and Random.





}
