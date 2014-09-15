package jxau.spms.common.vo;

public class TaskInfoVo {

	private String subName;
	private String content;
	private String diagram;
	private String indicator;
	private String schedule;
	private String reference;
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDiagram() {
		return diagram;
	}
	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	@Override
	public String toString() {
		return "TaskInfoVo [subName=" + subName + ", content=" + content
				+ ", diagram=" + diagram + ", indicator=" + indicator
				+ ", schedule=" + schedule + ", reference=" + reference + "]";
	}
	
}
