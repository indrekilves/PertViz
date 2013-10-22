/**
 * @(#) PrecedenceRelation.java
 */
public class PrecedenceRelation
{

	private Task toTask;
	
	public void setToTask( Task toTask )
	{
		this.toTask=toTask;
	}
	
	public Task getToTask( )
	{
		return toTask;
	}
	
	public void setDurationInDays( Integer durationInDays )
	{
		
	}
	
	@Override
	public String toString() {
		return "PrecedenceRelation [toTask=" + toTask + "]";
	}

}
