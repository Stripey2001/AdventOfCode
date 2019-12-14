import java.io.*;
class Day02_1{
	public static void main(String[] args)
	{
		String fileName = "Day2.txt";
		String input = ReadFile(fileName);
		String[] inputs = input.split("\\,");
		int[] commands = new int[inputs.length];
		commands = Decode(inputs,commands);
		RunCommands(commands);
		System.out.println(commands[0]);
	}
	
	public static String ReadFile(String fileName)
	{
		String Line = null;
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
			Line = bufferedReader.readLine();
		} catch(IOException e) {
			System.out.println("IO ERROR");
		}
		return Line;
	}
	
	public static int[] Decode(String[] inputs, int[] commands)
	{
		for(int i = 0;i < inputs.length; i++){
			commands[i] = Integer.parseInt(inputs[i]);
		}
		return commands;
	}		
	
	public static void RunCommands(int[] commands)
	{
		for(int i = 0; i < commands.length; i++){
			for(int j = 0; j < commands.length; j++){
				System.out.print(commands[j] + ",");
			}
			System.out.println();
			if(commands[i] == 1){
				commands[commands[i+3]] = commands[commands[i + 1]] + commands[commands[i + 2]];
				i +=3;
			}else if(commands[i] == 2){
				commands[commands[i+3]] = commands[commands[i + 1]] * commands[commands[i + 2]];
				i += 3;
			}else if(commands[i] == 99){
				i = commands.length;
			}else{
				System.out.println("There was an error");
			}
		}
	}

}