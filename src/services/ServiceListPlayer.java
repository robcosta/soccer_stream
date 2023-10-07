package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entities.Player;

public class ServiceListPlayer {
	private List<Player> list;
	String path;
	
	public ServiceListPlayer(String path) {
		this.path = path;
		this.list = getListPlayer();
	}
	
	public List<Player> getListPlayer() {
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
			List<Player> list = new ArrayList<>();
			String line;
			while ((line = bf.readLine()) != null) {				
				String[] fields = line.split(",");
				if (fields.length == 5) {
					String name = fields[0];
					String position = fields[1];
					String currentTeam = fields[3];
					int goalsScored = -1;
					int age = -1;
					try {
						age = Integer.parseInt(fields[2]);
						goalsScored = Integer.parseInt(fields[4]);
					} catch (NumberFormatException e) {
						//e.printStackTrace();
					}
				
			//	   System.out.println("===========> "+name + ", " + position + ", " + age + ", " + currentTeam + ", " + goalsScored);
					if (!(name == "" || position == "" || age < 0 || currentTeam == "" || goalsScored < 0)) {
						list.add(new Player(name, position, age, currentTeam, goalsScored));
					} 
				} 
			}
			
			return list;

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}
	
	public void playerPrint() {
		list.stream()
		.forEach(System.out::println);
	}
	
	public void playerTeamPrint(String time) {
		list.stream()
		.filter(p -> p.getCurrentTeam().toUpperCase().equals(time.toUpperCase()))
		.forEach(System.out::println);;
	}
	
	public void playerTeamGoalsPrint(String time, int numGoal) {
		list.stream()
		.filter(p -> p.getCurrentTeam().toUpperCase().equals(time.toUpperCase()) && p.getGoalsScored() >= numGoal)
		.forEach(System.out::println);;
	}
	
	public void groupPlayersByTeam() {
		list.stream()
			.sorted(Comparator.comparing(Player::getCurrentTeam)).forEach(System.out::println);
	}
	
	public double averageAge() {
		return list.stream()
				.mapToInt(Player::getAge)
				.average()
				.getAsDouble();
		
//		double sumAge = list.stream()
//				.map(p -> p.getAge())
//				.reduce(0, (x, y) -> (x + y)) ;		
//		return sumAge/list.size();
	}
	
	public void printOldestPlayer() {
		Player p = list.stream()
//			.max(Comparator.comparingInt(Player::getAge))
            .max((p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()))			
			.get();
		System.out.println("Oldest Player: "+p.getName() + ", "+p.getAge()+ " years.");
	}
	
	public void printPlayerNewest() {
		Player p = list.stream()
				.min(Comparator.comparingInt(Player::getAge))
				.get();
		System.out.println("Newest player: "+p.getName()+", "+p.getAge()+ " years.");
	}
	
	public void printPlayerGoalscorer() {
		Player p = list.stream()
				.max(Comparator.comparingInt(Player::getGoalsScored))
				.get();
		System.out.println("Player Goalscorer: "+p.getName()+", scored: "+p.getGoalsScored()+" goals.");
	}
	
	public int somatorioGoals() {
		return list.stream()
				.mapToInt(Player::getGoalsScored)
				.sum();
		
//		return list.stream()
//				.map(p -> p.getGoalsScored())
//				.reduce(0, (x,y) -> (x + y));
	}
	
	public void groupPlayersTeam() {
		Map<String, List<Player>> groupByTime = list.stream().collect(Collectors.groupingBy(Player::getCurrentTeam));
		System.out.println(groupByTime);
	}
	
	public void sortPlayersGoals() {
		list.stream()
			.sorted(Comparator.comparingInt(Player::getGoalsScored).reversed())
			.forEach(System.out::println);
	}
}
