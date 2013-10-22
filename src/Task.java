import java.util.List;

/**
 * @(#) Task.java
 */
public class Task {

	private String name;

	private String duration;
	
	private java.util.List<Task> parentTasks;

	public String getName( ) {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getDuration( ) {
		return duration;
	}

	public void setDuration( String duration ) {
		this.duration = duration;
	}

	public List getParentTasks( ) {
		return parentTasks;
	}

	public void setParentTasks( List parentTasks ) {
		this.parentTasks = parentTasks;
	}

	@Override
	public String toString( ) {
		String directParents = "(";

		if (parentTasks.isEmpty()) {
			for (Task parentTask : parentTasks) {
				if (parentTask != null) {
					directParents += " Name=" + parentTask.getName() + ",";
				}
			}
		} else {
			directParents += "none";
		}
		directParents += ")";

		return "Task [Name=" + name + ", Duration=" + duration + ",ParentIDs="
				+ directParents + "]";
	}

}
