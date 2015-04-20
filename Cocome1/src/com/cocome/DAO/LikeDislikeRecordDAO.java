package com.cocome.DAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface LikeDislikeRecordDAO {
public boolean insert(int entity_type,int entity_id,String user_id,boolean like,boolean dislike) throws SQLException;
public boolean deleteUserActivity(String user_id,int entity_type,int entity_id,String activity) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikeQuestionsOfUserFriendsAfterTime(String user_id, Timestamp post_date) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikeAnswerssOfUserFriendsAfterTime(String user_id, Timestamp post_date) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikePostsOfUserFriendsAfterTime(String user_id, Timestamp post_date) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikeQuestionsOfUser(String user_id) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikeAnswerssOfUser(String user_id) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikePostsOfUser(String user_id) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikeQuestionsOfUserAfterTime(String user_id, Timestamp post_date) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikeAnswerssOfUserAfterTime(String user_id, Timestamp post_date) throws SQLException;
List<LikeDislikeRecord> getLikeDisLikePostsOfUserAfterTime(String user_id, Timestamp post_date) throws SQLException;
}
