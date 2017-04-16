package sort;
import java.util.ArrayList;

public class RadixSort implements SortArrayList
{
	public String toString()
	{
		return "Radix Sort";
	}
	
	public void ascend(ArrayList<Integer> input) {
		boolean isIncreasing = true;
		radixSortArrayList(input, isIncreasing);
	}

	public void descend(ArrayList<Integer> input) {
		boolean isIncreasing = false;
		radixSortArrayList(input, isIncreasing);
	}
	
	private void radixSortArrayList(ArrayList<Integer> input,boolean isIncreasing)
	{
		int maxElemLength = maxDigitLength(input);
		ArrayList<ArrayList<String>> storeEachPass = new ArrayList<ArrayList<String>>();		
		for(int i = 0; i < 10; i++)
		{
			storeEachPass.add(new ArrayList<String>());
		}
		ArrayList<String> outputFromPaddingZeros = paddingZeros(maxElemLength, input);
		while(maxElemLength > 0)
		{
			
			for(int i = 0; i < 10; i++)
			{
				storeEachPass.get(i).clear();
			}
			for(int i = 0 ; i < outputFromPaddingZeros.size(); i++)
			{
				 String var  = outputFromPaddingZeros.get(i);
				 char c =var.charAt(maxElemLength - 1);
				 for(int j = 0; j < 10; j++)
				 {					 
					 if(Character.getNumericValue(c) == j)
					 {
						 storeEachPass.get(j).add(outputFromPaddingZeros.get(i));
					 }
				 }
			}
		
			maxElemLength--;
			outputFromPaddingZeros.clear();
			for(ArrayList<String> stringList: storeEachPass)
			{
				outputFromPaddingZeros.addAll(stringList);
			}
		}
		
		input.clear();
		if(isIncreasing)
		{
			for(int i = 0; i < outputFromPaddingZeros.size(); i++)
			{
				input.add(Integer.valueOf(outputFromPaddingZeros.get(i)));
			}
		}
		else
		{
			for(int i = outputFromPaddingZeros.size()-1; i >= 0; i--)
			{
				input.add(Integer.valueOf(outputFromPaddingZeros.get(i)));
			}
		}
	}
	
	private ArrayList<String> paddingZeros(int maxElemLength, ArrayList<Integer> input)
	{
		ArrayList<String> intermediateInput = new ArrayList<String>();
		for(int i = 0; i < input.size(); i++)
		{
			String str = String.format("%0"+maxElemLength+"d", input.get(i).intValue());  // 0009  
			intermediateInput.add(str);
		}
		return intermediateInput;
	}
	
	private int maxDigitLength(ArrayList<Integer> input)
	{
		int maxElemLength = 0;
		for(int i = 0; i < input.size(); i++)
		{
			int elem = input.get(i).intValue();
			int currElemLength = String.valueOf(elem).length();
			if(maxElemLength < currElemLength)
			{
				maxElemLength = currElemLength;
			}							
		}
		return maxElemLength;
	}
}
