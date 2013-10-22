/**
 * @(#) Task.java
 */
public class Task
{
	private String Name;
	
	private Integer ID;
	
	private Integer durationInDays;
	
	private PrecedenceRelation fromTask;
	
	public void setName( String name )
	{
		Name=name;
	}
	
	public String getName( )
	{
		return Name;
	}
	
	public void setID( Integer iD )
	{
		ID=iD;
	}
	
	public Integer getID( )
	{
		return ID;
	}
	
	public Integer getDurationInDays( )
	{
		return durationInDays;
	}
	
	public void setFromTask( PrecedenceRelation fromTask )
	{
		this.fromTask=fromTask;
	}
	
	public PrecedenceRelation getFromTask( )
	{
		return fromTask;
	}

	@Override
	public String toString() {
		return "Task [Name=" + Name + ", ID=" + ID + ", durationInDays="
				+ durationInDays + ", fromTask=" + fromTask + "]";
	}
	
	
}
