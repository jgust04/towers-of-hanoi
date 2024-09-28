// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Gustafson (jack23)

package towerofhanoi;

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * Represents the algorithm that solves the tower of hanoi
 * 
 * @author Range
 * @version Oct 17, 2023
 */
public class HanoiSolver
    extends Observable
{
    // ~ Fields ................................................................

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    // ~ Constructors ..........................................................
    /**
     * New HanoiSolver object.
     * 
     * @param numDisks
     *            the number of disks the game has
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    // ~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Gets the number of disks
     * 
     * @return number of disks
     */
    public int disks()
    {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * Gets the tower based on the position
     * 
     * @param position
     *            position of tower
     * @return tower based on position
     */
    public Tower getTower(Position position)
    {
        switch (position)
        {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of the string representations of each of
     * the towers.
     * 
     * @return A string of the string representations of each of the towers
     */
    public String toString()
    {
        return left.toString() + middle.toString() + right.toString();
    }


    // ----------------------------------------------------------
    /**
     * Moves a disk from one tower to another
     * 
     * @param source
     *            start tower
     * @param desination
     *            end tower
     */
    private void move(Tower source, Tower destination)
    {
        destination.push(source.pop());
        this.setChanged();
        this.notifyObservers(destination.position());
    }


    // ----------------------------------------------------------
    /**
     * Recursive method that moves all disks from start tower to end tower
     * 
     * @param currentDisks
     *            number of disks on that tower
     * @param startPole
     *            start tower
     * @param tempPole
     *            spare tower
     * @param endPole
     *            end tower
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }

        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    // ----------------------------------------------------------
    /**
     * Calls private helper method to execute the recursive solution
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }
}
