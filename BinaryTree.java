import java.util.Collection;

/**
 * A class acting as a mutable, encapsulated binary tree
 * parameterized by the strategy used to add and remove data
 * and an object to validate any invariants
 * For the purposes of this class: assume the data in the tree is unique
 */
public class BinaryTree<E> {

    /**
     * The current immutable binary tree which this object encapsulates
     */
    protected IBinTree<E> data = new BTEmpty<E>();

    /**
     * The strategy by which this tree will add and remove integers from itself
     */
    private IBTStrategy<E> strategy;

    /**
     * The validator which will say whether an add was valid or not
     */
    private IBTValidator<E> invariantValidator;

    /**
     * The default constructor which provides a default strategy and an no invariant (always valid) validator
     */
    public BinaryTree(){
        strategy = new StrategyBTDefault<E>();
        invariantValidator = new ValidatorBTDefault<E>();
    }

    /**
     * A constructor which takes in a strategy and a validator to customize the binary tree
     * @param strategy the strategy used to add and remove integers to this tree
     * @param validator the validator which reports success after add and remove is called
     */
    public BinaryTree(IBTStrategy<E> strategy, IBTValidator<E> validator){
        this.strategy = strategy;
        this.invariantValidator = validator;
    }

    /**
     * A copy constructor
     * @param bt the binary tree which we copy the data, strategy, and validator from
     */
    public BinaryTree(BinaryTree<E> bt){
        this.data = bt.data;  // this is ok if we assume the IBinTree objects are immutable
        this.strategy = bt.strategy; //We assume a strategy here is stateless
        this.invariantValidator = bt.invariantValidator; //We assume a validator is stateless
    }

    /**
     * A convenience constructor which takes a collection (i.e. List) of numbers and populates the tree
     * @param elements the initial numbers to add to the tree with the default strategy.
     */
    public BinaryTree(Collection<E> elements){
        this();
        for(E elt : elements){
            this.addElt(elt);
        }
    }

    /**
     * A constructor for initializing with a particular tree
     * @param bt the particular immutable tree to start with
     */
    public BinaryTree(IBinTree<E> bt){
        this.data = bt;
        strategy = new StrategyBTDefault();
        invariantValidator = new ValidatorBTDefault();
    }

    /**
     * "add element"
     * Uses the current strategy to make a tree by adding a number to the current tree
     * @param elt the element to add
     * @return true if the current validator says the add was valid
     */
    public boolean addElt(E elt){
        IBinTree<E> nextTree = this.strategy.addElt(elt, data);
        boolean validAdd = this.invariantValidator.validAdd(data,elt,nextTree);
        if(validAdd){
            this.data = nextTree;
        }
        return validAdd;
    }

    /**
     * Uses the current strategy to make a tree by removing a particular number from the current tree
     * @param elt the element to remove
     * @return true if the current validator says the remove was valid
     */
    public boolean removeElt(E elt){
        IBinTree<E> nextTree = this.strategy.removeElt(elt, data);
        boolean validRemove = this.invariantValidator.validRemove(this.data,elt,nextTree);
        if(validRemove) {
            this.data = nextTree;
        }
        return validRemove;
    }

    /**
     * Uses the current strategy to make a tree by removing the current root number from the current tree
     * @return true if the current validator says the remove was valid
     */
    public boolean removeRoot(){
        if(this.data.isEmpty()){
            return false;
        }
        else {
            return this.removeElt(this.data.getRoot());
        }
    }


    /**
     * gets the number of nodes (non-leaves) in the tree;
     * @return
     */
    public int size(){
        return this.data.size();
    }


    /**
     * mutates this object to use a different strategy from now on
     * @param nextStrategy a strategy for adding and removing numbers from an IBinTree
     */
    public void setStrategy(IBTStrategy nextStrategy){
        this.strategy = nextStrategy;
    }

    /**
     * mutates this object to use a different validator from now on
     * @param nextValidator a validator for checking if a particular operation respected the invariants of this tree
     */
    public void setValidator(IBTValidator nextValidator){
        this.invariantValidator = nextValidator;
    }

    /**
     * Pretty-Prints out the tree
     * @return a string representation of the tree
     */
    @Override
    public String toString(){
        return this.data.toString();
    }

    /**
     * Two BinaryTrees are equal if their immutable tree fields are equal
     * @param o another tree, ideally
     * @return true iff both trees have the same elements in the same shape
     */
    @Override
    public boolean equals(Object o){
        if(! (o instanceof BinaryTree))
            return false;
        return ((BinaryTree) o).data.equals(this.data);
    }
}
