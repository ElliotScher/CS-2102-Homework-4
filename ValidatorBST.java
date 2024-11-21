public class ValidatorBST<T extends Comparable<T>> implements IBTValidator<T> {
    @Override
    public boolean validAdd(IBinTree<T> oldTree, T elt, IBinTree<T> newTree) {
        return this.containsElt(elt, newTree) &&
                this.containsAll(oldTree, newTree) &&
                newTree.size() == oldTree.size() + 1 &&
                this.bstInvariant(newTree);
    }

    @Override
    public boolean validRemove(IBinTree<T> oldTree, T elt, IBinTree<T> newTree) {
        return ! this.containsElt(elt, newTree) &&
                this.containsAll(newTree, oldTree) &&
                newTree.size() == oldTree.size() - 1 &&
                this.bstInvariant(newTree);
    }

    public boolean containsElt(T elt, IBinTree<T> b){
        if(b.isEmpty()) { return false; }
        else if(b.getRoot().equals(elt)){ return true; }
        else {
            return this.containsElt(elt,b.getLeft()) ||
                    this.containsElt(elt, b.getRight());
        }
    }

    public boolean containsAll(IBinTree<T> elts, IBinTree<T> container){
        if(elts.isEmpty()) { return true; }
        else {
            return this.containsElt(elts.getRoot(),container) &&
                    this.containsAll(elts.getLeft(), container) &&
                    this.containsAll(elts.getRight(), container);
        }
    }

    public boolean bstInvariant(IBinTree<T> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return this.biggerThanAll(elts.getRoot(), elts.getLeft()) &&
                    this.smallerThanAll(elts.getRoot(), elts.getRight()) &&
                    this.bstInvariant(elts.getLeft()) &&
                    this.bstInvariant(elts.getRight());
        }
    }

    public boolean biggerThanAll(T elt, IBinTree<T> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return elt.compareTo(elts.getRoot()) > 0 &&
                    biggerThanAll(elt, elts.getLeft()) &&
                    biggerThanAll(elt, elts.getRight());
        }
    }

    public boolean smallerThanAll(T elt, IBinTree<T> elts){
        if(elts.isEmpty()) { return true; }
        else {
            return elt.compareTo(elts.getRoot()) < 0 &&
                    smallerThanAll(elt, elts.getLeft()) &&
                    smallerThanAll(elt, elts.getRight());
        }
    }
}
