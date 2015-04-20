//@ Author: Mrunal Lele
//@Chat server
package com.cocome.action;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


import org.apache.commons.io.IOUtils;

import com.cocome.DAO.MessageDAOImpl;
import com.cocome.DAO.MessageFetch;
import com.cocome.DAO.User;
import com.cocome.DAO.User_ChatDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringEscapeUtils;


//@Coded By Mrunal
//Do not make any changes
//Server for chat 
//Action classes required for chatting


public class ChatSever extends ActionSupport implements Serializable{
	
		private String uuid; //the unique chat-id
		private String chatWithUser; //the user you are chatting with
		private String userMessage;  //the message sent by you
		private InputStream inputStream; //input stream to send message
		private List<MessageFetch> msg_from_user;	//list of previous messages
		private String currentTimeStamp;	// add new timestamp to the message
		private int message_id;		//the message ID
		private User loggedInUser;  // the user object of session
		
		// getters and setters for the attributes
		
		public int getMessage_id() {
			return message_id;
		}

		public void setMessage_id(int message_id) {
			this.message_id = message_id;
		}

		public List<MessageFetch> getMsg_from_user() {
			return msg_from_user;
		}

		public void setMsg_from_user(List<MessageFetch> msg_from_user) {
			this.msg_from_user = msg_from_user;
		}
				
		
		public String getCurrentTimeStamp() {
			return currentTimeStamp;
		}

		public void setCurrentTimeStamp(String currentTimeStamp) {
			this.currentTimeStamp = currentTimeStamp;
		}

		
		public InputStream getInputStream() {
			return inputStream;
		}

		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}

		public String getChatWithUser() {
			return chatWithUser;
		}

		public void setChatWithUser(String chatWithUser) {
			this.chatWithUser = chatWithUser;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public User getLoggedInUser() {
			return loggedInUser;
		}

		public void setLoggedInUser(User loggedInUser) {
			this.loggedInUser = loggedInUser;
		}

		
		//@@ some method for testing
		
		public String StartChatForUser() throws ClassNotFoundException, SQLException{
			System.out.println("in start chat for user..");	
			return SUCCESS;
		}
		
		// to fetch user messages
		public String fetchMessageOfUser() throws ClassNotFoundException, SQLException{
			MessageDAOImpl msg1 = new MessageDAOImpl();
			System.out.println("the user id im chatting with is " + uuid);
			System.out.println("in fetch Message of user function");
			System.out.println("user id for messages is " + uuid);
			setMsg_from_user( msg1.fetchMessagesWithTimestamp(uuid, message_id));
			StringBuilder msgBuilder = new StringBuilder();
			
			if(msg_from_user != null){
				int c = 0;
				msgBuilder.append("[");
				for(MessageFetch msg:msg_from_user){
					msgBuilder.append("{\"messages\":\"");
					msgBuilder.append(StringEscapeUtils.escapeJavaScript(msg.getMessage()));
					System.out.println("message is :: "+ msg.getMessage());
					System.out.println("timestamp is :: "+ msg.getLast_send());
					msgBuilder.append("#");
					msgBuilder.append(msg.getLast_send());
					c++; 
					msgBuilder.append("\"");
					msgBuilder.append(",");
					msgBuilder.append("\"lastId\":");
					msgBuilder.append("\"");
					msgBuilder.append(msg_from_user.get(msg_from_user.size()-1).getM_id());
					msgBuilder.append("\"");
					msgBuilder.append("}");
					
					if (c != msg_from_user.size()){
						msgBuilder.append(",");
					}
					else{
						//this.setCurrentTimeStamp()
					}
					System.out.println("The message is :: " + msg);
				}
				
				msgBuilder.append("]");
			}
			else{
				msgBuilder.append("{}");
			}
			inputStream = IOUtils.toInputStream(msgBuilder.toString());
			System.out.println(msgBuilder.toString());
			return SUCCESS;
		}
		
		//to connect to a particular user for chating
		//fetch previous messages from user
		public String connectChat() throws ClassNotFoundException, SQLException{
			System.out.println("in connect chat function");
			Map session = ActionContext.getContext().getSession();
			User user=(User)session.get("user");
			this.setLoggedInUser(user);
			User_ChatDAOImpl user_chat=new User_ChatDAOImpl();
			System.out.println();
			String result1 =  user_chat.fetchChatDetails(user.getUser_id(), chatWithUser);
			System.out.println("the value of fetch chat details is :: " + result1);
			if(result1==null){
				generateUUID();
				user_chat.createChatEntry(uuid, user.getUser_id(), chatWithUser);
			}
			else{
				uuid = result1; 
			}			
			Timestamp tst = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			currentTimeStamp=tst.toString();
			System.out.println("UUId is " + uuid); 
			System.out.println("Chatting with user " + this.getChatWithUser());
			MessageDAOImpl msg1 = new MessageDAOImpl();
			System.out.println("the user id im chatting with is " + uuid);
			System.out.println("***************************************************************************");
			System.out.println("user id for messages is " + uuid);
			msg_from_user = msg1.fetchMessages(uuid);
			if(msg_from_user != null){
				for(MessageFetch msg:msg_from_user){
					System.out.println("The message is :: " + msg.getMessage());
				}
				this.setMessage_id(msg_from_user.get(msg_from_user.size()-1).getM_id());
			}			
			System.out.println("***************************************************************************");
			return SUCCESS; 
		}
		
		//to generate unique ID for chatting
		public String generateUUID(){
			System.out.println("in generate uuid");
			uuid=UUID.randomUUID().toString();
			System.out.println("The user id is" + uuid);
			return SUCCESS;
		}
		
		//adding the message in the database
		public String sendMessage() throws ClassNotFoundException, SQLException{
			String user_temp=null;
			System.out.println("in send message");
			System.out.println("the current timestamp is :: " + currentTimeStamp);
			Map session = ActionContext.getContext().getSession();
			User user=(User)session.get("user");
			User_ChatDAOImpl user1=new User_ChatDAOImpl();
			MessageDAOImpl msgdao=new MessageDAOImpl();
			System.out.println("the chat user id is : " + user.getUser_id());
			System.out.println(chatWithUser);
			user_temp=user1.fetchChatDetails(user.getUser_id(), chatWithUser);
			Timestamp ts = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			setCurrentTimeStamp(ts.toString());
			msgdao.addMessage(user_temp, user.getUser_id() + "~" + userMessage,currentTimeStamp);
			System.out.println("in send message" + userMessage);
			inputStream = IOUtils.toInputStream( " : " +userMessage);
			return SUCCESS;
		}
}