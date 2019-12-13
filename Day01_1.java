import java.io.*;
class Day01_1{
	public static void main(String[] args){
		String fileName = "Day1.txt";
		int Result = ReadFile(fileName);
		System.out.println("The Total is " + Result);
	}
	
	public static int ReadFile(String fileName){
		String Line = null;
		int Total = 0;
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
			while((Line = bufferedReader.readLine()) != null){
				int Mass = Integer.parseInt(Line);
				Total = Total + FuelRequired(Mass);}
		} catch (IOException e) {
			System.out.println("IO ERROR");}
		return Total;
	}
			
	public static int FuelRequired(int Mass){
		int Fuel = Mass/3;
		Fuel = Fuel - 2;
		return Fuel;
	}

}