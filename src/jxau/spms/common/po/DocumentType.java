package jxau.spms.common.po;

/**
 * @author Lai Huiqiang
 * 2014-9-20
 * TODO 学生上传文件类型
 */
public class DocumentType {

	private int documentNo;
	private String documentType;
	
	public int getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(int documentNo) {
		this.documentNo = documentNo;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	@Override
	public String toString() {
		return "DocumentType [documentNo=" + documentNo + ", documentType="
				+ documentType + "]";
	}
	
}
