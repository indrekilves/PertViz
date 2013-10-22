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
		HashMap<String, String> nodeTasks = new HashMap<String, String>();
		
		// nodes
		boolean isFirst = true;
		Integer i = 0;
		Integer nodeCnt = this.taskCollection.getTasks().size();
		for (Task task : this.taskCollection.getTasks()) {
			i++;
			bw.newLine();
			startTask = task;
			
			if (isFirst){
				bw.write("s[shape=polygon, sides=4, label=\" Task: " + task.getName() + " ("  + task.getDuration() + " days)\"]");
				isFirst = false;
				nodeTasks.put(task.getName(), "s");

			}
			else {
				// exclude last node
				if (i == nodeCnt){
					endTask = task;
					nodeTasks.put(task.getName(), "e" );
				}	
				else{
					bw.write("n" + i.toString() + "[shape=polygon, sides=4, label=\" Task: " + task.getName() + " ("  + task.getDuration() + " days)\"]");
					nodeTasks.put(task.getName(), "n" + i.toString() );
				}

			}
			
		}	
		bw.newLine();
		bw.newLine();
		bw.write("e[shape=polygon, sides=4, label=\" Task: " + endTask.getName() + " ("  + endTask.getDuration() + " days)\"]");

		// links 
		bw.newLine();
		i = 0;
		for (Task task : this.taskCollection.getTasks()) {
			i++;
			bw.newLine();
			// get first level children
			String nodeName = nodeTasks.get(task.getName());
			
			List <Task> childTasks = this.taskCollection.getChildTasksByTask(task);
			for (Task childTask : childTasks) {
				String childNodeId = nodeTasks.get(childTask.getName());
				bw.newLine();
				bw.write(nodeName + " -> " + childNodeId + "[label=\"\"]");
			}
		}	 
		
		bw.newLine();
		bw.write("}");
	}
	
	
}
