/**
 * An abstract binary tree removal strategy which is defined in terms of addition
 */
public abstract class StrategyBTAbs<E> implements IBTStrategy<E> {


    /**
     * Adding an element to a tree is a subclass responsibility
     *
     * @param elt the element to add
     * @param b   the tree to add it to
     * @return a new tree with the element added
     */
    @Override
    public abstract IBinTree<E> addElt(E elt, IBinTree<E> b);

    /**
     * A generic removal process defined in terms of addition by:
     * - searching for the element
     * - replacing the node with that element at the root with the left subtree merged into the right using repeated addInt()
     *
     * @param elt the element to remove
     * @param b   the tree from which to remove it
     * @return a new tree with all the elements from the old tree except i
     */
    @Override
    public IBinTree<E> removeElt(E elt, IBinTree<E> b) {
        if(b.isEmpty()){
            return b;
        }
        else if(b.getRoot().equals(elt)){
            return this.merge(b.getLeft(), b.getRight());
        }
        else{
            return new BTNode<E>(b.getRoot(),this.removeElt(elt, b.getLeft()), this.removeElt(elt,b.getRight()));
        }
    }

    /**
     * A helper method used to move all of the elements from one tree into another
     * @param from the tree whose elements we are taking from
     * @param to the tree that we are building up
     * @return a new tree with all the elements of `from` added to `to`
     */
    protected IBinTree<E> merge(IBinTree<E> from, IBinTree<E> to){
        if(from.isEmpty()){
            return to;
        }
        else if(to.isEmpty()) {
            return from;
        }
        else{
            IBinTree<E> addedRoot = this.addElt(from.getRoot(),to);
            IBinTree<E> mergeLeft = this.merge(from.getLeft(),addedRoot);
            IBinTree<E> mergeRight = this.merge(from.getRight(), mergeLeft);
            return mergeRight;
        }
    }
}
