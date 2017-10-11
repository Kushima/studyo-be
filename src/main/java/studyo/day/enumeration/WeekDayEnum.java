package studyo.day.enumeration;

public enum WeekDayEnum {
	MON(0, "monday"),
	TUE(1, "tuesday"),
	WED(2, "wednesday"),
	THU(3, "thursday"),
	FRI(4, "friday"),
	SAT(5, "saturday"),
	SUN(6, "sunday");
	
	private Integer order;
	private String description;

	private WeekDayEnum(Integer order, String description) {
		this.order = order;
		this.description = description;
	}

	public Integer getOrder() {
		return order;
	}

	public String getDescricao() {
		return description;
	}
}
