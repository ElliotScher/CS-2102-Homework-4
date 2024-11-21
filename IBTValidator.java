/**
 * An object (essentially a strategy) describing how to check the invariants of a particular kind of binary tree
 * (E.g. BST, AVL, MinHeap, MaxHeap, etc.)
 */
public interface IBTValidator<E> {

    /**
     * Check if adding elt to the old tree and getting the new tree is possible with the current invariants
     * @param oldTree the given tree we assume respects the invariants
     * @param elt the element to add
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree);
    /**
     * Check if removing elt from the old tree and getting the new tree is possible with the current invariants
     * @param oldTree the given tree we assume respects the invariants
     * @param elt the element to remove
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    public boolean validRemove(IBinTree<E> oldTree, E elt, IBinTree<E> newTree);
}
