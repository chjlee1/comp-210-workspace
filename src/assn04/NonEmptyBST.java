package assn04;


import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {

		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		if(this.getElement().compareTo(element) <= 0) {
			if(this.getRight().isEmpty())
				this._right = new NonEmptyBST<T>(element);
			else
				this.getRight().insert(element);
		}
		else if(this.getElement().compareTo(element) > 0) {
			if(this.getLeft().isEmpty())
				this._left = new NonEmptyBST<T>(element);
			else
				this.getLeft().insert(element);
		}
		return this;
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (this.isEmpty())
			return this;
		if (this.getElement().compareTo(element) > 0)
			this._left = this.getLeft().remove(element);
		else if (this.getElement().compareTo(element) < 0)
			this._right = this.getRight().remove(element);
		else {
			if (this.getLeft().isEmpty())
				return this.getRight();
			else if (this.getRight().isEmpty())
				return this.getLeft();
			BST<T> minElement = this.getRight();
			while (!minElement.getLeft().isEmpty()){
				minElement = minElement.getLeft();
			}
			this._element = minElement.getElement();
			this._right = this.getRight().remove(minElement.getElement());
		}
		return this;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		if (this.isEmpty())
			return;
		System.out.print(this._element + " ");
		this.getLeft().printPreOrderTraversal();
		this.getRight().printPreOrderTraversal();
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (this.isEmpty())
			return;
		this.getLeft().printPostOrderTraversal();
		this.getRight().printPostOrderTraversal();
		System.out.print(this._element + " ");

	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {
		if (this.isEmpty())
			return;
		Queue<BST<T>> queue = new LinkedList<BST<T>>();
		queue.add(this);
		while (!queue.isEmpty()) {
			BST<T> node = queue.remove();
			System.out.print(node.getElement() + " ");
			if(!node.getLeft().isEmpty())
				queue.add(node.getLeft());
			if(!node.getRight().isEmpty())
				queue.add(node.getRight());
		}
	}

	// GetHeight of A Tree

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}


	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
