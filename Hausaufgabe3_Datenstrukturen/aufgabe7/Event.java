package aufgabe7;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import aufgabe6.Account;

public class Event {

	private String eventname;
	private String location;
	private Calendar startTime;
	
	public Event(String eventname, String location, Calendar startTime) {
		this.eventname = eventname;
		this.location = location;
		this.startTime = startTime;
	}
	
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public String getFormatedStartTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		return sdf.format(startTime.getTime());
		
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		else if (obj == null) return false;
		else if (!(obj instanceof Account)) return false;
		
		Event other = (Event) obj;
		if (eventname == other.getEventname() && location == other.getLocation() && startTime == other.getStartTime()) return true;
		else return false;
	}
	
	
}
