
public class Time {

	private int hour, min;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public Time(int hour, int min) 
	{
		if(hour < 0 || hour >= 24 || min < 0 || min >= 60)
			System.out.println("Invalid time");
		else 
		{
		this.hour = hour;
		this.min = min;
		}
	}
	
	public int toMins() 
	{
		return this.hour*60 + this.min;
	}
	
	public boolean lessThan(Time other) 
	{
		return (this.toMins() < other.toMins());
	}
	
	public int timeSince(Time other) 
	{
		if(this.lessThan(other))
			return this.toMins() + (24*60 - other.toMins());
		else
			return this.toMins()-other.toMins();
	}
	
	@Override
	public String toString() 
	{
		String time;
		if(hour < 10 && min <10)
		 time = "0" + hour + ":" + "0" + min;
		else if(hour < 10)
		 time = "0" + hour + ":" + min;
		else if(min < 10)
		 time = "" + hour + ":" + "0" + min;
		else
			time = "" + hour + ":" + min;
		
		return time;
	}
	
}
