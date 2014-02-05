package stolr.graphstream.test;

public class MutualFriends {

	private UserFacebook userF;
	private String confiance;
	
	
	MutualFriends (UserFacebook userF, String confiance)
	{
		this.userF = userF;
		this.confiance = confiance;
	}
	public UserFacebook getUserF() {
		return userF;
	}
	public void setUserF(UserFacebook userF) {
		this.userF = userF;
	}
	public String getConfiance() {
		return confiance;
	}
	public void setConfiance(String confiance) {
		this.confiance = confiance;
	}
		
}
