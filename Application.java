import java.io.FileNotFoundException;

public class Application {
	
	public static void main(String[] args) throws FileNotFoundException {

		BinarySearchTree tree = new BinarySearchTree("input");
		tree.writeFileWithinOrderTraverse();
		
	}

	
}