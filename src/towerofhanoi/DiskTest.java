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
 * @author Jack Gustafson
 * @version Oct 18, 2023
 */
public class DiskTest
    extends TestCase
{
    // ~ Fields ................................................................

    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    private Object obj;

    // ~ Constructors ..........................................................
    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp()
    {
        disk1 = new Disk(15);
        disk2 = new Disk(10);
        disk3 = null;
        obj = new Object();
    }


    // ~ Methods ...............................................................
    /**
     * Test method for compareTo method.
     */
    public void testCompareTo()
    {
        Exception thrown = null;
        try
        {
            disk1.compareTo(disk3);
        }

        catch (IllegalArgumentException e)
        {
            thrown = e;
        }

        assertNotNull(thrown);

        assertEquals(1, disk1.compareTo(disk2));
        assertEquals(0, disk1.compareTo(disk1));
        assertEquals(-1, disk2.compareTo(disk1));
    }


    /**
     * Test method for toString method.
     */
    public void testToString()
    {
        assertTrue(disk1.toString().equals("15"));
    }


    /**
     * Test method for equals method.
     */
    public void testEquals()
    {
        assertTrue(disk1.equals(disk1));
        assertFalse(disk1.equals(disk2));
        assertFalse(disk1.equals(disk3));
        assertFalse(disk1.equals(obj));
    }
}
