package studyo.note;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import studyo.day.Day;
import studyo.subject.Subject;
import studyo.subjectday.enumeration.NoteTypeEnum;

@Document
public class Note {

	@Id
	private String id;

	private Day day;
	private Subject subject;
	private NoteTypeEnum type;
	private String text;
	private String annexUrl;
	private String link;

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public NoteTypeEnum getType() {
		return type;
	}

	public void setType(NoteTypeEnum type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnnexUrl() {
		return annexUrl;
	}

	public void setAnnexUrl(String annexUrl) {
		this.annexUrl = annexUrl;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
