package sort;
import java.util.ArrayList;

public class QuickSortRecursive implements SortArrayList
{
	public String toString()
	{
		return "Quick Sort (Recursive)";
	}
	
	public void ascend(ArrayList<Integer> input)
	{
		boolean isIncreasing = true;
		sort(input, 0, input.size() - 1, isIncreasing);
	}
	
	public void descend(ArrayList<Integer> input)
	{
		boolean isIncreasing = false;
		sort(input, 0, input.size() - 1, isIncreasing);
	}
	
	private void sort(ArrayList<Integer> input, int low, int high, boolean isIncreasing)
	{		
		if(low < high)
		{
			int pivot = partition(input, low, high, isIncreasing);
			sort(input, low, pivot - 1, isIncreasing);
			sort(input, pivot +1, high, isIncreasing);
		}
	}
	
	private int partition(ArrayList<Integer> input, int low, int high, boolean isIncreasing)
	{
		int pivot = input.get(high);
		int wall = low-1;
		int temp;
		for(int i = low; i < high; i++)
		{
			if ((isIncreasing == true && input.get(i) <= pivot)
				|| (isIncreasing == false && input.get(i) >= pivot))
				{
					wall++;
					temp = input.get(wall);
					input.set(wall, input.get(i));
					input.set(i, temp);
				}
		}		
		wall++;
		temp = input.get(wall);
		input.set(wall, pivot);
		input.set(high, temp);
		return wall;
	}	
}