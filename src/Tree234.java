import java.util.ArrayList;

class Tree234 {
	
   public Node root = new Node();
   public ArrayList<Long> myList = new ArrayList<Long>();
   
   public int find(long key) {
      Node curNode = root;
      int childNumber;
      while(true) {
         if((childNumber=curNode.findItem(key)) != -1) {
            return childNumber;
         }
         else if(curNode.isLeaf()) {
            return -1;  
         }
         else {
            curNode = getNextChild(curNode, key);
         }
       }
    }

   public void insert(long dValue) {
      Node curNode = root;
      DataItem tempItem = new DataItem(dValue);

      while(true) {
    	  if( curNode.isFull()) {
    		  split(curNode);
    		  curNode = curNode.getParent();
    		  curNode = getNextChild(curNode, dValue);
           }

          else if( curNode.isLeaf()) {
        	  break;   
          }
          else {
        	  curNode = getNextChild(curNode, dValue);
          }
      }
      curNode.insertItem(tempItem);
    }

   public Node getNextChild(Node theNode, long theValue) {
	      int j;
	      int numItems = theNode.getNumItems();
	      for(j=0; j<numItems; j++) { 
	         if( theValue < theNode.getItem(j).dData ) {
	            return theNode.getChild(j);
	         }
	      }
	      return theNode.getChild(j);
   }
   
   public void split(Node n) {
      DataItem itemB;
      DataItem itemC;
      Node parent;
      Node child2;
      Node child3;
      int index;

      itemC = n.removeItem();
      itemB = n.removeItem();
      child2 = n.disconnectChild(2);
      child3 = n.disconnectChild(3);

      Node newRight = new Node();

	      if(n==root) {
	         root = new Node();
	         parent = root;
	         root.connectChild(0, n);
	      }
	      else {
	          parent = n.getParent();
	      }
	      
	      index = parent.insertItem(itemB);
	      int nn = parent.getNumItems();
	
	      for(int i=nn-1; i>index; i--) {                                   
	         Node temp = parent.disconnectChild(i);
	         parent.connectChild(i+1, temp);
	      }
	      parent.connectChild(index+1, newRight);
	      newRight.insertItem(itemC);
	      newRight.connectChild(0, child2);
	      newRight.connectChild(1, child3);
   }

   public void display() {
	   myList.clear();
       recDisplay(root, 0, 0);
       System.out.print("myAll: ");
       for(int i =0; i < myList.size(); i++)
    	   System.out.print(myList.get(i) + " ");
   }

   private void recDisplay(Node thisNode, int level, int childNumber) {
	   int numItems = thisNode.getNumItems();

	   for(int j=0; j<numItems + 1; j++) {
    	  	Node nextNode = thisNode.getChild(j);
    	  	
    	  	if(nextNode != null) {
    	  		recDisplay(nextNode, level+1, j);
    	  	}
    	  	else {
    	  		for(int i = 0; i < thisNode.getNumItems(); i ++)
    	  			myList.add(thisNode.getItem(i).dData);
    	  		return;
    	  	}
         
    	  	if(j < numItems) {
    	  		myList.add(thisNode.getItem(j).dData);
    	  	}
       }
    }  
}
   


   