package sort;
import java.util.ArrayList;

public class TestSort {
	
	private static int length = 12;
	private static int randomNumberRange = 10*length;
	
	public static void main(String[] args)
	{		
		// Create a list of random values
		ArrayList<Integer> tempList = new ArrayList<Integer>(length);
		for(int i = 0; i < length; i++)
		{
			tempList.add((int)(Math.random()*randomNumberRange));
		}	
		SortData<Integer> data = new SortData<Integer>(tempList);
		System.out.print("Original Data: ");
		data.printData();
		System.out.println();
		
		ArrayList<SortArrayList> sortTypes = new ArrayList<SortArrayList>();
		sortTypes.add(new BubbleSort());
		sortTypes.add(new SelectionSort());
		sortTypes.add(new InsertionSort());
		sortTypes.add(new MergeSort());
		sortTypes.add(new MergeSortRecursive());
		sortTypes.add(new QuickSort());
		sortTypes.add(new QuickSortRecursive());
		sortTypes.add(new RadixSort());
		
		for (SortArrayList sort : sortTypes)
		{
			System.out.println(sort);
			ArrayList<Integer> ascendInput = data.getData();
			sort.ascend(ascendInput);
			System.out.print("Ascending: ");
			data.printData(ascendInput);
			
			ArrayList<Integer> descendInput = data.getData();
			sort.descend(descendInput);
			System.out.print("Descending: ");
			data.printData(descendInput);
			System.out.println();
		}
	}
}