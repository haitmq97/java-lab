package me.haitmq;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String team;
	
	
	
	

	public String getEmailAddress() {
		return emailAddress;
	}




	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter emailAddress - setEmailAddress()");
		this.emailAddress = emailAddress;
	}




	public String getTeam() {
		return team;
	}




	public void setTem(String team) {
		System.out.println("CricketCoach: inside setter team - setTeam()");
		this.team = team;
	}




	public CricketCoach() {
		System.out.println("CricketCoach: inside contructor - no args");
	}
	
	
	

	public FortuneService getFortuneService() {
		return fortuneService;
	}




	public void setFortuneService(FortuneService fortuneService) {
		
		System.out.println("CricketCoach: inside setter - setFortuneService()");
		this.fortuneService = fortuneService;
	}




	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
