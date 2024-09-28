// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Gustafson (jack23)

package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

// -------------------------------------------------------------------------
/**
 * Class that creates shapes in forms of disks along with its constructor and
 * methods.
 * 
 * @author Jack Gustafson
 * @version Oct 17, 2023
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{
    // ~ Constructors ..........................................................
    /**
     * New Disk object.
     * 
     * @param width
     *            width of disk
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom randomGenerator = new TestableRandom();
        int red = randomGenerator.nextInt(255);
        int green = randomGenerator.nextInt(255);
        int blue = randomGenerator.nextInt(255);
        Color color = new Color(red, green, blue);
        super.setBackgroundColor(color);
    }


    // ~ Methods ...............................................................
    // -------------------------------------------------------------------------
    /**
     * Compares two disks by width.
     * 
     * @param otherDisk
     *            other disk to be compared to
     * @return Returns 1 if this disk is greater than other disk, 0 if they are
     *             equal, and -1 if this disk is less than other disk.
     * @precondition parameter element is not null
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException();
        }

        if (this.getWidth() < otherDisk.getWidth())
        {
            return -1;
        }

        else if (this.getWidth() == otherDisk.getWidth())
        {
            return 0;
        }

        else
        {
            return 1;
        }
    }


    // -------------------------------------------------------------------------
    /**
     * Prints the width of the disks.
     * 
     * @return width of disk in a string
     */
    public String toString()
    {
        return "" + this.getWidth();
    }


    // -------------------------------------------------------------------------
    /**
     * Compares two disks by width.
     * 
     * @param obj
     *            other object being compared to
     * @return true if disks are equal, false if not
     */
    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Disk d1 = (Disk)obj;
        return this.getWidth() == d1.getWidth();
    }
}
