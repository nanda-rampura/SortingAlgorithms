package sort;
import java.util.ArrayList;

public class SortData<T>
{
	private ArrayList<T> savedInputData;
	
	public SortData(ArrayList<T> inData)
	{
		this.savedInputData = inData;
	}

	public ArrayList<T> getData()
	{
		ArrayList<T> newList = new ArrayList<T>(savedInputData);
		return newList;
	}
	
	public void printData()
	{
		for(T element: savedInputData)
		{
			System.out.print(element + " ");
		}
		System.out.println("");
	}
	
	public void printData(ArrayList<T> inData)
	{
		for(T element: inData)
		{
			System.out.print(element + " ");
		}
		System.out.println("");
	}	
}