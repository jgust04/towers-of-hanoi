// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Gustafson (jack23)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Represents a tower in tower of hanoi
 * 
 * @author Jack Gustafson
 * @version Oct 17, 2023
 */
public class Tower
    extends LinkedStack<Disk>
{
    // ~ Fields ................................................................

    private Position position;

    // ~ Constructors ..........................................................

    /**
     * New Tower object.
     * 
     * @param position
     *            position of tower
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }


    // ~ Methods ...............................................................
    // -------------------------------------------------------------------------
    /**
     * Gets the position of the tower.
     * 
     * @return position of tower
     */
    public Position position()
    {
        return position;
    }


    // -------------------------------------------------------------------------
    /**
     * Pushes a disk onto another tower
     * 
     * @param newDisk
     *            the disk being pushed
     * @precondition parameter element is not null and disk being pushed onto
     *                   must be smaller than other disk
     */
    @Override
    public void push(Disk newDisk)
    {
        if (newDisk == null)
        {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || this.peek().compareTo(newDisk) == 1)
        {
            super.push(newDisk);
        }

        else
        {
            throw new IllegalStateException();
        }
    }

}
