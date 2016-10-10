import com.sun.istack.internal.NotNull;
import java.util.ArrayList;

/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 * Encapsulated version.
 */
public class IntList {
    /** The head of the list is the first node in the list. If the list is empty, head is null **/
    private IntListNode head;
    private int size;

    @java.lang.Override
    public java.lang.String toString() {
        return "IntList{" +
                ", size=" + size +
                '}';
    }
    public static void main(){
        int[] a ={1,2,3,4,5};
        IntList test = new IntList(a);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntList intList = (IntList) o;

        return size == intList.size;

    }

    /** IntListNode is a nested class. It can be instantiated when associated with an instance of
     *  IntList.
     *  **/
    public class IntListNode {
        int item;
        IntListNode next;

        @java.lang.Override
        public java.lang.String toString() {
            return "IntListNode{" +
                    "item=" + item +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IntListNode that = (IntListNode) o;

            if (item != that.item) return false;
            return next.equals(that.next);

        }

        @Override
        public int hashCode() {
            return item;
        }

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public IntList() { size=0;}
    public IntList(IntList a) {
        if (a.head==null) {
            head = null;
            size=0;
        }
        else {
            IntListNode iterator = new IntListNode(a.head.item,null);
            IntListNode Head = iterator;
            int ref_size = a.getSize();
            for (int i = 1; i < ref_size; i++) {
                IntListNode tmp = new IntListNode(a.get(i),null);
                iterator.next = tmp;
                iterator = tmp;
            }
            this.head = Head;
            this.size = a.size;
        }
    }
    public IntList(int[] initial) {
        for (int i = initial.length - 1; i >= 0; i--) {
            head = new IntListNode(initial[i], head);
        }
        size = initial.length;
    }

    /**
     * Get the value at position pos. If the position does not exist, throw an
     * IndexOutOfBoundsException.
     * @param position to get from
     * @return the int at the position in the list.
     */
    public int get(int position) {
        if (position >= size) throw new IndexOutOfBoundsException("Position larger than size of list.");
        IntListNode curr = head;
        if (curr == null)
                throw new NullPointerException("This is an empty list!");
        while (position > 0) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }
    /* Fill in below! */
    @NotNull
    public IntListNode getNode(int position) {
        if (position >= size) throw new IndexOutOfBoundsException("Position larger than size of list.");
        IntListNode curr = head;
        while (position > 0) {
            curr = curr.next;
            position--;
        }
        return curr;
    }
    /**
     * Insert a new node into the IntList.
     * @param x value to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(int x, int position) {
        // Fill me in!

        if (position < 0)
                throw new IndexOutOfBoundsException("position can not be negative");
        else if (position >= size) {
            try {
                IntListNode lastItem = getNode(size - 1);
                lastItem.next = new IntListNode(x, null);
            } catch (NullPointerException e){
                head = new IntListNode(x, null);
                size++;
                return;
            }
        } else {
            IntListNode curr = head;
            IntListNode prev = null;
            if (curr == null) {
                head = new IntListNode(x, null);
                size++;
            } else {
                while (position > 0) {
                    prev = curr;
                    curr = curr.next;
                    position--;
                }
                if (prev != null) {
                    IntListNode tmp = new IntListNode(x, curr);
                    prev.next = tmp;
                } else {
                    IntListNode tmp = new IntListNode(x, curr);
                    head = tmp;
                }
            }
        }
        size++;
    }


    /**
     * Merge two sorted IntLists a and b into one sorted IntList containing all of their elements.
     * @return a new IntList without modifying either parameter
     */
    public static IntList merge(IntList a, IntList b) {
        // Fill me in!
        IntListNode head_it_a = a.head;
        IntListNode head_it_b = b.head;

        int[] arr= new int[a.size+b.size];
        int count = 0;
        while (head_it_a!=null && head_it_b !=null) {
                int getItem_a = head_it_a.item;
                int getItem_b = head_it_b.item;
            if (getItem_a < getItem_b) {
                arr[count]=getItem_a;
                head_it_a = head_it_a.next;
                count++;
            } else {
                    arr[count]=getItem_b;
                    head_it_b = head_it_b.next;
                count++;
                }
            }
            while(head_it_a!=null) {
                int getItem_a = head_it_a.item;
                arr[count]=getItem_a;
                head_it_a = head_it_a.next;
                count++;
            }
            while(head_it_b!=null) {
            int getItem_b = head_it_b.item;
            arr[count]=getItem_b;
            head_it_b = head_it_b.next;
                count++;
            }
        return new IntList(arr);
    }

    /**
     * Reverse the current list recursively, using a helper method.
     */
    public void reverse() {
        // Fill me in!
        this.head =reverseHelper(this.head);
    }
    public static IntListNode reverseHelper(IntListNode cur) {
        if (cur == null) {
            return cur;
        } else if (cur.next == null) {
            return cur;
        } else {
            IntListNode new_head = reverseHelper(cur.next);
            IntListNode tmp = cur.next;
            tmp.next = cur;
            cur.next = null;
            return new_head;
        }

    }

    /* Optional! */

    /**
     * Remove the node at position from this list.
     * @param position int representing the index of the node to remove. If greater than the size
     *                 of this list, throw an IndexOutOfBoundsException.
     */
    public void remove(int position) {
        if (position >= size) throw new IndexOutOfBoundsException();
        // fill me in
    }
}
