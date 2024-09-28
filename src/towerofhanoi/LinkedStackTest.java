// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Gustafson (jack23)

package towerofhanoi;

import student.TestCase;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * Test class to test LinkedStack constructor and methods.
 * 
 * @author Jack Gustafson
 * @version Oct 18, 2023
 */
public class LinkedStackTest
    extends TestCase
{
    // ~ Fields ................................................................

    private LinkedStack<Disk> stack1;
    private Disk disk1;
    private Disk disk2;

    // ~ Constructors ..........................................................
    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp()
    {
        stack1 = new LinkedStack<Disk>();
        disk1 = new Disk(15);
        disk2 = new Disk(10);
        stack1.push(disk1);
    }


    // ~ Methods ..............................................................
    /**
     * Test method for toString method.
     */
    public void testToString()
    {
        stack1.push(disk2);
        assertTrue(stack1.toString().equals("[10, 15]"));
    }


    /**
     * Test method for clear method.
     */
    public void testClear()
    {
        stack1.clear();
        assertEquals(0, stack1.size());
    }


    /**
     * Test method for size method.
     */
    public void testSize()
    {
        assertEquals(1, stack1.size());
    }


    /**
     * Test method for isEmpty method.
     */
    public void testIsEmpty()
    {
        assertFalse(stack1.isEmpty());
        stack1.pop();
        assertTrue(stack1.isEmpty());
    }


    /**
     * Test method for peek method.
     */
    public void testPeek()
    {
        assertTrue(stack1.peek().equals(disk1));
        stack1.pop();

        Exception thrown = null;
        try
        {
            stack1.peek();
        }

        catch (EmptyStackException e)
        {
            thrown = e;
        }

        assertNotNull(thrown);
    }


    /**
     * Test method for pop method.
     */
    public void testPop()
    {
        assertTrue(stack1.pop().equals(disk1));
        assertEquals(0, stack1.size());

        Exception thrown = null;
        try
        {
            stack1.pop();
        }

        catch (EmptyStackException e)
        {
            thrown = e;
        }

        assertNotNull(thrown);
    }


    /**
     * Test method for push method.
     */
    public void testPush()
    {
        stack1.push(disk2);
        assertEquals(2, stack1.size());
    }
}
