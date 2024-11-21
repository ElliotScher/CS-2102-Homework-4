import java.util.Random;
/**
 * An example max heap strategy for adding an int to an existing max heap
 */
public class StrategyMaxHeap3<E extends Comparable<E>> extends StrategyBTAbs<E> implements IBTStrategy<E> {
    @Override
    public BTNode<E> addElt(E elt, IBinTree<E> b) {
        if(b.isEmpty()){
            return new BTNode<E>(elt, new BTEmpty<E>(), new BTEmpty<E>());
        }
        else{
            Random r = new Random();
            if(elt.compareTo(b.getRoot()) < 0){
                if(r.nextBoolean()) {
                    return new BTNode<E>(b.getRoot(), b.getLeft(), this.addElt(elt, b.getRight()));
                }
                else{
                    return new BTNode<E>(b.getRoot(), this.addElt(elt, b.getLeft()), b.getRight());
                }
            }
            else{
                if(r.nextBoolean()) {
                    return new BTNode<E>(elt, b.getLeft(), this.addElt(b.getRoot(), b.getRight()));
                }
                else{
                    return new BTNode<E>(elt, this.addElt(b.getRoot(), b.getLeft()), b.getRight());
                }
            }
        }
    }
}
