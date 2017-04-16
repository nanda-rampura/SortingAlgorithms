package sort;
import java.util.ArrayList;

public class SelectionSort implements SortArrayList
{
	public String toString()
	{
		return "Selection Sort";
	}
	
	public void ascend(ArrayList<Integer> input) {
		boolean isIncreasing = true;
		selectionSort(input, isIncreasing);	
	}

	public void descend(ArrayList<Integer> input) {
		boolean isIncreasing = false;
		selectionSort(input, isIncreasing);	
	}
	
	private void selectionSort(ArrayList<Integer> input, boolean isIncreasing)
	{
		for(int i = 0; i < input.size(); i++)
		{
			int min = 0;
			min = i;
			for(int j = i+1; j < input.size(); j++)
			{
				if(((input.get(min) > input.get(j)) && (isIncreasing == true))
				|| ((input.get(min) < input.get(j)) && (isIncreasing == false)))
				{
					min = j;
				}
			}
			int temp;
			temp = input.get(i);
			input.set(i, input.get(min));
			input.set(min, temp);
		}	
	}
}