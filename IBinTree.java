/**
 * An Interface for an Immutable Binary Tree
 * Uses the Strategy Pattern for how to add elements
 * Uses the Visitor Pattern for how to traverse itself
 */
public interface IBinTree<E>{

    /**
     * A replacement for dynamic type checking (avoid instanceof) to determine if we are in a base-case
     * @return true if we are a representation of a leaf, false otherwise
     */
    public boolean isEmpty();

    /**
     * Assume valid for all non-leaves
     * @return the int at the root of the tree
     */
    public E getRoot();

    /**
     * Assume valid for all non-leaves
     * @return the left subtree which may be a leaf or a node
     */
    public IBinTree<E> getLeft();

    /**
     * Assume valid for all non-leaves
     * @return the right subtree which may be a leaf or a node
     */
    public IBinTree<E> getRight();

    /**
     *
     * @return the count of all non-leaf nodes in this tree
     */
    public int size();

}
