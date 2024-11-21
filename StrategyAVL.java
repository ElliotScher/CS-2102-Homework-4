/** A Candidate AVL Strategy (Prof. Ahrens is unsure if it is even correct or will always terminate */
public class StrategyAVL<E extends Comparable<E>> extends StrategyBST<E>{
    public int maxDepth(IBinTree<E> b){
        if(b.isEmpty()) { return 0; }
        else {
            return 1 + Math.max(this.maxDepth(b.getLeft()), this.maxDepth(b.getRight()));
        }
    }
    /**
     * Adding an element to a tree is a subclass responsibility
     *
     * @param elt the element to add
     * @param b   the tree to add it to
     * @return a new tree with the element added
     */
    @Override
    public IBinTree<E> addElt(E elt, IBinTree<E> b) {
        IBinTree<E> newTree = super.addElt(elt, b);
        if(this.maxDepth(newTree.getLeft()) - this.maxDepth(newTree.getRight()) > 1){
            IBinTree<E> newChildren = this.merge(newTree.getLeft(), newTree.getRight());
            return this.addElt(newTree.getRoot(),newChildren);
        }
        else if(this.maxDepth(newTree.getRight()) - this.maxDepth(newTree.getLeft()) > 1){
            IBinTree<E> newChildren = this.merge(newTree.getRight(), newTree.getLeft());
            return this.addElt(newTree.getRoot(),newChildren);
        }
        else {
            return newTree;
        }
    }
}
