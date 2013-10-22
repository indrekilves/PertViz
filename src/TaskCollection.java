/**
 * @(#) TaskCollection.java
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @(#) TaskCollection.java
 */
public class TaskCollection
{
	private java.util.List<Task> tasks;
	
	public TaskCollection() {
		this.tasks = new ArrayList<Task>();
	}

	public void addTask( Task task )
	{
		this.tasks.add(task);		
	}
	
	public void deleteTaskByID( Integer taskID )
	{
		
	}
	
	public void setTasks( List<Task> tasks )
	{
		this.tasks=tasks;
	}
	
	public List<Task> getTasks( )
	{
		return tasks;
	}

	public Task getTaskByID(Integer id) {
		
		for (Task task : this.tasks) {
			if (task.getID() == id)
				return task;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer("TaskCollection [tasks=");
		for (Task task : this.tasks) {
			s.append(task.toString() + ",");
		}
		s.append("]");
		return s.toString();		
	}
	

	

}
