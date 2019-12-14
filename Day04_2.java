import java.util.Arrays;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;
class Day04_2
{
	public static void main(String[] args)
	{
		int lowerRange = 372304;
		int higherRange = 847060;
		int count = 0;
		boolean valid;
		for(int i = lowerRange; i <= higherRange; i++){
			valid = CheckPassword(i);
			if(valid){
				count++;
			}
			//System.out.print(i);
			//System.out.println(" " + valid);
		}
		int[] correct = new int[count];
		count = 0;
		for(int i = lowerRange; i <= higherRange; i++){
			valid = CheckPassword(i);
			if(valid){
				correct[count] = i;
				count++;

			}
			//System.out.print(i);
			//System.out.println(" " + valid);
		}
		for(int i = 0; i < correct.length; i++){
			System.out.println(correct[i]);
		}
		System.out.println(count);
	}
	
	public static boolean CheckPassword(int password)
	{
		boolean valid = true;
		String passcode = Integer.toString(password);
		String[] passValues = passcode.split("");
		int[] Values = new int[passValues.length];
		int[] storedValues = new int[passValues.length];
		for(int i = 0;i < passValues.length;i++){
			Values[i] = Integer.parseInt(passValues[i]);
			storedValues[i] = Integer.parseInt(passValues[i]);
		}
		Values = BubbleSort(Values);
		for(int i = 0; i < Values.length; i++){
			if(Values[i] != storedValues[i]){
				valid = false;
			}
		}
		boolean testForDouble = false;
		if(valid){
			for(int i = 0; i < Values.length -1; i++){
				if(Values[i] == Values[i+1]){
					if(i < 4 && i > 0){
						if(Values[i] == Values[i+2] || Values[i] == Values[i-1]){
							testForDouble = false;
						}else{
							testForDouble = true;
					}}else if(i == 4){
						if(Values[i] == Values[i-1]){
							testForDouble = false;
						}else{
							testForDouble = true;
						}
					}else if(i == 0){
						if(Values[i] == Values[i+2]){
							testForDouble = false;
						}else{
							testForDouble = true;
						}
					}
					else{
						testForDouble = true;
					}
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
