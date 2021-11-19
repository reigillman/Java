package shelllab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * This PC is Windows and therefore I am using PB that executes cmd; this code will not run on other OS unless this is changed
 *
 */
public class Main {

	public static void main(String[] args) {
		Main letsgo=new Main();
		letsgo.commandInput();
	}
	public void commandInput() {
		ProcessBuilder pb= new ProcessBuilder();
		pb.command("cmd.exe", "/c", "dir");
		try {

			ArrayList<String> history= new ArrayList<String>(10);

			Process process = pb.start();
			//Scanner input = new Scanner(process.getInputStream());
			Scanner input = new Scanner(System.in);
			String previousLine= input.next();
			int num= 0;

			//System.out.println(process.exitValue()); //this should be 0 (just a test)
			history.add(input.next());
			if(history.size()==10) {
				history.remove(0);
				history.add(input.next());
			}

			while(input.hasNextLine()) {

				String repeat=input.next();

				if(previousLine.equals("exit")) {
					System.out.println("Exiting program...");
					System.exit(0);
				}
				else if(previousLine.equals("history")) {
					for(int i=0; i<history.size(); i++) {
						System.out.println(history.get(i));

					}
				}
				else if(previousLine.equals("!")) {
					repeat=previousLine;
					continue;
				}
				else if(previousLine.equals("!" + num)) {
					repeat=history.get(num);
					continue;
				}
				else {
					System.out.println("'" + previousLine + "'" + "is an invalid command");
					continue;
				}
				input.next();
				
				input= new Scanner(process.getErrorStream());
				boolean foundError= false;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	public void externalCommands() {

	}
}
