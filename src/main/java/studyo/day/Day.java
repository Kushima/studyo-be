package studyo.day;

import java.util.List;

import org.springframework.data.annotation.Id;

import studyo.day.enumeration.WeekDayEnum;
import studyo.subjectday.SubjectDay;

//TODO: Talvez nao seja necessario
public class Day {

	//Dia em que se passa esse registro
	@Id
	private String id;

	private WeekDayEnum name;
	
	private List<SubjectDay> subjects;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WeekDayEnum getName() {
		return name;
	}

	public void setName(WeekDayEnum name) {
		this.name = name;
	}

	public List<SubjectDay> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectDay> subjects) {
		this.subjects = subjects;
	}

	
}
