package com.bigdata2017.jdbc.bookshop.vo;

public class AuthorVo {
	private Long no;
	private String name;
	private String profile;

	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "AuthorVO [no=" + no + ", name=" + name + ", profile=" + profile + "]";
	}
}