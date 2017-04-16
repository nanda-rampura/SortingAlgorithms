package sort;
import java.util.ArrayList;
import java.util.ListIterator;

public class MergeSortRecursive implements SortArrayList
{
	public String toString()
	{
		return "Merge Sort (Recursive)";
	}
	
	public void ascend(ArrayList<Integer> input)
	{
		boolean isIncreasing = true;
		sort(input, isIncreasing);
	}
	
	public void descend(ArrayList<Integer> input)
	{
		boolean isIncreasing = false;
		sort(input, isIncreasing);
	}
	
	private void sort(ArrayList<Integer> input, boolean isIncreasing)
	{
		ArrayList<Integer> output = sortAndDivide(input, 0, input.size() - 1, isIncreasing);
		ListIterator<Integer> inputItr = input.listIterator();
		ListIterator<Integer> outputItr = output.listIterator();
		while(inputItr.hasNext())
		{
			inputItr.next();
			inputItr.set(outputItr.next());
		}		
	}

	private ArrayList<Integer> sortAndDivide(ArrayList<Integer> input, int lo, int hi, boolean isIncreasing)
	{
		if(lo == hi)
		{
			ArrayList<Integer> atomicElement = new ArrayList<Integer>();
			atomicElement.add(input.get(lo));
			return atomicElement;
		}
		else
		{
			int mid = (lo + hi) / 2;
			ArrayList<Integer> list1 = sortAndDivide(input, lo, mid, isIncreasing);
			ArrayList<Integer> list2 = sortAndDivide(input, mid+1, hi, isIncreasing);
			return merge(list1, list2, isIncreasing);
		}
	}

	private ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, boolean isIncreasing)
	{
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		int i = 0, j = 0;
		
		while((i < list1.size()) && (j < list2.size()))
		{
			int result = (isIncreasing == true)
				? ((list1.get(i)).compareTo(list2.get(j)))
				: ((list2.get(j)).compareTo(list1.get(i)));
			if(result > 0 )
			{
				mergedList.add(list2.get(j));
				j++;
			}
			else if(result < 0)
			{
				mergedList.add(list1.get(i));
				i++;
			}
			else
			{
				mergedList.add(list2.get(j));
				j++;
			}
		}
		if(i == list1.size())
		{
			for(int k = j; k < list2.size(); k++)
			{
				mergedList.add(list2.get(k));
			}
		}
		else if(j == list2.size())
		{
			for(int l = i; l < list1.size(); l++)
			{
				mergedList.add(list1.get(l));
			}
		}
		return mergedList;
	}
}