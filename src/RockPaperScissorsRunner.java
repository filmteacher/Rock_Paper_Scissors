import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class RockPaperScissorsRunner
{
    public static void main(String[] args) {
        JFrame rockPaperScissorsFrame = new RockPaperScissorsFrame();
        rockPaperScissorsFrame.setTitle("Rock Paper Scissors");
        rockPaperScissorsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Following the example that I have posted in Canvas,
        // get an instance of the Toolkit and set your main JFrame to be ¾ of the width of the display
        // and centered on the screen.
        // (The example is in the Canvas Course Documents folder that contains the Java GUI materials.)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) (screenSize.width * 0.30);
        int frameHeight = 605;
        rockPaperScissorsFrame.setSize(frameWidth, frameHeight);

        int x = (screenSize.width - frameWidth) / 2;
        int y = (screenSize.height - frameHeight) / 2;
        rockPaperScissorsFrame.setLocation(x, y);

        rockPaperScissorsFrame.setVisible(true);
    }
}
