public class ValidatorMinHeap<E extends Comparable<E>> extends ValidatorBT<E> {
    @Override
    public boolean bstInvariant(IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return smallerThanAll(elts.getRoot(), elts.getLeft()) &&
                    smallerThanAll(elts.getRoot(), elts.getRight()) &&
                    this.bstInvariant(elts.getLeft()) &&
                    this.bstInvariant(elts.getRight());
        }
    }
}