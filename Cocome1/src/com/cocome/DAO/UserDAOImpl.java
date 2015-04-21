package com.cocome.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;

public class UserDAOImpl implements UserDAO {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;


	public UserDAOImpl() throws ClassNotFoundException, SQLException {
		db_connection = DBConnection_Singleton.getInstance().getDBConnection();
	}

	@Override
	public User getUserDetails(String user_id) throws SQLException {
		// TODO Auto-generated method stub
		User user = null;
		query = "select * from  user where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			user = new User();
			user.setUser_id(user_id);
			user.setStatus(result.getString("status"));
			user.setFirst_name(result.getString("first_name"));
			user.setLast_name(result.getString("last_name"));
			user.setLogin_status(result.getInt("login_status"));
			
			user.setDate_of_birth(result.getDate("date_of_birth"));
			user.setGender(result.getString("gender"));
			user.setPhone_number(result.getString("phone_number"));
			user.setLocation(result.getString("location"));
			user.setProfession(result.getString("profession"));
			user.setEducation(result.getString("education"));
			user.setHobby(result.getString("hobby"));
			user.setAbout_me(result.getString("about_me"));
			user.setLinkedin_handle(result.getString("linkedin_handle"));
			user.setLast_update(result.getTimestamp("last_update"));
			user.setRel_stat(result.getString("rel_stat"));
			user.setLogout_time(result.getTimestamp("logout_time"));

			// user.setImage(result.getString("image"));
		}

		query = "select count(friend_user_id) as count from friends where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			user.setCount_of_friends(rs.getInt("count"));
		} else {
			user.setCount_of_friends(0);
		}

		query = "select count(request_from) as count from friend_requests where request_to=? and approved=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		statement.setInt(2, 0);
		ResultSet rs1 = statement.executeQuery();
		if (rs1.next()) {
			user.setPending_friend_requests(rs1.getInt("count"));
		}
		statement.close();
		return user;
	}

	@Override
	public boolean insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		query = "insert into user(user_id,status,first_name,last_name,login_status,date_of_birth,gender,phone_number,location,profession,education,hobby,about_me,linkedin_handle,last_update,rel_stat) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user.getUser_id());
		statement.setString(2, user.getStatus());
		statement.setString(3, user.getFirst_name());
		statement.setString(4, user.getLast_name());
		statement.setInt(5, user.getLogin_status());		
		statement.setDate(6, user.getDate_of_birth());
		statement.setString(7, user.getGender());
		statement.setString(8, user.getPhone_number());
		statement.setString(9, user.getLocation());
		statement.setString(10, user.getProfession());
		statement.setString(11, user.getEducation());
		statement.setString(12, user.getHobby());
		statement.setString(13, user.getAbout_me());
		statement.setString(14, user.getLinkedin_handle());
		statement.setTimestamp(15, user.getLast_update());
		statement.setString(16, user.getRel_stat());
		// statement.setString(18, user.getImage());
		// try {
		// FileInputStream fin = new
		// FileInputStream("C:\\Users\\NiharKhetan\\Downloads\\nkhetan.jpg");
		// statement.setBinaryStream(18, fin, fin.available());
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		int val = statement.executeUpdate();
		statement.close();
		if (val > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		query = "update user set first_name=?,last_name=?,gender=?,phone_number=?,location=?,profession=?,education=?,hobby=?,about_me=?,linkedin_handle=?,last_update=?,rel_stat=? where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user.getFirst_name());
		statement.setString(2, user.getLast_name());
		statement.setString(3, user.getGender());
		statement.setString(4, user.getPhone_number());
		statement.setString(5, user.getLocation());
		statement.setString(6, user.getProfession());
		statement.setString(7, user.getEducation());
		statement.setString(8, user.getHobby());
		statement.setString(9, user.getAbout_me());
		statement.setString(10, user.getLinkedin_handle());
		statement.setTimestamp(11, user.getLast_update());
		statement.setString(12, user.getRel_stat());
		statement.setString(13, user.getUser_id());
		int val = statement.executeUpdate();
		statement.close();
		if (val > 0)
			return true;
		else
			return false;
	}
    
    @Override
	public boolean updateSignout(User user) throws SQLException {
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp time = new java.sql.Timestamp(today.getTime());
		query="update user set logout_time=?,login_status=0 where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setTimestamp(1,time);
		statement.setString(2,user.getUser_id());
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}
    
    @Override
	public boolean updateLoginStatus(User user) throws SQLException {
		query="update user set login_status=1 where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1,user.getUser_id());
		int val=statement.executeUpdate();
		statement.close();
		if(val>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteUser(String user_id) throws SQLException {
		// TODO Auto-generated method stub
		query = "delete from user where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		int val = statement.executeUpdate();
		statement.close();
		if (val > 0)
			return true;
		else
			return false;
	}

	public String getFirstLastNameOfUser(String user_id) throws SQLException {
		query = "select * from user where user_id=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs3 = statement.executeQuery();
		if (rs3.next()) {

			return (rs3.getString("first_name") + " " + rs3
					.getString("last_name"));

		} else {
			return user_id;
		}
	}
	

	
	public List<User> getAllUsersByFirstName(String firstName) throws SQLException{
		User user = null;
		List<User> userList=new ArrayList<User>();
		Map session = ActionContext.getContext().getSession();
		User userFromSession=(User) session.get("user");
		query="select * from user where first_name like '%"+firstName+"%' and user_id!=?";
		statement = (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, userFromSession.getUser_id());
		ResultSet result = statement.executeQuery();
		while(result.next()){
			user = new User();
			user.setUser_id(result.getString("user_id"));
			user.setStatus(result.getString("status"));
			user.setFirst_name(result.getString("first_name"));
			user.setLast_name(result.getString("last_name"));
			user.setLogin_status(result.getInt("login_status"));

			user.setDate_of_birth(result.getDate("date_of_birth"));
			user.setGender(result.getString("gender"));
			user.setPhone_number(result.getString("phone_number"));
			user.setLocation(result.getString("location"));
			user.setProfession(result.getString("profession"));
			user.setEducation(result.getString("education"));
			user.setHobby(result.getString("hobby"));
			user.setAbout_me(result.getString("about_me"));
			user.setLinkedin_handle(result.getString("linkedin_handle"));
			user.setLast_update(result.getTimestamp("last_update"));
			user.setRel_stat(result.getString("rel_stat"));
			user.setLogout_time(result.getTimestamp("logout_time"));
			userList.add(user);
		}
		return userList;
		
	}
}
