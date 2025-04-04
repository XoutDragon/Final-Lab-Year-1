public class BinaryNode<T>
{
	private Object element;
	private BinaryNode<T> parent;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T element, BinaryNode<T> parentNode, BinaryNode<T> leftChild, BinaryNode<T> rightChild)
	{
		this.element = element;
		this.parent  = parentNode;
		this.left 	 = leftChild;
		this.right   = rightChild;
	}
	
	public BinaryNode(T element)
	{
		this(element, null, null, null);
	}
	
	@SuppressWarnings("unchecked")
	public T getElement()
	{
		return (T)this.element;
	}
	
	public BinaryNode<T> getParent()
	{
		return this.parent;
	}
	
	public BinaryNode<T> getLeft()
	{
		return this.left;
	}
	
	public BinaryNode<T> getRight()
	{
		return this.right;
	}
	
	public void setElement(T newElement)
	{
		if(this.getElement() == null)
			this.element = newElement;
	}
	
	public void setParent(BinaryNode<T> newParent)
	{
		this.parent = newParent;
	}
	
	public void setLeft(BinaryNode<T> newLeft)
	{
		this.left = newLeft;
	}
	
	public void setRight(BinaryNode<T> newRight)
	{
		this.right = newRight;
	}
	
	public static void main(String[] args)
	{
		BinaryNode<String> n1 = new BinaryNode<String>("root node");
		BinaryNode<String> n2 = new BinaryNode<String>("left child node");
		BinaryNode<String> n3 = new BinaryNode<String>("right child node");
		BinaryNode<String> n4 = new BinaryNode<String>("left grandchild node");
		
		n1.setLeft(n2);
		n2.setParent(n1);
		
		n1.setRight(n3);
		n3.setParent(n1);
		
		n2.setLeft(n4);
		n4.setParent(n2);
	}
}


