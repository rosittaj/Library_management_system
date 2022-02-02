package com.clientserver.dto;

public class IssueBook {
	private int idissuebook;
	private String issuedate;
	private String returndate;
	private String idbook;
	private String person_id;
	private String first_name;
	private String phone;
	private String issueid;
	private String status;
	private int fineamount;
	
	
	
	public int getFineamount() {
		return fineamount;
	}
	public void setFineamount(int fineamount) {
		this.fineamount = fineamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIssueid() {
		return issueid;
	}
	public void setIssueid(String issueid) {
		this.issueid = issueid;
	}
	public int getIdissuebook() {
		return idissuebook;
	}
	public void setIdissuebook(int idissuebook) {
		this.idissuebook = idissuebook;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getIdbook() {
		return idbook;
	}
	public void setIdbook(String bid) {
		this.idbook = bid;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

}
