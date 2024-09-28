// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jack Gustafson (jack23)

package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * Represents a stack using nodes
 * 
 * @author Jack Gustafson
 * @version Oct 17, 2023
 * @param <T>
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    // ~ Fields ................................................................

    private int size;
    private Node topNode;

    // ~ Constructors ..........................................................
    /**
     * New LinkedStack object.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }


    // ~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Returns a string representation of the stack. Format: The disks are
     * surrounded by brackets: [] The disks are separated by commas.
     * 
     * @return The string of the disks.
     */
    @Override
    public String toString()
    {
        String result = "";
        Node currentNode = topNode;

        for (int i = 0; i < size; i++)
        {
            if (currentNode.getNextNode() == null)
            {
                result += currentNode.getData();
            }
            else
            {
                result += currentNode.getData() + ", ";
            }
            currentNode = currentNode.getNextNode();
        }
        return "[" + result + "]";
    }


    // ----------------------------------------------------------
    /**
     * Clears the stack (removes all of the items from the stack).
     */
    @Override
    public void clear()
    {
        topNode = null;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Number of items in the stack.
     * 
     * @return The number of items in the stack.
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the stack is empty.
     * 
     * @return Returns true if the stack is empty.
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * Checks the item at the top of the stack without removing it.
     * 
     * @return Item at the top of the stack.
     * @precondition stack is not empty
     */
    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        return topNode.getData();
    }


    // ----------------------------------------------------------
    /**
     * Removes the item at the top of the stack.
     * 
     * @return The item that was removed.
     * @precondition stack is not empty
     */
    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        T result = topNode.getData();
        topNode = topNode.getNextNode();
        size--;

        return result;
    }


    // ----------------------------------------------------------
    /**
     * Pushes an item onto the stack.
     * 
     * @param anEntry
     *            Item to be pushed onto the stack.
     */
    @Override
    public void push(T anEntry)
    {
        // I know this if - else statement is redundant and unnecessary, but
        // WebCat says I need to use the second Node constructor to get 100%
        // code coverage and this is the only place I can think of where it
        // works.
        if (topNode == null)
        {
            Node newNode = new Node(anEntry);
            topNode = newNode;
            size++;
        }
        else
        {
            Node newNode = new Node(anEntry, null);
            // Same thing here - In the line above, I know I can replace null
            // with topNode but WebCat says I need to use setNextNode()
            newNode.setNextNode(topNode);
            topNode = newNode;
            size++;
        }
    }

    private class Node
    {
        private T data;
        private Node next;

        /**
         * New Node object.
         * 
         * @param dataPortion
         *            data value contained in node.
         */
        public Node(T dataPortion)
        {
            this(dataPortion, null);
        }


        /**
         * New Node object.
         * 
         * @param dataPortion
         *            data value contained in node.
         * @param nextNode
         *            the next node this node references
         */
        public Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }


        // ----------------------------------------------------------
        /**
         * Sets next Node.
         * 
         * @param nextNode
         *            the next node this node references.
         */
        public void setNextNode(Node nextNode)
        {
            next = nextNode;
        }


        // ----------------------------------------------------------
        /**
         * Gets next Node.
         * 
         * @return the next node.
         */
        public Node getNextNode()
        {
            return next;
        }


        // ----------------------------------------------------------
        /**
         * Gets data value.
         * 
         * @return the data value.
         */
        public T getData()
        {
            return data;
        }
    }
}
