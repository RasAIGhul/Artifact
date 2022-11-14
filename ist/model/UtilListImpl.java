package edu.psu.ist.model;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class UtilListImpl<E> implements ISplittableList<E> {
    // "propagating" this   ^ generic E up into the       ^ interface

        private List<E> left = new LinkedList<>();/* either new ArrayList<>() OR new LinkedList<>() .. decide carefully */;
        private List<E> right = new LinkedList<>(); /* either new ArrayList<>() OR new LinkedList<>() .. decide carefully */;

    @Override
    public void addToRightAtFront(E e) {
        right.add(0,e);
    }

    @Override
    public E removeFromRightAtFront() {
        if(rightLength() == 0)
        {
            throw new NoSuchElementException("Right list cannot be empty.");
        }

        E temp = right.get(0);
        right.remove(0);
        return temp;
    }

    @Override
    public void moveToVeryBeginning() {

        for (int i = leftLength() - 1; i >= 0; i--){
            E temp = left.get(i);
            addToRightAtFront(temp);
            left.remove(i);
        }
    }

    @Override
    public void moveForward() {
        if(rightLength() == 0)
        {
            throw new IllegalStateException("Right List cannot be empty");
        }
        left.add(right.get(0));
        removeFromRightAtFront();

    }

    @Override
    public int leftLength() {
        return left.size();
    }

    @Override
    public int rightLength() {
        return right.size();
    }

    @Override
    public void clear() {
        right.clear();
        left.clear();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("<");  // O(1)
        for (int i = 0; i < leftLength(); i++) { //O(n)
            if (i == leftLength() - 1) //O(1)
            {
                str.append(left.get(i));  //O(1)
            }
            else str.append(left.get(i) + ", ") ; //O(1)
        }
        str.append(">"); //O(1)

        str.append("<"); //O(1)
        for (int i = 0; i < rightLength(); i++) { //O(n)
            if (i == rightLength() - 1) //O(1)
            {
                str.append(right.get(i)); //O(1)
            }
            else str.append(right.get(i) + ", ") ; //O(1)
        }
        str.append(">");//O(1)

        // Total runtime is O(2n) = O(n)

        return str.toString();

    }


}

