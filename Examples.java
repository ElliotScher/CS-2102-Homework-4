import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

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

    IBinTree<Integer> exMaxHeapInvalid =
        new BTNode<>(7,
            new BTNode<>(3,
                new BTNode<>(1, empty, empty),
                new BTNode<>(2, empty, empty)),
            new BTNode<>(5,
                new BTNode<>(6, empty, empty),
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


    IBinTree<Integer> exMinHeap =
        new BTNode<>(1,
            new BTNode<>(2,
                new BTNode<>(3, empty, empty),
                new BTNode<>(4, empty, empty)),
            new BTNode<>(5,
                empty,
                new BTNode<>(7, empty, empty))
        );

    IBinTree<Integer> exMinHeapInvalid =
        new BTNode<>(1,
            new BTNode<>(2,
                new BTNode<>(3, empty, empty),
                new BTNode<>(4, empty, empty)),
            new BTNode<>(5,
                empty,
                new BTNode<>(7,
                    new BTNode<>(5, empty, empty),
                empty))
        );

    BST<Integer> bst = new BST<>(exMaxHeap);
    
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

    @Test
    public void testRemove5NotOK() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validRemove(exMaxHeap, 5, exMaxHeap));
    }

    @Test
    public void testInvalidMaxHeap() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validAdd(exMaxHeap, 6, exMaxHeapInvalid));
    }

    @Test
    public void testInvalidMinHeap() {
        ValidatorMinHeap<Integer> minHValid = new ValidatorMinHeap<>();
        assertFalse(minHValid.validAdd(exMinHeap, 5, exMinHeapInvalid));
    }

    @Test
    public void testInvalidAddElementAdded() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validAdd(exMaxHeap, 9, afterAdd6));
    }

    @Test
    public void searchNotFound() {
        assertEquals(Optional.empty(), bst.search(10));
    }

    @Test
    public void searchFound() {
        assertEquals(Optional.of(7), bst.search(7));
    }

    @Test
    public void searchFoundLeft() {
        assertEquals(Optional.of(3), bst.search(3));
    }

    @Test
    public void testInvalidAddBeforeInAfter() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validAdd(afterAdd6, 6, exMaxHeap));
    }

    @Test
    public void testInvalidRemoveAfterInBefore() {
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validRemove(afterRemove5, 5, exMaxHeap));
    }
}
