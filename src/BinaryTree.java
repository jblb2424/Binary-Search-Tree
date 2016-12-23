public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof BinaryTree) {  //Instantiate o as a tree
			BinaryTree  t = (BinaryTree) o;
			return (this.root.equals(t.root));
		} else {
			return false; 
		}
		
		
	}

	public BinaryTree<T> deepCopy() {
		BinaryTree<T> copy = new BinaryTree<T>(this.root);
		if(this.root != null) {
			copy.root.deepCopy(); //Deep copy on root
		}
		return copy;
		
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,boolean left) {
		BinaryTreeNode newRootCopy = newRoot.deepCopy(); //Create deep copies of passing values
		BinaryTree newTree = new BinaryTree(newRootCopy);
		BinaryTree thisDeepCopy = this.deepCopy();
		BinaryTree tDeepCopy = t.deepCopy();
		if(left == true) { //tree orientation depends on this boolean value
			newTree.root.setLeft(thisDeepCopy.root);
			newTree.root.setRight(tDeepCopy.root);
			
			
		} else {
			newTree.root.setLeft(tDeepCopy.root);
			newTree.root.setRight(thisDeepCopy.root);
		}
		
		return newTree;
		
		
	}
	
	public int size(){
		if(this.root != null) {
		return this.root.size();
		}
		return 0; //Tree is empty
				
	}
	
	public int height(){
		if(this.root != null)  {
			return this.root.height();
		}
		return 0; //Tree is empty
	}
	//root is called for these methods as that's the first(top) node in the tree
	public boolean full(){
		return this.root.full();
	}
	
	public void mirror(){
		this.root.mirror();
	}
	
	public String inOrder(){
		return this.root.inOrder();
	}
}
