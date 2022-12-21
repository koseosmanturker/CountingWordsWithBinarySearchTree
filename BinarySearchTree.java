import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BinarySearchTree {
	
	BTNode<String> root;
	
	public BinarySearchTree(){    
        root = null;    
    }  
	
	public BinarySearchTree(String path) throws FileNotFoundException {
		
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("File not found");
			return;
		}
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNext()) {
			String word = scan.next();
			word = makeProper(word);
			add(word);
		}

		scan.close();
	}
	
	private String makeProper(String word) {

		String output = "";

		for (int i = 0; i < word.length(); i++) {

			char ch = word.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				output += ch;
				continue;
			}

			if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch + 32);
				output += ch;
				continue;
			}

		}

		return output;
	}

	public void add(String itm) {
    	
    	root = add(root, itm);
    	
    }

	private BTNode<String> add(BTNode<String> r, String itm) {
		
		if(r == null) {
			return new BTNode<String>(itm);
		}
		
		if(itm.equals(r.data)) {
			r.freq++;
			return r;
		}
		
		if(compareStrings(itm, r.data)) {
			r.rchild = add(r.rchild, itm);
		}
		
		if(compareStrings(r.data, itm)) {
			r.lchild = add(r.lchild, itm);
		}
		
		return r;
	}
	
	public void writeFileWithinOrderTraverse() throws FileNotFoundException {
		
		File file = new File("out.txt");
		PrintWriter writer = new PrintWriter(file);
		
		writeFileWithinOrderTraverse(root,file, writer);
		
		writer.close();
		
	}

	private void writeFileWithinOrderTraverse(BTNode<String> r, File file, PrintWriter writer) {
		
		if(r == null) {
			return;
		}
		
		writeFileWithinOrderTraverse(r.lchild, file, writer);
		writer.println(r.data + " " + r.freq);
		writeFileWithinOrderTraverse(r.rchild, file, writer);
		
	}
	
	private boolean compareStrings(String s1, String s2) {
		
		//if s1 is before (lexicographically) than s2 returns true
		
		int len1 = s1.length();
		int len2 = s2.length();
		int size = minSize(len1, len2);
		
		for(int i = 0; i < size; i++) {
			
			char ch1 = s1.charAt(i);
			char ch2 = s2.charAt(i);
			
			if(ch1 != ch2) {
				
				if(ch1 < ch2) {
					return true;
				}
				return false;
				
			}
			
		}
		
		if(len2 > len1) {
			return false;
		}
		

		return true;
	}

	private int minSize(int len1, int len2) {

		if(len1 < len2) {
			return len1;
		}
		
		if(len2 < len1) {
			return len2;
		}
		
		return len1;
	}

}
