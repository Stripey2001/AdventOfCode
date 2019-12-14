import java.util.Arrays;
class Day04_1
{
	public static void main(String[] args)
	{
		int lowerRange = 111111;
		int higherRange = 111134;
		int count = 0;
		boolean valid;
		for(int i = lowerRange; i < higherRange; i++){
			valid = CheckPassword(i);
			if(valid){
				count++;
			}
			System.out.print(i);
			System.out.println(valid);
		}
		System.out.println(count);
	}
	
	public static boolean CheckPassword(int password)
	{
		boolean valid = true;
		String passcode = Integer.toString(password);
		String[] passValues = passcode.split("");
		int[] Values = new int[passValues.length];
		for(int i = 0;i < passValues.length;i++){
			Values[i] = Integer.parseInt(passValues[i]);
		}
		int[] storedValues = Values;
		for(int i = 0; i < Values.length; i++){
			System.out.println(storedValues[i]);
		}
		Values = BubbleSort(Values);
		for(int i = 0; i < storedValues.length; i++){
			System.out.println(storedValues[i]);
		}
		for(int i = 0; i < Values.length; i++){
			//System.out.println(Values[i]);
			//System.out.println(storedValues[i]);
			if(Values[i] != storedValues[i]){
				valid = false;
			}
		}
		boolean testForDouble = false;
		if(valid){
			for(int i = 0; i < Values.length -1; i++){
				if(Values[i] == Values[i+1]){
					testForDouble = true;
				}
			}
			if(testForDouble == false){
				valid = false;
			}
		}
		return valid;
	}
	
	public static int[] BubbleSort(int[] Values)
	{
		boolean Swapped = true;
		int temp;
		int j = 0;
		while (Swapped) {
			Swapped = false;
			j++;
			for (int i = 0; i < Values.length - j; i++){
				if (Values[i] > Values[i + 1]) {
					temp = Values[i];
					Values[i] = Values[i+1];
					Values[i+1] = temp;
					Swapped = true;
				}
			}
		}
		return Values;
	}



}