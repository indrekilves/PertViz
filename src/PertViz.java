import java.io.IOException;
import java.util.Scanner;

/**
 * @(#) PertViz.java
 */
public class PertViz {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to PertViz - *.pert to *.dot converter.");
		System.out.println("Enter location of *.pert file (input):");
		String inputFile = in.nextLine();
		System.out.println("Enter location of *.dot file (output):");
		String outputFile =  in.nextLine();

		
		try {

			TaskParser parser = new TaskParser();
			System.out.println("Parsing pert file " + inputFile);
			TaskCollection tc;
			tc = parser.parseTasksFromFile(inputFile);

			System.out.println("Generating dot file " + outputFile);
			DotFileGenerator dfg = new DotFileGenerator();
			dfg.generateDotFile(tc, outputFile);

			System.out.println("Dot file generated.");

		} catch (IOException e) {
			System.out.println("Error parsing file " + e.getMessage());
			e.printStackTrace();
		}

	}

}
