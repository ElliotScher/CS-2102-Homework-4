public class ValidatorMaxHeap<E extends Comparable<E>> implements IBTValidator<E> {
    @Override
    public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return this.containsElt(elt, newTree) &&
                this.containsAll(oldTree, newTree) &&
                newTree.size() == oldTree.size() + 1 &&
                this.bstInvariant(newTree);
    }

    @Override
    public boolean validRemove(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        return ! this.containsElt(elt, newTree) &&
                this.containsAll(newTree, oldTree) &&
                newTree.size() == oldTree.size() - 1 &&
                this.bstInvariant(newTree);
    }

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

    public boolean bstInvariant(IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return this.biggerThanAll(elts.getRoot(), elts.getLeft()) &&
                    this.biggerThanAll(elts.getRoot(), elts.getRight()) &&
                    this.bstInvariant(elts.getLeft()) &&
                    this.bstInvariant(elts.getRight());
        }
    }

    public boolean biggerThanAll(E elt, IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return elt.compareTo(elts.getRoot()) > 0 &&
                    biggerThanAll(elt, elts.getLeft()) &&
                    biggerThanAll(elt, elts.getRight());
        }
    }

    public boolean smallerThanAll(E elt, IBinTree<E> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return elt.compareTo(elts.getRoot()) < 0 &&
                    smallerThanAll(elt, elts.getLeft()) &&
                    smallerThanAll(elt, elts.getRight());
        }
    }
}
