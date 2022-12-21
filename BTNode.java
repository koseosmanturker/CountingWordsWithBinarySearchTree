
public class BTNode<T> {
	
	public T data;
	public BTNode<T> rchild;
	public BTNode<T> lchild;
	public int freq;
	
	public BTNode() {
		rchild = lchild = null;
	}

	public BTNode(T itm) {
		data = itm;
		freq = 1;
	}
	
}
