import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTestCases {
	BinaryTreeNode node1 = new BinaryTreeNode(1);
	BinaryTreeNode node2 = new BinaryTreeNode(2);
	BinaryTreeNode node3 = new BinaryTreeNode(3);
	BinaryTreeNode node4 = new BinaryTreeNode(4);
	BinaryTreeNode node5 = new BinaryTreeNode(5);
	BinaryTreeNode node6 = new BinaryTreeNode(6);
	BinaryTreeNode node7 = new BinaryTreeNode(7);
	BinaryTreeNode node8 = new BinaryTreeNode(8);
	BinaryTreeNode node9 = new BinaryTreeNode(9);
	
	BinaryTreeNode node10 = new BinaryTreeNode(10);
	BinaryTreeNode node11 = new BinaryTreeNode(11);
	BinaryTreeNode node12 = new BinaryTreeNode(12);
	BinaryTreeNode node13 = new BinaryTreeNode(13);
	
	BinaryTreeNode node14 = new BinaryTreeNode(14);
	BinaryTreeNode node15 = new BinaryTreeNode(15);
	BinaryTreeNode node16 = new BinaryTreeNode(16);
	
	
	BinaryTree tree1 = new BinaryTree(node1);
	BinaryTree tree2 = new BinaryTree(node10);
	BinaryTree tree3 = new BinaryTree(node14);
	BinaryTree oneNodeTree = new BinaryTree();
	
	
	@Before
	public void setUp() {
		//Tree1
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		node3.setLeft(node6);
		node3.setRight(node7);	
		
		//Tree2
		node10.setLeft(node11);
		node10.setRight(node12);
		node11.setLeft(node13);
		
		//Tree3
		node14.setLeft(node15);

			
	}
	
	@Test
	public void testSize() {
	
		assertTrue(tree1.size() == 7);
		assertTrue(tree3.size() == 2);
		assertTrue(oneNodeTree.size() == 0);
	}
	
	@Test
	public void testDeepCopy() {
		assertTrue(tree1.deepCopy().equals(tree1));
		assertFalse(tree2.deepCopy().equals(tree1));
	}
	
	@Test
	public void TestEquals() {
		BinaryTree copiedTree = tree1.deepCopy();
		assertFalse(tree1.equals(tree2));
		assertTrue(tree1.equals(copiedTree));
	}
	
	@Test
	public void testHeght() {
		assertTrue(tree1.height() == 3);
		assertTrue(tree3.height() == 2);
		assertTrue(oneNodeTree.height() == 0);
	}
	@Test
	public void testFull() {
		assertTrue(tree1.full());
		assertTrue(tree3.full() == false);
	}
	@Test
	public void testInOrder() {
		assertTrue(tree3.inOrder().equals("(15)(14)"));
		assertTrue(tree1.inOrder().equals("(4)(2)(5)(1)(6)(3)(7)"));
	}
	
	@Test
	public void testMirror() {
		tree2.mirror();
		assertTrue(tree2.inOrder().equals("(12)(10)(11)(13)"));
		tree2.mirror();
		assertTrue(tree2.inOrder().equals("(13)(11)(10)(12)"));
		
	}
	
	//Tests for Nodes
	@Test
	public void testSizeNode() {
		
		assertTrue(node16.size() == 1);
		assertTrue(node11.size() == 2);
	
	}
	
	@Test
	public void testDeepCopyNode() {
		assertTrue(node11.deepCopy().equals(node11));
		assertFalse(node16.deepCopy().equals(node11));
	}
	
	@Test
	public void TestEqualsNode() {
		BinaryTreeNode copiedNode = node16.deepCopy();
		assertFalse(node16.equals(node11));
		assertTrue(node16.equals(copiedNode));
	}
	
	@Test
	public void testHeghNodet() {
		assertTrue(node11.height() == 2);
		assertTrue(node16.height() == 1);
	}
	@Test
	public void testFullNode() {
		assertTrue(node16.full() == true);
		assertTrue(node11.full() == false);
	}
	@Test
	public void testInOrderNode() {
		assertTrue(node16.inOrder().equals("(16)"));
		assertTrue(node11.inOrder().equals("(13)(11)"));
	}
	
	@Test
	public void testMirrorNode() {
		node16.mirror();
		assertTrue(node16.inOrder().equals("(16)"));
		node11.mirror();
		assertTrue(node11.inOrder().equals("(11)(13)"));
		
	}

}
