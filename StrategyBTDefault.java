/**
 * A Strategy for adding integers in breadth first order
 */
public class StrategyBTDefault<E> extends StrategyBTAbs<E> implements IBTStrategy<E>
{
    /**
     * Used as a helper method used to measure the shortest path between the root node and leaf
     * @param b the tree to measure
     * @return how many non-leaf nodes are between the root node and the closest leaf
     */
    private int minDepth(IBinTree<E> b){
        if(b.isEmpty()){
            return 0;
        }
        else{
            return 1 + Math.min(this.minDepth(b.getLeft()), this.minDepth(b.getRight()));
        }
    }

    /**
     * Get a tree by replacing the nearest leaf (closest to root, left to right) with a node containing i
     *
     * @param elt the element to add to the tree
     * @param b   a tree (no invariants)
     * @return a new (immutable) tree with i added
     */
    @Override
    public IBinTree<E> addElt(E elt, IBinTree<E> b) {
        if(b.isEmpty()){
            return new BTNode<E>(elt, new BTEmpty(), new BTEmpty());
        }
        else {
            if(this.minDepth(b.getLeft()) <= this.minDepth(b.getRight())){
                return new BTNode<E>(b.getRoot(), this.addElt(elt,b.getLeft()), b.getRight());
            }
            else {
                return new BTNode<E>(b.getRoot(), b.getLeft(), this.addElt(elt,b.getRight()));
            }
        }
    }



}
