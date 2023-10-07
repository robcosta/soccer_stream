package entities;

public class Player {
	private String name;
	private String position;
	private Integer age;
	private String currentTeam;
	private Integer goalsScored;

	public Player() {
	}
	
	public Player(String name, String position, Integer age, String currentTeam, Integer goalsScored) {
		super();
		this.name = name;
		this.position = position;
		this.age = age;
		this.currentTeam = currentTeam;
		this.goalsScored = goalsScored;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(String currentTeam) {
		this.currentTeam = currentTeam;
	}

	public Integer getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(Integer goalsScored) {
		this.goalsScored = goalsScored;
	}
	
	@Override
	public String toString() {
		return getName()+" - "+getPosition()+" - "+getCurrentTeam();
	}
	
	
	
	
}
