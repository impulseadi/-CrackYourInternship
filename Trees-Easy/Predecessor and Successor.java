// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

 class Res
    {
        Node pre = null;
        Node succ = null;
    }
class PreSucc
{
   
     public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
      public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t = sc.nextInt();
          
           while(t-->0){
            int n = sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
           Res p = new Res();
           Res s = new Res();
            for(int i=0;i<n;i++){
                
                int a=sc.nextInt();
                int a1=sc.nextInt();
                
                char lr=sc.next().charAt(0);
                
                if(i==0){
                    
                    root=new Node(a);
                    
                    switch(lr)
                    {
                        
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            int key = sc.nextInt();
            GfG g=new GfG();
            g.findPreSuc(root, p, s, key);
            
            if(p.pre != null)
              System.out.print(p.pre.data + " ");
              else
              System.out.print("-1" + " ");
              
            if(s.succ != null)
              System.out.println(s.succ.data);
              else
              System.out.println("-1");
            
            
        }
    }
}// } Driver Code Ends


/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respec
// Java program to find predecessor
// and successor in a BST
class GFG{

// BST Node
static class Node
{
	int key;
	Node left, right;

	public Node()
	{}

	public Node(int key)
	{
		this.key = key;
		this.left = this.right = null;
	}
};

static Node pre = new Node(), suc = new Node();

// This function finds predecessor and
// successor of key in BST. It sets pre
// and suc as predecessor and successor
// respectively
static void findPreSuc(Node root, int key)
{
	
	// Base case
	if (root == null)
		return;

	// If key is present at root
	if (root.key == key)
	{
		
		// The maximum value in left
		// subtree is predecessor
		if (root.left != null)
		{
			Node tmp = root.left;
			while (tmp.right != null)
				tmp = tmp.right;
				
			pre = tmp;
		}

		// The minimum value in
		// right subtree is successor
		if (root.right != null)
		{
			Node tmp = root.right;
			
			while (tmp.left != null)
				tmp = tmp.left;
				
			suc = tmp;
		}
		return;
	}

	// If key is smaller than
	// root's key, go to left subtree
	if (root.key > key)
	{
		suc = root;
		findPreSuc(root.left, key);
	}
	
	// Go to right subtree
	else
	{
		pre = root;
		findPreSuc(root.right, key);
	}
}

// A utility function to insert a
// new node with given key in BST
static Node insert(Node node, int key)
{
	if (node == null)
		return new Node(key);
	if (key < node.key)
		node.left = insert(node.left, key);
	else
		node.right = insert(node.right, key);
		
	return node;
}

// Driver code
public static void main(String[] args)
{
	
	// Key to be searched in BST
	int key = 65;

	/*
	* Let us create following BST
	*		 50
	*		 / \
	*	 30 70
	*	 / \ / \
	*	 20 40 60 80
	*/

	Node root = new Node();
	root = insert(root, 50);
	insert(root, 30);
	insert(root, 20);
	insert(root, 40);
	insert(root, 70);
	insert(root, 60);
	insert(root, 80);

	findPreSuc(root, key);
	if (pre != null)
		System.out.println("Predecessor is " + pre.key);
	else
		System.out.println("No Predecessor");

	if (suc != null)
		System.out.println("Successor is " + suc.key);
	else
		System.out.println("No Successor");
}
}

// This code is contributed by sanjeev2552
