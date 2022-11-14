package edu.psu.ist.model;

import java.util.NoSuchElementException;

/**
 * A <i>splittable list</i> is a variant of a normal list that that is
 * split into two lists: a left list and a right list.
 * <p>
 * The data structure uses the notion of a "handle" to specify insertion and
 * deletion sites for entries stored in each side of the list. The handle sits
 * between the left and right lists (see asg instructions for illustration).
 * <ul>
 *     <li>additions can be made to the list (start of right side) by calling
 *     {@link #addToRightAtFront(T)};</li>
 *     <li>removals can be made only by calling
 *     {@link #removeFromRightAtFront()} (right list cannot be empty)</li>
 * </ul>
 *
 * @param <T> the type of the entries stored each side of this splittable-list.
 */
public interface ISplittableList<T> {

    /**
     * Adds entry {@code e} to the beginning of the right side list.
     *
     * @param e the entry to add.
     */
    void addToRightAtFront(T e);

    /**
     * Removes and returns the first entry from the right list. The method
     * requires that the right side list must be a non-empty when called.
     *
     * @throws NoSuchElementException if one attempts to remove from an empty
     *                                right list.
     */
    T removeFromRightAtFront();

    /**
     * Moves all entries from the left list and prepends them
     * (sticks them to the front) of the entries in the right list. This
     * method may be called at any time.
     */
    void moveToVeryBeginning();

    /**
     * Moves the position of {@code this} splittable list's "handle" forward by
     * one (i.e.: it moves the position of the handle in this list one to the
     * right).
     *
     * @throws IllegalStateException if one tries to move forward into an empty
     *                               right list (would put the data structure
     *                               into an 'illegal state')
     */
    void moveForward();

    /**
     * Returns the length of the left list. This method may be called at any
     * time.
     *
     * @return returns the length of the left list.
     */
    int leftLength();

    /**
     * Returns the length of the right list. This method may be called at any
     * time.
     *
     * @return returns the length of the right list.
     */
    int rightLength();

    /**
     * Clears the contents out of both the left and right sides of this
     * splittable list.
     */
    void clear();
}
