/*
 * Name: Chase Callister
 * Assignment: 4
 * Class: CSE 205
 * Description: A data structure designed to solve the Josephus porblem.
 */
public class LinkedList 
{

	private static int size;
	private static Node head;
	private static Node tail;
	private static final int MAX = 100;
	
	public LinkedList(int num)
	{
		size = num;
		for (int i = 0; i < size; i++)
		{
			if (i == 0)
			{
				addToFront(i + 1);
			}
			else
				addToEnd(i + 1);
			 			
		}
	}
	
	/*
	 * Adds a node to the front of the list
	 */
	public void addToFront(int num)
	{
		Node node = new Node(num);
		node.next = head;
		head = node;
	}
	
	/*
	 * Adds a node to the end of the list
	 */
	public void addToEnd(int num)
	{
		Node node = new Node(num);
		if (head.next == null)
		{
			tail = node;
		    head.setNext(node);
		}
		else
		{
			tail.setNext(node);
		    tail = node;
		}	
		
	}
	
	/*
	 * Add a node a specified index
	 */
	public void addAtIndex(int value, int index)
	{
		Node node = new Node(value);
		Node current = head;
		Node previous = null;
		for (int i = 0; i < index; i++)
		{
			previous = current;
			current = current.next;
			if (i == index - 1)
			{
				previous.setNext(node);
			    node.next = current;
			}
		}
			
	}
	/*
	 * Deletes the node at the front of the list
	 */
	public void deleteFront()
	{
		head = head.next;
		size--;
	}
	
	/*
	 * Deletes node at the end of the list
	 */
	public void deleteEnd()
	{
		Node current = head;
		Node previous = null;
		for (int i = 0; i < size; i++)
		{
			previous = current;
			current = current.next;
			if (current.next == null)
			{
				previous.next = null;
				tail = previous;
				size--;
			}
				
		}
	}
	
	/*
	 * Deletes Node at specific index
	 */
	public static void deleteIndex(int index)
	{
		Node current = head;
		Node previous = null;
		if (index == 0)
		{
			head = head.next;
		}
		else
		{
			for (int i = 0; i < index; i++)
			{
				previous = current;
				current = current.next;
				if (i == index - 1)
				{
					previous.next = current.next;
					size--;
				}
			}
		}
	}
	
	/*
	 * Deletes node with matching data that occurs first
	 */
	public static void deleteFirst(LinkedList list, int value)
	{
		Node current = list.head;
		Node previous = null;
		
		for (int i = 0; i < MAX; i++)
		{
			if (current.next == null)
				return;
			if (value - 1 == 0 && head != null || value - 1 < 0)
			{
				list.head = current.next;
				return;
			}
			if (i == value - 1)
			{
				previous.next = current.next;
			}
			previous = current;
			current = current.next;
		}
		list.size--;
	}
	
	/*
	 * Deletes the entire list
	 */
	public void empty()
	{
		head.next = null;
		head = null;
	}
	
	/*
	 * Verifies if a specific node exists within the list
	 */
	public static boolean contains(LinkedList list , int num)
	{
		Node current = list.head;
		Node previous = null;
		
		for (int i = 0; i < MAX; i++)
		{
			if (current.next == null)
				return false;
			if (current.getData() == num)
			{
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
		
	}
	/*
	 * Retrieves data from specified node
	 */
	public static int getData(LinkedList list, int index)
	{
		Node current = list.head;
		for (int i = 0; i < index; i++)
		{
			if (index <= 1)
			{
				return list.head.getData();
			}

			if (i == index - 1)
			{
				return current.getData();
			}
			current = current.next;
		}
		return -1;
	}
	
	public String toString(LinkedList list)
	{
		String str = "";
		Node current = list.head;
		while(current != null)
		{
			str += current.getData();
			if (current.next != null)
				str += " - ";
			current = current.getNext();
		}
		
		return str;
		
	}
	
}
