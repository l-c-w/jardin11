package com.jardin.shop11.Dto;

import java.sql.Date;

public class EventDto {

	public EventDto() {
	}

	public EventDto(String e_code, String e_name, String e_content, String file1, String file2, Date start_date,
			Date end_date) {
		this.e_code = e_code;
		this.e_name = e_name;
		this.e_content = e_content;
		this.file1 = file1;
		this.file2 = file2;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	private String e_code // 이벤트 코드
			, e_name // 이벤트 명
			, e_content// 이벤트 내용
			, file1 // 썸네일
			, file2; // 본문 이미지 파일

	private Date start_date // 이벤트 시작일
			, end_date; // 이벤트 종료일

	public String getE_code() {
		return e_code;
	}

	public void setE_code(String e_code) {
		this.e_code = e_code;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_content() {
		return e_content;
	}

	public void setE_content(String e_content) {
		this.e_content = e_content;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
