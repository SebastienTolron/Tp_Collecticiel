package stolr.graphstream.test;

import java.util.ArrayList;

public class UserFacebook {
	
	private String id ;
	private String Name ;
	private ArrayList<MutualFriends> mutualF;
	private ArrayList<UserFacebook> Friends;
	private String confiance;
	
	

	public UserFacebook(String id, String name, String confiance) {
		super();
		this.id = id;
		this.setConfiance(confiance);
		Name = name;
		mutualF = new ArrayList<MutualFriends>() ;
		Friends = new ArrayList<UserFacebook>() ;
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
	public ArrayList<MutualFriends> getMutualFriends() {
		return mutualF;
	}
	public void setMutualFriends(ArrayList<MutualFriends> mutualFriends) {
		mutualF = mutualFriends;
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


	public String getConfiance() {
		return confiance;
	}


	public void setConfiance(String confiance) {
		this.confiance = confiance;
	}
	
}
