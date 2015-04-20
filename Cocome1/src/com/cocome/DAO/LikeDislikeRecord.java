package com.cocome.DAO;

import java.sql.Timestamp;

public class LikeDislikeRecord {
int id;
int entity_type;
int entity_id;
String user_id;
boolean like;
boolean dislike;
Timestamp timestamp;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getEntity_type() {
	return entity_type;
}
public void setEntity_type(int entity_type) {
	this.entity_type = entity_type;
}
public int getEntity_id() {
	return entity_id;
}
public void setEntity_id(int entity_id) {
	this.entity_id = entity_id;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public boolean isLike() {
	return like;
}
public void setLike(boolean like) {
	this.like = like;
}
public boolean isDislike() {
	return dislike;
}
public void setDislike(boolean dislike) {
	this.dislike = dislike;
}
public Timestamp getTimestamp() {
	return timestamp;
}
public void setTimestamp(Timestamp timestamp) {
	this.timestamp = timestamp;
}


}
