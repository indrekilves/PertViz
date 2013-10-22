import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @(#) TaskParser.java
 */
public class TaskParser
{
	final static Charset ENCODING = StandardCharsets.UTF_8;

	
	public TaskCollection parseTasksFromFile( String pertFileName ) throws IOException
	{
		List<String> pertFileLines = readPertFile(pertFileName);
		
	    System.out.println("Pert file content: " + pertFileLines);

		return parseTasksFromLines(pertFileLines);
	}
	

	List<String> readPertFile(String pertFileName) throws IOException {
	    Path path = Paths.get(pertFileName);
	    return Files.readAllLines(path, ENCODING);
	  }
	
	
	private TaskCollection parseTasksFromLines(List<String> pertFileLines) {
		TaskCollection tc = new TaskCollection();
		
		for (String line : pertFileLines) {
			String[] parts = line.split(",");
			Task task = new Task();
			task.setID(Integer.parseInt(parts[0]));
			task.setName(parts[1]);
			
			
			for (int i = 2; i < parts.length; i++) {
				String parentTaskID = parts[i];
				
				Task parentTask = tc.getTaskByID(Integer.parseInt(parentTaskID));
				PrecedenceRelation parentTaskRel = new PrecedenceRelation();
				parentTaskRel.setToTask(parentTask);
				
				task.setFromTask(parentTaskRel);
			}
			
			tc.addTask(task);
		}
		
		System.out.println("Created " + tc.toString());
		return tc;
	}


	
}
