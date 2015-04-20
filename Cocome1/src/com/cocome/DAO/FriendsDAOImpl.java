package com.cocome.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FriendsDAOImpl implements FriendsDAO {
	private Connection db_connection;
	private PreparedStatement statement;
	private String query;
	private String query1;
	private String query2;
	UserDAOImpl userDAO;
	public FriendsDAOImpl() throws ClassNotFoundException, SQLException{
		db_connection=DBConnection_Singleton.getInstance().getDBConnection();
	}

	@Override
	public List<Friends> getFriendsOfUser(String user_id) throws SQLException, ClassNotFoundException {
		List<Friends> friends=new ArrayList<Friends>();
		query="select friend_user_id from friends where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_id);
		ResultSet rs=statement.executeQuery();
		userDAO = new UserDAOImpl();
		while(rs.next()){
			Friends friend=new Friends();
			friend.setUser(userDAO.getUserDetails(rs.getString("friend_user_id")));
			
			friends.add(friend);
		}
		
		System.out.println("Friends Details");
		for(Friends fr:friends){
			System.out.println(fr.getUser().getFirst_name());
		}
		statement.close();
		return friends;		
	}
	
	public List<String> getFriendsList(String user_name) throws SQLException {
		// TODO Auto-generated method stub
		List<String> friends_list=new ArrayList<String>();
		query="select friend_user_id from friends where user_id=?";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, user_name);
		ResultSet rs=statement.executeQuery();
		
		while(rs.next()){	
			
			friends_list.add(rs.getString("friend_user_id"));
		}
		statement.close();
		return friends_list;
	}	
	
	public List<String> intersection(List<String> list1, List<String> list2) {
        List<String> list = new ArrayList<String>();

        for (String t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
	
	public LinkedHashMap sortHashMapByValues(HashMap passedMap) {
		   List mapKeys = new ArrayList(passedMap.keySet());
		   List mapValues = new ArrayList(passedMap.values());
		   Collections.sort(mapValues, Collections.reverseOrder());
		   Collections.sort(mapKeys, Collections.reverseOrder());

		   LinkedHashMap sortedMap = new LinkedHashMap();

		   Iterator valueIt = mapValues.iterator();
		   while (valueIt.hasNext()) {
		       Object val = valueIt.next();
		       Iterator keyIt = mapKeys.iterator();

		       while (keyIt.hasNext()) {
		           Object key = keyIt.next();
		           String comp1 = passedMap.get(key).toString();
		           String comp2 = val.toString();

		           if (comp2.equals(comp1)){
		               passedMap.remove(key);
		               mapKeys.remove(key);
		               sortedMap.put((String)key, (Integer)val);
		               break;
		           }

		       }

		   }
		   return sortedMap;
		}
	
	
	public List<Friends> getSuggestedFriendsOfUser(String user_id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Friends> friends=new ArrayList<Friends>();
		
		//Get people who are not my friends
		
		//All peoples list
		List<String> peopleList=new ArrayList<String>();
		List<String> myFriendsList=new ArrayList<String>();
		List<String> peopleNotInMyFreindsList=new ArrayList<String>();
		
		query="select user_id from login";
		statement=(PreparedStatement) db_connection.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){				
			peopleList.add(rs.getString("user_id"));
		}
		peopleList.remove(user_id);		
		
		myFriendsList = getFriendsList(user_id);		
		
		//Finding people who are not my friends but exist in social network
		for (String eachMember: peopleList){
			int flag = 0;
			for (String eachFriend: myFriendsList){			
				if (eachMember.equals(eachFriend)){
					flag = 1;
				}
			}
			if (flag == 0){
				peopleNotInMyFreindsList.add(eachMember);
			}
		}
		
		System.out.println("Printing people not in my friends list");
		for(String suchPeople: peopleNotInMyFreindsList){
			System.out.println(suchPeople);
		}
		
		HashMap<String,Integer> mutualFriends = new HashMap<String,Integer>();		
					
		//Get each of such people friends and calculate intersection with my friends
		//Store as Person, no of intersections
		
		for (String suchPeople: peopleNotInMyFreindsList){
			List<String> friendsofSuchPeople=new ArrayList<String>();
			friendsofSuchPeople = getFriendsList(suchPeople);
			if (intersection(friendsofSuchPeople, myFriendsList).size() !=0){
				mutualFriends.put(suchPeople, intersection(friendsofSuchPeople, myFriendsList).size());			
			}
			
		}
		
		LinkedHashMap<String, Integer> mutualFriendsSorted = new LinkedHashMap<>();
		mutualFriendsSorted = sortHashMapByValues(mutualFriends);
		
		for (Map.Entry<String, Integer> entry : mutualFriendsSorted.entrySet()) {
	        String key = entry.getKey().toString();;
	        Integer value = entry.getValue();
	        System.out.println("key, " + key + " value " + value );
	    }
		
		//sort and return people with most score
		userDAO = new UserDAOImpl();
		for (Map.Entry<String, Integer> entry : mutualFriendsSorted.entrySet()) {
	        String key = entry.getKey().toString();;
	        Integer value = entry.getValue();
	        System.out.println("key, " + key + " value " + value );
	        Friends friend=new Friends();
			friend.setUser(userDAO.getUserDetails(key));			
			friends.add(friend);
	    }
		

		return friends;
	}
	
	
	@Override
	public boolean IfFriends(String usermain,String friend) throws SQLException{
		query="select * from friends where user_id=? and friend_user_id=?";
		statement= (PreparedStatement) db_connection.prepareStatement(query);
		statement.setString(1, usermain);
		statement.setString(2, friend);
		ResultSet res=statement.executeQuery();
		if(res.next()){
			statement.close();
			return true;
		}
		else
			return false;
	}
		
}
