package com.jardin.shop11.Dto;

import java.sql.Timestamp;

public class ReplyDto {

	public ReplyDto() {

	}

	public ReplyDto(String e_code, String id, String r_pw, String r_content, int r_number, Timestamp r_date) {
		this.e_code = e_code;
		this.id = id;
		this.r_pw = r_pw;
		this.r_content = r_content;
		this.r_number = r_number;
		this.r_date = r_date;
	}

	private String e_code, id, r_pw, r_content;
	private int r_number;
	private Timestamp r_date;

	public String getE_code() {
		return e_code;
	}

	public void setE_code(String e_code) {
		this.e_code = e_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getR_pw() {
		return r_pw;
	}

	public void setR_pw(String r_pw) {
		this.r_pw = r_pw;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public int getR_number() {
		return r_number;
	}

	public void setR_number(int r_number) {
		this.r_number = r_number;
	}

	public Timestamp getR_date() {
		return r_date;
	}

	public void setR_date(Timestamp r_date) {
		this.r_date = r_date;
	}

}
