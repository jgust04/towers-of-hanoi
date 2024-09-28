// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Gustafson (jack23)

package towerofhanoi;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class to test Disk constructor and methods.
 * 
 * @author Range
 * @version Oct 18, 2023
 */
public class HanoiSolverTest
    extends TestCase
{
    // ~ Fields ................................................................

    private HanoiSolver game;
    private Tower left;
    private Tower middle;
    private Tower right;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    // ~ Constructors ..........................................................
    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp()
    {
        game = new HanoiSolver(3);
        left = game.getTower(Position.LEFT);
        middle = game.getTower(Position.MIDDLE);
        right = game.getTower(Position.RIGHT);
        disk1 = new Disk(15);
        disk2 = new Disk(10);
        disk3 = new Disk(5);

    }


    // ~ Methods ..............................................................
    /**
     * Test method for disks method.
     */
    public void testDisks()
    {
        assertEquals(3, game.disks());
    }


    /**
     * Test method for getTower method.
     */
    public void testGetTower()
    {
        assertTrue(game.getTower(Position.LEFT).equals(left));
        assertTrue(game.getTower(Position.MIDDLE).equals(middle));
        assertTrue(game.getTower(Position.RIGHT).equals(right));
        assertTrue(game.getTower(Position.DEFAULT).equals(middle));
    }


    /**
     * Test method for toString method.
     */
    public void testToString()
    {
        assertTrue(game.toString().equals("[][][]"));
    }


    /**
     * Test method for solve method.
     */
    public void testSolve()
    {
        game.getTower(Position.LEFT).push(disk1);
        game.getTower(Position.LEFT).push(disk2);
        game.getTower(Position.LEFT).push(disk3);
        game.solve();

        assertEquals(0, game.getTower(Position.LEFT).size());
        assertEquals(3, game.getTower(Position.RIGHT).size());
    }

}
