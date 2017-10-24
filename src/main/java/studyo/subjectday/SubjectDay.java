package studyo.subjectday;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import studyo.day.enumeration.WeekDayEnum;
import studyo.subject.Subject;

@Document
public class SubjectDay {

	@Id
	private String id;

	private WeekDayEnum day; 

	private Subject subject;

	private LocalTime startTime;
	private LocalTime endTime;
	
	public WeekDayEnum getDay() {
		return day;
	}

	public void setDay(WeekDayEnum day) {
		this.day = day;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
}
