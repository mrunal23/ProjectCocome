package com.cocome.DAO;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;

public class User {
	private String user_id;
	private String status;
	private String first_name;
	private String last_name;
	private int login_status;
	private Timestamp last_login_time;
	private Date date_of_birth;
	private String gender;
	private String phone_number;
	private String location;
	private String profession;
	private String education;
	private String hobby;
	private String rel_stat;
	private String about_me;
	private String linkedin_handle;
	private Timestamp last_update;
	private Timestamp logout_time;
	private int count_of_friends;
	private int pending_friend_requests;

	//private File image;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getLogin_status() {
		return login_status;
	}
	public void setLogin_status(int login_status) {
		this.login_status = login_status;
	}
	public Timestamp getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location= location;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getAbout_me() {
		return about_me;
	}
	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	public String getLinkedin_handle() {
		return linkedin_handle;
	}
	public void setLinkedin_handle(String linkedin_handle) {
		this.linkedin_handle = linkedin_handle;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public String getRel_stat() {
		return rel_stat;
	}
	public void setRel_stat(String rel_stat) {
		this.rel_stat = rel_stat;
	}
//	public File getImage() {
//		return image;
//	}
//	public void setImage(File image) {
//		this.image = image;
//	}
	public Timestamp getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(Timestamp logout_time) {
		this.logout_time = logout_time;
	}
	public int getCount_of_friends() {
		return count_of_friends;
	}
	public void setCount_of_friends(int count_of_friends) {
		this.count_of_friends = count_of_friends;
	}
	public int getPending_friend_requests() {
		return pending_friend_requests;
	}
	public void setPending_friend_requests(int pending_friend_requets) {
		this.pending_friend_requests = pending_friend_requets;
	}

	
}
