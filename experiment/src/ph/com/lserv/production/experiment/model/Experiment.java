package ph.com.lserv.production.experiment.model;

import java.sql.Date;

public class Experiment {
	Integer primaryKey;
	Date time_from, time_to;
	String time_diff;
	
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Date getTime_from() {
		return time_from;
	}
	public void setTime_from(Date time_from) {
		this.time_from = time_from;
	}
	public Date getTime_to() {
		return time_to;
	}
	public void setTime_to(Date time_to) {
		this.time_to = time_to;
	}
	public String getTime_diff() {
		return time_diff;
	}
	public void setTime_diff(String time_diff) {
		this.time_diff = time_diff;
	}
	public Experiment(Integer primaryKey, Date time_from, Date time_to, String time_diff) {
		this.primaryKey = primaryKey;
		this.time_from = time_from;
		this.time_to = time_to;
		this.time_diff = time_diff;
	}
	
	public Experiment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
