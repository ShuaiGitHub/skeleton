/** A data structure to represent a Linked List of Integers.
  * Each IntList represents one node in the overall Linked List.
  *
  * @author Maurice Lee and Wan Fung Chui
  */

public class IntList {

    /**
     * The integer stored by this node.
     */
    private int item;
    /**
     * The next node in this IntList.
     */
    private IntList next;

    /**
     * Constructs an IntList storing ITEM and next node NEXT.
     */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /**
     * Constructs an IntList storing ITEM and no next node.
     */
    public IntList(int item) {
        this(item, null);
    }
    public IntList(IntList old){
        this.item = old.item();
        this.next = old.next();
    }
    /**
     * Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints (1 2 3)
     */
    public static IntList list(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns the integer stored by this IntList.
     */
    public int item() {
        return item;
    }

    /**
     * Returns the next node stored by this IntList.
     */
    public static IntList duplicate(IntList old){
        IntList tmp =new IntList(old.item());
        IntList iterator = old;
        IntList tmp2 = tmp;
        while (iterator.next() != null) {
            tmp.next = new IntList(iterator.next().item());
        }
        return tmp2;
    }

    public IntList next() {
        return next;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        if (position < 0 || position > this.size() - 1)
            throw new IllegalArgumentException("invalid position!");
        else {
            int step = 0;
            IntList tmp = this;// as head
            while (step != position) {
                tmp = tmp.next();
                step++;
            }
            return tmp.item();
        }
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        int count = 0;
        IntList tmp = this;
        while (tmp != null) {
            tmp = tmp.next();
            count++;
        }
        // YOUR CODE HERE
        return count;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "( 1 2 3 )".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        // YOUR CODE HERE
        IntList tmp = this;
        String output = "(";
        for (int i = 0; i < this.size(); i++) {
            output = output + " "+Integer.toString(tmp.item());
            tmp = tmp.next();
        }
        output = output + " )";
        return output;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        // YOUR CODE HERE
        return this.toString().equals(obj.toString());
    }

    /**
     * Adds the given item at the end of the list.
     *
     * @param item, the int to be added.
     */
    public void add(int item) {
        // YOUR CODE HERE
        IntList tmp = this;
        while (tmp.next() != null) {
            tmp = tmp.next();
        }
        tmp.next = new IntList(item);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        int holder = Integer.MAX_VALUE;
        // YOUR CODE HERE
        IntList tmp = this;
        while (tmp != null) {

            if (tmp.item() < holder)
                    holder = tmp.item();
            tmp = tmp.next();
        }
        return holder;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        // YOUR CODE HERE
        int totalSum = 0;
        IntList tmp = this;
        while (tmp != null) {
            totalSum = totalSum + (int)Math.pow(tmp.item(),2);
            tmp = tmp.next();
        }
        return totalSum;
    }

    /**
     * Returns a new IntList consisting of L1 followed by L2,
     * non-destructively.
     *
     * @param l1 list to be on the front of the new list.
     * @param l2 list to be on the back of the new list.
     * @return new list with L1 followed by L2.
     */
    // REWRITE THIS!
    public static IntList append(IntList l1, IntList l2) {
        // YOUR CODE HERE
        IntList it_list = l1;
        if (l1!=null) {
            IntList tmp = new IntList(l1.item());
            IntList tmp2 = tmp;
            while (it_list.next() != null) {
                tmp.next = new IntList(it_list.next());
                it_list = it_list.next();
                tmp = tmp.next();
            }
            it_list = l2;
            while (it_list != null) {
                tmp.next = new IntList(it_list.item());
                it_list = it_list.next();
                tmp = tmp.next();
            }
            return tmp2;
        }
        else {
            it_list = l2;
            IntList tmp = new IntList(l2.item());
            IntList tmp2 = tmp;
            while (it_list.next() != null) {
                tmp.next = new IntList(it_list.next());
                it_list = it_list.next();
                tmp = tmp.next();
            }
            return tmp2;
        }
    }
}
