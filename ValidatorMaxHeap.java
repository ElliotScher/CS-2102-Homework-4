public class ValidatorMaxHeap<E extends Comparable<E>>  implements IBTValidator<E> {
    @Override
    public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return false;
    }

    @Override
    public boolean validRemove(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return false;
    }
}