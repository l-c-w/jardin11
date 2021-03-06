package com.jardin.shop11.Dto;

public class SearchingDto {

	private int curPage = 1;// 현재 페이지
	private String e_code;// 이벤트 코드
	private String option;// 검색 옵션
	private String search;// 검색어

	// 이벤트 분기용
	private String event_type;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public String getE_code() {
		return e_code;
	}

	public void setE_code(String e_code) {
		this.e_code = e_code;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

}
