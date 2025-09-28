
// 5. Note sample program files are attached for the Interface
// and a test program that use this Cheat Strategy.
// Please note that Cheat and Random can be easily done as external classes.
// Do Use an external class for Cheat and Random.
//
//    e. Cheat:
//    no more than 10% of the time,
//    have the computer cheat and pick the winning symbol
//    based on the choice the player already made.
//    Make this an external class.
class Cheat implements Strategy
{
    public Cheat(String playerMove) {}

    public String getMove(String playerMove)
    {
        String computerMove = "";
        switch (playerMove)
        {
            case "R":
                computerMove = "P";
                break;
            case "P":
                computerMove = "S";
                break;
            case "S":
                computerMove = "R";
                break;
        }
        return computerMove;
    }
}
