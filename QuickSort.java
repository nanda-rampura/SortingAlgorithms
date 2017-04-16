package sort;
import java.util.ArrayList;

public class QuickSort implements SortArrayList
{		
	public String toString()
	{
		return "Quick Sort (Iterative)";
	}
	
	public void ascend(ArrayList<Integer> input) {
		boolean isIncreasing = true;
		sort(input, 0, input.size() - 1, isIncreasing);	
	}

	public void descend(ArrayList<Integer> input) {
		boolean isIncreasing = false;
		sort(input, 0, input.size() - 1, isIncreasing);	
	}
	
	private void sort(ArrayList<Integer> input, int low, int high, boolean isIncreasing)
	{
		ArrayList<Boundary> boundary1 = new ArrayList<Boundary>();	 	
		boundary1.add(new Boundary(low, high));
		do
		{
			ArrayList<Boundary> boundary2 = new ArrayList<Boundary>();
			for(Boundary i: boundary1)
			{
				if(i.getLow() < i.getHigh())
				{
				 int pivot = partition(input, i.getLow(), i.getHigh(), isIncreasing);
				 boundary2.add(new Boundary(i.getLow(), pivot-1));
				 boundary2.add(new Boundary(pivot+1, i.getHigh()));
				}
			}
			boundary1 = boundary2;
		}while(!boundary1.isEmpty());
	}
	
	private int partition(ArrayList<Integer> input, int low, int high, boolean isIncreasing)
	{
		int wall = low-1;
		int pivot = input.get(high);
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
		
	private class Boundary
	{
		private int low;
		private int high;
		
		Boundary(int low, int high)
		{
			this.low = low;
			this.high = high;
		}
		public int getLow() {
			return low;
		}
		public int getHigh() {
			return high;
		}
	}
}
