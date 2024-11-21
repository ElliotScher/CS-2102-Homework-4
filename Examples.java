import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Examples {
    
    BTEmpty<Integer> empty = new BTEmpty<>();

    IBinTree<Integer> exMaxHeap =
        new BTNode<>(7,
            new BTNode<>(3,
                new BTNode<>(1, empty, empty),
                new BTNode<>(2, empty, empty)),
            new BTNode<>(5,
                empty,
                new BTNode<>(4, empty, empty))
        );
    
    IBinTree<Integer> afterAdd6 =
        new BTNode<>(7,
            new BTNode<>(6,
                new BTNode<>(1, empty, empty),
                new BTNode<>(3,
                    new BTNode<>(2, empty, empty),
                    empty
                )
            ),
            new BTNode<>(5,
                empty,
                new BTNode<>(4, empty, empty))
        );

    IBinTree<Integer> afterRemove5 =
        new BTNode<>(7,
            new BTNode<>(3,
                new BTNode<>(1, empty, empty),
                new BTNode<>(2, empty, empty)),
            new BTNode<>(4, empty, empty)
        );
    
    @Test
    public void testAdd6OK() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertTrue(maxHValid.validAdd(exMaxHeap, 6, afterAdd6));
    }

    @Test
    public void testRemove5OK() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertTrue(maxHValid.validRemove(exMaxHeap, 5, afterRemove5));
    }

    @Test
    public void testAdd6NotOK() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validAdd(exMaxHeap, 5, exMaxHeap));
    }
}
