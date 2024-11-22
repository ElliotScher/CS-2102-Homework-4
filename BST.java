import java.util.Optional;

public class BST<T extends Comparable<T>> extends BinaryTree<T>{
    
    public BST(IBinTree<T> data) {
        this.data = data;
        this.setStrategy(new StrategyBST());
        this.setValidator(new ValidatorBST());
    }

    public Optional<T> search(T key) {
        return search(key, this.data);
    }

    private Optional<T> search(T key, IBinTree<T> someTree) {
        if (someTree.isEmpty()) {
            return Optional.empty();
        } else if (someTree.getRoot().compareTo(key) == 0) {
            return Optional.of(someTree.getRoot());
        } else if (key.compareTo(someTree.getRoot()) < 0) {
            return search(key, someTree.getLeft());
        } else {
            return search(key, someTree.getRight());
        }
    }
}
