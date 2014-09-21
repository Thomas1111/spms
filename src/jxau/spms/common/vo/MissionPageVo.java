package jxau.spms.common.vo;

public class MissionPageVo {

	private int first;	//第一个missionNo位置
	private int last;	
	private int number;
	private int currentNo;
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.last = (first + number - 1);
		this.number = number;
	}
	public int getCurrentNo() {
		return currentNo;
	}
	public void setCurrentNo(int currentNo) {
		this.currentNo = currentNo;
	}
	@Override
	public String toString() {
		return "MissionPageVo [first=" + first + ", last=" + last + ", number="
				+ number + ", currentNo=" + currentNo + "]";
	}
	
}
