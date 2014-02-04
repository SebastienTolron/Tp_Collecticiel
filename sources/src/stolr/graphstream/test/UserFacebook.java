package stolr.graphstream.test;

import java.util.ArrayList;

public class UserFacebook {
	
	private String id ;
	private String Name ;
	private ArrayList<UserFacebook> MutualFriends;
	private ArrayList<UserFacebook> Friends;
	private String confiance;
	
	

	public UserFacebook(String id, String name, String conf) {
		super();
		this.id = id;
		Name = name;
		MutualFriends = new ArrayList<UserFacebook>() ;
		Friends = new ArrayList<UserFacebook>() ;
		confiance = conf;
	}
	
	
	public UserFacebook() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<UserFacebook> getMutualFriends() {
		return MutualFriends;
	}
	public void setMutualFriends(ArrayList<UserFacebook> mutualFriends) {
		MutualFriends = mutualFriends;
	}
	
	
	public String getConfiance() {
		return confiance;
	}


	public void setConfiance(String confiance) {
		this.confiance = confiance;
	}


	public ArrayList<UserFacebook> getFriends() {
		return Friends;
	}


	public void setFriends(ArrayList<UserFacebook> friends) {
		Friends = friends;
	}

	
	public UserFacebook getById (String id)
	{
		UserFacebook ureturn = null;
		for (int i=0 ; i< this.Friends.size() ; i++)
		{
			if (id.equals(this.Friends.get(i).getId()))
				ureturn = Friends.get(i);
		}
		
		return ureturn;
	}
	
}
