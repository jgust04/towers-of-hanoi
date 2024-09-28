// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Gustafson (jack23)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Range
 * @version Oct 18, 2023
 */
public class ProjectRunner
{
    // ~ Methods ...............................................................
    // -------------------------------------------------------------------------
    /**
     * Runs the application.
     * 
     * @param args
     *            java arguments.
     */
    public static void main(String[] args)
    {
        int disks = 6;
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
            HanoiSolver game = new HanoiSolver(disks);
            PuzzleWindow project = new PuzzleWindow(game);
        }

        HanoiSolver game = new HanoiSolver(disks);
        PuzzleWindow project = new PuzzleWindow(game);
    }
}
