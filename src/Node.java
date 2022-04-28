
public class Node 
{

	private int data;
	protected Node next;
	
	public Node(int num)
	{
		this.data = num;
	}
	
	public int getData()
	{
		return this.data;
	}
	
	public void setData(int num)
	{
		this.data = num;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public void setNext(Node node)
	{
		this.next = node;
	}
}
