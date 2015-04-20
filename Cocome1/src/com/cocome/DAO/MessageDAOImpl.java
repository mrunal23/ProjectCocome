package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/*
 * @Coded By Mrunal
Do not make any changes
Action class for operation on messages
*
*/
public class MessageDAOImpl implements MessageDAO{

	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	
	//constructor
	public MessageDAOImpl() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}
	
	//to fetch a list of messages on document load
	@Override
	public List<MessageFetch> fetchMessages(String uid) throws SQLException {
		// TODO Auto-generated method stub
		//List<String> messages = new ArrayList<String>();
		List<MessageFetch> messages = new ArrayList<MessageFetch>();
		System.out.println("in fetch messages class");
		
		query="select m_id, message, last_send from messages where uuid=? ";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, uid);
		ResultSet rs=statement.executeQuery();
		
		while(rs.next()){
			System.out.println("In fetch message : while loop");
			MessageFetch msg=new MessageFetch();
			msg.setLast_send(rs.getTimestamp("last_send").toString());
			msg.setMessage(rs.getString("message"));
			msg.setM_id(rs.getInt("m_id"));
			messages.add(msg);
		}
		
		if(messages.isEmpty()){
			return null;
		}
		else{
			return messages;	
		}
	}

	//to add messages in the database
	@Override
	public void addMessage(String uid, String msg,String currentTimeStamp) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("in add message method of MessageImpl class");
		System.out.println("the uid is :: " + uid);
		System.out.println("in addmessage method. \n the current Timestamp  is : " + currentTimeStamp);
		query="INSERT into messages(uuid,message,last_send) VALUES (?,?,?)";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, uid);
		statement.setString(2, msg);
		statement.setTimestamp(3, Timestamp.valueOf(currentTimeStamp));
		statement.executeUpdate();
	}

	//to fetch messages during polling
	@Override
	public List<MessageFetch> fetchMessagesWithTimestamp(String uid,
			int mes_id) throws SQLException {
		// TODO Auto-generated method stub
		List<MessageFetch> messages = new ArrayList<MessageFetch>();
		System.out.println("in fetch messages class");
		query="select m_id,message, last_send from messages where uuid=? and m_id>? order by m_id asc";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, uid);///////////////////
		statement.setInt(2, mes_id);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			System.out.println("In fetch message : while loop");
			MessageFetch msg=new MessageFetch();
			msg.setLast_send(rs.getTimestamp("last_send").toString());
			msg.setMessage(rs.getString("message"));
			msg.setM_id(rs.getInt("m_id"));
			messages.add(msg);
		}
		if(messages.isEmpty()){
			return null;
		}
		else{
			return messages;	
		}
	}	
}
