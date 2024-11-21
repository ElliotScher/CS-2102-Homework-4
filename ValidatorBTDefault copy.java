/**
 * A default validator which says that all trees are valid
 */
public class ValidatorBTDefault<E> implements IBTValidator<E> {


    /**
     * A placeholder validator that says all adds are valid (even if they don't make sense)
     * @param oldTree the given tree we assume respects the invariants
     * @param elt the element to add
     * @param newTree the new tree which we are validating
     * @return true always
     */
    @Override
    public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return true;
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
        return true;
    }
}
