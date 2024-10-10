import com.dsa.linkedlist.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(0);
		
		list.append(2);

		list.insert(1, 1);
		list.append(3);
		list.printList();
		
		list.reverse();
		list.printList();
		
	
	}
}
