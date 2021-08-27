package solution;
import util.DoubleNode;
/**
 * A DoubleLinkedSeq is a sequence of double numbers. The sequence can have a
 * special &quot;current element&quot;, which is specified and accessed through
 * four methods that are not available in the IntArrayBag class (start,
 * getCurrent, advance, and isCurrent).
 * 
 * Limitations:
 * 
 * Beyond Integer.MAX_VALUE element, the size method does not work.
 * 
 * @author Sydney Magee
 * @version 10.17.2019
 */
public class DoubleLinkedSeq implements Cloneable
{
    private int manyNodes;
    private DoubleNode head;
    private DoubleNode tail;
    private DoubleNode cursor;
    private DoubleNode precursor;

    /**
     * Initializes an empty DoubleLinkedSeq.
     * 
     * @postcondition This sequence is empty.
     */
    public DoubleLinkedSeq()
    {
        manyNodes = 0;
        head = null;
        tail = null;
        cursor = null;
        precursor = null;
    }

    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element before the current element. If there was
     *                no current element, then this method places the new
     *                element at the front of this sequence. The newly added
     *                element becomes the new current element of this sequence.
     */
    public void addBefore(double element)
    {
        if (tail == null)
        {
            head = tail = cursor = new DoubleNode(element);
        }
        else if (precursor == null)
        {
            head = new DoubleNode(element, head);
            cursor = head;
        }
        else
        {
            precursor.addNodeAfter(element);
            cursor = precursor.getLink();
        }
        manyNodes++;
    }

    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element after the current element. If there was no
     *                current element, then this method places the new element
     *                at the end of this sequence. The newly added element
     *                becomes the new current element of this sequence.
     */
    public void addAfter(double element)
    {
        if (head == null)
        {
            head = tail = cursor = new DoubleNode(element);
        }
        else if (cursor == null || cursor == tail)
        {
            tail.addNodeAfter(element);
            precursor = tail;
            cursor = precursor.getLink();
            tail = cursor;
        }
        else
        {
            cursor.addNodeAfter(element);
            precursor = cursor;
            cursor = precursor.getLink();
        }
        manyNodes++;
    }

    /**
     * Places the contents of another sequence at the end of this sequence.
     * 
     * @precondition other must not be null.
     * 
     * @param other
     *            a sequence show contents will be placed at the end of this
     *            sequence.
     * 
     * @postcondition the elements from other have been placed at the end of
     *                this sequence. The current element of this sequence
     *                remains where it was, and other is unchanged.
     * 
     * @throws NullPointerException
     *             if other is null.
     */
    public void addAll(DoubleLinkedSeq other) throws NullPointerException
    {
        if (other == null)
        {
            throw new NullPointerException();
        }
        if (manyNodes == 0)
        {
            DoubleLinkedSeq newSeq = other.clone();
            this.head = newSeq.head;
            this.tail = newSeq.tail;
            cursor = precursor = null;
        }
        else
        {
            DoubleLinkedSeq newSeq2 = other.clone();
            tail.setLink(newSeq2.head);
            tail = newSeq2.tail;
        }
        manyNodes += other.size();
    }

    /**
     * Move forward so that the current element is now the next element in the
     * sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition If the current element was already the end element of this
     *                sequence (with nothing after it), then there is no longer
     *                any current element. Otherwise, the new element is the
     *                element immediately after the original current element.
     * 
     * @throws IllegalStateException
     *             if there is not current element.
     */
    public void advance() throws IllegalStateException
    {
        if (isCurrent())
        {
            if (cursor == tail)
            {
                cursor = null;
                precursor = null;
            }
            else
            {
                precursor = cursor;
                cursor = cursor.getLink();
            }
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    /**
     * Creates a copy of this sequence.
     * 
     * @return a copy of this sequence. Subsequent changes to the copy will not
     *         affect the original, nor vice versa.
     * @throws RuntimeException
     *             if this class does not implement Cloneable.
     * 
     */
    public DoubleLinkedSeq clone() throws RuntimeException
    {
        DoubleLinkedSeq answer = new DoubleLinkedSeq();
        if (cursor == null)
        {
            DoubleNode[] copy = DoubleNode.listCopyWithTail(head);
            answer.head = copy[0];
            answer.tail = copy[1];
            answer.manyNodes = manyNodes;
        }
        else if (cursor == head)
        {
            DoubleNode[] copy = DoubleNode.listCopyWithTail(head);
            answer.head = copy[0];
            answer.tail = copy[1];
            answer.manyNodes = manyNodes;
        }
        else
        {
            DoubleNode[] copy1 = DoubleNode.listPart(head, precursor);
            DoubleNode[] copy2 = DoubleNode.listPart(cursor, tail);
            copy1[1].setLink(copy2[0]);
            answer.head = copy1[0];
            answer.precursor = copy1[1];
            answer.cursor = copy2[0];
            answer.tail = copy2[1];
            answer.manyNodes = manyNodes;
        }
        return answer;
    }

    /**
     * Creates a new sequence that contains all the elements from s1 followed by
     * all of the elements from s2.
     * 
     * @precondition neither s1 nor s2 are null.
     * 
     * @param s1
     *            the first of two sequences.
     * @param s2
     *            the second of two sequences.
     * 
     * @return a new sequence that has the elements of s1 followed by the
     *         elements of s2 (with no current element).
     * 
     * @throws NullPointerException
     *             if s1 or s2 are null.
     */
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1,
            DoubleLinkedSeq s2) throws NullPointerException
    {
        DoubleLinkedSeq result = new DoubleLinkedSeq();
        if (s1 == null || s2 == null)
        {
            throw new NullPointerException();
        }
        else
        { 
            result.addAll(s1);
            result.addAll(s2);
            result.precursor = null;
            result.cursor = null;
            result.manyNodes = DoubleNode.listLength(result.head);
        } 
        return result;
    }

    /**
     * Returns a copy of the current element in this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @return the current element of this sequence.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public double getCurrent() throws IllegalStateException
    {
        if (isCurrent())
        {
            return cursor.getData();
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    /**
     * Determines whether this sequence has specified a current element.
     * 
     * @return true if there is a current element, or false otherwise.
     */
    public boolean isCurrent()
    {
        if (cursor != null)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**
     * Removes the current element from this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition The current element has been removed from this sequence,
     *                and the following element (if there is one) is now the new
     *                current element. If there was no following element, then
     *                there is now no current element.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public void removeCurrent() throws IllegalStateException
    {
        if (cursor == null)
        {
            throw new IllegalStateException();
        }
        else
        {
            if (manyNodes == 1)
            {
                head = cursor = tail = precursor = null;
            }
            else if (cursor == head)
            {
                head = head.getLink();
                cursor = head;
            }   
            else if (cursor == tail)
            {
                precursor.removeNodeAfter();
                tail = precursor;
                cursor = precursor = null;
            }
            else
            {
                precursor.removeNodeAfter();
                tail = precursor;
                cursor = precursor = null;
            }
            manyNodes--;
        }
    }

    /**
     * Determines the number of elements in this sequence.
     * 
     * @return the number of elements in this sequence.
     */
    public int size()
    {
        return manyNodes;
    }

    /**
     * Sets the current element at the front of this sequence.
     * 
     * @postcondition If this sequence is not empty, the front element of this
     *                sequence is now the current element; otherwise, there is
     *                no current element.
     */
    public void start()
    {
        if (head == null)
        {
            cursor = null;
        }
        else
        {
            cursor = head;
        }
    }

    /**
     * Returns a String representation of this sequence. If the sequence is
     * empty, the method should return &quot;&lt;&gt;&quot;. If the sequence has
     * one item, say 1.1, and that item is not the current item, the method
     * should return &quot;&lt;1.1&gt;&quot;. If the sequence has more than one
     * item, they should be separated by commas, for example: &quot;&lt;1.1,
     * 2.2, 3.3&gt;&quot;. If there exists a current item, then that item should
     * be surrounded by square braces. For example, if the second item is the
     * current item, the method should return: &quot;&lt;1.1, [2.2],
     * 3.3&gt;&quot;.
     * 
     * @return a String representation of this sequence.
     */
    @Override
    public String toString()
    {
        String result = "<";
        for (DoubleNode c = head; c != null; c = c.getLink())
        {
            if (c ==  cursor && c == tail)
            {
                result += "[" + c.getData() + "]";
            }
            else if (c == cursor)
            {
                result += "[" + c.getData() + "], ";
            }
            else if (c == tail)
            {
                result += c.getData();
            }
            else
            {
                result += c.getData() + ", ";
            }
        }
        result += ">";
        return result;
    }

    /**
     * Determines if this object is equal to the other object.
     * 
     * @param other
     *            The other object (possibly a DoubleLinkedSequence).
     * @return true if this object is equal to the other object, false
     *         otherwise. Two sequences are equal if they have the same number
     *         of elements, and each corresponding element is equal
     */
    public boolean equals(Object other)
    {
        String obj1 = ((DoubleLinkedSeq) other).toString();
        String obj2 = this.toString();
        return obj2.equals(obj1);
    }
}
