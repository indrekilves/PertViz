import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
		bw.newLine();
		
		Task startTask = null;
		Task endTask = null;
		HashMap<Integer, String> nodeTasks = new HashMap<Integer, String>();
		
		// nodes
		boolean isFirst = true;
		Integer i = 0;
		for (Task task : this.taskCollection.getTasks()) {
			i++;
			bw.newLine();
			startTask = task;
			
			if (isFirst){
				bw.write("s[shape=polygon, sides=4, label='" + task.getName() + "']");
				isFirst = false;
				nodeTasks.put(task.getID(), "s");

			}
			else {
				bw.write("n" + i.toString() + "[shape=polygon, sides=4, label='" + task.getName() + "']");
				endTask = task;
				nodeTasks.put(task.getID(), "n" + i.toString() );

			}
			
		}	
		bw.newLine();
		bw.newLine();
		bw.write("e[shape=polygon, sides=4, label='" + endTask.getName() + "']");

		// links 
//		bw.newLine();
//		i = 0;
//		for (Task task : this.taskCollection.getTasks()) {
//			i++;
//			bw.newLine();
//			// get first level children
//			String nodeId = nodeTasks.get(task.getID());
//			
//			List <Task> childTasks = this.taskCollection.getChildTasksByTask(task);
//			for (Task childTask : childTasks) {
//				String childNodeId = nodeTasks.get(childTask.getID());
//				bw.write(nodeId + " -> " + childNodeId + "[label='']");
//			}
//		}	
		
		bw.newLine();
		bw.write("}");
	}
	
	
}
