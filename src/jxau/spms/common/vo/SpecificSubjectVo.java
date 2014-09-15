package jxau.spms.common.vo;

/**
 * @author Lai Huiqiang
 * 2014-9-14
 * TODO 导师选题详细信息
 */
public class SpecificSubjectVo {

	private String tutorNo;
	private String tutorName;
	private int sex;
	private int age;
	private String major;
	private String telephone;
	private String nation;
	private String tutorTitle;
	private String eduBackground;
	private String college;
	private String subName;
	private String subSource;
	private String papLocation;
	private String subType;
	private String subPosition;
	private String subBrief;
	
	public String getTutorNo() {
		return tutorNo;
	}
	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getTutorTitle() {
		return tutorTitle;
	}
	public void setTutorTitle(String tutorTitle) {
		this.tutorTitle = tutorTitle;
	}
	public String getEduBackground() {
		return eduBackground;
	}
	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubSource() {
		return subSource;
	}
	public void setSubSource(String subSource) {
		this.subSource = subSource;
	}
	public String getPapLocation() {
		return papLocation;
	}
	public void setPapLocation(String papLocation) {
		this.papLocation = papLocation;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getSubPosition() {
		return subPosition;
	}
	public void setSubPosition(String subPosition) {
		this.subPosition = subPosition;
	}
	public String getSubBrief() {
		return subBrief;
	}
	public void setSubBrief(String subBrief) {
		this.subBrief = subBrief;
	}
	@Override
	public String toString() {
		return "SpecificSubjectVo [tutorNo=" + tutorNo + ", tutorName="
				+ tutorName + ", sex=" + sex + ", age=" + age + ", major="
				+ major + ", telephone=" + telephone + ", nation=" + nation
				+ ", tutorTitle=" + tutorTitle + ", eduBackground="
				+ eduBackground + ", college=" + college + ", subName="
				+ subName + ", subSource=" + subSource + ", papLocation="
				+ papLocation + ", subType=" + subType + ", subPosition="
				+ subPosition + ", subBrief=" + subBrief + "]";
	}
	
}
