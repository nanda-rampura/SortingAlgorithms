package sort;
import java.util.ArrayList;

public class BubbleSort implements SortArrayList
{
	public String toString()
	{
		return "Bubble Sort";
	}
	
	public void ascend(ArrayList<Integer> input) {
		boolean isIncreasing = true;
		bubbleSort(input, isIncreasing);	
	}

	public void descend(ArrayList<Integer> input) {
		boolean isIncreasing = false;
		bubbleSort(input, isIncreasing);	
	}

	private void bubbleSort(ArrayList<Integer> input, boolean isIncreasing)
	{
		boolean swapped;
		do
		{
			swapped = false;
			for(int i = 0, j = i+1; j < input.size(); i++, j++)
			{
				if(((input.get(i) > input.get(j)) && (isIncreasing == true))
				|| ((input.get(i) < input.get(j)) && (isIncreasing == false)))
				{
					int temp;
					temp = input.get(i);
					input.set(i, input.get(j));
					input.set(j, temp);
					swapped = true;
				}
			}
		}while(swapped);
	}
}