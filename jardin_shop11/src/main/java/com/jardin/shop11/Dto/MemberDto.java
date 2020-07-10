package com.jardin.shop11.Dto;

import java.sql.Date;

public class MemberDto {

	public MemberDto() {

	}

	public MemberDto(String name, String id, String pw, String email1, String email2, String mailreceive, String post,
			String address1, String address2, String phone1, String phone2, String phone3, String sms, Date virth,
			String byear, String bmonth, String bday, String birthtype) {

		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email1 = email1;
		this.email2 = email2;
		this.mailreceive = mailreceive;
		this.post = post;
		this.address1 = address1;
		this.address2 = address2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.byear = byear;
		this.bmonth = bmonth;
		this.bday = bday;
		this.sms = sms;
		this.birthtype = birthtype;

	}

	private String name, id // 회원 ID
			, pw // 비밀번호
			, email1 // 이메일 계정명
			, email2 // 이메일 도메인
			, mailreceive // 이메일 수신 동의
			, post // 우편번호
			, address1 // 주소
			, address2 // 상세주소
			, phone1 // 핸드폰 1
			, phone2// 핸드폰 2
			, phone3// 핸드폰 3
			, sms // sms수신 동의
			, byear // 생년
			, bmonth // 생월
			, bday // 생일
			, birthtype; // 음,양력

	private Date birth; // 생년월일

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getMailreceive() {
		return mailreceive;
	}

	public void setMailreceive(String mailreceive) {
		this.mailreceive = mailreceive;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getByear() {
		return byear;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public String getBmonth() {
		return bmonth;
	}

	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getBirthtype() {
		return birthtype;
	}

	public void setBirthtype(String birthtype) {
		this.birthtype = birthtype;
	}

}
