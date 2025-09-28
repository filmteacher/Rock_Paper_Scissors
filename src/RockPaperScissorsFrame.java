import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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

    JTextArea middleTA;

    JScrollPane scroller;

    JLabel titleLbl;
    JLabel winsLbl;
    JLabel lossesLbl;
    JLabel tiesLbl;

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
    statsPnl.setLayout(new GridLayout(2, 3));
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
}
