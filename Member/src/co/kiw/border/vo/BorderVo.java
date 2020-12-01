package co.kiw.border.vo;

import java.sql.Date;

public class BorderVo {
	private int borderId;
	private String borderWriter;
	private String borderTitle;
	private String borderContent;
	private Date borderDate;
	private int borderHit;
	
	public String getBorderTitle() {
		return borderTitle;
	}
	public void setBorderTitle(String borderTitle) {
		this.borderTitle = borderTitle;
	}
	public int getBorderId() {
		return borderId;
	}
	public void setBorderId(int borderId) {
		this.borderId = borderId;
	}
	public String getBorderWriter() {
		return borderWriter;
	}
	public void setBorderWriter(String borderWriter) {
		this.borderWriter = borderWriter;
	}
	public String getBorderContent() {
		return borderContent;
	}
	public void setBorderContent(String borderContent) {
		this.borderContent = borderContent;
	}
	public Date getBorderDate() {
		return borderDate;
	}
	public void setBorderDate(Date borderDate) {
		this.borderDate = borderDate;
	}
	public int getBorderHit() {
		return borderHit;
	}
	public void setBorderHit(int borderHit) {
		this.borderHit = borderHit;
	}
	
	

}
