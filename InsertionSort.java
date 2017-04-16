package sort;
import java.util.ArrayList;

public class InsertionSort implements SortArrayList
{
	public String toString()
	{
		return "Insertion Sort";
	}
	
	public void ascend(ArrayList<Integer> input) {
		boolean isIncreasing = true;
		insertionSort(input, isIncreasing);	
	}

	public void descend(ArrayList<Integer> input) {
		boolean isIncreasing = false;
		insertionSort(input, isIncreasing);	
	}
	
	private ArrayList<Integer> subSort(ArrayList<Integer> input, int i, boolean isIncreasing)
	{
		for(int k = i; k >0; k--)
		{
			if(((input.get(k) < input.get(k-1)) && isIncreasing == true)
			|| ((input.get(k) > input.get(k-1)) && isIncreasing == false))
			{
				int temp;
				temp = input.get(k);
				input.set(k, input.get(k-1));
				input.set(k-1, temp);
			}
		}
		return input;
	}
	
	private void insertionSort(ArrayList<Integer> input, boolean isIncreasing)
	{
		for(int i = 0, j = i+1; j < input.size(); i++, j++)
		{
			if(((input.get(i) > input.get(j)) && isIncreasing == true)
			|| ((input.get(i) < input.get(j) && isIncreasing == false)))
			{
				int temp;
				temp = input.get(i);
				input.set(i, input.get(j));
				input.set(j, temp);
				subSort(input, i, isIncreasing);
			}
		}
	}
}