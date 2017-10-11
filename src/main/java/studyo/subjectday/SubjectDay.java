package studyo.subjectday;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;

import studyo.day.Day;
import studyo.subject.Subject;

public class SubjectDay {

	@Id
	private String id;

	private Day day;
	private Subject subject;

	private LocalTime startTime;
	private LocalTime endTime;

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
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
