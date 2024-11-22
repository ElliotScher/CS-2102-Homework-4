public class ValidatorMaxHeap<E extends Comparable<E>> extends ValidatorBT<E> {
    @Override
    public boolean bstInvariant(IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return biggerThanAll(elts.getRoot(), elts.getLeft()) &&
                    biggerThanAll(elts.getRoot(), elts.getRight()) &&
                    this.bstInvariant(elts.getLeft()) &&
                    this.bstInvariant(elts.getRight());
        }
    }
}
