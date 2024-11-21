/**
 * The strategy for adding and removing integers from an integer binary tree
 */
public interface IBTStrategy<E> {

    /**
     * Produces a new tree by adding i to the elements of the old tree (respecting any invariants)
     *
     * @param elt the element to add to the tree
     * @param b   a tree assumed to respect any invariants needed by the strategy
     * @return the new (immutable) tree now containing elt
     */
    public IBinTree<E> addElt(E elt, IBinTree<E> b);

    /**
     * Produces a new tree by removing an element from the elements of the old tree (respecting any invariants)
     *
     * @param elt the element to remove from the tree
     * @param b   a tree assumed to respect any invariants needed by the strategy
     * @return the new (immutable) tree no longer containing elt
     */
    public IBinTree<E> removeElt(E elt, IBinTree<E> b);


}
