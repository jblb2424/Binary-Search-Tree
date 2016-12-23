
public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;
	
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}
	
	public int size(){
		int size = 0; //the size of the tree

		
		if(this.getLeft() != null && this.getRight() != null){ //Both children exist
			size = size + left.size();
			size = size + right.size();
		}
		if(this.getRight() != null && this.getLeft() == null){ // Right child exists
			size = size + right.size();
		}
		if(this.getRight() == null && this.getLeft() != null){ //Left child exists
			size = size + left.size();
		}
		
		
		
		return size + 1; //add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	public BinaryTreeNode<T> deepCopy(){ 
		BinaryTreeNode<T> copy = new BinaryTreeNode<T>(this.data);
		BinaryTreeNode<T> newLeft = null;
		BinaryTreeNode<T> newRight = null;
		if (this.left != null) {
			newLeft = this.left.deepCopy();
			copy.setLeft(newLeft);
		}
		if (this.right != null) {
			newRight = this.right.deepCopy();
			copy.setRight(newRight);
		}
		return copy;		
	}
	
	@Override
	public boolean equals(Object o){ 
		if (o instanceof BinaryTreeNode) {  
			BinaryTreeNode  n = (BinaryTreeNode) o; 
			
			//Protects against null cases
			if((this.left == null && n.left != null) && (this.right == null && n.right != null)  && (this.left != null && n.left == null) && (this.right != null && n.right == null))
			{
				return false;
			}
			
			if(n.getData() != this.getData()) { //Checks if initial parents are equal...does this have to be .equal?
				return false;
			}
			
			if(n.getRight() != null && n.getLeft()!= null){ //Case1: Both children exist
				boolean retval = n.getRight().equals(this.getRight()) && n.getLeft().equals(this.getLeft());
				return retval;
			}
			
			if(n.getRight() != null && n.getLeft() == null){ //Case2: Only right child exists
				boolean retval = n.getRight().equals(this.getRight());
				return retval;
			}
			
			if(n.getRight() == null && n.getLeft() != null){ //Case3: only left child exists
				boolean retval = n.getLeft().equals(this.getLeft());
				return retval;
			}
			
			if(n.getRight() == null && n.getLeft() == null){ //Case4: No children
				return true;
			}
			
			
		} 
		return false; 
	}
	
	public int height(){
		int count = 1;
		
		if(this.left != null || this.right != null) { //If both children exist
			int left = 0;
			int right = 0;
			
			if(this.left!= null) { //If left child exists
			left = this.left.height() +1 ;
			}
			
			if(this.right!= null) { // If right child exists
				right = this.right.height() +1 ;
				}
			
			if(left > right) { //Returns the greater of left and right side
				return left;
			} else {
				return right;
			}
			
			
		}
		
		return count;
	}

	public boolean full(){
		if(this.right == null || this.left == null) {
			if(this.right == null && this.left == null) { //If you reach the last node and full() still is true, return true
				return true;
			} else {
				return false;
			}
		}
		
		boolean equality = this.left.height() == this.right.height(); //Checks if the right and left heights are equal
	
		
		
		if(equality == true) { //If the heights are the same, call full again on children nodes
			return this.left.full() && this.right.full();
		} else {
			return false;
		}
		
		
			
	}
	
	public void mirror(){ 
		
	
		if(this.left != null && this.right != null) { //Both children exist
			BinaryTreeNode left = this.left; //Declares new variables to hold left and right values since they are being swapped
			BinaryTreeNode right = this.right;

			this.setRight(left);
			this.setLeft(right);
			this.left.mirror();
			this.right.mirror();
			
		}
		
		if(this.left != null && this.right == null) { //Left exists
		
			BinaryTreeNode left = this.left;
			this.setRight(left);

			this.setLeft(null);
			this.right.mirror();
		}
		
		else if(this.left == null && this.right != null) { //Right exists

			BinaryTreeNode right = this.right;
			this.setLeft(right);
			this.setRight(null);
			this.left.mirror();
		}
		
				
	}
	
	public String inOrder(){
		String order = "";
		//Call left, then middle, then right in order to obtain the order left->value-> right
		if (this.left != null){
	       order += this.left.inOrder();
	       
	    }
		
		order += "(" + this.data + ")";
		
		if (this.right != null){
		       order += this.right.inOrder();
		    }
		return order;	
	}

}
