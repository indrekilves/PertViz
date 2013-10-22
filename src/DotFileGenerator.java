import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @(#) DotFileGenerator.java
 */
public class DotFileGenerator
{
	private TaskCollection taskCollection;
//	
//	private String outputFileName;
//	
	private BufferedWriter bw;
	
	public void generateDotFile( TaskCollection tc, String outputFileName )
	{
		try {
			 
			File file = new File(outputFileName);
 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			this.bw = new BufferedWriter(fw);
			this.taskCollection = tc;
			
			writeDotFile();
			
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeDotFile() throws IOException {
		bw.write("digraph simplePERT {");
		
		boolean isFirst = true;

		Integer i = 0;
		for (Task task : this.taskCollection.getTasks()) {
			i++;
			bw.newLine();
			
			if (isFirst){
				bw.write("s[shape=polygon, sides=4, label='" + task.getName() + "']");
				isFirst = false;
			}
			else {
				bw.write("n" + i.toString() + "[shape=polygon, sides=4, label='" + task.getName() + "']");
			}
			
		}		
		
		bw.write("}");
	}
	
	
}
