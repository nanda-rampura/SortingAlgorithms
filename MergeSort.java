package sort;
import java.util.ArrayList;

public class MergeSort implements SortArrayList
{
	public String toString()
	{
		return "Merge Sort (Iterative)";
	}
	
	public void ascend(ArrayList<Integer> input) {
		boolean isIncreasing = true;
		mergeSortArrayList(input, isIncreasing);
	}

	public void descend(ArrayList<Integer> input) {
		boolean isIncreasing = false;
		mergeSortArrayList(input, isIncreasing);
	}
	
	private void mergeSortArrayList(ArrayList<Integer> input, boolean isIncreasing)
	{
		ArrayList<ArrayList<Integer>> mergeInputList = divide(input);
		ArrayList<ArrayList<Integer>> mergeOutputList = merge(mergeInputList, isIncreasing);
		input.clear();
		input.addAll(mergeOutputList.get(0));
	}
	
	private ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> mergeInputList, boolean isIncreasing)
	{
		ArrayList<ArrayList<Integer>> outputFromMerge;
		do
		{
			outputFromMerge = new ArrayList<ArrayList<Integer>>();
			for(int i = 0, j = i+1; j < mergeInputList.size() && i < mergeInputList.size(); i+=2, j+=2)
			{
				ArrayList<Integer> sortOutputList = sort(mergeInputList.get(i), mergeInputList.get(j), isIncreasing);
				outputFromMerge.add(sortOutputList);
			}
			
			if((mergeInputList.size() % 2) != 0)
			{
				outputFromMerge.add((mergeInputList.get((mergeInputList.size()) - 1)));
			}
			mergeInputList = outputFromMerge;
		}while(mergeInputList.size()!=1);
		return outputFromMerge;
	}
		
	private ArrayList<ArrayList<Integer>> divide(ArrayList<Integer> inputList)
	{
		ArrayList<ArrayList<Integer>> outputFromDivide = new ArrayList<ArrayList<Integer>>();
		for (Integer elem : inputList)
		{
			ArrayList<Integer> intermediateList = new ArrayList<Integer>(1);
			intermediateList.add(elem);
			outputFromDivide.add(intermediateList);
		}
		return outputFromDivide;		
	}

	private ArrayList<Integer> sort(ArrayList<Integer> list1, ArrayList<Integer> list2, boolean isIncreasing)
	{
		ArrayList<Integer> outputFromSort = new ArrayList<Integer>();
		int i = 0, j = 0;
		
		while((i < list1.size()) && (j < list2.size()))
		{
			int result = ((list1.get(i)).compareTo(list2.get(j)));
			if(result > 0 )
			{
				if(isIncreasing)
				{
					outputFromSort.add(list2.get(j));
					j++;
				}
				else
				{
					outputFromSort.add(list1.get(i));
					i++;
				}
			}
			else if(result < 0)
			{
				if(isIncreasing)
				{
					outputFromSort.add(list1.get(i));
					i++;
				}
				else
				{
					outputFromSort.add(list2.get(j));
					j++;	
				}
			}
			else
			{
				outputFromSort.add(list2.get(j));
				j++;
			}
		}
		if(i == list1.size())
		{
			for(int k = j; k < list2.size(); k++)
			{
				outputFromSort.add(list2.get(k));
			}
		}
		else if(j == list2.size())
		{
			for(int l = i; l < list1.size(); l++)
			{
				outputFromSort.add(list1.get(l));
			}
		}
		return outputFromSort;
	}	
}

