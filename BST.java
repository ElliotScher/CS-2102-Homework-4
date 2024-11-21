import java.util.Optional;

public class BST<T extends Comparable<T>> extends BinaryTree<T>{
    
    public BST(IBinTree<T> data) {
        this.data = data;
        this.setStrategy(new StrategyBST());
        this.setValidator(new ValidatorBST());
    }

    public Optional<T> search(T key) {
        return null;
        // TODO
    }

    private Optional<T> search(T key, IBinTree<T> someTree) {
        return null;
        // TODO
    }
}
