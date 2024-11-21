public class StrategyBST<E extends Comparable<E>> extends StrategyBTAbs<E> {

    /**
     * Adding an element to a tree is a subclass responsibility
     *
     * @param elt the element to add
     * @param b   the tree to add it to
     * @return a new tree with the element added
     */
    @Override
    public IBinTree<E> addElt(E elt, IBinTree<E> b) {
        if(b.isEmpty()){
            return new BTNode<E>(elt,new BTEmpty<E>(), new BTEmpty<E>());
        }
        else if(elt.compareTo(b.getRoot()) < 0){
            return new BTNode<E>(b.getRoot(),this.addElt(elt, b.getLeft()), b.getRight());
        }
        else {
            return new BTNode<E>(b.getRoot(), b.getLeft(), this.addElt(elt, b.getRight()));
        }
    }
}
