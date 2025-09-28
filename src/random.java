//    d. Random:
//    Randomize the computer’s choice as in the normal game.
//    Make this an external class.
class Random implements Strategy
{
    public Random(String playerMove) {}

    public String getMove(String playerMove)
    {
        String computerMove = "";
        int randomNum = (int)(Math.random() * 3);
        if (randomNum == 0)
        {
            computerMove = "R";
        }
        else if (randomNum == 1)
        {
            computerMove = "P";
        }
        else
        {
            computerMove = "S";
        }
        return computerMove;
    }
}
