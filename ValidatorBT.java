/**
 * A default validator which says that all trees are valid
 */
public class ValidatorBT<E extends Comparable<E>> implements IBTValidator<E> {


    /**
     * A placeholder validator that says all adds are valid (even if they don't make sense)
     * @param oldTree the given tree we assume respects the invariants
     * @param elt the element to add
     * @param newTree the new tree which we are validating
     * @return true always
     */
     @Override
     public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
         return this.containsElt(elt, newTree) &&
                 this.containsAll(oldTree, newTree) &&
                 newTree.size() == oldTree.size() + 1 &&
                 this.bstInvariant(newTree);
     }

    /**
     * A placeholder validator that says all removals are valid (even if they don't make sense)
     * @param oldTree the given tree we assume respects the invariants
     * @param elt the element to remove
     * @param newTree the new tree which we are validating
     * @return true always
     */
    @Override
    public boolean validRemove(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return !this.containsElt(elt, newTree) &&
                this.containsAll(newTree, oldTree) &&
                newTree.size() == oldTree.size() - 1 &&
                this.bstInvariant(newTree);
    }

    /**
     * Checks if the binary tree contains the specified element.
     *
     * @param elt the element to search for in the binary tree
     * @param b the binary tree to search within
     * @return true if the element is found in the binary tree, false otherwise
     */
    public boolean containsElt(E elt, IBinTree<E> b){
        if(b.isEmpty()) { return false; }
        else if(b.getRoot().equals(elt)){ return true; }
        else {
            return this.containsElt(elt,b.getLeft()) ||
                    this.containsElt(elt, b.getRight());
        }
    }

    public boolean containsAll(IBinTree<E> elts, IBinTree<E> container){
        if(elts.isEmpty()) { return true; }
        else {
            return this.containsElt(elts.getRoot(),container) &&
                    this.containsAll(elts.getLeft(), container) &&
                    this.containsAll(elts.getRight(), container);
        }
    }

    /**
     * Checks if the given binary tree satisfies the binary search tree (BST) invariant.
     * The BST invariant requires that for every node, all elements in the left subtree
     * are less than the node's value, and all elements in the right subtree are greater
     * than the node's value.
     *
     * @param elts the binary tree to check
     * @return true if the binary tree satisfies the BST invariant, false otherwise
     */
    public boolean bstInvariant(IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return this.biggerThanAll(elts.getRoot(), elts.getLeft()) &&
                    this.biggerThanAll(elts.getRoot(), elts.getRight()) &&
                    this.bstInvariant(elts.getLeft()) &&
                    this.bstInvariant(elts.getRight());
        }
    }

    /**
     * Checks if the given element is bigger than all elements in the binary tree.
     *
     * @param elt  the element to compare
     * @param elts the binary tree to check against
     * @return true if the element is bigger than all elements in the binary tree, false otherwise
     */
    public boolean biggerThanAll(E elt, IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return elt.compareTo(elts.getRoot()) > 0 &&
                    biggerThanAll(elt, elts.getLeft()) &&
                    biggerThanAll(elt, elts.getRight());
        }
    }

    /**
     * Checks if the given element is smaller than all elements in the binary tree.
     *
     * @param elt  the element to compare
     * @param elts the binary tree to check against
     * @return true if the element is smaller than all elements in the binary tree, false otherwise
     */
    public boolean smallerThanAll(E elt, IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return elt.compareTo(elts.getRoot()) < 0 &&
                    smallerThanAll(elt, elts.getLeft()) &&
                    smallerThanAll(elt, elts.getRight());
        }
    }
}
