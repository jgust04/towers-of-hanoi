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
 * Test class to test Tower constructor and methods.
 * 
 * @author Jack Gustafson
 * @version Oct 18, 2023
 */
public class TowerTest
    extends TestCase
{
    // ~ Fields ................................................................

    private Tower tower1;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    // ~ Constructors ..........................................................
    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp()
    {
        tower1 = new Tower(Position.LEFT);
        disk1 = new Disk(15);
        disk2 = new Disk(10);
        disk3 = null;
    }


    // ~ Methods ..............................................................
    /**
     * Test method for position method.
     */
    public void testPosistion()
    {
        assertTrue(tower1.position().equals(Position.LEFT));
    }


    /**
     * Test method for push method.
     */
    public void testPush()
    {
        Exception thrown = null;
        Exception thrown2 = null;

        try
        {
            tower1.push(disk3);
        }

        catch (IllegalArgumentException e)
        {
            thrown = e;
        }

        assertNotNull(thrown);

        tower1.push(disk1);
        assertEquals(1, tower1.size());

        tower1.push(disk2);
        assertEquals(2, tower1.size());

        try
        {
            tower1.push(disk1);
        }

        catch (IllegalStateException e)
        {
            thrown2 = e;
        }

        assertNotNull(thrown2);
    }
}
